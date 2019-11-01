# ThreadPoolTaskExecutorApplicationDemo

### Documentation
Variables to play with:
 * numberOfTasks - The number of how many parallel execution of a task we want to run. The fake task takes 2 seconds to complete.
 * corePoolSize - The number of initial threads the executor will use to execute our fake tasks
 * maxPoolSize - The maximum number of threads the executor will use to execute our fake tasks
 * queueSizeOfThreadPool - The size of the queue for that executor. Use null for DEFAULT.

The queue used by the ThreadPoolTaskExecutor class is a LinkedBlockingQueue. This is an unbounded queue which means 
it will cause new tasks to be queued in cases where all corePoolSize threads are busy. 
Thus, no more than corePoolSize threads will ever be created (does not have any effect).
When the queue is full THEN AND ONLY THEN new threads are created
up to the maxPoolSize to handle the tasks in the queue. The default value of the queue is Integer.MAX_VALUE which basically means
if we do not set the queue size the maxPoolSize property will NEVER be used. (Unless somehow the system is flooded with 0x7fffffff concurrent tasks)

### Additional Links
ThreadPoolTaskExecutor doc:

* [ThreadPoolTaskExecutor documentation](https://docs.oracle.com/javase/1.5.0/docs/api/java/util/concurrent/ThreadPoolExecutor.html)

