package com.shopperstar.project.cart.resource;

public enum DeliveryMethod {
	
	NEXT_DAY_DELIVERY, STANDARD_DELIVERY, PICKUP;

	public static Double getDeliveryPrice(DeliveryMethod method) {
		
		if (method == DeliveryMethod.NEXT_DAY_DELIVERY) {
			return 25.00;
		} else if (method == DeliveryMethod.STANDARD_DELIVERY) {
			return 4.99;
		} else {
			return 0.00;
		}
	}
}
