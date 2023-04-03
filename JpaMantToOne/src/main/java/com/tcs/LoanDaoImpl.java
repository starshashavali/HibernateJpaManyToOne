package com.tcs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LoanDaoImpl implements LoanDao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

	@Override
	public void saveLoan(Loan loan) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.merge(loan);
			//if you persist it will  work to insert only one record
			//if you write merge it will be work on insert and update 
			
			tx.commit();
			System.out.println("Loan object is Persisted sucessfully");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public Loan fetchLoanDetailsById(Integer loanId) {
		EntityManager em = factory.createEntityManager();
		Loan loan = em.find(Loan.class, loanId);
		em.close();
		return loan;
	}

	@Override
	public void removeLoan(Integer loanId) {

		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Loan loan = em.find(Loan.class, loanId);

			em.remove(loan);

			System.out.println("Loan object is deleted sucessfully");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
