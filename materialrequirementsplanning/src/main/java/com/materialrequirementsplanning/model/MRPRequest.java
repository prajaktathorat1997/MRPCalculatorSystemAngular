package com.materialrequirementsplanning.model;

import java.util.List;

public class MRPRequest {
	private List<BOMItem> bom;
    private List<InventoryItem> inventory;

	public MRPRequest() {
		
	}

	public MRPRequest(List<BOMItem> bom, List<InventoryItem> inventory) {
		super();
		this.bom = bom;
		this.inventory = inventory;
	}

	public List<BOMItem> getBom() {
		return bom;
	}

	public void setBom(List<BOMItem> bom) {
		this.bom = bom;
	}

	public List<InventoryItem> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryItem> inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "MRPRequest [bom=" + bom + ", inventory=" + inventory + "]";
	}

}
