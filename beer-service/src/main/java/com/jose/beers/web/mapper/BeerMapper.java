/**
 * 
 */
package com.jose.beers.web.mapper;

import org.mapstruct.Mapper;

import com.jose.beers.web.domain.Beer;
import com.jose.beers.web.model.BeerDto;

/**
 * Created on 06-Jul-2021 1:27:17 pm
 * @author josephfs
 *
 */

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
	BeerDto beerToBeerDto(Beer beer);
	Beer beerDtoToBeer(BeerDto beerDto);

}
