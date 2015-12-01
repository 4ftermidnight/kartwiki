package br.com.aftermidnight.kartwiki.service;

import java.util.concurrent.TimeUnit;

public abstract class Task extends Thread {

    private boolean isPaused = true;
 
    public Task(String name) {
        super(name);
    }
 
	public boolean isRunning() {
		return !isPaused;
	}

	public boolean isPaused() {
		return isPaused;
	}
    
    private void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
    
    public void pause(){
    	setPaused(true);
    }
    
    public void unpause(){
    	setPaused(false);
//    	notify();
    }
    
    abstract public void runningImplementation();
    
    @Override
    public void run() {
        try {
        	while(true){
		
//	                while (isPaused()) {
//		                    try {
//		                        wait();
//		                    } catch (Exception e) { }
//		                }
        		synchronized (this) {
        			if(isRunning()){	                
            			runningImplementation();
            		}
				}
        		
        		
        		TimeUnit.SECONDS.sleep(10);
        	}
             	
        }catch(Exception e){
        	e.printStackTrace();
        	
        }
    	
    	
    }

	
}