package activity;

public class TaskRewrite {
    interface Task { void run(); }

    public static void main(String[] args) {
        Task job = new Task() {
            public void run(){
                System.out.println("Order placed");
            }
        };
        job.run();

        Task job2 = () -> System.out.println("Order placed via Lambda");
        job2.run();
    }
}
