package com.shopperstar.project.cart.model;

public enum DeliveryMethod {
	
	NEXT_DAY_DELIVERY, STANDARD_DELIVERY, PICKUP;
	
	private final static Double nextDayDeliveryPrice = 25.00;
	private final static Double standardDeliveryPrice = 5.00;
	private final static Double pickupPrice = 0.00;
	
	public static DeliveryMethod getDeliveryMethod(String method) {
		
		if (method.equals("NEXT_DAY_DELIVERY")) {
			
			return NEXT_DAY_DELIVERY;
			
		} else if (method.equals("STANDARD_DELIVERY")) {
			
			return STANDARD_DELIVERY;
			
		} else {
			
			return PICKUP;
			
		}
	}
	
	public static Double getDeliveryPrice(DeliveryMethod method) {
		
		if (method == DeliveryMethod.NEXT_DAY_DELIVERY) {
			return nextDayDeliveryPrice;
		} else if (method == DeliveryMethod.STANDARD_DELIVERY) {
			return standardDeliveryPrice;
		} else {
			return pickupPrice;
		}
	}
}
