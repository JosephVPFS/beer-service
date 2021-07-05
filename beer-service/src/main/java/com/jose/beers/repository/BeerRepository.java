/**
 * 
 */
package com.jose.beers.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jose.beers.web.domain.Beer;

/**
 * Created on 05-Jul-2021 4:41:12 pm
 * @author josephfs
 *
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
