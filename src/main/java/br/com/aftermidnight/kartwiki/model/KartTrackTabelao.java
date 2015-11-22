package br.com.aftermidnight.kartwiki.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="karttrack_tabela_unica")
public class KartTrackTabelao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="rotulo_da_bateria",length=100, nullable=false)
	@NotEmpty
	private String rotuloDaBateria;
	
	@Column(name="nome_piloto",length=100, nullable=false)
	@NotEmpty
	private String driverName;
	
	@Column(name="num_kart", nullable=false)
	private Integer kartNumber;
	
	@Column(name="volta", nullable=false)
	private Integer lap;
	
	@Column(name="posicao", nullable=false)
	private Integer position;
	
	@Column(name="tempo", nullable=false)
	@Temporal(value=TemporalType.TIME)	
	private Date time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRotuloDaBateria() {
		return rotuloDaBateria;
	}

	public void setRotuloDaBateria(String rotuloDaBateria) {
		this.rotuloDaBateria = rotuloDaBateria;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Integer getKartNumber() {
		return kartNumber;
	}

	public void setKartNumber(Integer kartNumber) {
		this.kartNumber = kartNumber;
	}

	public Integer getLap() {
		return lap;
	}

	public void setLap(Integer lap) {
		this.lap = lap;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KartTrackTabelao other = (KartTrackTabelao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KartTrackTabelao [id=" + id + ", rotuloDaBateria=" + rotuloDaBateria + ", driverName=" + driverName
				+ ", kartNumber=" + kartNumber + ", lap=" + lap + ", position=" + position + ", time=" + time + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
