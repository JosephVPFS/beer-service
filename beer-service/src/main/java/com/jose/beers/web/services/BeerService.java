/**
 * 
 */
package com.jose.beers.web.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.jose.beers.web.model.BeerDto;

/**
 * Created on 07-Jul-2021 10:39:21 am
 * @author josephfs
 *
 */
public interface BeerService {

	/**
	 * @param beerId
	 * @return
	 */
	ResponseEntity<BeerDto> getBeerByiD(UUID beerId);

	/**
	 * @param beerDto
	 * @return
	 */
	BeerDto saveBeer(BeerDto beerDto);

	/**
	 * @param beerId
	 * @param beerDto
	 * @return
	 */
	BeerDto updateBeer(UUID beerId, BeerDto beerDto);

}
