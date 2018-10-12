package ru19july.bask.scene3d.parser.antlr;

// Generated from C:/Projects/Scene3D/app/src/g4\LangParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import ru19july.bask.scene3d.parser.antlr.LangParser;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(LangParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(LangParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(LangParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#methodName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodName(LangParser.MethodNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(LangParser.InstructionContext ctx);
}