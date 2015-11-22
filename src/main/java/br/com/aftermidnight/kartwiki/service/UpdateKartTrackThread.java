package br.com.aftermidnight.kartwiki.service;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.aftermidnight.kartwiki.dao.hibernate.KartTrackDAO;
import br.com.aftermidnight.kartwiki.model.KartTrackTabelao;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.KartodromoXMLElement;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.PosicaoXMLElement;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.adapter.MinutoSegundoMilisegundoAdapter;
import br.com.aftermidnight.kartwiki.util.xml.JAXBHelper;


public class UpdateKartTrackThread extends Thread implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject @ApplicationScoped
	private KartTrackDAO dao;
	
	private String xmlUrl;
	
	
	public UpdateKartTrackThread(KartTrackDAO dao) {
		this.dao = dao;
	}
	
	public UpdateKartTrackThread() {
		super();
	}

	

	public void run() {
		while(true){
			System.out.println("[("+this.getId()+")"+this.getName()+"] running...");
			
			KartodromoXMLElement k = readXmlData(getXmlUrl());
			
			System.out.println("leu: "+k);
			
			proccessData(k);
			
			
			try {
				Thread.sleep(1000*5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private KartodromoXMLElement readXmlData(String urlXml){
		System.out.println("Processando url:"+urlXml);
		JAXBHelper jaxbHelper = new JAXBHelper();
		String xmlUrl = "http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml";
		return jaxbHelper.xml2JavaObject(xmlUrl, KartodromoXMLElement.class);
	}
	
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
	
	public String getXmlUrl() {
		return xmlUrl;
	}


	public void setXmlUrl(String xmlUrl) {
		this.xmlUrl = xmlUrl;
	}

	
	
}
