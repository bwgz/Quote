package org.bwgz.quote.data;

import java.util.List;

import org.bwgz.quote.data.Quote;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations={ "/quote-context.xml" })
abstract public class QuoteTest extends DataModelTest {
    @Autowired
    private List<Quote> quotes;

    @SuppressWarnings("unchecked")
	private List<Quote> findAllQuotes() {
    	return entityManager.createQuery("select q from Quote q").getResultList();
    }

    @Test
    public void createQuotes() {
    	logger.info("createQuotes()");
    	for (Quote quote : quotes) {
	        try {
	        	entityManager.persist(quote);
	        } catch (Exception e) {
	            Assert.fail(String.format("Quote: %s Exception: %s", quote.toString(), e.getMessage()));
	        }
    	}
    }

    @SuppressWarnings("unused")
	private void dumpQuotes(String title) {
    	logger.finest(title);
		try {
			List<Quote> quotes = findAllQuotes();
			if (quotes.size() == 0) {
				logger.finest("No quotes found.");
			}
			else {
		        for (Quote quote : quotes) {
		        	logger.finest(String.format("Quote: %s", quote.toString()));
		        }
			}
		} catch(Exception e) {
	    	logger.finest(String.format("Exception: %s", e.getMessage()));
		}
    }
}
