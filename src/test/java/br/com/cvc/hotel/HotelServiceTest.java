package br.com.cvc.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.cvc.hotel.entity.HotelFind;
import br.com.cvc.hotel.entity.HotelReturn;
import br.com.cvc.hotel.entity.broker.HotelBroker;
import br.com.cvc.hotel.service.HotelService;

@SpringBootTest
public class HotelServiceTest extends ApplicationTests{
 
    @Autowired
    private HotelService hotelService;
    
    @Test
	public void getHotelbyId() {
    	//[Hotel [id=1, name=Hotel Teste 1, cityCode=1032, cityName=Porto Seguro, rooms=[Room [roomID=0, categoryName=Standard, price=Price [adult=1372.54, child=848.61]]]]]
    	HotelBroker hotelMock = new HotelBroker(1, "Hotel Teste 1");
    	List<HotelBroker> hoteis = hotelService.findById(1);
    	System.out.println("mock="+hotelMock.getName() +" api=" + hoteis.get(0).getName());
    	assertThat(hotelMock.getName()).isEqualTo(hoteis.get(0).getName());
	}
    
    @Test
	public void getHotelbyCityId() {
    	HotelBroker hotelMock = new HotelBroker(1, "Hotel Teste 1");
    	List<HotelBroker> hoteis = hotelService.findByCityId(1032);
    	System.out.println("mock="+hotelMock.getName() +" api=" + hoteis.get(0).getName());
    	assertThat(hotelMock.getName()).isEqualTo(hoteis.get(0).getName());
    	
	}
	
    @Test
	public void calculaHospedagem() {
    	
    	HotelFind find = new HotelFind();
    	find.setAdults(1);
    	find.setChildren(1);
    	find.setCheckin(new Date(2020, 11, 20));
    	find.setCheckout(new Date(2020, 11, 21));
    	find.setCityCode(1032);
    	
    	List<HotelReturn> hoteisRetorno = hotelService.calculaHospedagemByCityId(find);
    	System.out.println("HotelServiceTest.calculaHospedagem()-"+hoteisRetorno.get(0).getRooms().get(0).getTotalPrice());
    	assertThat( 3173.071428571429 ).isEqualTo(hoteisRetorno.get(0).getRooms().get(0).getTotalPrice());
	}
    
	
}
