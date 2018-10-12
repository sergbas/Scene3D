package ru19july.bask.scene3d.parser.antlr;

// Generated from C:/Projects/Scene3D/app/src/g4\LangParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParser#sceneDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSceneDeclaration(LangParser.SceneDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#sceneName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSceneName(LangParser.SceneNameContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link LangParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(LangParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#any_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAny_value(LangParser.Any_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#digits}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigits(LangParser.DigitsContext ctx);
}