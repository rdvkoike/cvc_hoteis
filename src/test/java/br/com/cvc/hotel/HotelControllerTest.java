package br.com.cvc.hotel;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.cvc.hotel.entity.HotelFind;
import br.com.cvc.hotel.service.HotelController;

@SpringBootTest
public class HotelControllerTest extends ApplicationTests{
 
//	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private HotelController hotelController;
	
	public void setUp() {
	}    
    
	@Test
	public void testGETcalculaHospedagemHoteisPorIdCidade_HotelController() throws Exception {
		
		SimpleDateFormat sdf =  new SimpleDateFormat ("yyyy-MM-dd");
		
		HotelFind hotelfind = new HotelFind();
		hotelfind.setAdults(1);
		hotelfind.setChildren(1);
		hotelfind.setCheckin(new Date(2020,11,20));
		hotelfind.setCheckout(new Date(2020,11,21));
		hotelfind.setCityCode(1032);
		
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/hospedagem?adults="+
				hotelfind.getAdults()+"&children="+hotelfind.getChildren()+"&cityCode="+hotelfind.getCityCode()+
				"&checkin="+sdf.format(hotelfind.getCheckin())+"&checkout="+sdf.format(hotelfind.getCheckout())
				))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
//		return "HotelFind [cityCode=" + cityCode + ", checkin=" + checkin + ", checkout=" + checkout + ", adults="
//		+ adults + ", children=" + children + "]";

	}
	
	@Test
	public void testGETcalculaHospedagemHoteisPorIdCidade_IdHotel_HotelController() throws Exception {
		
		SimpleDateFormat sdf =  new SimpleDateFormat ("yyyy-MM-dd");
		
		
		HotelFind hotelfind = new HotelFind();
		hotelfind.setAdults(1);
		hotelfind.setChildren(1);
		hotelfind.setCheckin(new Date(2020,11,20));
		hotelfind.setCheckout(new Date(2020,11,21));
		hotelfind.setCityCode(1032);
		
		hotelfind.setHotelId(1);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/hospedagem/"+hotelfind.getHotelId()+"?adults="+
				hotelfind.getAdults()+"&children="+hotelfind.getChildren()+"&cityCode="+hotelfind.getCityCode()+
				"&checkin="+sdf.format(hotelfind.getCheckin())+"&checkout="+sdf.format(hotelfind.getCheckout())
				))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
//		return "HotelFind [cityCode=" + cityCode + ", checkin=" + checkin + ", checkout=" + checkout + ", adults="
//		+ adults + ", children=" + children + "]";

	}
}
