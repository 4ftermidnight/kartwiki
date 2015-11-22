package br.com.aftermidnight.kartwiki.model;



import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.aftermidnight.kartwiki.model.jaxb.livetime.KartodromoXMLElement;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.PosicaoXMLElement;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.adapter.MinutoSegundoMilisegundoAdapter;
import br.com.aftermidnight.kartwiki.util.xml.JAXBHelper;


public class KartTrackTest {
	
	private static EntityManagerFactory factory;
	
	private EntityManager em;
	
    
	@BeforeClass
    static public void init(){
		factory = Persistence.createEntityManagerFactory("kartwikiPU-JUnit");
    }
	
	@Before
	public void setUp() {
		this.em = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		this.em.close();
	}
    
	@AfterClass
	static public void finish(){
		
    }
	
//	@Ignore("Usado apenas para teste simples")
	@Test
	 public void saveKartTrack() {
		KartTrack entity = new KartTrack();
		
		entity.setName("Kartodromo para Teste");
		entity.setUrlSite("http://www.siteteste.com.br");
		entity.setUrlXml("http://laptime.sisecom.com.br/clientes/22157614CC3471X1Wp8CD9WE8/livetime.html");
		

		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		
	 }
	
	@Ignore("Usado apenas para teste simples")
	@Test
	public void testKartTrackConversorFromXml() {
		
	 }
	
	@Ignore("Usado apenas para teste simples")
	@Test
	public void testKartTrackIncludingAlgorithm() throws Exception {
		JAXBHelper jaxbHelper = new JAXBHelper();
		String xmlUrl = "http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml";
		KartodromoXMLElement k = jaxbHelper.xml2JavaObject(xmlUrl, KartodromoXMLElement.class);

		System.out.println("leu o xml: "+k);
		
		KartTrack kartTrack;
		
		em.getTransaction().begin();
		
		for(PosicaoXMLElement pos : k.getProva().getPosicoes()){
			kartTrack = null;
			
			String hql = "from KartTrack k where k.kartNumber="+pos.getNumero()+" and k.lap="+pos.getVolta();
			try{
				kartTrack = em.createQuery(hql, KartTrack.class).getSingleResult();
			}catch(NoResultException e){
				kartTrack = null;
			}
			
			if (kartTrack == null) kartTrack = new KartTrack();
			
//			kartTrack.setRotuloDaBateria(k.getProva().getTitulo());
//			kartTrack.setLap(pos.getVolta());
//			kartTrack.setDriverName(pos.getNome());
//			kartTrack.setPosition(pos.getPosicao());
//			kartTrack.setKartNumber(pos.getNumero());
//			kartTrack.setTime(MinutoSegundoMilisegundoAdapter.stringToDate(pos.getTempoVolta().trim()));
			
			
			em.merge(kartTrack);
			
		}
		
		em.getTransaction().commit();
		
	
	 }

	

    
    
}

