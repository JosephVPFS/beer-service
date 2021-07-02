/**
 * 
 */
package com.jose.beers.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

/**
 * Copyright 2021 Simmons
 *
 * Created on Jul 2, 2021 4:57:57 PM by @author injprakash
 *
 */
public class BeerPagedList extends PageImpl<BeerDto> {

	/**
	 * @param content
	 * @param pageable
	 * @param total
	 */
	public BeerPagedList(List<BeerDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	/**
	 * @param content
	 */
	public BeerPagedList(List<BeerDto> content) {
		super(content);
	}

}
