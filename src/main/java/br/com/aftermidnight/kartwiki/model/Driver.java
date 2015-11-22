package br.com.aftermidnight.kartwiki.model;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Driver
 *
 */
@Entity
@Table(name="driver")
public class Driver implements Serializable {


	@Id
	private Long id;
	private static final long serialVersionUID = 1L;

	public Driver() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
