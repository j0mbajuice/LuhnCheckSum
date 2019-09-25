import java.util.Scanner;

/**
 * 	- Thinking Like A Programmer -
 *  - V. Anton Spraul -
 *  
 * 	@author joshventocilla
 *
 *	This program takes an identification number of arbitrary length and determines whether
 *	the number is valid under the Luhn formula. The program must process each character before
 *	reading the next one.
 */

public class LuhnCheckSum {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String digit;
		
		try {	
			char charValue;
			
			int oddLengthCheckSum = 0;
			int evenLengthCheckSum = 0;
			int position = 1;
			int checksum;
			
			// Enter 10 digit number
			System.out.print("Enter a number that is at least 10 digits long: ");
			digit = input.next();
			
			// Calculate values
			for(int i=0; i<10; i++) {
				charValue = digit.charAt(i);
				
				if(position % 2 == 0) {
					oddLengthCheckSum += doubleDigitValue(charValue - '0');
					evenLengthCheckSum += charValue - '0';
				} else {
					evenLengthCheckSum += doubleDigitValue(charValue - '0');
					oddLengthCheckSum += charValue - '0';
				}
				position++;
			}
			
			if( (position - 1) % 2 == 0) {
				checksum = evenLengthCheckSum;
			} else {
				checksum = oddLengthCheckSum;
			}
			
			System.out.println("Checksum is " + checksum + ".");
			
			if( checksum % 10 == 0) {
				System.out.println("Checksum is divisible by 10. Valid.");
			} else {
				System.out.println("Checksum is not divisble by 10. Invalid.");
			}
		}
		catch(StringIndexOutOfBoundsException e) {
			System.out.println("Number must be 10 digits long.");
			System.out.println("Enter a number that is at least 10 digits long: ");
			digit = input.next();
		}
					
	}
	
	/**
	 * Doubles the value of the digit and checks the doubled digit. If the doubled digit is > 10
	 * then add the digits separately, otherwise the sum is the double digit.
	 * @int digit The digit to be checked
	 */
	public static int doubleDigitValue(int digit) {
		
		int num = digit * 2;
		int sum;
		
		if(num > 10) {
			sum  = 1 + (num % 10);
		} else {
			sum = num;
		}
		
		return sum;
	}
		
}
