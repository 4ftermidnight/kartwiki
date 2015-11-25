package br.com.aftermidnight.kartwiki.service;

public abstract class Task implements Runnable{

	private String name;
    private boolean isPaused;
 
    public Task(String name) 
    {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
	public boolean isRunning() {
		return !isPaused;
	}

	public boolean isPaused() {
		return isPaused;
	}
    
    public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	
}