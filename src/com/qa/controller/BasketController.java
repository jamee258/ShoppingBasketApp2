package com.qa.controller;

import java.util.List;

import com.qa.domain.Basket;
import com.qa.domain.Offer;
import com.qa.domain.Product;

public class BasketController {

	@SuppressWarnings("unused")
	private Product product;
	private Basket basket;
	List<Product> productsList;

	public BasketController(Basket basket) {
		this.basket = basket;
	}

	public void addProduct(Product product, int quantity) {
		basket.add(product, quantity);
	}

	public void removeProduct(Product product) {
		basket.remove(product);
	}

	public void clearBasket() {

	}

	private double calculateTotalBOGOF(int quantity, double unitPrice) {
		double remainder = Math.ceil(quantity / 2d);
		double totalPrice = remainder * unitPrice;
		return totalPrice;
	}

	private double calculateTotalTFTPOT(int quantity, double unitPrice) {
		
		return 0;
	}

	public double getTotalPrice(Basket myBasket) {
		productsList = myBasket.getAllItems();
		double totalPrice = 0;

		for (Product product : productsList) {
			int productId = product.getId();
			int quantity = myBasket.getItemQuantityTracker().get(productId);
			double unitPrice = product.getUnitPrice();

			if (product.getOffer() != null) {
				Offer offer = product.getOffer();
				if (offer.isBOGOF()) {
					totalPrice += calculateTotalBOGOF(quantity, unitPrice);
				} else if (offer.isTFTPOT()) {
					totalPrice += calculateTotalTFTPOT(quantity, unitPrice);
				}
			}

		}
		return totalPrice;
	}

}