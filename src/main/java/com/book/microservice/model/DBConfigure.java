package com.book.microservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Chakshu Goyal
 *
 */
@Entity
@Table(name="dbconfig")
public class DBConfigure {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
	
	
	@Column(name="Microservices")
    private String Microservices;
    
    @Column(name="CPU")
    private String CPU;
    
    @Column(name="mem")
    private String mem;
    
    @Column(name="response")
    private String response;
    
    @Column(name="throughtput")
    private String throughtput;
    
    @Column(name="timestamp")
    private String timestamp;

	public String getMicroservices() {
		return Microservices;
	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}

	public String getMem() {
		return mem;
	}

	public void setMem(String mem) {
		this.mem = mem;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getThroughtput() {
		return throughtput;
	}

	public void setThroughtput(String throughtput) {
		this.throughtput = throughtput;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setMicroservices(String microservices) {
		Microservices = microservices;
	}
	
    
}
