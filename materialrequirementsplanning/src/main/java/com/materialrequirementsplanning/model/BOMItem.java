package com.materialrequirementsplanning.model;

public class BOMItem {
	private String name;
    private int quantity;
	public BOMItem() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BOMItem(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "BOMItem [name=" + name + ", quantity=" + quantity + "]";
	}

}
