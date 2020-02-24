import java.text.NumberFormat;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount();
		saver1.setSavingsBalance(2000.0);
		SavingsAccount saver2 = new SavingsAccount();
		saver2.setSavingsBalance(3000.0);
		SavingsAccount.setAnnualInterestRate(0.04);
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		System.out.println("saver1 starting balance of $2000.00 and annual interest rate of 4%\nMonthly Interest\tMonthly Balance");
		System.out.println("================\t================");
		for(int i=0; i<12; i++) {
			System.out.println(formatter.format(saver1.calculateMonthlyInterest()) + "\t\t\t" + formatter.format(saver1.getSavingsBalance())); 
		}

		System.out.println("\n");
		System.out.println("saver2 starting balance of $3000.00 and annual interest rate of 4%\nMonthly Interest\tMonthly Balance");
		System.out.println("================\t================");
		for(int i=0; i<12; i++) {
			System.out.println(formatter.format(saver2.calculateMonthlyInterest()) + "\t\t\t" + formatter.format(saver2.getSavingsBalance())); 
		}

		SavingsAccount.setAnnualInterestRate(0.05);
		System.out.println("\nsaver1 following month with an annual interest rate of 5%\nMonthly Interest\tMonthly Balance");
		System.out.println("================\t================");
		System.out.println(formatter.format(saver1.calculateMonthlyInterest()) + "\t\t\t" + formatter.format(saver1.getSavingsBalance())); 

		System.out.println("\n");
		System.out.println("saver2 following month with an annual interest rate of 5%\nMonthly Interest\tMonthly Balance");
		System.out.println("================\t================");
		System.out.println(formatter.format(saver2.calculateMonthlyInterest()) + "\t\t\t" + formatter.format(saver2.getSavingsBalance())); 
	}

}
