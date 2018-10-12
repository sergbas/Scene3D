// Generated from C:/Projects/Scene3D/app/src/g4\LangParser.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParserParser}.
 */
public interface LangParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParserParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(LangParserParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParserParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(LangParserParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParserParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(LangParserParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParserParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(LangParserParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParserParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(LangParserParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParserParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(LangParserParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParserParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(LangParserParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParserParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(LangParserParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParserParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(LangParserParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParserParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(LangParserParser.InstructionContext ctx);
}