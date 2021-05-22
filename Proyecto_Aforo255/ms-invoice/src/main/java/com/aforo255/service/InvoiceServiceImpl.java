package com.aforo255.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aforo255.entity.Invoice;
import com.aforo255.repository.InvoiceRepository;
@Service
public class InvoiceServiceImpl implements IInvoiceService{

	@Autowired
	InvoiceRepository _accountRepo;
	
	@Override
	public List<Invoice> findAll() {
		// TODO Auto-generated method stub
		return  (List<Invoice>)_accountRepo.findAll();
	}

	@Override
	public Invoice findById(Integer id) {
		// TODO Auto-generated method stub
		return _accountRepo.findById(id).orElse(null);
	}

	@Override
	public Invoice save(Invoice account) {
		// TODO Auto-generated method stub
		return _accountRepo.save(account);
	}

}
