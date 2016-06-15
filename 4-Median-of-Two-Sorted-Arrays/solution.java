public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //this problem can be transform to find the kth largest number from two sorted arrays
        //note: ith is count from 0
        //here, we need find the media, 
        //so if l1+l2 is odd, we need to find (l1+l2)/2 th number
        //if l1+l2 is even, need to find (l1+l2)/2 and (l1+l2)/2-1 th  number and return their average value
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        int k =(l1+l2)/2;
        
        double v1 = helper(nums1, 0, l1-1, nums2, 0, l2-1, k);
        if((l1+l2)%2 == 0){
            double v2 = helper(nums1, 0, l1-1, nums2, 0, l2-1, k-1);
            v1 = (v1+v2)/2;
        }
        
        return v1;
    }
    
    public double helper(int[] nums1, int lo1, int hi1, int[] nums2, int lo2, int hi2, int k){
        if(lo1 > hi1)
            return (double)nums2[lo2+k];
        if(lo2 > hi2)
            return (double)nums1[lo1+k];
            
        int m1 = lo1 + (hi1-lo1)/2;
        int m2 = lo2 + (hi2-lo2)/2;
        
        if(nums1[m1] <= nums2[m2]){
            //if so, nums1[lo1...m1], nums2[lo2...m2] <= nums2[m2]
            //so there would be *at least* (m1-lo1+1) + (m2-lo2+1) numbers <= nums2[m2]
            
            //nums1[m1+1...hi1], nums2[m2...hi2] > nums[m1]
            //so there would be at least (h1-m1-1+1) + (hi2-m2+1) > nums[m1]
            if(k < (m1-lo1+1) + (m2-lo2+1-1))
                return helper(nums1, lo1, hi1, nums2, lo2, m2-1, k);
            else
                return helper(nums1, m1+1, hi1, nums2, lo2, hi2, k-(m1-lo1+1));
        }
        else{//nums2[m2] < nums1[m1]
            if(k < (m2-lo2+1) + (m1-lo1+1-1)) // the -1 means not include nums1[m1]
                return helper(nums2, lo2, hi2, nums1, lo1, m1-1, k);
            else
                return helper(nums2, m2+1,  hi2, nums1, lo1, hi1, k-(m2-lo2+1));
        }
        
        //note: when use devide and conquer, if you use inclusive boundary, ie both lo and hi are inclusive
        //make sure each branch has at least one changed boundary, ie the new lo and new hi for next branch,
        //at least one of them is changed, otherwise there can be dead loop
    }
}