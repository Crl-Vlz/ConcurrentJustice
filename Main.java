public class Main {
    public static void main(String[] args) {
        DataCenter dc = new DataCenter();
        Worker[] wk = new Worker[5];
        System.out.println("Initial value: " + dc.getCount());
        for (int i = 0; i < 5; i++) {
            wk[i] = new Worker(dc, "Thread-" + i);
            wk[i].start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                wk[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Final value: " + dc.getCount());
    }
}
