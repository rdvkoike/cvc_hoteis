package br.com.cvc.hotel.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cvc.hotel.entity.HotelFind;
import br.com.cvc.hotel.entity.HotelReturn;
import br.com.cvc.hotel.entity.PriceDetail;
import br.com.cvc.hotel.entity.Room;
import br.com.cvc.hotel.entity.broker.HotelBroker;
import br.com.cvc.hotel.entity.broker.RoomBroker;

@Service
public class HotelService {
	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${broker.comissao}")
	private double brokerComissao;
	
	public List<HotelBroker> findById(int id) {
		ResponseEntity<HotelBroker[]> response = restTemplate.getForEntity("https://cvcbackendhotel.herokuapp.com/hotels/"+id, HotelBroker[].class);
		return Arrays.asList(response.getBody());
	}

	public List<HotelBroker> findByCityId(int cityId) {
		ResponseEntity<HotelBroker[]> response = restTemplate.getForEntity("https://cvcbackendhotel.herokuapp.com/hotels/avail/"+cityId, HotelBroker[].class);
		return Arrays.asList(response.getBody());
		
	}

	public List<HotelReturn> calculaHospedagemByCityId(HotelFind find) {
		
		System.out.println("HotelService.calculaHospedagem()"+find);
		
		List<HotelReturn> hoteisReturn = new ArrayList<HotelReturn>();
		List<HotelBroker> hoteisBroker = findByCityId(find.getCityCode());
		long diffMili = find.getCheckout().getTime() - find.getCheckin().getTime();
		int days = (int) TimeUnit.DAYS.convert(diffMili, TimeUnit.MILLISECONDS);
		System.out.println ("days: " + days);
		for (HotelBroker hotel : hoteisBroker) {
			
			hoteisReturn.add(transformHotelRules(hotel, find.getAdults(), find.getChildren(), days));
		}
		return hoteisReturn;
	}

	
	public List<HotelReturn> calculaHospedagemByHotelId(HotelFind find) {
		
		System.out.println("HotelService.calculaHospedagem()"+find);
		
		List<HotelReturn> hoteisReturn = new ArrayList<HotelReturn>();
		List<HotelBroker> hoteisBroker = findById(find.getHotelId());
		long diffMili = find.getCheckout().getTime() - find.getCheckin().getTime();
		int days = (int) TimeUnit.DAYS.convert(diffMili, TimeUnit.MILLISECONDS);
		System.out.println ("days: " + days);
		for (HotelBroker hotel : hoteisBroker) {
			hoteisReturn.add(transformHotelRules(hotel, find.getAdults(), find.getChildren(), days));
		}
		return hoteisReturn;
	}

	private HotelReturn transformHotelRules(HotelBroker hotel, int adults, int children, int days) {
		
		HotelReturn hotelReturn = new HotelReturn();
		hotelReturn.setId(hotel.getId());
		hotelReturn.setCityName(hotel.getCityName());
		hotelReturn.setRooms(new ArrayList<Room>());
		for (RoomBroker roomB : hotel.getRooms()) {
			Room roomReturn = new Room();
			roomReturn.setCategoryName(roomB.getCategoryName());
			roomReturn.setRoomID(roomB.getRoomID());
			
			calculaPrice(roomReturn, roomB, adults, children, days);
			hotelReturn.getRooms().add(roomReturn);
		}
		return hotelReturn;
	}

	private void calculaPrice(Room roomReturn, RoomBroker roomB, int adults, int children, int days) {

		roomReturn.setPriceDetail(new PriceDetail());
		
		double priceDayAdult = roomB.getPrice().getAdult() / brokerComissao;
		double priceDaychild = roomB.getPrice().getChild() / brokerComissao;
		
		roomReturn.getPriceDetail().setPricePerDayAdult(priceDayAdult);
		roomReturn.getPriceDetail().setPricePerDayChild(priceDaychild);
		
		//calculo total
		/*
		Pegar a quantidade de dias e multiplicar pelo valor do Adulto
		Pegar a quantidade de dias e multiplicar pelo valor do Criança
		Adicionar a comissão de .70 para adulto e para criança * Formula para fazer isso ({valorViagemAdulto}/0.7) Ex: (500/0.7);
		Somar tudo e você terá o totalPrice
	*/
		double totalPrice = (priceDayAdult * adults * days) +(priceDaychild * children * days)  ;
		roomReturn.setTotalPrice(totalPrice);
		
	}
	
}
