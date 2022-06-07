package com.MariusPaulikas.Servlet.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.Servlet.Models.Banking;

@Repository
public interface BankingRepository extends CrudRepository <Banking, Long> {

	List<Banking> findAll();
}
