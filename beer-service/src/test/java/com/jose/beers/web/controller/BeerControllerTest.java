package com.jose.beers.web.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jose.beers.web.model.BeerDto;

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
		BeerDto beerDto = BeerDto.builder().build();
		String json = mapper.writeValueAsString(beerDto);
		mockMvc.perform(post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isCreated());
	}

	/**
	 * Test method for {@link com.jose.beers.web.controller.BeerController#updateBeer(java.util.UUID, com.jose.beers.web.model.BeerDto)}.
	 * @throws Exception 
	 */
	@Test
	void testUpdateBeer() throws Exception {
		BeerDto beerDto = BeerDto.builder().build();
		String json = mapper.writeValueAsString(beerDto);
		mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(status().isNoContent());
	}

}
