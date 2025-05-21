package com.transferjaca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transferjaca.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long>{

}
