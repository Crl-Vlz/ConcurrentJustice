public class DataCenter {
    private int count;
    private volatile boolean inUse;

    public DataCenter() {
        this.count = 0;
        this.inUse = false;
    }

    public void increment() {
        synchronized (this) {
            this.count++;
        }
    }

    public void decrement() {
        this.count--;
    }

    public int getCount() {
        return this.count;
    }

    public void setInUse() {
        synchronized (this) {
            this.inUse = true;
        }
    }

    public void setFree() {
        synchronized (this) {
            this.inUse = false;
        }
    }

    public boolean getState() {
        return this.inUse;
    }

}