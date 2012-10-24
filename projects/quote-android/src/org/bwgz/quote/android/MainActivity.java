package org.bwgz.quote.android;

import java.util.ArrayList;
import java.util.List;

import org.bwgz.quote.android.R;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String URL = "http://192.168.2.201:8080/quote-json-server/quote/1";	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView t1 =(TextView)findViewById(R.id.textView1);
        t1.setText(URL);
        
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(acceptableMediaTypes);
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

        String string;        
        
        try {
        	ResponseEntity<Quote> entity = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, Quote.class);
            string = entity.getBody().toString();
        } catch (RestClientException e) {
        	string = e.getMessage();
        }

        TextView t2 = (TextView)findViewById(R.id.textView2); 
        t2.setText(string);
        
        Quote quote = restTemplate.getForObject(URL, Quote.class);
        TextView t3 =(TextView)findViewById(R.id.textView3); 
        t3.setText(quote.getQuote());
    }
}