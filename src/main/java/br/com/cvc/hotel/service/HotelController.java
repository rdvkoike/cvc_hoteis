package br.com.cvc.hotel.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.hotel.entity.HotelFind;
import br.com.cvc.hotel.entity.HotelReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Hotel", produces = "application/json")
public class HotelController {

	@Autowired
	HotelService service;

	@ApiOperation(value="Retorna a lista de hoteis, om os valores de estadia calculado, de acordo com os parametros de filtro.", 
			response = HotelReturn[].class)    
	@GetMapping("/hospedagem")
	public void calculaHospedagem(@RequestParam(value = "adults", required = true) @NotNull 
			@ApiParam(name =  "adults", type = "String", value = "Quantidade de adultos", example="1",required = true)
			int adults,
			@RequestParam(value = "children", required = true) @NotNull 
			@ApiParam(name =  "children", type = "integer", value = "Quantidade de crianças", example="1",required = true)			
			int children,
			@RequestParam(value = "cityCode", required = true) @NotNull 
			@ApiParam(name =  "cityCode", type = "integer", value = "Código da cidade 1032 (Porto Seguro), 7110 (Rio de Janeiro), 9626 (São Paulo)", example="1",required = true)
			int cityCode,
			@RequestParam(value = "checkin", required = true) @NotNull 
			@ApiParam(name =  "checkin", type = "String", value = "Data de checkin no formato yyyy-MM-dd", required = true)
			String checkin,
			@RequestParam(value = "checkout", required = true) @NotNull
			@ApiParam(name =  "checkout", type = "String", value = "Data de checkin no formato yyyy-MM-dd", required = true)
			String checkout) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date checkinDate = null;
		Date checkoutDate = null;

		try {
			checkinDate = sdf.parse(checkin);
			checkoutDate = sdf.parse(checkout);
		} catch (Exception e) {
			throw new IllegalArgumentException("Formato de data não suportado. Utilizar padrão yyyy-MM-dd");
		}

		HotelFind hotelfind = new HotelFind();

		hotelfind.setAdults(adults);
		hotelfind.setChildren(children);
		hotelfind.setCityCode(cityCode);
		hotelfind.setCheckin(checkinDate);
		hotelfind.setCheckout(checkoutDate);

		service.calculaHospedagemByCityId(hotelfind);

	}

	@ApiOperation(value="Retorna o hotel pelo ID (ou lista de hoteis com o mesmo ID) com os valores de estadia calculado, de acordo com os parametros de filtro.",
			response = HotelReturn[].class)
	@GetMapping("/hospedagem/{id}")
	public void calculaHospedagemByHotelId(@PathVariable 
			@ApiParam(name =  "Id", type = "integer", value = "Id do hotel ou da rede de hoteis", example="1", required = true)
			int id,
			@RequestParam(value = "adults", required = true) @NotNull 
			@ApiParam(name =  "adults", type = "String", value = "Quantidade de adultos", example="1",required = true)
			int adults,
			@RequestParam(value = "children", required = true) @NotNull 
			@ApiParam(name =  "children", type = "integer", value = "Quantidade de crianças", example="1",required = true)			
			int children,
			@RequestParam(value = "cityCode", required = true) @NotNull 
			@ApiParam(name =  "cityCode", type = "integer", value = "Código da cidade 1032 (Porto Seguro), 7110 (Rio de Janeiro), 9626 (São Paulo)", example="1",required = true)
			int cityCode,
			@RequestParam(value = "checkin", required = true) @NotNull 
			@ApiParam(name =  "checkin", type = "String", value = "Data de checkin no formato yyyy-MM-dd", required = true)
			String checkin,
			@RequestParam(value = "checkout", required = true) @NotNull
			@ApiParam(name =  "checkout", type = "String", value = "Data de checkin no formato yyyy-MM-dd", required = true)
			String checkout) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date checkinDate = null;
		Date checkoutDate = null;

		try {
			checkinDate = sdf.parse(checkin);
			checkoutDate = sdf.parse(checkout);
		} catch (Exception e) {
			throw new IllegalArgumentException("Formato de data não suportado. Utilizar padrão yyyy-MM-dd");
		}

		HotelFind hotelfind = new HotelFind();

		hotelfind.setHotelId(id);

		hotelfind.setAdults(adults);
		hotelfind.setChildren(children);
		hotelfind.setCityCode(cityCode);
		hotelfind.setCheckin(checkinDate);
		hotelfind.setCheckout(checkoutDate);

		service.calculaHospedagemByHotelId(hotelfind);
	}
}
