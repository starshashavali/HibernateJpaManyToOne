package com.tcs;

public class Tester {

	public static void main(String[] args) {
		LoanDao dao=new LoanDaoImpl();
		/*
		 * invoke saveLoan
		 
		Loan ploan= new Loan();
		ploan.setLoanId(10111);
		ploan.setLoanType("PersonalLoan");
		ploan.setAmount(500000.0);
		
		Loan vloan= new Loan();
		vloan.setLoanId(10112);
		vloan.setLoanType("vechile loan");
		vloan.setAmount(100000.0);
		
	
		Loan hloan= new Loan();
		hloan.setLoanId(10113);
		hloan.setLoanType("home  loan");
		hloan.setAmount(900000.0);
		
		Customer customer= new Customer();
		customer.setCustomerId(1001);
		customer.setCustomerName("A");

		
		ploan.setCustomer(customer);
		hloan.setCustomer(customer);
		vloan.setCustomer(customer);
		
		dao.saveLoan(hloan);
		dao.saveLoan(vloan);
		dao.saveLoan(ploan);
		*/
		
		Loan loan=dao.fetchLoanDetailsById(10112);
		//print loan details
		System.out.println(loan);
		Customer c=loan.getCustomer();
		System.out.println(c);
		
		/*
		 * lazy loading fetch only loan table data
		 * in many to one default fetch size is load ,it will fetch 
		 * src(loan) and targer(Customer) also
		 * \
		 */
		dao.removeLoan(10112);
		//if you remove src it  will remove target is removed automatically
		
		/*
		 * if we want too delete only src (loan)
		 * chenge cascade type persist
		 */
	}

}
