package ru19july.bask.scene3d.parser;

import android.annotation.TargetApi;
import android.os.Build;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

import ru19july.bask.scene3d.parser.antlr.LangLexer;
import ru19july.bask.scene3d.parser.antlr.LangParser;
import ru19july.bask.scene3d.parser.antlr.LangParserBaseVisitor;

import static java.util.stream.Collectors.toList;

public class VisitorOrientedParser {

    public LangScene parse(String someLangSourceCode) {
        CharStream charStream = new ANTLRInputStream(someLangSourceCode);
        LangLexer lexer = new LangLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);

        ClassVisitor classVisitor = new ClassVisitor();
        LangScene traverseResult = classVisitor.visit(parser.sceneDeclaration());
        return traverseResult;
    }

    private static class ClassVisitor extends LangParserBaseVisitor<LangScene> {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public LangScene visitSceneDeclaration(@NotNull LangParser.SceneDeclarationContext ctx) {
            String className = ctx.sceneName().getText();
            MethodVisitor methodVisitor = new MethodVisitor();
            List<LangMethod> methods = ctx.method()
                    .stream()
                    .map(method -> method.accept(methodVisitor))
                    .collect(toList());
            return new LangScene(className, methods);
        }
    }

    private static class MethodVisitor extends LangParserBaseVisitor<LangMethod> {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public LangMethod visitMethod(@NotNull LangParser.MethodContext ctx) {
            String methodName = ctx.methodName().getText();

            ParameterVisitor parameterVisitor = new ParameterVisitor();
           /* LangParameter parameters = ctx.parameters()
                    .stream()
                    .map(p -> p.accept(parameterVisitor))
                    .collect(toList());
*/
            InstructionVisitor instructionVisitor = new InstructionVisitor();
            List<LangInstruction> instructions = ctx.instruction()
                    .stream()
                    .map(i -> i.accept(instructionVisitor))
                    .collect(toList());

            return new LangMethod(methodName, null, instructions);
        }
    }

    private static class ParameterVisitor extends  LangParserBaseVisitor<LangParameter> {

        @Override
        public LangParameter visitParameters(@NotNull LangParser.ParametersContext ctx) {
            String name = ctx.getText();
            return new LangParameter(name);
        }
    }

    private static class InstructionVisitor extends  LangParserBaseVisitor<LangInstruction> {

        @Override
        public LangInstruction visitInstruction(@NotNull LangParser.InstructionContext ctx) {
            String instructionName = ctx.getText();
            return new LangInstruction(instructionName);
        }
    }
}