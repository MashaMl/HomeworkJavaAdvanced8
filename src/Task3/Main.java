package Task3;

public class Main {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        main.setName("Main");
        main.setPriority(1);

        Thread priorityRunner = new Thread(new PriorityRunner());
        priorityRunner.setName("PriorityRunner");
        priorityRunner.setPriority(5);

        Thread priorityThread = new Thread(new PriorityThread());
        priorityThread.setName("PriorityThread");
        priorityThread.setPriority(10);

        priorityRunner.start();
        priorityThread.start();

        for(int i = 1; i < 51; ++i) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
class PriorityRunner implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i < 51; ++i) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
class PriorityThread extends Thread {
    @Override
    public void run() {
        for(int i = 1; i < 51; ++i) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
