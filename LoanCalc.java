// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
    
    static double epsilon = 0.001;  // Approximation accuracy
    static int iterationCounter;    // Number of iterations 
    
    // Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
    public static void main(String[] args) {        
        // Gets the loan data
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        
        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        // Computes the periodical payment using brute force search
        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate / 100.0, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        // Computes the periodical payment using bisection search
        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate / 100.0, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    // Computes the ending balance of a loan, given the loan amount, the periodical
    // interest rate (as a percentage), the number of periods (n), and the periodical payment.
    public static double endBalance(double loan, double rate, int n, double payment) {
        double balance = loan;
        double interestFactor = 1.0 + rate;

        for (int i = 0; i < n; i++) {
            balance = balance - payment;
            balance = balance * interestFactor;
        }

        return balance;
    }

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0; 
        
        double g = loan / n; 
        
        g = Math.floor(g / epsilon) * epsilon;
        
        while (endBalance(loan, rate, n, g) > 0) {
            g = g + epsilon;
            iterationCounter++; 
        }
        
        return g;
    }

    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0; 

        double L = loan / n; 
        
        double H = loan * Math.pow(1.0 + rate, n);

        while (endBalance(loan, rate, n, H) > 0) {
            H = H * 2;
        }
        
        double g;

        while ((H - L) > epsilon) {
            iterationCounter++;
            
            g = (L + H) / 2.0;

            double f_g = endBalance(loan, rate, n, g);

            if (f_g > 0) {
                L = g; 
            } 
            else { 
                H = g; 
            }
        }

        return (L + H) / 2.0; 
    }
}