package com.collectio.model;

import java.util.Date;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@NodeEntity
public class Item {

	@Id
	@GeneratedValue
	Long ietmId;

	String itemName;

	String brandName;

	//Manufacturer manufacturer;

	//Inspiration inspiration;

	//Origin origin;

	boolean isSigned;

	String nameOfSigningAuthority;

	@JsonIgnoreProperties("items")
	@Relationship(type = "BELONGS_TO")
	Category category;

	//Collector collector;

	Date releaseDate;

	String batchNo;

	Date manufacturingDate;

	HandMade isHandMade;

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public boolean isSigned() {
		return isSigned;
	}

	public void setSigned(boolean isSigned) {
		this.isSigned = isSigned;
	}

	public String getNameOfSigningAuthority() {
		return nameOfSigningAuthority;
	}

	public void setNameOfSigningAuthority(String nameOfSigningAuthority) {
		this.nameOfSigningAuthority = nameOfSigningAuthority;
	}

	public Long getIetmId() {
		return ietmId;
	}

	public void setIetmId(Long ietmId) {
		this.ietmId = ietmId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public HandMade getIsHandMade() {
		return isHandMade;
	}

	public void setIsHandMade(HandMade isHandMade) {
		this.isHandMade = isHandMade;
	}

	public Long getId() {
		return ietmId;
	}

	public void setId(Long id) {
		this.ietmId = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/*public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Inspiration getInspiration() {
		return inspiration;
	}

	public void setInspiration(Inspiration inspiration) {
		this.inspiration = inspiration;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}*/

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/*public Collector getCollector() {
		return collector;
	}

	public void setCollector(Collector collector) {
		this.collector = collector;
	}*/

}
