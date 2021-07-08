package ru.tcreator;

import java.util.concurrent.LinkedBlockingQueue;

public class CallStorage {
  protected final LinkedBlockingQueue<Call> call_collection;

  public CallStorage() {
    this.call_collection = new LinkedBlockingQueue<>();
  }

  public void put(Call call) throws InterruptedException {
    call_collection.put(call);
  }

  public Call poll() {
    return this.call_collection.poll();
  }

  public boolean isEmpty() {
    return call_collection.isEmpty();
  }
}
