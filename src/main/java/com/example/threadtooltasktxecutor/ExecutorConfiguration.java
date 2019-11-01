package com.example.threadtooltasktxecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import static com.example.threadtooltasktxecutor.ThreadPoolTaskExecutorDemo.*;

/**
 * com.example.threadtooltasktxecutor.Executor, created on 01/11/2019 10:05 <p>
 * @author NikolaosK
 */
@Configuration
public class ExecutorConfiguration {

  @Bean("myExecutor")
  public ThreadPoolTaskExecutor getTaskExecutor() {
    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    if (queueSizeOfThreadPool != null) {
      taskExecutor.setQueueCapacity(queueSizeOfThreadPool);
    }
    taskExecutor.setCorePoolSize(corePoolSize);
    taskExecutor.setMaxPoolSize(maxPoolSize);

    return taskExecutor;
  }

}
