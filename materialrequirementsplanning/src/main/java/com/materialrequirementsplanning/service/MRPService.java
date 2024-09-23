package com.materialrequirementsplanning.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.materialrequirementsplanning.model.BOMItem;
import com.materialrequirementsplanning.model.InventoryItem;
import com.materialrequirementsplanning.model.MRPRequest;

@Service
public class MRPService {
	 public Map<String, Object> calculateRequirements(MRPRequest request) {
	        Map<String, Object> result = new HashMap<>();
	        Map<String, Integer> netRequirements = new HashMap<>();
	        Map<String, Integer> plannedOrders = new HashMap<>();

	        for (BOMItem item : request.getBom()) {
	            String componentName = item.getName();
	            int requiredQuantity = item.getQuantity();

	            int availableStock = request.getInventory().stream()
	                .filter(inventoryItem -> inventoryItem.getName().equals(componentName))
	                .map(InventoryItem::getStock)
	                .findFirst()
	                .orElse(0);

	            int netRequirement = Math.max(0, requiredQuantity - availableStock);
	            netRequirements.put(componentName, netRequirement);

	          
	            if (netRequirement > 0) {
	                plannedOrders.put(componentName, netRequirement);
	            }
	        }

	        result.put("netRequirements", netRequirements);
	        result.put("plannedOrders", plannedOrders);
	        return result;
	    }
	

}
