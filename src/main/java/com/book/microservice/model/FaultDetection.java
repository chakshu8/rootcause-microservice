package com.book.microservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="faultdetection")
public class FaultDetection {

	@Id
	@Column(name="microservice_name")
    private String microservice_name;
	
	@Column(name="cpu")
    private String cpu;
	
	@Column(name="memory")
    private String memory;
	
	@Column(name="root_cause")
    private String root_cause;

	public String getMicroservice_name() {
		return microservice_name;
	}

	public void setMicroservice_name(String microservice_name) {
		this.microservice_name = microservice_name;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getRoot_cause() {
		return root_cause;
	}

	public void setRoot_cause(String root_cause) {
		this.root_cause = root_cause;
	}
	
	
	
}
