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
import br.com.aftermidnight.kartwiki.service.UpdateKartTrackThread;
import br.com.aftermidnight.kartwiki.util.jsf.FacesUtil;
import br.com.aftermidnight.kartwiki.util.xml.JAXBHelper;

@ApplicationScoped
@Named
public class KartTrackUpdateServiceBean implements Serializable{

	private boolean running = false;

	@Inject private UpdateKartTrackThread thread;
	
	@Inject	private KartTrackDAO dao;
	
	public KartTrackUpdateServiceBean(){}
	
	@PostConstruct
    public void afterCreate() {
//		thread.setXmlUrl("http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml");
//		thread.start();
    }
	
	@PreDestroy
    public void preDestroy() {
		
    }
	
	
	public void startKartTrackUpdateService(){		
		if(isRunning()){
			FacesUtil.info("Serviço já está iniciado");
		} else {
			KartodromoXMLElement k = readXmlData("http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml");
			
			System.out.println("leu: "+k);
			
			proccessData(k);
//			thread.notifyAll();
//			running = true;
			FacesUtil.info("Serviço iniciado");
		}
	}
	
	public void stopKartTrackUpdateService(){
		if(!isRunning()){
			FacesUtil.info("Serviço já está parado");
		} else {
			try {
				thread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			running = false;
			FacesUtil.info("Serviço paradoo");
		}
	}
	

	public boolean isRunning() {
		return thread.isAlive();
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
