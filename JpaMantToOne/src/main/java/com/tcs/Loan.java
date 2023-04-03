package com.tcs;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tbl_Loans")
public class Loan {
	@Id
	@Column(name="loan_id")
	private Integer loanId;

	@Column(name="loan_type")
	private String loanType;
	@Column(name="amount")
	private Double amount;
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.EAGER)
	//cascade used to propagate crud operation source to target.it is enum.
	@JoinColumn(name="customer_id")
	//@JoinColumn represent foreign key column.
	//foreign key represents parent table primary key
	private Customer customer;
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", amount=" + amount + ", customer=" + customer
				+ "]";
	}

}
