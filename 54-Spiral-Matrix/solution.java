public class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> ans = new ArrayList<>();

        int h = m.length;
        if(h == 0)
            return ans;
        int n = m[0].length;
        
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = h-1;
        
        int count = 0;
        while(count < h*n){
            //go right
            for(int i = left; count < h*n && i <= right; i++){
                ans.add(m[up][i]);
                count++;
            }
            up++;
            if(count >= h*n)    break;
            
            //go down
            for(int i = up; count < h*n && i <= down; i++){
                ans.add(m[i][right]);
                count++;
            }
            right--;
            if(count >= h*n)    break;
            
            //go left
            for(int i = right; count < h*n && i >= left; i--){
                ans.add(m[down][i]);
                count++;
            }
            down++;
            if(count >= h*n)    break;
            
            //go up
            for(int i = down; count < h*n && i >= up; i--){
                ans.add(m[i][left]);
                count++;
            }
            left++;
            if(count >= h*n)    break;
        }
        
        return ans;
    }
}