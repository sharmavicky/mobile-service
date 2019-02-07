package com.cts.mobilerecharge.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transaction")
@NamedQueries({
	@NamedQuery(name = "Transaction.fetchAllTransactionDetail", query = "select distinct t from Transaction t "
			+ "left join fetch t.operator " + " left join fetch t.user " + "where t.user.id =:userId")})
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tr_id")
	private int id;
	
	@Column(name = "tr_mobilenumber")
	private String mobileNumber;
	
	@Column(name = "tr_amount")
	private int amount;
	@Column(name = "tr_date")
	private Date date;

	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tr_us_id")
	
	@JsonIgnore
    private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tr_op_id")
	private Operator operator;


	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int id, String mobileNumber, int amount, Date date, User user, Operator operator) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.amount = amount;
		this.date = date;
		this.operator=operator;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", mobileNumber=" + mobileNumber + ", amount=" + amount + ", date=" + date
				+ "]";
	}

}
