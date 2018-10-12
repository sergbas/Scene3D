parser grammar LangParser;

options { tokenVocab=LangLexer; }

classDeclaration : CLASS className L_CURLY_BRACE (method)* R_CURLY_BRACE;
className : ID ;
method : methodName (parametrized)? L_CURLY_BRACE (instruction)+ R_CURLY_BRACE ;
methodName : ID ;
instruction : ID ;
parametrized : LR_BRACKET (parameters)? RR_BRACKET;
parameters
    : ID
    | (ID COMMA)* ID
    ;

