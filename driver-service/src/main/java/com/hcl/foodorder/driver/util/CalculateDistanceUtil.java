package com.hcl.foodorder.driver.util;

import org.springframework.stereotype.Component;

/**
 * Calculate Distance between two points
 * 
 * @author hari
 *
 */
@Component
public class CalculateDistanceUtil {
	/**
	 * Calculate the distance between two points 
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return
	 */
	public double distance(double lat1, double lon1, double lat2, double lon2) {
		return Math.sqrt((lat2 - lat1) * (lat2 - lat1) + (lon2 - lon1) * (lon2 - lon1));
	}
}
