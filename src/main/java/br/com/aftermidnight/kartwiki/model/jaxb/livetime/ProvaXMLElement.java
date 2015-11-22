package br.com.aftermidnight.kartwiki.model.jaxb.livetime;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ProvaXMLElement {
			
	private Integer id; //ID="5912" 
	private String titulo; //TITULO="BATERIA INDOOR 08/11/2015 DOMINGO - CORRIDA - (BATERIA 6)&lt;br&gt;PISTA 2&lt;br&gt;CORRIDA (00:00)"
	private String data; //DATA="PROVA ENCERRADA"
	private String tempoProva; //TEMPOPROVA="PROVA ENCERRADA" 
	private String voltasRestantes; //VOLTASRESTANTES="0"
	private String tempoRestante; //TEMPORESTANTE="00:00:00" 
	private String melhorVoltaDaProva; //MELHORVOLTAPROVA="Melhor Volta: #4 - FABIO RAMOS - 00:59.800 - na volta 18" 
	private String bandeira; //BANDEIRA="iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAOdSURBVFhHrZdbTxNREMf7UXgkvNAKX4D3JpLoi098Ar+DgCgoF6OSgJQ75SJQBOQmlPtFbkIwyIMIifFBBSJguJWWv//p2d1qafcinWSymz17Zn4z5+ycWZfLQrKzs+/cy8k5yfN4Lp2ozJG5VvZNx91u921venoosjIJDLYAgRrgTS3QVwf011MblPbxvpfPZKzHB3RXA1P98Ho8IbHxXxBCL84xMwCUuYCH1CfUCmoltZpaS62hVlFfUOW9Ymo+tYA62gnvLU/IcSaMyMf7gMeaMXH+THPu47We6i+iFigQAYqHcPHZQBsh3PYzYUQe7AUe0IAYkehLqOXU5xpERwXwbRv4vAY0EEKeSwZKqQItWZC5om9buRxu60wYkQ93xSaLAUmnGBWAxhIV6Wg7onJyBLSXAWOdwERAvVdE1eF1iEBjFCLpnjAiH6QhfVL8NdgDhC+BlSlg2K8Ajg8AyUboAohEYkuWyEZnAyEyr2fCiLy3LblzMbj1QTldf8/d36zuD/eZAQJcnBGCcLJcyQKQ562vohBGJrKysu5Gd3uAEZlNlLHNVeV0ZY6fZGMMwF8OnJ8qgEILALHTXAWvOzMkvl33c3PPIh00ZuVcxj8uK6fLs0BXQwygrhg4OwEuQ2rth7mMvlJzm3WVEN+ujIyMsC3nArCxFANoZ+ER+bXHulAInBLgNzfka+35BmEtghLfrry0tEurF43x9UXldGkGaGHFEzn4yU8wX2VAAAJN2j7huxYA4tsZwBo3nw7QxHIrsvcdeMrs6BnQl2Z1PgUAWxvc+VQpMBKNGBX5tAZMv1P3x4es/zwnLs7VfbeWgZQAiFGRIxoWgEWmXuSK33sikRqx/0ONyLs3XoIFFhxdpMLNBhM7TvR0nnNvDOB7GTPt56YbH7IPMDeZAgCJQMqryFAP8K7fPkBKMiAAZ6xwIrMTwMy4fYCF6RRlYPeLcvp1V6ldmRpLEUBwxK7Lf98LjtoDsCzFdVrBcYoxYQ0QLcXRw8jqIAqHnboHJs2XQHxGDyPjODaDGGB75lRG2Mya2JQWIHocixgNiRnEJkuyE0liSyIX59daM6MlM4NY1zoiK5A1Ni5J7IjzpG26rUx0tALb7Ibj5Zznxs4O+0OOJ3CeNPL4vxZbmdAdFPO/oOTR9Q44AYBp5PEQtjJh9eVo47Yjv1EmLHa7418zHUbPxJXNaP9ee5mTcLc7/VM1fs/Zv0kPZ1ft/p7/AUT32Ndd6H38AAAAAElFTkSuQmCC"
	
	private List<ObservacaoXMLElement> observacoes = new ArrayList<ObservacaoXMLElement>();
	private List<PosicaoXMLElement> posicoes = new ArrayList<PosicaoXMLElement>(); 
	

	public ProvaXMLElement() {}

	@XmlAttribute(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlAttribute(name = "TITULO")
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@XmlAttribute(name = "DATA")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@XmlAttribute(name = "TEMPOPROVA")
	public String getTempoProva() {
		return tempoProva;
	}

	public void setTempoProva(String tempoProva) {
		this.tempoProva = tempoProva;
	}

	@XmlAttribute(name = "VOLTASRESTANTES")
	public String getVoltasRestantes() {
		return voltasRestantes;
	}

	public void setVoltasRestantes(String voltasRestantes) {
		this.voltasRestantes = voltasRestantes;
	}

	@XmlAttribute(name = "TEMPORESTANTE")
	public String getTempoRestante() {
		return tempoRestante;
	}

	public void setTempoRestante(String tempoRestante) {
		this.tempoRestante = tempoRestante;
	}

	@XmlAttribute(name = "MELHORVOLTAPROVA")
	public String getMelhorVoltaDaProva() {
		return melhorVoltaDaProva;
	}

	public void setMelhorVoltaDaProva(String melhorVoltaDaProva) {
		this.melhorVoltaDaProva = melhorVoltaDaProva;
	}

	@XmlAttribute(name = "BANDEIRA")
	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	@XmlElement(name = "OBSERVACOES")
	public List<ObservacaoXMLElement> getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(List<ObservacaoXMLElement> observacoes) {
		this.observacoes = observacoes;
	}
	
	@XmlElement(name = "POSICOES")
	public List<PosicaoXMLElement> getPosicoes() {
		return posicoes;
	}

	public void setPosicoes(List<PosicaoXMLElement> posicoes) {
		this.posicoes = posicoes;
	}

	@Override
	public String toString() {
		return "\n\tProvaXMLElement [getId()=" + getId() + ", getTitulo()=" + getTitulo() + ", getData()=" + getData()
				+ ", getTempoProva()=" + getTempoProva() + ", getVoltasRestantes()=" + getVoltasRestantes()
				+ ", getTempoRestante()=" + getTempoRestante() + ", getMelhorVoltaDaProva()=" + getMelhorVoltaDaProva()
				+ ", \n\t\tgetObservacoes()=" + getObservacoes() + ", \n\t\tgetPosicoes()=" + getPosicoes() + "]";
	}
	
	

}
