public class FinancialForecaster {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base Case: If no more periods left, return the current accumulated value
        if (periods == 0) {
            return presentValue;
        }

        // Recursive Call: Calculate value for next year and decrement periods
        double nextYearValue = presentValue * (1 + growthRate);
        return calculateFutureValue(nextYearValue, growthRate, periods - 1);
    }
}