parser grammar LangParser;

options { tokenVocab=LangLexer; }

sceneDeclaration : SCENE sceneName L_CURLY_BRACE (method)* R_CURLY_BRACE;
sceneName : ID ;
method : methodName (LR_BRACKET (parameters)? RR_BRACKET)? L_CURLY_BRACE (instruction)+ R_CURLY_BRACE ;
methodName : ( OBJECT3D | ID ) ;
instruction : ID ;
parameters : (any_value COMMA)* any_value ;
any_value : ( ID | digits) ;
digits : DIGITS ;

