package com.jose.beers.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.beers.web.model.BeerDto;
import com.jose.beers.web.model.BeerStyleEnum;
import com.jose.beers.web.services.BeerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	
	private final BeerService beerService;
	/**
	 * 
	 * @param beerId
	 * @return
	 */
	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
		
		return beerService.getBeerByiD(beerId);
		
	}

	/**
	 * 
	 * @param beerDto
	 * @return
	 */
	@PostMapping
	public ResponseEntity saveBeer(@RequestBody @Validated BeerDto beerDto) {
		return new ResponseEntity<>(beerService.saveBeer(beerDto), HttpStatus.CREATED);
		
	}
	/**
	 * 
	 * @param beerId
	 * @param beerDto
	 * @return
	 */
	@PutMapping({"/{beerId}"})
	public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody @Validated BeerDto beerDto) {
		return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
		
	}
}
