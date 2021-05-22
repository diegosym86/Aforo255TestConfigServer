package com.aforo255.entity;

import java.io.Serializable;
import java.util.Date;


public class Transaction  implements Serializable{

	
	private static final long serialVersionUID = 1L;	

	private Integer id;
	private Integer invoiceId;
	private double amount ; 
	private Date datetime ;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	} 	
	
}