package com.MariusPaulikas.Servlet.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "banking_acct")

public class Banking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String accttype;
	
	private String transactionamount;
	
	private String transactionparty;
	
	private String transactiontype;
	
	private String balance;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_id")
	private User user;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAccttype() {
		return accttype;
	}


	public void setAccttype(String accttype) {
		this.accttype = accttype;
	}


	public String getTransactionamount() {
		return transactionamount;
	}


	public void setTransactionamount(String transactionamount) {
		this.transactionamount = transactionamount;
	}


	public String getTransactionparty() {
		return transactionparty;
	}


	public void setTransactionparty(String transactionparty) {
		this.transactionparty = transactionparty;
	}


	public String getTransactiontype() {
		return transactiontype;
	}


	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}


	public String getBalance() {
		return balance;
	}


	public void setBalance(String balance) {
		this.balance = balance;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
