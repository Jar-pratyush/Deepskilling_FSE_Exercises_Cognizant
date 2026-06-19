public class ForecastingTest {
    public static void main(String[] args) {
        double initialInvestment = 10000.0; // $10,000
        double annualGrowthRate = 0.05;     // 5% growth
        int years = 10;                     // Forecast for 10 years

        System.out.println("--- FINANCIAL FORECASTING (RECURSIVE) ---");
        System.out.printf("Present Value: $%.2f%n", initialInvestment);
        System.out.printf("Annual Growth Rate: %.0f%%%n", (annualGrowthRate * 100));
        System.out.printf("Forecast Periods: %d years%n", years);

        double futureValue = FinancialForecaster.calculateFutureValue(initialInvestment, annualGrowthRate, years);

        System.out.println("-----------------------------------------");
        System.out.printf("Predicted Future Value: $%.2f%n", futureValue);

        System.out.println("\n--- OPTIMIZATION ANALYSIS ---");
        System.out.println("Time Complexity: O(n) where n is the number of years.");
        System.out.println("Optimization Strategy: To avoid excessive recursive calls (Stack Overflow) for massive timeframes,");
        System.out.println("we could use Memoization to cache intermediate years, or rewrite it iteratively.");
    }
}