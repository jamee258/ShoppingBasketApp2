package com.qa.domain;

public class Product {

	private int id;
	private String name;
	private double unitPrice;
	private Offer offer;

	public Product(int id, String name, double unitPrice) {
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@Override
	public boolean equals(Object object) {
		boolean areEqual = false;
		if (object instanceof Product) {
			// Cast Object to a Product
			Product product = (Product) object;
			// Products are equal if they share the same Name and ID
			areEqual = (product.id == id) && name.equalsIgnoreCase(product.getName());
		}

		return areEqual;
	}

}