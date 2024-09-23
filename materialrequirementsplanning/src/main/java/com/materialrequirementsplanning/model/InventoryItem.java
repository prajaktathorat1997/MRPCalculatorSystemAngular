package com.materialrequirementsplanning.model;

public class InventoryItem {
	private String name;
    private int stock;
	public InventoryItem() {
		
	}
	@Override
	public String toString() {
		return "InventoryItem [name=" + name + ", stock=" + stock + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public InventoryItem(String name, int stock) {
		super();
		this.name = name;
		this.stock = stock;
	}

}
