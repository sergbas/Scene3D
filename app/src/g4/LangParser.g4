parser grammar LangParser;

classDeclaration : 'class' className '{' (method)* '}';
className : ID ;
method : methodName '{' (instruction)+ '}' ;
methodName : ID ;
instruction : ID ;

