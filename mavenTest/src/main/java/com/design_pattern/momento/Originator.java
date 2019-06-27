package com.design_pattern.momento;

public class Originator {
   private Info state;

   public Info getState() {
      return state;
   }

   public void setState(Info state) {
      this.state = state;
   }

   public Memento saveStateToMemento(){
      return new Memento(state);
   }
 
   public void getStateFromMemento(Memento Memento){
      state = Memento.getState();
   }
}