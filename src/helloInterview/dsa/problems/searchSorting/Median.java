package helloInterview.dsa.problems.searchSorting;

public class Median {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            int partitionA = left + (right - left) / 2;

            int partitionB = (m + n + 1) / 2 - partitionA;

            int Aleft =
                    partitionA == 0
                            ? Integer.MIN_VALUE
                            : nums1[partitionA - 1];

            int Aright =
                    partitionA == m
                            ? Integer.MAX_VALUE
                            : nums1[partitionA];

            int Bleft =
                    partitionB == 0
                            ? Integer.MIN_VALUE
                            : nums2[partitionB - 1];

            int Bright =
                    partitionB == n
                            ? Integer.MAX_VALUE
                            : nums2[partitionB];

            // Correct partition found
            if (Aleft <= Bright && Bleft <= Aright) {

                // Even total length
                if ((m + n) % 2 == 0) {
                    return (
                            Math.max(Aleft, Bleft)
                                    + Math.min(Aright, Bright)
                    ) / 2.0;
                }

                // Odd total length
                return Math.max(Aleft, Bleft);
            }

            // Too many elements taken from nums1
            else if (Aleft > Bright) {
                right = partitionA - 1;
            }

            // Too few elements taken from nums1
            else {
                left = partitionA + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Median median = new Median();

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(
                median.findMedianSortedArrays(nums1, nums2)
        );
    }
}