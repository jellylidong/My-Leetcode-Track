public class Solution {
    public int maxArea(int[] h) {
        int left = 0;
        int right = h.length-1;
        
        int max = 0;
        while(left < right){
            max = Math.max(max, (right-left) * Math.min(h[left], h[right]));
            
            //if h[left] < h[right], the min height will always be h[left], so left++
            //if h[left] >= h[right], the min heigh will aleays be h[right], so right--
            if(h[left] < h[right])
                left++;
            else
                right--;
        }
        return max;
    }
}