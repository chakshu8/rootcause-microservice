package com.book.microservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="performance")
public class Performance {

	@Id
	@Column(name="agent_key")
    private String agent_key;
	
	@Column(name="response")
    private String response;
	
	@Column(name="throughput")
    private String throughput;
	
	@Column(name="timestamp")
    private String timestamp;

	public String getAgent_key() {
		return agent_key;
	}

	public void setAgent_key(String agent_key) {
		this.agent_key = agent_key;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getThroughput() {
		return throughput;
	}

	public void setThroughput(String throughput) {
		this.throughput = throughput;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
