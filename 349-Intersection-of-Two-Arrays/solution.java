public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);
        HashSet<Integer> ans = new HashSet<>();
        for(int i = 0;  i < nums2.length; i++){
            if(set.contains(nums2[i]))
                ans.add(nums2[i]);
        }
        
        int size = ans.size();
        int [] arr = new int[size];
        for(int n: ans){
            arr[size-1] = n;
            size--;
        }
        
        return arr;
    }
}

//intwesection is jiao ji