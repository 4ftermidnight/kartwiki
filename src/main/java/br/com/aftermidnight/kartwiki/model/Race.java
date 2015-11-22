package br.com.aftermidnight.kartwiki.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Race
 *
 */
@Entity
@Table(name="race")

public class Race implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long idFromXml;
	
	@Column
	private String name;
	
	@Column
	@Temporal(value=TemporalType.DATE)
	private Date date;
	
	@OneToMany(mappedBy="race")
	private List<Lap> laps = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "kattrackId")
	private KartTrack kartTrack;

	public Race() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdFromXml() {
		return idFromXml;
	}
	public void setIdFromXml(Long idFromXml) {
		this.idFromXml = idFromXml;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Lap> getLaps() {
		return laps;
	}
	public void setLaps(List<Lap> laps) {
		this.laps = laps;
	}
	
	public KartTrack getKartTrack() {
		return kartTrack;
	}
	public void setKartTrack(KartTrack kartTrack) {
		this.kartTrack = kartTrack;
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
		Race other = (Race) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Race [id=" + id + ", idFromXml=" + idFromXml + ", name=" + name + ", date=" + date + "]";
	}
  
	
}
