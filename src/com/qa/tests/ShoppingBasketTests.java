package com.qa.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.controller.BasketController;
import com.qa.domain.Basket;
import com.qa.domain.Product;
import com.qa.model.DataProvider;

public class ShoppingBasketTests {

	private final int BEANS_ID = 1;
	private final int CHEESE_ID = 3;
	private final int BUTTER_ID = 12;

	@Test
	public void testCalculateBOGOF() {
		// Arrange
		// Calculate price of 5 cans of beans
		int actualQuantity = 5;
		double unitPrice = 0.56;
		double derivedQuantity = 3;
		double expectedPrice = derivedQuantity * unitPrice;

		Product beans2 = DataProvider.findProductById(BEANS_ID);

		Basket basket = new Basket();
		basket.add(beans2, actualQuantity);

		// Act
		BasketController bc = new BasketController(basket);
		double actualPrice = bc.getTotalPrice(basket);

		// Assert
		assertEquals(expectedPrice, actualPrice, 0.001);
	}

	@Test
	public void testCalculateTFTPOTOfferWithinSameGroup() {
		// Arrange
		Product cheese = DataProvider.findProductById(CHEESE_ID);
		Product butter = DataProvider.findProductById(BUTTER_ID);

		int actualCheeseQuantity = 4;
		int actualButterQuantity = 2;
		double expectedTotalPrice = 8.66;

		Basket basket = new Basket();
		basket.add(cheese, actualCheeseQuantity);
		basket.add(butter, actualButterQuantity);

		// Act
		BasketController bc = new BasketController(basket);
		double actualTotalPrice = bc.getTotalPrice(basket);

		// Assert
		assertEquals(expectedTotalPrice, actualTotalPrice, 0.0001);
	}

	@Test
	public void testShouldThrowExceptionForCrossGroupOffers() {
		// Arrange

		// Act

		// Assert
	}

}