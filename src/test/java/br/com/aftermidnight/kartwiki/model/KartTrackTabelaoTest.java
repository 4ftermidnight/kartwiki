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


public class KartTrackTabelaoTest {
	
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
	@Ignore("Usado apenas para teste simples")
	@Test
	 public void salvarKartodromo() {
		KartTrackTabelao k = new KartTrackTabelao();
		
		k.setDriverName("Matheus");
		k.setKartNumber(1);
		k.setLap(1);
		k.setPosition(1);
		k.setRotuloDaBateria("Bateria 1");
		k.setTime(new Date());
		
		
		em.getTransaction().begin();
		em.merge(k);
		em.getTransaction().commit();
		
	 }

//	@Test
	 public void salvarCenario2() {
			KartTrackTabelao k = new KartTrackTabelao();
			
			em.getTransaction().begin();
			
			
			k.setDriverName("Matheus");
			k.setKartNumber(1);
			k.setLap(1);
			k.setPosition(1);
			k.setRotuloDaBateria("Bateria 1");
			k.setTime(new Date());
				
			
			em.merge(k);
			
			
			k.setDriverName("Nicolas");
			k.setKartNumber(2);
			k.setLap(1);
			k.setPosition(1);
			k.setRotuloDaBateria("Bateria 1");
			k.setTime(new Date());
			
			em.merge(k);
			
			String hql = "from KartTrackTabelao k where k.kartNumber=1";
			KartTrackTabelao k2 = em.createQuery(hql, KartTrackTabelao.class).getSingleResult();
			System.out.println(k2);
			
			
			em.getTransaction().commit();
	 }
	
	@Test
	public void testarAlgoritmoDeInclusao() throws Exception {
		JAXBHelper jaxbHelper = new JAXBHelper();
		String xmlUrl = "http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml";
		KartodromoXMLElement k = jaxbHelper.xml2JavaObject(xmlUrl, KartodromoXMLElement.class);

		System.out.println("leu o xml: "+k);
		
		KartTrackTabelao t;
		
		em.getTransaction().begin();
		
		for(PosicaoXMLElement pos : k.getProva().getPosicoes()){
			t = null;
			
			String hql = "from KartTrackTabelao k where k.kartNumber="+pos.getNumero()+" and k.lap="+pos.getVolta();
			try{
				t = em.createQuery(hql, KartTrackTabelao.class).getSingleResult();
			}catch(NoResultException e){
				t = null;
			}
			
			if (t == null) t = new KartTrackTabelao();
			
			t.setRotuloDaBateria(k.getProva().getTitulo());
			t.setLap(pos.getVolta());
			t.setDriverName(pos.getNome());
			t.setPosition(pos.getPosicao());
			t.setKartNumber(pos.getNumero());
			t.setTime(MinutoSegundoMilisegundoAdapter.stringToDate(pos.getTempoVolta().trim()));
			
			
			em.merge(t);
			
		}
		
		em.getTransaction().commit();
		
	
	 }

	

    
    
}

