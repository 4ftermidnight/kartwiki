package br.com.aftermidnight.kartwiki.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

import br.com.aftermidnight.kartwiki.dao.hibernate.KartTrackDAO;
import br.com.aftermidnight.kartwiki.model.KartTrackTabelao;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.KartodromoXMLElement;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.PosicaoXMLElement;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.adapter.MinutoSegundoMilisegundoAdapter;
import br.com.aftermidnight.kartwiki.service.Scheduler;
import br.com.aftermidnight.kartwiki.service.UpdateKartTrackTask;
import br.com.aftermidnight.kartwiki.service.UpdateKartTrackThread;
import br.com.aftermidnight.kartwiki.util.jsf.FacesUtil;
import br.com.aftermidnight.kartwiki.util.xml.JAXBHelper;

@ApplicationScoped
@Named
public class KartTrackUpdateServiceBean implements Serializable{

	private boolean running;

	@Inject private UpdateKartTrackThread thread;
	
	@Inject	private KartTrackDAO dao;
	
	
	private UpdateKartTrackTask taskUpdateKartTrack = new UpdateKartTrackTask();
	private Scheduler scheduler = new Scheduler();
	
	
	
	
	
	public KartTrackUpdateServiceBean(){}
	
	@PostConstruct
    public void afterCreate() {
//		thread.setXmlUrl("http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml");
//		thread.start();
		setup();
    }
	
	@PreDestroy
    public void preDestroy() {
		
    }
	
	private void setup(){
		scheduler.schedule(taskUpdateKartTrack);
//		scheduler.pause();
	}
	
	public void resume(){
		if(isRunning()){
			FacesUtil.info("Serviço já está iniciado");
		} else {	
			scheduler.resume();
			FacesUtil.info("Serviço iniciado");
		}
	}
	
	public void pause(){
		if(isPaused()){
			FacesUtil.info("Serviço já está parado");
		} else {
			scheduler.pause();
			FacesUtil.info("Serviço paradoo");
		}
	}
	

	public boolean isRunning() {
		System.out.println("isRunning:"+ scheduler.isRunning());
		return scheduler.isRunning();
	}
	
	public boolean isPaused() {
		System.out.println("isPaused:"+scheduler.isPaused());
		return scheduler.isPaused();
	}
	
	
	
	

	
	
	
	
	
	
	
	
	//TODO: remover para classe especifica e colcoar numa thread
	private KartodromoXMLElement readXmlData(String urlXml){
		System.out.println("Processando url:"+urlXml);
		JAXBHelper jaxbHelper = new JAXBHelper();
		String xmlUrl = "http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml";
		return jaxbHelper.xml2JavaObject(xmlUrl, KartodromoXMLElement.class);
	}
	//TODO: remover para classe especifica e colcoar numa thread
	private void proccessData(KartodromoXMLElement k) {
		
		KartTrackTabelao t;
		
		dao.getEntityManager().getTransaction().begin();
		
		for(PosicaoXMLElement pos : k.getProva().getPosicoes()){
			t = null;
			
			String hql = "from KartTrackTabelao k where k.kartNumber="+pos.getNumero()+" and k.lap="+pos.getVolta();
			try{
				t = dao.getEntityManager().createQuery(hql, KartTrackTabelao.class).getSingleResult();
			}catch(NoResultException e){
				t = null;
			}
			
			if (t == null) t = new KartTrackTabelao();
			
			t.setRotuloDaBateria(k.getProva().getTitulo());
			t.setLap(pos.getVolta());
			t.setDriverName(pos.getNome());
			t.setPosition(pos.getPosicao());
			t.setKartNumber(pos.getNumero());
			try {
				t.setTime(MinutoSegundoMilisegundoAdapter.stringToDate(pos.getTempoVolta().trim()));
			} catch (Exception e) {
				e.printStackTrace();
				t.setTime(null);
			}
			
			
			dao.getEntityManager().merge(t);
			
		}
		
		dao.getEntityManager().getTransaction().commit();
	}
	
}
