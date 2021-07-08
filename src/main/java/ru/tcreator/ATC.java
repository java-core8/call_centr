package ru.tcreator;
import java.util.concurrent.TimeUnit;

public class ATC implements Runnable {
  protected CallStorage call_stack;
  protected final int LIMIT_MESSAGE = 20;
  protected int count_message = 0;
  protected final int LIMIT_CALL_BUILD_MS = 1000;

  public ATC(CallStorage call_stack) {
    this.call_stack = call_stack;
  }

  @Override
  public void run() {
    while (limitIsDone()) {
      try {
        String callName = "Звонок №" + count_message;
        addNewCall(callName);
        System.out.println("Поступил звонок: " + callName);
        TimeUnit.MILLISECONDS.sleep(LIMIT_CALL_BUILD_MS);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  protected boolean limitIsDone() {
    return ++count_message < LIMIT_MESSAGE;
  }

  protected void addNewCall(String callName) throws InterruptedException {
    call_stack.put(new Call(callName));
  }
}
