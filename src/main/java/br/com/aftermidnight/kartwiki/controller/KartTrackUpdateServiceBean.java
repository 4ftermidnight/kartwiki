package br.com.aftermidnight.kartwiki.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aftermidnight.kartwiki.dao.hibernate.KartTrackDAO;
import br.com.aftermidnight.kartwiki.model.KartTrack;
import br.com.aftermidnight.kartwiki.service.UpdateKartTrackTask;
import br.com.aftermidnight.kartwiki.util.jsf.FacesUtil;

@ApplicationScoped
@Named
public class KartTrackUpdateServiceBean implements Serializable{

	private List<UpdateKartTrackTask> tasks;
	
	@Inject
	private KartTrackDAO dao;
	
	
	public KartTrackUpdateServiceBean(){}
	
	@PostConstruct
    public void afterCreate() {
		setup();
		
    }
	
	@PreDestroy
    public void preDestroy() {
		
    }
	
	private void setup(){
		tasks = new ArrayList<>();
	
		for(KartTrack k : dao.buscarTodos()){
			System.out.println(k.getName());
		}
		
		
		//ler os kartodromos cadastrados no banco (ver questão de sincronismo)
		UpdateKartTrackTask task = new UpdateKartTrackTask("task1");
		task.setXmlUrl("http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml");
		task.start();
		
		tasks.add(task);
	}
	
	public void resume(){
		if(isRunning()){
			FacesUtil.info("Serviço já está iniciado");
		} else {
			for(UpdateKartTrackTask task : tasks){
				task.unpause();
			}
			
			FacesUtil.info("Serviço iniciado");
		}
	}
	
	public void pause(){
		if(isPaused()){
			FacesUtil.info("Serviço já está parado");
		} else {
			for(UpdateKartTrackTask task : tasks){
				task.pause();
			}
			FacesUtil.info("Serviço paradoo");
		}
	}
	

	public boolean isRunning() {
		for(UpdateKartTrackTask task : tasks){
			if(task.isRunning() == false){
				return false;
			}
		}
		return true;
	}
	
	public boolean isPaused() {
		for(UpdateKartTrackTask task : tasks){
			if(task.isPaused() == false){
				return false;
			}
		}
		return true;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
}
