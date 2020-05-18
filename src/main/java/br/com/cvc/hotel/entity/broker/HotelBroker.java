package br.com.cvc.hotel.entity.broker;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelBroker {

	
	/**
[{
  "id": 1,
  "name": "Hotel Teste 1",
  "cityCode": 1032,
  "cityName": "Porto Seguro",
  "rooms": [
    {
      "roomID": 0,
      "categoryName": "Standard",
      "price": {
        "adult": 1372.54,
        "child": 848.61
      }
    }
  ]
}]

	 */
	
	private int id;
	private String name;
	private int cityCode;
	private String cityName;
	private List<RoomBroker> rooms;
	public HotelBroker() {
	}
	public HotelBroker(int i, String string) {
		this.id=i;
		this.name=string;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<RoomBroker> getRooms() {
		return rooms;
	}
	public void setRooms(List<RoomBroker> rooms) {
		this.rooms = rooms;
	}
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", cityCode=" + cityCode + ", cityName=" + cityName + ", rooms="
				+ rooms + "]";
	}

	
}
