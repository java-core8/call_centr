package ru.tcreator;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Specialist implements Runnable {
  protected CallStorage callStorage;

  Specialist(CallStorage callStorage) {
    this.callStorage = callStorage;
  }

  @Override
  public void run() {
    do {
      try {
        Call current_call = callStorage.poll();
        if(current_call != null) {
          workEmulate(current_call);
        } else {
          TimeUnit.MILLISECONDS.sleep(1000);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (!callStorage.isEmpty());
  }

  protected void workEmulate(Call callName) throws InterruptedException {
    System.out.println("\t\t\t\t\t\t\t\tСпециалист взял в работу звонок " + callName);
    TimeUnit.MILLISECONDS.sleep(randomDelayMs(500, 1500));

    System.out.println("\t\t\t\t\t\t\t\tзвонок " + callName + " всё ещё в работе");
    TimeUnit.MILLISECONDS.sleep(randomDelayMs(500, 1500));

    System.out.println("\t\t\t\t\t\t\t\tработа по звонку " + callName + " завершается");
    TimeUnit.MILLISECONDS.sleep(randomDelayMs(500, 1500));

    System.out.println("\t\t\t\t\t\t\t\tработа по звонку " + callName + " окончена");
  }
  protected int randomDelayMs(int min, int max) {
    Random random = new Random();
    return random.nextInt((max - min) + 1) + min;
  }

}
