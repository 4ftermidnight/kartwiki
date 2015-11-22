package br.com.aftermidnight.kartwiki.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: KartTrack
 *
 */
@Entity
@Table(name="karttrack")
public class KartTrack implements Serializable {
	
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String otherName;
	
	@Column
	private String urlXml;
	
	@Column
	private String urlSite;
	
	@OneToMany(mappedBy="kartTrack"/*, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval=true*/)
	private List<Race> races = new ArrayList<>();
	
	
	

	public KartTrack() {
		super();
	}   
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	
	public String getUrlSite() {
		return urlSite;
	}

	public void setUrlSite(String urlSite) {
		this.urlSite = urlSite;
	}

	public String getUrlXml() {
		return urlXml;
	}

	public void setUrlXml(String urlXml) {
		this.urlXml = urlXml;
	}

	public List<Race> getRaces() {
		return races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
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
		KartTrack other = (KartTrack) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KartTrack [id=" + id + ", name=" + name + ", otherName=" + otherName + ", urlXml=" + urlXml
				+ ", urlSite=" + urlSite + "]";
	}


	
	
   
	
}
