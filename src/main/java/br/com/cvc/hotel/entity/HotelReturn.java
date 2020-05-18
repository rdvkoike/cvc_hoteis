package br.com.cvc.hotel.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelReturn {
/*	{
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
	private int id;
	private String cityName;
	private List<Room> rooms;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	@Override
	public String toString() {
		return "HotelValues [id=" + id + ", cityName=" + cityName + ", rooms=" + rooms + "]";
	}
	
}
