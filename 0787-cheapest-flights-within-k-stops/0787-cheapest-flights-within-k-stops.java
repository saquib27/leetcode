class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] minimumPrice = new int[n];

        Arrays.fill(minimumPrice, Integer.MAX_VALUE);
        minimumPrice[src] = 0;

        while (k-- != -1) {
            int[] price = Arrays.copyOf(minimumPrice, n);

            for (int[] flight : flights) {
                if (minimumPrice[flight[0]] == Integer.MAX_VALUE) {
                    continue;
                }
                else if (minimumPrice[flight[0]] + flight[2] < price[flight[1]]) {
                    price[flight[1]] = minimumPrice[flight[0]] + flight[2];
                }
            }

            minimumPrice = price;
        }

        return minimumPrice[dst] == Integer.MAX_VALUE ? -1 : minimumPrice[dst];
    }
}