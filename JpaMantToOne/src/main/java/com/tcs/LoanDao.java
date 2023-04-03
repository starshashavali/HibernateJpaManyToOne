package com.tcs;

public interface LoanDao {
void saveLoan(Loan loan);
	Loan fetchLoanDetailsById(Integer loanId);
	void removeLoan(Integer loanId);
	
	
}
