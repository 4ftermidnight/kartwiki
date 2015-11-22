package br.com.aftermidnight.kartwiki.model.jaxb.livetime;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PosicaoXMLElement {
	private byte[] setas; //<SETAS>iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAVSURBVDhPY2AYBaMhMBoCoyEACQEABBAAAXKlE3YAAAAASUVORK5CYII=</SETAS>
	private Integer posicao; // <POS>2</POS>
	private Integer numero; //<NUMERO>14</NUMERO>
	private String nome; //<NOME>THIAGO POERSCH</NOME>
	private String categoria; //<CATEGORIA>INDOOR</CATEGORIA>
	private Integer volta; // <VOLTA>20</VOLTA>
	private String tempoVolta; //<TEMPO_VOLTA>01:02.113</TEMPO_VOLTA>
	private String tempoTotal; //  <TEMPO_TOTAL>00:20:57.753</TEMPO_TOTAL>
	private Integer melhorVolta; // <MELHOR_VOLTA>11</MELHOR_VOLTA>
	private String tempoMelhorVolta; //<TEMPO_MELHOR_VOLTA>01:01.909</TEMPO_MELHOR_VOLTA>
	private String melhorVolta2; //<MELHOR_VOLTA2>17</MELHOR_VOLTA2>
	private String tempoMelhorVolta2; //<TEMPO_MELHOR_VOLTA2>01:01.939</TEMPO_MELHOR_VOLTA2>
	private String difl; //<DIFL>00:42.603</DIFL>
	private String difa; //<DIFA>00:42.603</DIFA>
	private Double velocidade; //<VELOCIDADE>0,00</VELOCIDADE>
	private Integer pIni; //<P_INI>0</P_INI>
	private Integer trechos; //<TRECHOS>0</TRECHOS>
	private String tempoVoltaIdeal; //<VOLTAIDEAL>00:00.000</VOLTAIDEAL>
	
	
	
	public PosicaoXMLElement(Integer posicao, Integer numero, String nome) {
		super();
		this.posicao = posicao;
		this.numero = numero;
		this.nome = nome;
	}

	public PosicaoXMLElement() {
		super();
	}

	@XmlElement(name="POS")
	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	@XmlElement(name="NUMERO")
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@XmlElement(name="NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement(name="CATEGORIA")
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@XmlElement(name="VOLTA")
	public Integer getVolta() {
		return volta;
	}

	public void setVolta(Integer volta) {
		this.volta = volta;
	}

	
	@XmlElement(name="TEMPO_VOLTA")
	public String getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	@XmlElement(name="TEMPO_TOTAL")
	public String getTempoTotal() {
		return tempoTotal;
	}

	public void setTempoTotal(String tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	@XmlElement(name="MELHOR_VOLTA")
	public Integer getMelhorVolta() {
		return melhorVolta;
	}

	public void setMelhorVolta(Integer melhorVolta) {
		this.melhorVolta = melhorVolta;
	}

	@XmlElement(name="TEMPO_MELHOR_VOLTA")
	public String getTempoMelhorVolta() {
		return tempoMelhorVolta;
	}

	public void setTempoMelhorVolta(String tempoMelhorVolta) {
		this.tempoMelhorVolta = tempoMelhorVolta;
	}

	@XmlElement(name="MELHOR_VOLTA2")
	public String getMelhorVolta2() {
		return melhorVolta2;
	}

	public void setMelhorVolta2(String melhorVolta2) {
		this.melhorVolta2 = melhorVolta2;
	}

	@XmlElement(name="TEMPO_MELHOR_VOLTA2")
	public String getTempoMelhorVolta2() {
		return tempoMelhorVolta2;
	}

	public void setTempoMelhorVolta2(String tempoMelhorVolta2) {
		this.tempoMelhorVolta2 = tempoMelhorVolta2;
	}

	@XmlElement(name="DIFL")
	public String getDifl() {
		return difl;
	}

	public void setDifl(String difl) {
		this.difl = difl;
	}

	@XmlElement(name="DIFA")
	public String getDifa() {
		return difa;
	}

	public void setDifa(String difa) {
		this.difa = difa;
	}

	@XmlElement(name="VELOCIDADE")
	public Double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}
	
	@XmlElement(name="SETAS")
	public byte[] getSetas() {
		return setas;
	}

	public void setSetas(byte[] setas) {
		this.setas = setas;
	}

	@XmlElement(name="TRECHOS")
	public Integer getTrechos() {
		return trechos;
	}

	public void setTrechos(Integer trechos) {
		this.trechos = trechos;
	}

	@XmlAttribute(name="P_INI")
	public Integer getpIni() {
		return pIni;
	}

	public void setpIni(Integer pIni) {
		this.pIni = pIni;
	}

	@XmlAttribute(name="VOLTAIDEAL")
	public String getTempoVoltaIdeal() {
		return tempoVoltaIdeal;
	}

	public void setTempoVoltaIdeal(String tempoVoltaIdeal) {
		this.tempoVoltaIdeal = tempoVoltaIdeal;
	}

	@Override
	public String toString() {
		return "\n\tPosicaoXMLElement [getPosicao()=" + getPosicao() + ", getNumero()=" + getNumero() + ", getNome()=" + getNome()
				+ ", getCategoria()=" + getCategoria() + ", getVolta()=" + getVolta() + ", getTempoVolta()="
				+ getTempoVolta() + ", getTempoTotal()=" + getTempoTotal() + ", getMelhorVolta()=" + getMelhorVolta()
				+ ", getTempoMelhorVolta()=" + getTempoMelhorVolta() + ", getMelhorVolta2()=" + getMelhorVolta2()
				+ ", getTempoMelhorVolta2()=" + getTempoMelhorVolta2() + ", getDifl()=" + getDifl() + ", getDifa()="
				+ getDifa() + ", getVelocidade()=" + getVelocidade() + ", getSetas()=" + Arrays.toString(getSetas())
				+ ", getTrechos()=" + getTrechos() + ", getpIni()=" + getpIni() + ", getTempoVoltaIdeal()="
				+ getTempoVoltaIdeal() + "]";
	}

	
	
}
