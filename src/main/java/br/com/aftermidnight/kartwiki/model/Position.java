package br.com.aftermidnight.kartwiki.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Position
 *
 */
@Entity
@Table(name="position")

public class Position implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private Integer positionNumber;
	
	@Column
	private String driverLabel;
	
	@Column
	private Integer kartNumber;
	
	@Column
	@Temporal(value=TemporalType.TIME)
	private Date lapTime;
	
	@ManyToOne
	private Lap lap;

	
	public Position() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPositionNumber() {
		return positionNumber;
	}
	public void setPositionNumber(Integer position) {
		this.positionNumber = position;
	}
	public String getDriverLabel() {
		return driverLabel;
	}
	public void setDriverLabel(String driverLabel) {
		this.driverLabel = driverLabel;
	}
	public Integer getKartNumber() {
		return kartNumber;
	}
	public void setKartNumber(Integer kartNumber) {
		this.kartNumber = kartNumber;
	}
	public Date getLapTime() {
		return lapTime;
	}
	public void setLapTime(Date lapTime) {
		this.lapTime = lapTime;
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
		Position other = (Position) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", positionNumber=" + positionNumber + ", driverLabel=" + driverLabel + ", kartNumber="
				+ kartNumber + ", lapTime=" + lapTime + "]";
	}

	
	
}
