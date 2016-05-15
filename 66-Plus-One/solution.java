public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        int carry = 1;
        while(i >= 0 && carry + digits[i] >= 10){
            digits[i] = (carry + digits[i])%10;
            i--;
        }
        if(i >= 0){
            digits[i]++;
            return digits;
        }
        int[] ans = new int[digits.length+1];
        ans[0] = 1;
        for(int j = 0; j < digits.length; j++){
            ans[j+1] = digits[j];
        }
        return ans;
    }
}