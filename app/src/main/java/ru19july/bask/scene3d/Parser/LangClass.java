package ru19july.bask.scene3d.parser;

import java.util.Collection;
import java.util.List;

public class LangClass {
    private String name;
    private Collection<LangMethod> methods;

    public LangClass(String className, Collection<LangMethod> methods) {
        this.name = className;
        this.methods = methods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LangMethod> getMethods() {
        return (List<LangMethod>) methods;
    }

}
