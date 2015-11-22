package br.com.aftermidnight.kartwiki.util.xml;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.aftermidnight.kartwiki.model.jaxb.livetime.KartodromoXMLElement;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.PosicaoXMLElement;
import br.com.aftermidnight.kartwiki.model.jaxb.livetime.ProvaXMLElement;
import br.com.aftermidnight.kartwiki.util.file.FileDownloader;


public class JAXBHelperTest {

	private static final JAXBHelper jaxbHelper = new JAXBHelper();
    
	@BeforeClass
    static public void antesDosTestes(){
//    	System.out.println("Iniciando teste JAXBHelper");
    }
    
	@AfterClass
	static public void depoisDosTestes(){
//    	System.out.println("Finalizando teste JAXBHelper");
    }
    
   
//    @Test
    public void testarBaixarLivetimeXML() {
    	String fileNameOut = "src/test/resources/xml/";
    	String url = "http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml";
		FileDownloader.gravaArquivoDeURL(url, fileNameOut, "out.xml");
		assertTrue(new File(fileNameOut).exists());
    }
    
//    @Test
    public void testarLivetimeConversaoXML2ObjetoJava() {
    	String fileNameIn = "src/test/resources/xml/livetime-teste.xml";
    	KartodromoXMLElement k = jaxbHelper.xml2JavaObject(new File(fileNameIn), KartodromoXMLElement.class);
//    	System.out.println(k);     

    	assertEquals(k.getNome().trim(), "SAN MARINO KART LTDA" );
    	assertEquals(k.getLogomarca(), "" );
    	
    	assertEquals(k.getProva().getId().intValue(), 5912);
    	assertEquals(k.getProva().getTitulo().trim(), "BATERIA INDOOR 08/11/2015 DOMINGO - CORRIDA - (BATERIA 6)<br>PISTA 2<br>CORRIDA (00:00)");
    	assertEquals(k.getProva().getData(), "PROVA ENCERRADA");
    	assertEquals(k.getProva().getTempoProva(), "PROVA ENCERRADA");
    	assertEquals(k.getProva().getVoltasRestantes(), "0");
    	assertEquals(k.getProva().getTempoRestante(), "00:00:00");
    	assertEquals(k.getProva().getMelhorVoltaDaProva(), "Melhor Volta: #4 - FABIO RAMOS - 00:59.800 - na volta 18");
    	assertEquals(k.getProva().getTempoRestante(), "00:00:00");
    	assertEquals(k.getProva().getBandeira(), "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAOdSURBVFhHrZdbTxNREMf7UXgkvNAKX4D3JpLoi098Ar+DgCgoF6OSgJQ75SJQBOQmlPtFbkIwyIMIifFBBSJguJWWv//p2d1qafcinWSymz17Zn4z5+ycWZfLQrKzs+/cy8k5yfN4Lp2ozJG5VvZNx91u921venoosjIJDLYAgRrgTS3QVwf011MblPbxvpfPZKzHB3RXA1P98Ho8IbHxXxBCL84xMwCUuYCH1CfUCmoltZpaS62hVlFfUOW9Ymo+tYA62gnvLU/IcSaMyMf7gMeaMXH+THPu47We6i+iFigQAYqHcPHZQBsh3PYzYUQe7AUe0IAYkehLqOXU5xpERwXwbRv4vAY0EEKeSwZKqQItWZC5om9buRxu60wYkQ93xSaLAUmnGBWAxhIV6Wg7onJyBLSXAWOdwERAvVdE1eF1iEBjFCLpnjAiH6QhfVL8NdgDhC+BlSlg2K8Ajg8AyUboAohEYkuWyEZnAyEyr2fCiLy3LblzMbj1QTldf8/d36zuD/eZAQJcnBGCcLJcyQKQ562vohBGJrKysu5Gd3uAEZlNlLHNVeV0ZY6fZGMMwF8OnJ8qgEILALHTXAWvOzMkvl33c3PPIh00ZuVcxj8uK6fLs0BXQwygrhg4OwEuQ2rth7mMvlJzm3WVEN+ujIyMsC3nArCxFANoZ+ER+bXHulAInBLgNzfka+35BmEtghLfrry0tEurF43x9UXldGkGaGHFEzn4yU8wX2VAAAJN2j7huxYA4tsZwBo3nw7QxHIrsvcdeMrs6BnQl2Z1PgUAWxvc+VQpMBKNGBX5tAZMv1P3x4es/zwnLs7VfbeWgZQAiFGRIxoWgEWmXuSK33sikRqx/0ONyLs3XoIFFhxdpMLNBhM7TvR0nnNvDOB7GTPt56YbH7IPMDeZAgCJQMqryFAP8K7fPkBKMiAAZ6xwIrMTwMy4fYCF6RRlYPeLcvp1V6ldmRpLEUBwxK7Lf98LjtoDsCzFdVrBcYoxYQ0QLcXRw8jqIAqHnboHJs2XQHxGDyPjODaDGGB75lRG2Mya2JQWIHocixgNiRnEJkuyE0liSyIX59daM6MlM4NY1zoiK5A1Ni5J7IjzpG26rUx0tALb7Ibj5Zznxs4O+0OOJ3CeNPL4vxZbmdAdFPO/oOTR9Q44AYBp5PEQtjJh9eVo47Yjv1EmLHa7418zHUbPxJXNaP9ee5mTcLc7/VM1fs/Zv0kPZ1ft/p7/AUT32Ndd6H38AAAAAElFTkSuQmCC");
    	
    	assertEquals(k.getProva().getObservacoes().get(0).getTexto(), "LAPTIME - SISTEMA DE CRONOMETRAGEM - WWW.LAPTIME.COM.BR");
    	
    }
    
    @Test
    public void testarLivetimeConversaoUrlXML2ObjetoJava() {
    	String xmlUrl= "http://laptime.sisecom.com.br/clientes/22157614CC3471X1WP8CD9WE8/livetime.xml";
    	KartodromoXMLElement k = jaxbHelper.xml2JavaObject(xmlUrl, KartodromoXMLElement.class);
    	
    	System.out.println(k);  

    }
    
//    @Test
    public void testarGerarXML() {
    	String fileNameOut = "src/test/resources/xml/out"+new Date().getTime()+".xml";
    	
    	KartodromoXMLElement k = new KartodromoXMLElement();
    	ProvaXMLElement prova = new ProvaXMLElement();
    	prova.getPosicoes().add(new PosicaoXMLElement(1,11,"asdasd"));
    	prova.getPosicoes().add(new PosicaoXMLElement(2,22,"asdasd"));
    	k.setProva(prova);
    	
    	
    	jaxbHelper.javaObject2Xml(fileNameOut, KartodromoXMLElement.class, k);
    	System.out.println(k);
        
        assertTrue(new File(fileNameOut).exists());
        
    }
    
    
    
    
}

