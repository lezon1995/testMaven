package com.design_pattern.visitor;

public interface ComputerPart {
   public void accept(ComputerPartVisitor computerPartVisitor);
}