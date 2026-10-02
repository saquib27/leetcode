class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            int ans = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], ans);
            stack.push(nums2[i]);
        }

        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            answer[i] = map.get(nums1[i]);
        }

        return answer;
    }
}