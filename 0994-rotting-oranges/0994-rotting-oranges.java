class Solution {
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = rows == 0 ? 0 : grid[0].length;

        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    ++freshOranges;
                }
                else if (grid[row][col] == 2) {
                    queue.offer(new int[] {row, col});
                }
            }
        }

        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int minMinutes = 0;

        while (!queue.isEmpty() && freshOranges != 0) {
            ++minMinutes;

            int size = queue.size();

            while (size-- != 0) {
                int[] arr = queue.poll();

                for (int[] direction : directions) {
                    int row = arr[0] + direction[0];
                    int col = arr[1] + direction[1];

                    if (row < 0 || row == rows || col < 0 || col == cols) {
                        continue;
                    }

                    if (grid[row][col] == 1) {
                        --freshOranges;
                        grid[row][col] = 2;
                        queue.offer(new int[] {row, col});
                    }
                }
            }
        }

        return freshOranges == 0 ? minMinutes : -1;
    }
}