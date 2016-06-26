public class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        if(m.length == 0)
            return new ArrayList<Integer>();
        if(m[0].length == 0)
            return new ArrayList<Integer>();
            
        int left = 0;
        int up = 0;
        int right = m[0].length-1;
        int down = m.length-1;
        
        List<Integer> ans = new ArrayList<>();
        while(left <= right && up <= down){
            for(int i = left; i <= right; i++)
                ans.add(m[up][i]);
            up++;
            
            for(int i = up; i <= down; i++)
                ans.add(m[i][right]);
            right--;
            
            //when going left, must ganrantee current row  is valid
            if(up <= down)
                for(int i = right; i >= left; i--)
                    ans.add(m[down][i]);
            down--;
            
            //when going up, must ganrantee current col is valid
            if(left <= right)
                for(int i = down; i >= up; i--)
                    ans.add(m[i][left]);
            left++;
            
            //otherwise for cases like [[2,3]] (which is only one row or one col), we can get wrong answer, add too many numbers
        }
        
        return ans;
    }
}