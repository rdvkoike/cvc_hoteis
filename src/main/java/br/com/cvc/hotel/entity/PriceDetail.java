package br.com.cvc.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDetail {
	/**
{
  "id": 1,
  "cityName": "Porto Seguro",
  "rooms":[{
      "roomID": 1,
      "categoryName": "Standard",
      "totalPrice": 10000.00,
      "priceDetail": {
        "pricePerDayAdult": 500.00,
        "pricePerDayChild": 50.00
      }
    }]
}
*/
	private double pricePerDayAdult;
	private double pricePerDayChild;
	public double getPricePerDayAdult() {
		return pricePerDayAdult;
	}
	public void setPricePerDayAdult(double pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}
	public double getPricePerDayChild() {
		return pricePerDayChild;
	}
	public void setPricePerDayChild(double pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}
	@Override
	public String toString() {
		return "PriceDetail [pricePerDayAdult=" + pricePerDayAdult + ", pricePerDayChild=" + pricePerDayChild + "]";
	}
		
}
