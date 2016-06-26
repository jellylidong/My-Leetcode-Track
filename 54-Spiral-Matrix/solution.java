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
            
            if(up <= down)
                for(int i = right; i >= left; i--)
                    ans.add(m[down][i]);
            down--;
            
            if(left <= right)
                for(int i = down; i >= up; i--)
                    ans.add(m[i][left]);
            left++;
        }
        
        return ans;
    }
}