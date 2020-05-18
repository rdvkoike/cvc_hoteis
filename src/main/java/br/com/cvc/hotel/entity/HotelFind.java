package br.com.cvc.hotel.entity;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class HotelFind {
	/*	
	CityCode
	Checkin
	Checkout
	Quantidade de Adultos
	Quantidade de Crianças
	{
		"cityCode":1032,
		"checkin":2020-11-20,
		"checkout":2020-11-21,
		'adults":1,
		"children":1
	}
		
	
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
	@ApiModelProperty(notes = "Código da cidade")
	private int cityCode;
	private Date checkin;
	private Date checkout;
	private int adults;
	private int children;
	private int hotelId;
		
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	@Override
	public String toString() {
		return "HotelFind [cityCode=" + cityCode + ", checkin=" + checkin + ", checkout=" + checkout + ", adults="
				+ adults + ", children=" + children + "]";
	}
	

}
