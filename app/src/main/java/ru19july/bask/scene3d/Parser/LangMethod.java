package ru19july.bask.scene3d.Parser;

import java.util.Collection;

public class LangMethod {
    private String name;
    private Collection<LangInstruction> instructions;

    public LangMethod(String methodName, Collection<LangInstruction> instructions) {
        name = methodName;
        this.instructions = instructions;
    }
}
