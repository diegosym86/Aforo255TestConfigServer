package com.aforo255.entity;

import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction")
public class Transaction  {
	
	@BsonId
	private String id ; 
	private double amount ;
	private Integer invoiceId;
	private Date datetime ;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int accountId) {
		this.invoiceId = accountId;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	} 	
}

