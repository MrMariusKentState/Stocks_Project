package com.MariusPaulikas.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.Models.Banking;

@Repository
public interface BankingRepository extends CrudRepository <Banking, Long> {

	List<Banking> findAll();
}
