package com.design_pattern.visitor;

public interface ComputerPart {
   void accept(ComputerPartVisitor computerPartVisitor);
}