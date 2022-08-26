class ZeroEvenOdd {
    private int n, ptr = 1;
    private boolean zeroLock = false;
    
    public ZeroEvenOdd(int n) { this.n = n; }

    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while(ptr <= n){
            while(zeroLock == true) wait();
            if(ptr <= n) printNumber.accept(0);
            zeroLock = true;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while(ptr <= n){
            while(zeroLock == false || ptr % 2 == 1) wait();
            if(ptr <= n) printNumber.accept(ptr);
            zeroLock = false; ptr++;
            notifyAll(); 
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while(ptr <= n){
            while(zeroLock == false || ptr % 2 == 0) wait();
            if(ptr <= n) printNumber.accept(ptr);
            zeroLock = false; ptr++;
            notifyAll(); 
        }
    }
}