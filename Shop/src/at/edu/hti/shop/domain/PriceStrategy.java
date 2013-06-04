/**
 * 
 */
package at.edu.hti.shop.domain;

import java.util.List;

/**
 * @author spanninger
 * 
 */
public class PriceStrategy implements IPriceStrategy {


	@Override
	public double calculatePrice(List<OrderLine> lines) {
		double sum = 0.0;

		for (OrderLine line : lines) {
			sum += line.getPrice();
		}

		if (sum > 10) {
			return sum;
		} else {
			sum = sum + 5;
		}

		return sum;

	}

}
