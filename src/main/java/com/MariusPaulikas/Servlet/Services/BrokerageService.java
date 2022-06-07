package com.MariusPaulikas.Servlet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.Servlet.Models.Brokerage;
import com.MariusPaulikas.Servlet.Repositories.BrokerageRepository;

@Service
public class BrokerageService {
	
	private final BrokerageRepository brokeragerepository;

	public BrokerageService (BrokerageRepository brokeragerepository) {
		this.brokeragerepository = brokeragerepository;
	}
	
	public List<Brokerage> allBrokerageAccounts () {
		return brokeragerepository.findAll();
	}
	
	
	public Brokerage findBrokerageAccounts (Long id) {
		Optional<Brokerage> onebrokerageaccount = brokeragerepository.findById(id);
		if(onebrokerageaccount.isPresent()) {
			return onebrokerageaccount.get();
		}
		else {
			return null;
		}
	}
	
}
