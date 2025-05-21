package com.transferjaca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transferjaca.model.Transfer;
import com.transferjaca.repository.TransferRepository;
@Service
public class TransferService {
	
	@Autowired
	private TransferRepository transferRepository;
	
	public List<Transfer> findAll() {
        return transferRepository.findAll();
    }


    public Transfer findById(Long id) {
        return transferRepository.findById(id).orElse(null);
    }


    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }


    public void deleteById(Long id) {
    	transferRepository.deleteById(id);
    }

}
