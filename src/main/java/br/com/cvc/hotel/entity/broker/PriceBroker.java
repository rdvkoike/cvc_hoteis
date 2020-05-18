package br.com.cvc.hotel.entity.broker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceBroker {
	private double adult;
	private double child;
	public double getAdult() {
		return adult;
	}
	public void setAdult(double adult) {
		this.adult = adult;
	}
	public double getChild() {
		return child;
	}
	public void setChild(double child) {
		this.child = child;
	}
	@Override
	public String toString() {
		return "Price [adult=" + adult + ", child=" + child + "]";
	}

	
}
