package com.qa.domain;

public class Offer {

	// TODO Complete the offer class. Suggest the correct types
	private int id;
	private String offerDescription;
	private String shortDescription;
	private boolean isBOGOF;
	private boolean isTFTPOT;
	private int TFTPOTGroup;
	private boolean discount;
	private int discountPercentage;

	public Offer(int id, String offerDescription, String shortDescription, boolean isBOGOF, boolean isTFTPOT,
			int TFTPOTGroup, boolean discount, int discountPercentage) {
		this.id = id;
		this.offerDescription = offerDescription;
		this.shortDescription = shortDescription;
		this.isBOGOF = isBOGOF;
		this.isTFTPOT = isTFTPOT;
		this.TFTPOTGroup = TFTPOTGroup;
		this.discount = discount;
		this.discountPercentage = discountPercentage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public boolean isBOGOF() {
		return isBOGOF;
	}

	public void setBOGOF(boolean isBOGOF) {
		this.isBOGOF = isBOGOF;
	}

	public boolean isTFTPOT() {
		return isTFTPOT;
	}

	public void setTFTPOT(boolean isTFTPOT) {
		this.isTFTPOT = isTFTPOT;
	}

	public int getTFTPOTGroup() {
		return TFTPOTGroup;
	}

	public void setTFTPOTGroup(int tFTPOTGroup) {
		TFTPOTGroup = tFTPOTGroup;
	}

	public boolean isDiscount() {
		return discount;
	}

	public void setDiscount(boolean discount) {
		this.discount = discount;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

}