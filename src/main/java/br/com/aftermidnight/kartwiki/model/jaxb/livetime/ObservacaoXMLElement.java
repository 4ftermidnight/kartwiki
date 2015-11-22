package br.com.aftermidnight.kartwiki.model.jaxb.livetime;

import javax.xml.bind.annotation.XmlElement;

public class ObservacaoXMLElement {

	private String texto;

	@XmlElement(name="TEXTO")
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "\n\tObservacaoXMLElement [getTexto()=" + getTexto() + "]";
	}
	
	
	
	
}
