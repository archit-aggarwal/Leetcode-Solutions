class FooBar {
    private int n;
    private boolean lock;

    public FooBar(int n) {
        this.n = n;
        lock = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            synchronized(this){
                if(lock == true) wait();
                // printFoo.run() outputs "foo"
        	    printFoo.run();
                lock = true;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            synchronized(this){
                if(lock == false) wait();
                // printBar.run() outputs "bar"
        	    printBar.run();
                lock = false;
                notifyAll();
            }
        }
    }
}