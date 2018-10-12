package ru19july.bask.scene3d.parser.antlr;

// Generated from C:/Projects/Scene3D/app/src/g4\LangParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

import ru19july.bask.scene3d.parser.antlr.LangParser;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(LangParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(LangParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(LangParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(LangParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(LangParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(LangParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(LangParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(LangParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(LangParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(LangParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(LangParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(LangParser.ParametersContext ctx);
}