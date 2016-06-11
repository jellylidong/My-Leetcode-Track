public class Solution {
    public String largestNumber(int[] nums) {
        Integer[] newNum = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++)
            newNum[i] = new Integer(nums[i]);
        Arrays.sort(newNum, new myComparator());
        StringBuilder ans = new StringBuilder();
        for(int n: newNum)
            ans.append(n);
        int i = 0;
        while(i < ans.length()-1 && ans.charAt(i) == '0')
            i++;
        return ans.toString().substring(i);
    }

    public class myComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer n1, Integer n2){
            String s1 = n1 + "" + n2;
            String s2 = n2 + "" + n1;
            // for(int i = 0; i < s1.length(); i++){
            //     if(s1.charAt(i) > s2.charAt(i))
            //         return -1;
            // }
            // return 1;
            return -s1.compareTo(s2);
        }
    }
}