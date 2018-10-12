parser grammar LangParser;

options { tokenVocab=LangLexer; }

classDeclaration : CLASS className L_CURLY_BRACE (method)* R_CURLY_BRACE;
className : ID ;
method : methodName (LR_BRACKET (parameters)? RR_BRACKET)? L_CURLY_BRACE (instruction)+ R_CURLY_BRACE ;
methodName : ID ;
instruction : ID ;
parameters : (ID COMMA)* ID ;

