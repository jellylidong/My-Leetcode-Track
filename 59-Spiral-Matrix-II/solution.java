public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = n-1;
        
        int count = 1;
        while(count <= n*n){
            //go right
            // System.out.println(left + " " + right + " " + up + " " + down);
            for(int i = left; count <= n*n && i <= right; i++)
                ans[up][i] = count++;
            up++; //1
            
            //go down
            // System.out.println(left + " " + right + " " + up + " " + down);
            for(int i = up; count <= n*n && i <= down; i++)
                ans[i][right] = count++;
            right--; 
            
            //go left
            // System.out.println(left + " " + right + " " + up + " " + down);
            for(int i = right; count <= n*n && i >= left; i--)
                ans[down][i] = count++;
            down--;
            
            // System.out.println(left + " " + right + " " + up + " " + down);
            for(int i = down; count <= n*n && i <= up; i--)
                ans[i][left] = count++;
            left++;
        }
        
        return ans;
    }
}