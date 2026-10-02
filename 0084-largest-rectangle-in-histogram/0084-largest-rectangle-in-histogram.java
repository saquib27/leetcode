class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxarea=0;
        Stack<Integer> stack = new Stack<>();

        int start= -1;
        int end=0;

        while (end <= heights.length){
          while  (!stack.isEmpty() && (end==heights.length || heights[end]<heights[stack.peek()])
            ){
                int index = stack.pop();
                int height = heights[index];
                start = stack.isEmpty() ? -1: stack.peek();

                int width = end-start-1;
                int area = height * width;

                maxarea = Math.max(maxarea,  area);
            }
            stack.push(end);
            ++end;

        }
        return maxarea;
    }
}