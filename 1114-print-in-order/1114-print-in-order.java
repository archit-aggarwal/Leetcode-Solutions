class Foo {
    private int lock = 0;
    
    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        lock = 1;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(lock < 1) wait();
        printSecond.run();
        lock = 2;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(lock < 2) wait();
        printThird.run();
        lock = 3;
        notifyAll();
    }
}