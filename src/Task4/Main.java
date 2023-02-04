package Task4;

public class Main {
    public static void main(String[] args) {
        Print print = new Print();
        First first = new First(print);
        Second second = new Second(print);

        first.start();
        second.start();
    }
}

class First extends Thread{
    Print print;
    String id = "Class 1";
    public First(Print print) { this.print = print; }

    @Override
    public void run() {
        for(int i = 0; i < 5; ++i) {
            print.printFirst(id);
        }
    }
}
class Second extends Thread {
    Print print;
    String id = "Class 2";

    public Second(Print print) { this.print = print; }
    @Override
    public void run() {
        for(int i = 0; i < 5; ++i) {
            print.printSecond(id);
        }
    }
}
class Print {
    boolean check;

    synchronized public void printFirst(String str) {
        if(!check) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(str);
        check = false;
        notify();
    }

    synchronized public void printSecond(String str) {
        if(check) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(str);
        check = true;
        notify();
    }


}