parser grammar LangParser;

options { tokenVocab=LangLexer; }

sceneDeclaration : SCENE sceneName L_CURLY_BRACE ( object3d | method )* R_CURLY_BRACE ;
sceneName : ID ;
method : methodName ( LR_BRACKET ( parameters )? RR_BRACKET )? L_CURLY_BRACE ( instruction )+ R_CURLY_BRACE ;
methodName : ( ID ) ;
instruction : ID ;
parameters : (any_value COMMA)* any_value ;
any_value : ( ID | digits) ;
digits : DIGITS ;
object3d : OBJECT3D ( LR_BRACKET ( parameters )? RR_BRACKET )? SEMI ;
