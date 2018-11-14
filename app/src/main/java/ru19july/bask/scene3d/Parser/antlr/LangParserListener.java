package ru19july.bask.scene3d.parser.antlr;
// Generated from D:/Projects/Scene3D/app/src/g4\LangParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#sceneDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSceneDeclaration(LangParser.SceneDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#sceneDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSceneDeclaration(LangParser.SceneDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#sceneName}.
	 * @param ctx the parse tree
	 */
	void enterSceneName(LangParser.SceneNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#sceneName}.
	 * @param ctx the parse tree
	 */
	void exitSceneName(LangParser.SceneNameContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link LangParser#any_value}.
	 * @param ctx the parse tree
	 */
	void enterAny_value(LangParser.Any_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#any_value}.
	 * @param ctx the parse tree
	 */
	void exitAny_value(LangParser.Any_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#digits}.
	 * @param ctx the parse tree
	 */
	void enterDigits(LangParser.DigitsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#digits}.
	 * @param ctx the parse tree
	 */
	void exitDigits(LangParser.DigitsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#object3d}.
	 * @param ctx the parse tree
	 */
	void enterObject3d(LangParser.Object3dContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#object3d}.
	 * @param ctx the parse tree
	 */
	void exitObject3d(LangParser.Object3dContext ctx);
}