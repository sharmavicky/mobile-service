package com.cts.mobilerecharge.bean;

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
@Table(name = "offer")
@NamedQueries({
	@NamedQuery(name = "Offers.fetchOffersDetails", query = "select distinct o from Offers o "
			+ "left join fetch o.operator "
			+ "where o.operator.id = :operatorId") })

public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "of_id")
	private int id;
	
	@Column(name = "of_name")
	private String name;
	@Column(name = "of_amount")
	private int amount;
    
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name ="of_op_id")
	@JsonIgnore
    private Operator operator;

	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Offers(int id, String name, int amount, Operator operator) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.operator = operator;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}



	@Override
	public String toString() {
		return "Offers [id=" + id + ", name=" + name + ", amount=" + amount + ", operator=" + operator + "]";
	}

	
}
