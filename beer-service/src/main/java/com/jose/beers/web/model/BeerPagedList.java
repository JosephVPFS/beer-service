/**
 * 
 */
package com.jose.beers.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Copyright 2021 Simmons
 *
 * Created on Jul 2, 2021 4:57:57 PM by @author injprakash
 *
 */
public class BeerPagedList extends PageImpl<BeerDto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BeerPagedList(@JsonProperty("content") List<BeerDto> content,
                         @JsonProperty("number") int number,
                         @JsonProperty("size") int size,
                         @JsonProperty("totalElements") Long totalElements,
                         @JsonProperty("pageable") JsonNode pageable,
                         @JsonProperty("last") boolean last,
                         @JsonProperty("totalPages") int totalPages,
                         @JsonProperty("sort") JsonNode sort,
                         @JsonProperty("first") boolean first,
                         @JsonProperty("numberOfElements") int numberOfElements) {

        super(content, PageRequest.of(number, size), totalElements);
    }

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
