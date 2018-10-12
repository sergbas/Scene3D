package ru19july.bask.scene3d.parser;

import java.util.Collection;

import ru19july.bask.scene3d.parser.LangMethod;

public class LangClass {
    private String name;
    private Collection<LangMethod> methods;

    public LangClass(String className, Collection<LangMethod> methods) {
        this.name = className;
        this.methods = methods;
    }
}
