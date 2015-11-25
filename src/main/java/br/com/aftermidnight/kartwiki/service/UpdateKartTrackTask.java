package br.com.aftermidnight.kartwiki.service;

import java.util.concurrent.TimeUnit;

public class UpdateKartTrackTask extends Task {
   
	public UpdateKartTrackTask() {
		super("UpdateKartTrackTask");
	}
	
	public UpdateKartTrackTask(String name) {
		super(name);
	}

	@Override
    public void run()
    {
        try
        {
        	while(isRunning()){
        		Long duration = (long) (Math.random() * 5);
                System.out.println("Doing a task during : " + getName());
                TimeUnit.SECONDS.sleep(duration);
        	}
            
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}