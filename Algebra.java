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


    public static int plus(int x1, int x2) {
        int result = x1;
        
        if (x2 > 0) {
            while (x2 > 0) {
                result++;
                x2--;
            }
        } 
        else if (x2 < 0) {
            int absX2 = 0;
            while (x2 < 0) {
                absX2++;
                x2++;
            }
            while (absX2 > 0) {
                result--;
                absX2--;
            }
        }
        return result;
    }

    public static int minus(int x1, int x2) {
        int result = x1;

        if (x2 > 0) {
            while (x2 > 0) {
                result--;
                x2--;
            }
        } 
        else if (x2 < 0) {
            int absX2 = 0;
            while (x2 < 0) {
                absX2++;
                x2++;
            }
            while (absX2 > 0) {
                result++;
                absX2--;
            }
        }
        return result;
    }

    public static int times(int x1, int x2) {
        if (x1 == 0 || x2 == 0) {
            return 0;
        }

        int result = 0;
        
        int absX2 = x2;
        if (x2 < 0) {
            absX2 = minus(0, x2); 
        }

        while (absX2 > 0) {
            result = plus(result, x1);
            absX2--;
        }

        if (x2 < 0) {
            return minus(0, result);
        } else {
            return result;
        }
    }

    public static int pow(int x, int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int result = x;
        int count = 1; 

        while (count < n) {
            result = times(result, x);
            count++;
        }
        return result;
    }

    public static int div(int x1, int x2) {
        if (x2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        if (x1 == 0) {
            return 0;
        }

        int absX1 = x1;
        if (x1 < 0) {
            absX1 = minus(0, x1);
        }
        int absX2 = x2;
        if (x2 < 0) {
            absX2 = minus(0, x2);
        }
        
        int count = 0;
        int current = absX1;

        while (current >= absX2) {
            current = minus(current, absX2);
            count++;
        }

        if ((x1 < 0) != (x2 < 0)) {
            return minus(0, count);
        } else {
            return count;
        }
    }

    public static int mod(int x1, int x2) {
        if (x2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        
        int quotient = div(x1, x2);
        int product = times(quotient, x2);
        return minus(x1, product);
    }   

    public static int sqrt(int x) {
        if (x < 0) {
            return 0;
        }
        if (x == 0) {
            return 0;
        }

        int i = 1; 
        
        while (true) {
            int iSquared = times(i, i);

            if (iSquared == x) {
                return i;
            }
            
            if (iSquared > x) {
                return minus(i, 1);
            }
            
            i++;
        }
    }   
}