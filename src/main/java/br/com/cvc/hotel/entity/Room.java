package br.com.cvc.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {
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
	private int roomID;
	private String categoryName;
	double totalPrice;
	private PriceDetail priceDetail;
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public PriceDetail getPriceDetail() {
		return priceDetail;
	}
	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", categoryName=" + categoryName + ", totalPrice=" + totalPrice
				+ ", priceDetail=" + priceDetail + "]";
	}
	
}
