
public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	
	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(double annualInterestRate) {
		SavingsAccount.annualInterestRate = annualInterestRate;
	}

	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}
	
	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public double calculateMonthlyInterest(){
		double monthlyInterest = savingsBalance * annualInterestRate / 12.0;
		savingsBalance += monthlyInterest;
		
		return monthlyInterest;
	}
}
