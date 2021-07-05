package com.jose.beers.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.beers.web.model.BeerDto;
import com.jose.beers.web.model.BeerStyleEnum;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	
	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
		return new ResponseEntity<BeerDto>(BeerDto.builder()
				.beerName("KF Strong")
				.beerStyle(BeerStyleEnum.LAGER)
				.build(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity saveBeer(@RequestBody BeerDto beerDto) {
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PutMapping({"/{beerId}"})
	public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
