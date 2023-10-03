public class Worker extends Thread {

    private DataCenter data;
    private int i;

    public Worker(DataCenter d, String name) {
        super(name);
        this.data = d;
        i = 0;
    }

    @Override
    public void run() {

        while (i < 1000) {
            synchronized (data) {
                while (data.getState()) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                data.setInUse();
            }
            data.increment();
            i++;
            System.out.println(getName() + " increments");

            synchronized (data) {
                data.setFree();
                data.notify();
            }

        }

    }

}
