class ZeroEvenOdd {
    private int n;
    private int ptr = 1;
    private boolean zeroLock = false;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(ptr <= n){
            synchronized(this){ 
                while(zeroLock == true) wait();
                if(ptr <= n) printNumber.accept(0);
                zeroLock = true;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(ptr <= n){
            synchronized(this){ 
                while(zeroLock == false || ptr % 2 == 1) wait();
                if(ptr <= n) printNumber.accept(ptr);
                zeroLock = false;
                ptr++;
                notifyAll(); 
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(ptr <= n){
            synchronized(this){ 
                while(zeroLock == false || ptr % 2 == 0) wait();
                if(ptr <= n) printNumber.accept(ptr);
                zeroLock = false;
                ptr++;
                notifyAll(); 
            }
        }
    }
}