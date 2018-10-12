package ru19july.bask.scene3d.parser;

import java.util.Collection;

import ru19july.bask.scene3d.parser.LangInstruction;

public class LangMethod {
    private String name;
    private Collection<LangInstruction> instructions;

    public LangMethod(String methodName, Collection<LangInstruction> instructions) {
        name = methodName;
        this.instructions = instructions;
    }
}
