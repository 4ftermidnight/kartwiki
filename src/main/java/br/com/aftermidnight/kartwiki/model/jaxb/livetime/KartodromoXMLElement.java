package br.com.aftermidnight.kartwiki.model.jaxb.livetime;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "KARTODROMOS")
@XmlType(propOrder = {"nome", "logomarca","prova"})
public class KartodromoXMLElement {
	
	private String nome;
		
	private String logomarca;

	private ProvaXMLElement prova;
	

	public KartodromoXMLElement() {
		super();
	}

	
	public KartodromoXMLElement(String nome) {
		super();
		this.nome = nome;
	}
	
	public KartodromoXMLElement(String nome, ProvaXMLElement prova) {
		super();
		this.nome = nome;
		this.prova = prova;
	}

	
	@XmlElement(name = "PROVA")
	public ProvaXMLElement getProva() {
		return prova;
	}


	public void setProva(ProvaXMLElement prova) {
		this.prova = prova;
	}

	@XmlAttribute(name="NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlAttribute(name="LOGOMARCA")
	public String getLogomarca() {
		return logomarca;
	}

	public void setLogomarca(String logomarca) {
		this.logomarca = logomarca;
	}


	@Override
	public String toString() {
		return "KartodromoXMLElement [getProva()=" + getProva() + ", getNome()=" + getNome() + ", getLogomarca()="
				+ getLogomarca() + "]";
	}
	
	

}
