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
	
	public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
	
	private final BeerRepository beerRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(beerRepository.count() == 0) {
			beerRepository.save(Beer.builder()
					.beerName("KF String")
					.beerStyle("LARGE")
					.UPC(BEER_1_UPC)
					.price(new BigDecimal("400.50"))
					.build());
			
			beerRepository.save(Beer.builder()
					.beerName("Carlsberg")
					.beerStyle("E-Strong")
					.UPC(BEER_2_UPC)
					.price(new BigDecimal("440.50"))
					.build());
			
			beerRepository.save(Beer.builder()
					.beerName("Hieneken")
					.beerStyle("Double Strong")
					.UPC(BEER_3_UPC)
					.price(new BigDecimal("130.70"))
					.build());
		}
		
		System.out.println("Beer Count : " + beerRepository.count());
		
	}

}
