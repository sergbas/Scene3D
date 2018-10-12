package ru19july.bask.scene3d.Parser;

import java.util.Collection;

public class LangClass {
    private String name;
    private Collection<LangMethod> methods;

    public LangClass(String className, Collection<LangMethod> methods) {
        this.name = className;
        this.methods = methods;
    }
}
