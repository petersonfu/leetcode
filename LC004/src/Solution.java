public class Solution {
	
	public double findKth(int[] nums1, int[] nums2, int s1, int s2, int k) {
		if (s1 >= nums1.length) return nums1[s1 + k - 1];
		if (s2 >= nums2.length) return nums2[s2 + k - 1];		
		if (k == 1) {
			return Math.min(nums1[s1], nums2[s2]);
		}
		int check1 = s1 + k / 2 - 1 < nums1.length ? nums1[s1 + k / 2 - 1] : Integer.MAX_VALUE;
		int check2 = s2 + k / 2 - 1 < nums2.length ? nums2[s2 + k / 2 - 1] : Integer.MAX_VALUE;
		if (check1 < check2) {
			return findKth(nums1, nums2, s1 + k/2, s2, k - k/2);
		} else {
			return findKth(nums1, nums2, s1, s2 + k/2, k - k/2);
		}
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalLength = nums1.length + nums2.length;
		if (totalLength % 2 == 1) {
			return findKth(nums1, nums2, 0, 0, totalLength / 2 + 1);
		} else {
			return (findKth(nums1, nums2, 0, 0, totalLength / 2) +
					findKth(nums1, nums2, 0, 0, totalLength / 2 + 1)) / 2.0;
		}
	}
	
	/* 
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0.0;
        int m = nums1.length;
        int n = nums2.length;
        int s1 = 0, e1 = nums1.length - 1, s2 = 0, e2 = nums2.length - 1;
        while(m + n > 3) {
            int kill = (m + n) / 4;
            if (kill > n) {s1+=kill; e1-=kill;}
            else if (kill > m) {s2+=kill; e2-=kill;}
            else {
                if (nums1[s1 + kill - 1] < nums2[s2 + kill - 1]) s1+=kill; else s2+=kill;
                if (nums1[e1 - kill + 1] > nums2[e2 - kill + 1]) e1-=kill; else e2-=kill;
            }
            m = Math.max(e1 - s1 + 1, 0);
            n = Math.max(e2 - s2 + 1, 0);
        }
        // Tons of edge conditions.
        if (m+n == 1) {
            if (n==0) return nums1[s1];
            else return nums2[s2];
        } else if (m + n == 2) {
            if (m==0) return (nums2[s2] + nums2[e2]) / 2.0;
            else if (n==0) return (nums1[s1] + nums1[e1]) / 2.0;
            else return (nums1[s1]+nums2[s2]) / 2.0;
        } else {
            if (m==0) return nums2[s2+1];
            else if (n==0) return nums1[s1+1];
            else if (m==1) {
                if (nums1[s1] <= nums2[s2]) return nums2[s2];
                else if (nums1[s1] >= nums2[e2]) return nums2[e2];
                else return nums1[s1];
            } else {
                if (nums2[s2] <= nums1[s1]) return nums1[s1];
                else if (nums2[s2] >= nums1[e1]) return nums1[e1];
                else return nums2[s2];
            }
        }
    }*/
}