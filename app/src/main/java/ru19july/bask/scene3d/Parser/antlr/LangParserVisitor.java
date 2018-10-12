package ru19july.bask.scene3d.Parser.antlr;

// Generated from C:/Projects/Scene3D/app/src/g4\LangParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParserParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(LangParserParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParserParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(LangParserParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParserParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(LangParserParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParserParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(LangParserParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParserParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(LangParserParser.InstructionContext ctx);
}