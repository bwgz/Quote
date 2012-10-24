package org.bwgz.quote.android;

import org.springframework.hateoas.ResourceSupport;

public class Quote extends ResourceSupport {
	private String quote;
	
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("id: ").append(getId()).append("; ");
        sb.append("quote: ").append(getQuote()).append("; ");

        return sb.toString();
	}
}
