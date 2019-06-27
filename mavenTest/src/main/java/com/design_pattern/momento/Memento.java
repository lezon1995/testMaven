package com.design_pattern.momento;

public class Memento {
   private Info state;
 
   public Memento(Info state){
      this.state = state;
   }
 
   public Info getState(){
      return state;
   }  
}