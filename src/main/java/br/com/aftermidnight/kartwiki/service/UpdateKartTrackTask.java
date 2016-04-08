package br.com.aftermidnight.kartwiki.service;

import java.util.Date;

import br.com.aftermidnight.kartwiki.dao.hibernate.KartTrackDAO;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.KartodromoXMLElement;
import br.com.aftermidnight.kartwiki.util.xml.JAXBHelper;

public class UpdateKartTrackTask extends Task {
   
	private String xmlUrl;

	private JAXBHelper jaxbHelper = new JAXBHelper();

	private KartTrackDAO dao = new KartTrackDAO();
	
	public UpdateKartTrackTask() {
		super("UpdateKartTrackTask");
	}
	
	public UpdateKartTrackTask(String name) {
		super(name);
	}

	
	@Override
	public void runningImplementation() {
	       System.out.println(getName()+ " : "+ new Date());
//	       KartodromoXMLElement  elem = readXmlData(getXmlUrl());
//
//	       proccessData(elem);
//	       
//	       System.out.println(dao.contarTotalDeRegistros());
	       
	}
	
	
	
	
	

	public String getXmlUrl() {
		return xmlUrl;
	}

	public void setXmlUrl(String xmlUrl) {
		this.xmlUrl = xmlUrl;
	}

	private KartodromoXMLElement readXmlData(String urlXml){
		System.out.println("Reading url:"+urlXml);
		return jaxbHelper.xml2JavaObject(xmlUrl, KartodromoXMLElement.class);
	}
	

	private void proccessData(KartodromoXMLElement k) {
		
		System.out.println("Processing "+ k);
//		
//		KartTrackTabelao t;
//		
//		dao.getEntityManager().getTransaction().begin();
//		
//		for(PosicaoXMLElement pos : k.getProva().getPosicoes()){
//			t = null;
//			
//			String hql = "from KartTrackTabelao k where k.kartNumber="+pos.getNumero()+" and k.lap="+pos.getVolta();
//			try{
//				t = dao.getEntityManager().createQuery(hql, KartTrackTabelao.class).getSingleResult();
//			}catch(NoResultException e){
//				t = null;
//			}
//			
//			if (t == null) t = new KartTrackTabelao();
//			
//			t.setRotuloDaBateria(k.getProva().getTitulo());
//			t.setLap(pos.getVolta());
//			t.setDriverName(pos.getNome());
//			t.setPosition(pos.getPosicao());
//			t.setKartNumber(pos.getNumero());
//			try {
//				t.setTime(MinutoSegundoMilisegundoAdapter.stringToDate(pos.getTempoVolta().trim()));
//			} catch (Exception e) {
//				e.printStackTrace();
//				t.setTime(null);
//			}
//			
//			
//			dao.getEntityManager().merge(t);
//			
//		}
//		
//		dao.getEntityManager().getTransaction().commit();
	}
	
	
}