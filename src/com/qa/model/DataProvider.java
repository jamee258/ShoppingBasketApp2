package com.qa.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qa.domain.Offer;
import com.qa.domain.Product;

public class DataProvider {

	public static List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(7, "0.5 Litre Semi-Skimmed Milk", 0.65));
		products.add(new Product(1, "Beans", 0.56));
		products.add(new Product(3, "Cheese", 1.99));
		products.add(new Product(13, "Eggs", 1.59));
		products.add(new Product(12, "Butter", 2.34));
		products.add(new Product(2, "Cornflakes", 2.20));
		products.add(new Product(14, "Toothpaste", 1.00));
		products.add(new Product(10, "Milk (0.5 litre Skimmed)", 1.59));
		products.add(new Product(4, "Ham (5 Slices)", 2.49));
		return products;
	}

	public static Product[] getProductNames() {
		List<Product> products = getProductsWithOffers();
		Product[] productNames = new Product[products.size()];

		for (int j = 0; j < productNames.length; j++) {
			productNames[j] = products.get(j);
		}
		return productNames;

	}

	public static List<Product> getProductsWithOffers() {
		Map<Integer, Integer> offers = getProductOffers();
		// TODO Use the stream interface to filter the list of offers
		List<Product> productsWithOffers = new ArrayList<Product>();
		for (Product product : getAllProducts()) {
			Integer offerId = offers.get(product.getId());
			if (offerId != null) {
				Offer productOffer = getAllOffers().stream().filter(x -> x.getId() == offerId).limit(1).findFirst()
						.get();
				product.setOffer(productOffer);
			}
			productsWithOffers.add(product);
		}
		return productsWithOffers;
	}

	public static List<Offer> getAllOffers() {
		List<Offer> offers = new ArrayList<Offer>();
		offers.add(new Offer(1, "Buy One Get One Free", "BOGOF", true, false, 0, false, 0));
		offers.add(new Offer(2, "Three for the price of two on selected sandwich fillers", "BOGOF", false, false, 1,
				false, 0));
		offers.add(new Offer(3, "Three for the price of two on selected milk based products", "BOGOF", false, false, 2,
				false, 0));
		offers.add(new Offer(4, "Discount of 10%", "Discount", true, false, 0, true, 10));
		offers.add(new Offer(5, "Discount of 20%", "Discount", true, false, 0, true, 20));

		return offers;
	}

	private static Map<Integer, Integer> getProductOffers() {
		// Mimics a join table with a foreign key relationship
		// Key = Product, Value = Offer
		Map<Integer, Integer> offers = new HashMap<Integer, Integer>();
		offers.put(1, 1);
		offers.put(3, 2);
		offers.put(4, 2);
		offers.put(5, 3);
		offers.put(6, 3);
		offers.put(7, 3);
		offers.put(8, 3);
		offers.put(9, 3);
		offers.put(10, 3);
		offers.put(11, 4);
		offers.put(12, 2);

		return offers;
	}

	public static Product findProductById(int productId) {
		List<Product> productsList = getProductsWithOffers();
		for (Product product : productsList) {
			int productListId = product.getId();
			if (productListId == productId) {
				return product;
			}
		}
		return null;
	}

}