import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private String tasks;
    public Task(String tasks) {
        this.tasks = tasks;
    }
    @Override
    public void run() {
        System.out.println("Starting " + tasks + " " + Thread.currentThread().getName());
        // Simulate some work
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished " + tasks + " " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an ExecutorService with 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // Submit tasks to the ExecutorService
        executorService.submit(new Task("Task 1"));
        executorService.submit(new Task("Task 2"));
        executorService.submit(new Task("Task 3"));
        executorService.submit(new Task("Task 4"));
        executorService.submit(new Task("Task 5"));

        //another way of doing same thing as we have done above
        //  Task task1 = new Task("Task 1");
        //  Thread task1obj = new Thread(task1);
        //  executorService.submit(task1obj);

        // Shutdown the ExecutorService
        executorService.shutdown();
    }
}