package ru19july.bask.scene3d.Parser;

import android.annotation.TargetApi;
import android.os.Build;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;

import java.lang.reflect.Method;
import java.util.List;

import ru19july.bask.scene3d.Parser.antlr.LangLexerLexer;
import ru19july.bask.scene3d.Parser.antlr.LangParserBaseVisitor;
import ru19july.bask.scene3d.Parser.antlr.LangParserParser;

import static java.util.stream.Collectors.toList;

public class VisitorOrientedParser {

    public LangClass parse(String someLangSourceCode) {
        CharStream charStream = new ANTLRInputStream(someLangSourceCode);
        LangLexerLexer lexer = new LangLexerLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        LangParserParser parser = new LangParserParser(tokens);

        ClassVisitor classVisitor = new ClassVisitor();
        LangClass traverseResult = classVisitor.visit(parser.classDeclaration());
        return traverseResult;
    }

    private static class ClassVisitor extends LangParserBaseVisitor<LangClass> {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public LangClass visitClassDeclaration(@NotNull LangParserParser.ClassDeclarationContext ctx) {
            String className = ctx.className().getText();
            MethodVisitor methodVisitor = new MethodVisitor();
            List<LangMethod> methods = ctx.method()
                    .stream()
                    .map(method -> method.accept(methodVisitor))
                    .collect(toList());
            return new LangClass(className, methods);
        }
    }

    private static class MethodVisitor extends LangParserBaseVisitor<LangMethod> {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public LangMethod visitMethod(@NotNull LangParserParser.MethodContext ctx) {
            String methodName = ctx.methodName().getText();
            InstructionVisitor instructionVisitor = new InstructionVisitor();
            List<LangInstruction> instructions = ctx.instruction()
                    .stream()
                    .map(instruction -> instruction.accept(instructionVisitor))
                    .collect(toList());
            return new LangMethod(methodName, instructions);
        }
    }

    private static class InstructionVisitor extends  LangParserBaseVisitor<LangInstruction> {

        @Override
        public LangInstruction visitInstruction(@NotNull LangParserParser.InstructionContext ctx) {
            String instructionName = ctx.getText();
            return new LangInstruction(instructionName);
        }
    }
}