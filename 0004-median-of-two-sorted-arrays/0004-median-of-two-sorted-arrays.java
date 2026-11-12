class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 > length2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = length1;
        int mid = (length1 + length2 + 1) / 2;

        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = mid - mid1;

            int maxLeft1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int minRight1 = mid1 == length1 ? Integer.MAX_VALUE : nums1[mid1];

            int maxLeft2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int minRight2 = mid2 == length2 ? Integer.MAX_VALUE : nums2[mid2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((length1 + length2) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        return 0.0;
    }
}