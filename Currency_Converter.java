package mypackage;
import java.util.Scanner;

public class Currency_Converter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to currency converter!");
		System.out.println("1.USD to Rupee");
		System.out.println("2. Rupee to USD");
		System.out.println("3.EUR to Rupee");
		System.out.println("4.Rupee to EUR");
		System.out.print("Enter your choice (1 or 2 or 3 or 4): ");
		int choice = scanner.nextInt();
		
		if (choice == 1) {
			System.out.print("enter the amount in USD: ");
			double USD = scanner.nextDouble();
			double Rupee = usdToRupee(USD);
			System.out.println("Converted amount in Rupee: " + Rupee);
		} else if (choice == 2) {
			System.out.print("Enter the amount in Rupee: ");
			double Rupee = scanner.nextDouble();
			double USD = RupeeTousd(Rupee);
			System.out.println("Converted amount in USD: " + USD);
		} else if (choice ==3) {
			System.out.print("Enter the amount in EURO: ");
			double EURO = scanner.nextDouble();
			double Rupee = euroToRupee(EURO);
			System.out.println("Converted amount  in Rupee: " + Rupee);
			
		} else if (choice ==4) {
			System.out.print("Enter the amount in Rupee: ");
			double Rupee = scanner.nextDouble();
			double EURO = RupeeToEuro(Rupee);
			System.out.println("Converted amount in EURO: " + EURO);
		}
		else {
			System.out.println("Invalid choice. please select 1 or 2 or 3 or 4.");
		}
		scanner.close();
	}
	private static double usdToRupee(double USD) {
		
		return USD * 83.47;
	}
	private static double RupeeTousd(double Rupee) {
		
		return Rupee * 0.0119804;
	}

	private static double euroToRupee(double EURO) {
		
		return EURO *89.10;
	}

	private static double RupeeToEuro(double Rupee) {
		return Rupee *0.0113;
		
	}	

}
