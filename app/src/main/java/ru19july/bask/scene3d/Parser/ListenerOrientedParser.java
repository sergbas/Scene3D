package ru19july.bask.scene3d.parser;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.util.ArrayList;
import java.util.Collection;

import ru19july.bask.scene3d.parser.antlr.LangLexer;
import ru19july.bask.scene3d.parser.antlr.LangParser;
import ru19july.bask.scene3d.parser.antlr.LangParserBaseListener;

public class ListenerOrientedParser {

    public LangScene parse(String code) {
        CharStream charStream = new ANTLRInputStream(code);
        LangLexer lexer = new LangLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);

        ClassListener classListener = new ClassListener();
        parser.sceneDeclaration().enterRule(classListener);
        return classListener.getParsedClass();
    }

    class ClassListener extends LangParserBaseListener {

        private LangScene parsedClass;

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void enterSceneDeclaration(@NotNull LangParser.SceneDeclarationContext ctx) {
            String sceneName = ctx.sceneName().getText();
            MethodListener methodListener = new MethodListener();
            ctx.method().forEach(method -> method.enterRule(methodListener));
            Collection<LangMethod> methods = methodListener.getMethods();
            parsedClass = new LangScene(sceneName, methods);
        }

        public LangScene getParsedClass() {
            return parsedClass;
        }
    }

    class MethodListener extends LangParserBaseListener implements ParseTreeListener {

        private Collection<LangMethod> methods;

        public MethodListener() {
            methods = new ArrayList<>();
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void enterMethod(@NotNull LangParser.MethodContext ctx) {
            String methodName = ctx.methodName().getText();

            Collection<LangParameter> parameters = null;

            ParameterListener parameterListener = new ParameterListener();
            if(ctx.parameters() != null) {
                ctx.parameters().enterRule(parameterListener);
                //parameters = parameterListener.getParameters();
            }

            AnyValueListener anyValueListener = new AnyValueListener();
            if(ctx.parameters() != null && ctx.parameters().any_value() != null) {
                ctx.parameters().any_value().forEach(v -> v.enterRule(anyValueListener));
                parameters = anyValueListener.getParameters();
            }

            InstructionListener instructionListener = new InstructionListener();
            ctx.instruction().forEach(instruction -> instruction.enterRule(instructionListener));
            Collection<LangInstruction> instructions = instructionListener.getInstructions();

            methods.add(new LangMethod(methodName, parameters, instructions));
        }

        public Collection<LangMethod> getMethods() {
            return methods;
        }
    }

    class ParameterListener extends LangParserBaseListener {

        private Collection<LangParameter> parameters;

        public ParameterListener() {
            parameters = new ArrayList<>();
        }

        @Override
        public void enterParameters(@NotNull LangParser.ParametersContext ctx) {
            String instructionName = ctx.getText();
            parameters.add(new LangParameter(instructionName));
        }

        public Collection<LangParameter> getParameters() {
            return parameters;
        }
    }

    class AnyValueListener extends LangParserBaseListener {

        private Collection<LangParameter> parameters;

        public AnyValueListener() {
            parameters = new ArrayList<>();
        }

        @Override
        public void enterAny_value(LangParser.Any_valueContext ctx) {
            String name = ctx.getText();
            parameters.add(new LangParameter(name));
        }

        public Collection<LangParameter> getParameters() {
            return parameters;
        }
    }

    class InstructionListener extends LangParserBaseListener {

        private Collection<LangInstruction> instructions;

        public InstructionListener() {
            instructions = new ArrayList<>();
        }

        @Override
        public void enterInstruction(@NotNull LangParser.InstructionContext ctx) {
            String instructionName = ctx.getText();
            instructions.add(new LangInstruction(instructionName));
        }

        public Collection<LangInstruction> getInstructions() {
            return instructions;
        }
    }
}
