// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int i = x1;
		int count = 0;
		while ( count < x2 ) {
			i = i + 1;
			count = count + 1;
		}
		return i;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
	
		int i = x1;
		int count = 0;
		while ( count < x2 ) {
			i -=  1;
			count = count + 1;
		}
		return i;
		
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int i = x1;
		int result = 0;
		int count = 0;
		while ( count < x2 ) {
			result +=  i;
			count = count + 1;
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int i = x;
		int result = 0;
		int count = 0;
		int countd = 1;
		while (countd < n) {
			result = 0;
			while ( count < x ) {
				result +=  i;
				count = count + 1;
			}
			countd += 1;
			count = 0;
			i = result;
			
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int i = x2;
		int result = 0;
		int count = 0;
		while ( result < x1 ) {
			result +=  i;
			count = count + 1;
		}
		
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int i = x2;
		int result = 0;
		int count = 0;
		while ( result < x1 ) {
			result +=  i;
			count = count + 1;
		}
		if(result == x1){
			return 0;
		}else{
			return minus(x1,minus(result,i));
		}
		
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int i = 0;
		int result = 0;
		while ( result != x ) {
			result = times(i,i);
			i++;
			if(result > x){
				return minus(i,1);
			}
			
		}
		
		return minus(i,1);
	}	
	  	  
}