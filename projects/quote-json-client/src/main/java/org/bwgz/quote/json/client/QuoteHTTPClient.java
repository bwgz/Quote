package org.bwgz.quote.json.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class QuoteHTTPClient {
	private static final String URL = "http://192.168.2.201:8080/quote-json-server/quote/1";	

	public static void main(String[] args) {
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet(URL);

            System.out.println("executing request " + httpget.getURI());

            // Create a response handler
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("----------------------------------------");

        } catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            httpclient.getConnectionManager().shutdown();
        }
	}
}
