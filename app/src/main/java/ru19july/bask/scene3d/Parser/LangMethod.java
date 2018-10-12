package ru19july.bask.scene3d.parser;


import java.util.Collection;
import java.util.List;

public class LangMethod {
    private String name;
    private List<LangParameter> parameters;
    private Collection<LangInstruction> instructions;

    public LangMethod(String methodName, Collection<LangInstruction> instructions) {
        name = methodName;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LangInstruction> getInstructions() {
        return (List<LangInstruction>) instructions;
    }

}
