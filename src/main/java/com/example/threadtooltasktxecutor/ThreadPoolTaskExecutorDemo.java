package com.example.threadtooltasktxecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Demo of Spring's ThreadPoolTaskExecutor usage to find the required numbers of our application.
 *
 * numberOfTasks - The number of how many parallel execution of a task we want to run. The fake task takes 2 seconds to complete.
 *
 * corePoolSize - The number of initial threads the executor will use to execute our fake tasks
 * maxPoolSize - The maximum number of threads the executor will use to execute our fake tasks
 * queueSizeOfThreadPool - The size of the queue for that executor.
 *                         null = DEFAULT.
 *                         0 = no queue at all.
 *
 * The queue is used when ALL core pool threads are busy. When the queue is full THEN AND ONLY THEN new threads are created
 * up to the maxPoolSize to handle the tasks in the queue. The default value of the queue is Integer.MAX_VALUE which basically means
 * if we do not set the queue size the maxPoolSize property will NEVER be used. (Unless somehow the system is flooded with 0x7fffffff concurrent tasks)
 * If the queue is full and all threads are busy then the new task is rejected and an exception is thrown.
 */
@SpringBootApplication
public class ThreadPoolTaskExecutorDemo {

  private static final int numberOfTasks = 10;

  protected static final int corePoolSize = 5;
  protected static final int maxPoolSize = 10;
  protected static final Integer queueSizeOfThreadPool = 1;

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(ThreadPoolTaskExecutorDemo.class, args);
    ThreadPoolTaskExecutor myExecutor = (ThreadPoolTaskExecutor) context.getBean("myExecutor");
    myExecutor.setWaitForTasksToCompleteOnShutdown(true);

    for (int i = 1; i <= numberOfTasks; i++) {
      myExecutor.submit(new FakeTask(i));
    }

    context.close();
  }

}
