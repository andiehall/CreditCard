import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreditCard {
	
	public static long number;
	public static long[] newCreditCard = new long[16];
	public static int validCreditCards = 0;
	public static int invalidCreditCards = 0;
	
	public static void main(String[] args) throws IOException 
	{
		
		importingFile();
		calcCard();
		// hello dhgfjysgfsdgyf
		// hehe
	}
	
	public static void importingFile() throws IOException 
	{
		
		Scanner creditCardFile = new Scanner(new File("CreditCardNumbers.txt"));
		while(creditCardFile.hasNext())
		{
			number = creditCardFile.nextLong();
			
			for(int i = 15; i >= 0; i--)
			   {
			   newCreditCard[i] = number % 10;
			   number = number / 10;
			   }
			calcCard();
		}
		
	}
	
	public static void calcCard() throws IOException
	{
		
		for(int i = 0; i < newCreditCard.length; i += 2) {
			
			newCreditCard[i] = newCreditCard[i]*2;
			
			if(newCreditCard[i] > 9) {
					long digit1 = newCreditCard[i] % 10;
					long digit2 = newCreditCard[i] /10;
			
					newCreditCard[i] = digit1 + digit2;
				}
				
			checkIfHeIsValid();
			
		}
		
	}
	
	public static void checkIfHeIsValid()
	{
		long settingCard = 0;
		
			for(int i = 0; i < newCreditCard.length; i++) {
						
				settingCard += newCreditCard[i];
				
			}
			
			if (settingCard % 10 == 0) {
				validCreditCards++;
				for(int i = 0; i < newCreditCard.length; i++) {
				
				System.out.println(newCreditCard[i] + " is valid");	
				}
			}
			
			else {
				invalidCreditCards++;
				for(int i = 0; i < newCreditCard.length; i++) {
					
					System.out.println(newCreditCard[i] + " is not valid");	
					}

			}
			
			

		
	}

}
