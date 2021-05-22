package com.aforo255.service;

import java.util.List;

import com.aforo255.entity.Invoice;

public interface IInvoiceService {

	public List<Invoice> findAll();
	public Invoice findById (Integer id ); 
	public Invoice save (Invoice account);
	
}

