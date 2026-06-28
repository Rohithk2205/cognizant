import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
       
        if (years == 0) {
            return currentValue;
        }
        
      
        double nextYearValue = currentValue * (1 + growthRate);
        return calculateFutureValue(nextYearValue, growthRate, years - 1);
    }


    private static Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValueMemoized(double currentValue, double growthRate, int years) {
        // Base case
        if (years == 0) {
            return currentValue;
        }
        
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        
        
        double nextYearValue = currentValue * (1 + growthRate);
        double result = calculateFutureValueMemoized(nextYearValue, growthRate, years - 1);
        
        
        memo.put(years, result);
        return result;
    }

 
    public static double calculateFutureValueIterative(double currentValue, double growthRate, int years) {
        return currentValue * Math.pow(1 + growthRate, years);
    }

    public static void main(String[] args) {
        System.out.println("=== Financial Forecasting Tool ===\n");

        double initialInvestment = 1000.0;
        double annualGrowthRate = 0.10; 
        int years = 10;

        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Annual Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecasting for: " + years + " years\n");

        // Test recursive approach
        System.out.println("=== Recursive Approach ===");
        long startTime = System.nanoTime();
        double futureValueRecursive = calculateFutureValue(initialInvestment, annualGrowthRate, years);
        long endTime = System.nanoTime();
        System.out.println("Future Value: $" + String.format("%.2f", futureValueRecursive));
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Time Complexity: O(n)\n");

        // Test memoized approach
        System.out.println("=== Memoized Recursive Approach ===");
        memo.clear(); // Clear memo for fresh test
        startTime = System.nanoTime();
        double futureValueMemoized = calculateFutureValueMemoized(initialInvestment, annualGrowthRate, years);
        endTime = System.nanoTime();
        System.out.println("Future Value: $" + String.format("%.2f", futureValueMemoized));
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Time Complexity: O(n) with O(n) space for memoization\n");

        // Test iterative approach
        System.out.println("=== Iterative (Formula) Approach ===");
        startTime = System.nanoTime();
        double futureValueIterative = calculateFutureValueIterative(initialInvestment, annualGrowthRate, years);
        endTime = System.nanoTime();
        System.out.println("Future Value: $" + String.format("%.2f", futureValueIterative));
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Time Complexity: O(1)\n");

        System.out.println("=== Analysis & Optimization ===");
        System.out.println("1. Simple Recursion:");
        System.out.println("   - Time: O(n) - makes n recursive calls");
        System.out.println("   - Space: O(n) - call stack depth of n");
        System.out.println("   - Issue: Can cause stack overflow for large n");
        System.out.println();
        System.out.println("2. Memoization Optimization:");
        System.out.println("   - Time: O(n) - but faster for repeated calculations");
        System.out.println("   - Space: O(n) - for memoization table + call stack");
        System.out.println("   - Benefit: Avoids redundant calculations");
        System.out.println();
        System.out.println("3. Iterative Formula (Best for this case):");
        System.out.println("   - Time: O(1) - direct calculation");
        System.out.println("   - Space: O(1) - no extra storage needed");
        System.out.println("   - Best choice when mathematical formula exists");
        System.out.println();
        System.out.println("When to use recursion:");
        System.out.println("- Problem naturally divides into similar sub-problems");
        System.out.println("- Tree/graph traversals, divide-and-conquer algorithms");
        System.out.println("- When memoization can significantly improve performance");
        System.out.println();
        System.out.println("When to avoid recursion:");
        System.out.println("- Simple calculations with known formulas");
        System.out.println("- Very deep recursion (risk of stack overflow)");
        System.out.println("- Performance-critical code without memoization");
    }
}
