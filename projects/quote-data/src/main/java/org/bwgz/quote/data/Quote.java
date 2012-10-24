package org.bwgz.quote.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quote")
public class Quote {
	@Id
	@GeneratedValue
	private Long id;
	private String quote;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
