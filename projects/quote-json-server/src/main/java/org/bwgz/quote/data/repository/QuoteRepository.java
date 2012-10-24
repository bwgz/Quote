package org.bwgz.quote.data.repository;

import org.bwgz.quote.data.Quote;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

@RestResource(path = "quote")
public interface QuoteRepository extends PagingAndSortingRepository<Quote, Long> {
}
