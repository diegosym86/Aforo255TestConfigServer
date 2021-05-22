package com.aforo255.repository;

import org.springframework.data.repository.CrudRepository;

import com.aforo255.entity.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice,Integer> {

}

