package com.MariusPaulikas.Servlet.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.Servlet.Models.Brokerage;

@Repository
public interface BrokerageRepository extends CrudRepository <Brokerage, Long> {

	List<Brokerage> findAll();
}
