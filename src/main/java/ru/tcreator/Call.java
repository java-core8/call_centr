package ru.tcreator;

public class Call {
  protected String name;

  public Call(String name) {
    this.name = name;
  }
  @Override
  public String toString() {
    return "Звонок " + name;
  }
}
