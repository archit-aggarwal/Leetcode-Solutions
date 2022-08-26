class H2O {
    private int hydrogen = 2, oxygen = 1;

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		while(hydrogen == 0 && oxygen == 1) wait();
        releaseHydrogen.run();
        hydrogen--;
        if(hydrogen == 0 && oxygen == 0){
            hydrogen = 2; oxygen = 1;
        }
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while(hydrogen > 0 && oxygen == 0) wait();
        releaseOxygen.run();
        oxygen--;
        if(hydrogen == 0 && oxygen == 0){
            hydrogen = 2; oxygen = 1;
        }
        notifyAll();
    }
}