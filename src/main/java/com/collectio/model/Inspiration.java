package com.collectio.model;

import java.util.Date;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Inspiration {

	@Id
	@GeneratedValue
	Long inspirationId;

	String name;

	String wikipediaURL;

	Date startPeriod;

	Date endPeriod;
	
	Set<Item> items;

	public Long getInspirationId() {
		return inspirationId;
	}

	public void setInspirationId(Long inspirationId) {
		this.inspirationId = inspirationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(Date startPeriod) {
		this.startPeriod = startPeriod;
	}

	public Date getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(Date endPeriod) {
		this.endPeriod = endPeriod;
	}

	public String getWikipediaURL() {
		return wikipediaURL;
	}

	public void setWikipediaURL(String wikipediaURL) {
		this.wikipediaURL = wikipediaURL;
	}

}
