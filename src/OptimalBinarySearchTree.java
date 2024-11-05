public class OptimalBinarySearchTree {
    public static void main(String[] args) {
        int[] nodes = {10, 20, 30, 40};
        int[] freq = {4, 2, 6, 3};

        System.out.println("Recursion: " + recursive(freq, 0, freq.length - 1));
    }

    static int recursive(int[] freq, int i, int j) {
        // Base case: if there are no elements in this range, the cost is 0
        if (i > j) return 0;

        // Base case: if there is only one element, the cost is its frequency
        if (i == j) return freq[i];

        // Get the sum of frequencies in this range
        int fsum = sum(freq, i, j);

        // Initialize minimum cost
        int min = Integer.MAX_VALUE;

        // Try making each key in this range the root
        for (int k = i; k <= j; k++) {
            // Cost of making freq[k] the root
            int cost = recursive(freq, i, k - 1) + recursive(freq, k + 1, j);
            min = Math.min(min, cost);
        }

        // Return minimum cost + the sum of frequencies in this range
        return min + fsum;
    }

    // Utility function to calculate the sum of frequencies in the range [i, j]
    static int sum(int[] freq, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += freq[k];
        }
        return s;
    }
}
