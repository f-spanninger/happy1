/**
 * 
 */
package at.edu.hti.shop.domain;

import java.util.List;

/**
 * @author spanninger
 *
 */
interface IPriceStrategy {
	
	public double calculatePrice(List<OrderLine> lines);

}
