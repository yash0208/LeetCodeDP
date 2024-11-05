public class FractionalKnapSack {
    public static void main(String[] args) {
        int[] weight = {10, 5, 15, 7, 6, 18, 3};
        int[] profit = {2, 3, 5, 7, 1, 4, 1};
        double[] fractional_capacity = new double[weight.length];

        // Calculate the profit/weight ratio (fractional capacity) for each item
        for (int i = 0; i < weight.length; i++) {
            fractional_capacity[i] = (double) profit[i] / weight[i]; // Cast to double for floating-point division
        }

        int capacity = 15;
        System.out.println("Max profit (Recursive): " + recursion(weight, fractional_capacity, profit, capacity, weight.length));
    }


    public static double recursion(int[] weight, double[] fractional_capacity, int[] profit, int capacity, int n) {
        // Base condition
        if (n == 0 || capacity == 0) return 0;

        // If the weight of the current item is less than or equal to the remaining capacity
        if (weight[n - 1] <= capacity) {
            return Math.max(
                    // Include the whole item
                    profit[n - 1] + recursion(weight, fractional_capacity, profit, capacity - weight[n - 1], n - 1),
                    // Exclude the item
                    recursion(weight, fractional_capacity, profit, capacity, n - 1)
            );
        } else {
            // If we can't fit the whole item, take the fractional part
            double fractionalProfit = fractional_capacity[n - 1] * capacity; // Calculate profit for the fractional item
            return fractionalProfit; // Return the fractional profit since this is the last item we can add
        }
    }
}
