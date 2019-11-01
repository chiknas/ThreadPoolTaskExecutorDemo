package com.example.threadtooltasktxecutor;

/**
 * com.example.threadtooltasktxecutor.thread, created on 01/11/2019 10:06 <p>
 * @author NikolaosK
 */
public class FakeTask implements Runnable {

  private int threadName;

  public FakeTask(int threadName) {
    this.threadName = threadName;
  }

  @Override
  public void run() {
    try {
      System.out.println("Going to work " + Thread.currentThread().getName() + " for task number #" + threadName);
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("DONE " + Thread.currentThread().getName());
    }
  }
}
