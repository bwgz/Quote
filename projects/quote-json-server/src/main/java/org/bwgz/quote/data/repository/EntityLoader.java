package org.bwgz.quote.data.repository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.bwgz.quote.data.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("entityLoader")
public class EntityLoader {
  private static final Logger LOG = LoggerFactory.getLogger(EntityLoader.class);

  @Inject
  private QuoteRepository quotes;
 
  @PostConstruct
  private void load() {
	  Quote quote;
	  
	  quote = new Quote();
	  quote.setQuote("Insanity: doing the same thing over and over again and expecting different results.");
	  quotes.save(quote);
	  LOG.info("saved quote: " + quote);
	  
	  quote = new Quote();
	  quote.setQuote("Better to remain silent and be thought a fool than to speak out and remove all doubt.");
	  quotes.save(quote);
	  LOG.info("saved quote: " + quote);
  }
}
