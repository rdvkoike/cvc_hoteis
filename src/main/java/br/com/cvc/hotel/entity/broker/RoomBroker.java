package br.com.cvc.hotel.entity.broker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomBroker {
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
	private PriceBroker price;
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
	public PriceBroker getPrice() {
		return price;
	}
	public void setPrice(PriceBroker price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", categoryName=" + categoryName + ", price=" + price + "]";
	}
}
