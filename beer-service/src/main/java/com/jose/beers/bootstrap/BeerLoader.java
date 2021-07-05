/**
 * 
 */
package com.jose.beers.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jose.beers.repository.BeerRepository;
import com.jose.beers.web.domain.Beer;

import lombok.Data;

/**
 * Created on 05-Jul-2021 4:50:00 pm
 * @author josephfs
 *
 */

@Data
@Component
public class BeerLoader implements CommandLineRunner {
	
	private final BeerRepository beerRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(beerRepository.count() == 0) {
			beerRepository.save(Beer.builder()
					.beerName("KF String")
					.beerStyle("LARGE")
					.UPC(1200000L)
					.price(new BigDecimal("400.50"))
					.build());
			
			beerRepository.save(Beer.builder()
					.beerName("Carlsberg")
					.beerStyle("E-Strong")
					.UPC(1200001L)
					.price(new BigDecimal("440.50"))
					.build());
		}
		
		System.out.println("Beer Count : " + beerRepository.count());
		
	}

}
