package com.qa.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

	private List<Product> items = new ArrayList<Product>();
	private Map<Integer, Integer> itemQuantityTracker = new HashMap<Integer, Integer>();

	public Basket() {

	}

	public void add(Product product, int quantity) {
		Integer currentItemQuantity = itemQuantityTracker.get(product.getId());
		if (currentItemQuantity == null) {
			itemQuantityTracker.put(product.getId(), quantity);
			items.add(product);
		} else {
			// Increment the current quantity for this key
			int q = currentItemQuantity += quantity;
			itemQuantityTracker.replace(currentItemQuantity, q);
		}
	}

	public boolean remove(Product product) {
		boolean success = false;

		// Check if that item exists in the List
		if (items.contains(product)) {
			int currentQuantity = itemQuantityTracker.get(product.getId());

			if (currentQuantity == 1) {
				items.remove(product);
				itemQuantityTracker.remove(product.getId());
				success = true;
			} else {
				itemQuantityTracker.replace(product.getId(), currentQuantity);
				success = true;
			}
		} else {
			// If it does not exist then return false
			itemQuantityTracker.get(product.getId());
			success = false;
		}

		return success;

	}

	public void clear() {
		itemQuantityTracker.clear();
		items.clear();
	}

	public int numberOfItems() {
		return items.size();
	}

	public List<Product> getAllItems() {
		return items;
	}

	public Map<Integer, Integer> getItemQuantityTracker() {
		return itemQuantityTracker;
	}

}