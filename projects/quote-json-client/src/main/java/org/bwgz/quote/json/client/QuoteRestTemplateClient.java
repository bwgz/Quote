package org.bwgz.quote.json.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class QuoteRestTemplateClient {
	private static final String URL = "http://192.168.2.201:8080/quote-json-server/quote/1";	

	public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(acceptableMediaTypes);
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

        System.out.printf("url: %s\n", URL);
        try {
        	ResponseEntity<Quote> entity = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, Quote.class);
            System.out.printf("json: %s\n", entity.getBody().toString());

            Quote quote = restTemplate.getForObject(URL, Quote.class);
            System.out.printf("quote: %s\n", quote.getQuote());
        } catch (RestClientException e) {
        	e.printStackTrace();
        }
	}
}
