package com.MariusPaulikas.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.Models.Brokerage;

@Repository
public interface BrokerageRepository extends CrudRepository <Brokerage, Long> {

	List<Brokerage> findAll();
}
