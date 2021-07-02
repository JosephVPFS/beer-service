/**
 * 
 */
package com.jose.beers.web.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright 2021 Simmons
 *
 * Created on Jul 2, 2021 4:55:59 PM by @author injprakash
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	private UUID id;
    private Integer version;

    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;

    private String beerName;

    private BeerStyleEnum beerStyle;

    private Long upc;

    private BigDecimal price;

    private Integer quantityOnHand;

}
