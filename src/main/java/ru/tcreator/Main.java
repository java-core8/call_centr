package ru.tcreator;

public class Main {
  public static void main(String[] args) {
    CallStorage callStorage = new CallStorage();
    Thread atcThread = new Thread(new ATC(callStorage));
    Thread specThread = new Thread(new Specialist(callStorage));

    atcThread.start();
    specThread.start();

  }
}
