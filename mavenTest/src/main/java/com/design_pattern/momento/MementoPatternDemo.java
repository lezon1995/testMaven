package com.design_pattern.momento;

public class MementoPatternDemo {
   public static void main(String[] args) {
      Originator originator = new Originator();
      CareTaker careTaker = new CareTaker();
      originator.setState(new Info("张三",20));
      originator.setState(new Info("李四",18));
      careTaker.add(originator.saveStateToMemento());
      originator.setState(new Info("王五",22));
      careTaker.add(originator.saveStateToMemento());
      originator.setState(new Info("赵六",25));
 
      System.out.println("Current State: " + originator.getState());    
      originator.getStateFromMemento(careTaker.get(0));
      System.out.println("First saved State: " + originator.getState());
      originator.getStateFromMemento(careTaker.get(1));
      System.out.println("Second saved State: " + originator.getState());
   }
}