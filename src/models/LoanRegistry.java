package models;

import utilities.StatusType;

public class LoanRegistry {
		
	private Loan[] registry;
	private int nextPosition;
	
	public LoanRegistry() {
		registry = new Loan[100];
	}
	
	
	
	public void addLoad(Loan loan) throws LoanAlreadyExistsException {
		for(int i = 0; i < nextPosition; i++ ) {
			if(registry[i].equals(loan)) {
				throw new LoanAlreadyExistsException();
			}
		}
		registry[nextPosition] = loan;
		nextPosition++;
	}
	
	public Loan findLoan(String bookID) throws LoanNotFoundException
	{
		for(int i = 0; i < nextPosition; i++) {
			if(registry[i].getBook().getID().equals(bookID)&& registry[i].getStatus() == StatusType.CURRENT) {
				return registry[i];
			}
		}
		throw new LoanNotFoundException();
	}
	
	public boolean isBookOnLoan (String bookID) {
		try {
			Loan findLoan = findLoan(bookID); 
			return true;
		}catch(LoanNotFoundException e) {
			return false;
		}
	}
	
	
}
