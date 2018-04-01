package com.maxicorrea.jbmp.models.core;

import java.util.HashSet;
import java.util.Set;

public class Editor {

  private Image source;
  private Image edited;
  private Set<Observer> observers = new HashSet<>();

  public Editor() {
    super();
  }

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void setSourceImage(Image source) {
    this.source = source;
    edited = new Image(source);
    notifyObservers();
  }

  public void resetEditedImage() {
    edited = new Image(source);
    notifyObservers();
  }

  public void applyOperation(Operation operation) {
    edited = operation.apply(edited);
    notifyObservers();
  }

  public Image getSourceImage() {
    return source;
  }

  public Image getEditedImage() {
    return edited;
  }

  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(edited);
    }
  }

}
