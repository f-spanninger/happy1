package at.edu.hti.shop.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private static final long serialVersionUID = 1L;
    private ArrayList<OrderLine> lines = new ArrayList<OrderLine>();
    private PriceStrategy ps = new PriceStrategy();
    
	public boolean add(OrderLine e) {

		if (e == null || e.getAmount() == 0)
			return false;

		return lines.add(e);
	}

	public double calcPrize() {
		return ps.calculatePrice(lines);
		
	}

	public String toString() {
	
		return super.toString() + " \n =>" +calcPrize();
	}
	
	public OrderLine getLine(int index) {
		if (lines.size() >= index) { return lines.get(index);}
		return null;
	}
	
	public List<OrderLine> getLine (Product p) {
		List<OrderLine> lineList = new ArrayList<OrderLine>();
		for (OrderLine line : lines) {
			if (line.getProduct() == p) {
				lineList.add(line);
			}
		}
		return lineList;
	}
	
	public int getSize() {
		return lines.size();
	}

	public void setAmount(int amount, OrderLine line) {
		int idx = lines.indexOf(line);
		if (idx < 0 ) {
			return;
	    }
		if (amount == 0) {
			lines.remove(idx);
			return;
	    }
		if (lines.get(idx) != null) {
			lines.get(idx).setAmount(amount);
		}
		
	}
	
}
