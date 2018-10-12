package ru19july.bask.scene3d.parser;

import java.util.Collection;
import java.util.List;

public class LangScene {
    private String name;
    private Collection<LangMethod> methods;

    public LangScene(String name, Collection<LangMethod> methods) {
        this.name = name;
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
