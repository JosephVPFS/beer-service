package com.jose.beers.web.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jose.beers.bootstrap.BeerLoader;
import com.jose.beers.web.model.BeerDto;
import com.jose.beers.web.model.BeerStyleEnum;
import com.jose.beers.web.services.BeerService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

/**
 * Created on 05-Jul-2021 12:28:59 pm
 * @author josephfs
 *
 */

@WebMvcTest(BeerController.class)
class BeerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
    BeerService beerService;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.jose.beers.web.controller.BeerController#getBeerById(java.util.UUID)}.
	 * @throws Exception 
	 */
	@Test
	void testGetBeerById() throws Exception {
		given(beerService.getBeerByiD(any())).willReturn(new ResponseEntity<BeerDto>(getBeerDto(), HttpStatus.OK));
		
		mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

	/**
	 * Test method for {@link com.jose.beers.web.controller.BeerController#saveBeer(com.jose.beers.web.model.BeerDto)}.
	 * @throws Exception 
	 */
	@Test
	void testSaveBeer() throws Exception {
		given(beerService.saveBeer(any())).willReturn(getBeerDto());
		BeerDto beerDto = getBeerDto();
		String json = mapper.writeValueAsString(beerDto);
		mockMvc.perform(post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isCreated());
	}

	/**
	 * @return
	 */
	private BeerDto getBeerDto() {
		BeerDto beerDto = BeerDto.builder()
				.beerName("Carlsberg")
				.beerStyle(BeerStyleEnum.IPA)
				.upc(BeerLoader.BEER_1_UPC)
				.price(new BigDecimal("230.50"))
				.build();
		return beerDto;
	}

	/**
	 * Test method for {@link com.jose.beers.web.controller.BeerController#updateBeer(java.util.UUID, com.jose.beers.web.model.BeerDto)}.
	 * @throws Exception 
	 */
	@Test
	void testUpdateBeer() throws Exception {
		given(beerService.updateBeer(any(), any())).willReturn(getBeerDto());
		BeerDto beerDto = getBeerDto();
		String json = mapper.writeValueAsString(beerDto);
		mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isNoContent());
	}

}
