package ru19july.bask.scene3d.Parser;

import android.os.Build;
import android.support.annotation.RequiresApi;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import ru19july.bask.scene3d.Parser.antlr.LangLexerLexer;
import ru19july.bask.scene3d.Parser.antlr.LangParserBaseListener;
import ru19july.bask.scene3d.Parser.antlr.LangParserParser;

public class ListenerOrientedParser {

    public class Class {
        private String name;
        private Collection<Method> methods;

        public Class(String className, Collection<Method> methods) {
            this.name = className;
            this.methods = methods;
        }
    }

    public class Method {
        private String name;
        private Collection<Instruction> instructions;

        public Method(String methodName, Collection<Instruction> instructions) {
            name = methodName;
            this.instructions = instructions;
        }
    }

    public class Instruction {
        private String name;

        public Instruction(String instructionName) {
            name = instructionName;
        }
    }

    public Class parse(String code) {
        CharStream charStream = new ANTLRInputStream(code);
        LangLexerLexer lexer = new LangLexerLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        LangParserParser parser = new LangParserParser(tokens);

        ClassListener classListener = new ClassListener();
        parser.classDeclaration().enterRule(classListener);
        return classListener.getParsedClass();
    }

    class ClassListener extends LangParserBaseListener {

        private Class parsedClass;

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void enterClassDeclaration(@NotNull LangParserParser.ClassDeclarationContext ctx) {
            String className = ctx.className().getText();
            MethodListener methodListener = new MethodListener();
            ctx.method().forEach(method -> method.enterRule(methodListener));
            Collection<Method> methods = methodListener.getMethods();
            parsedClass = new Class(className,methods);
        }

        public Class getParsedClass() {
            return parsedClass;
        }
    }

    class MethodListener extends LangParserBaseListener implements ParseTreeListener {

        private Collection<Method> methods;

        public MethodListener() {
            methods = new ArrayList<>();
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void enterMethod(@NotNull LangParserParser.MethodContext ctx) {
            String methodName = ctx.methodName().getText();
            InstructionListener instructionListener = new InstructionListener();
            ctx.instruction().forEach(instruction -> instruction.enterRule(instructionListener));
            Collection<Instruction> instructions = instructionListener.getInstructions();
            methods.add(new Method(methodName, instructions));
        }

        public Collection<Method> getMethods() {
            return methods;
        }
    }

    class InstructionListener extends LangParserBaseListener {

        private Collection<Instruction> instructions;

        public InstructionListener() {
            instructions = new ArrayList<>();
        }

        @Override
        public void enterInstruction(@NotNull LangParserParser.InstructionContext ctx) {
            String instructionName = ctx.getText();
            instructions.add(new Instruction(instructionName));
        }

        public Collection<Instruction> getInstructions() {
            return instructions;
        }
    }
}
