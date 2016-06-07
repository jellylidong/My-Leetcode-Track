public class Solution {
    
    //devide and conqure method
    public List<int[]> getSkyline(int[][] b) {
        if(b.length == 0)
            return new ArrayList<int[]>();
        return merge(b, 0, b.length-1);
    }
    
    public List<int[]> merge(int[][] b, int lo, int hi){
        if(lo < hi){
            int mid = lo + (hi-lo)/2;
            List<int[]> l1 = merge(b, lo, mid);
            List<int[]> l2 = merge(b, mid+1, hi);
            
            return merge(l1, l2);
        }
        else{
            List<int[]> ans = new ArrayList<>();
            ans.add(new int[] {b[lo][0], b[lo][2]});
            ans.add(new int[] {b[lo][1], 0});
            return ans;
        }
    }
    
    public List<int[]> merge(List<int[]> l1, List<int[]> l2){
        List<int[]> ans = new ArrayList<>();
        
        int h1 = 0;
        int h2 = 0;
        int preMax = Integer.MIN_VALUE;
        
        int i1 = 0;
        int i2 = 0;
        
        while(i1 < l1.size() && i2 < l2.size()){
            int x = 0;
            int h = 0;
            
            if(l1.get(i1)[0] < l2.get(i2)[0]){
                x = l1.get(i1)[0];
                h1 = l1.get(i1)[1];
                h = Math.max(h1, h2);
                i1++;
            }
            else if(l1.get(i1)[0] > l2.get(i2)[0]){
                x = l2.get(i2)[0];
                h2 = l2.get(i2)[1];
                h = Math.max(h1, h2);
                i2++;
            }
            else{
                x = l1.get(i1)[0];
                h1 = l1.get(i1)[1];
                h2 = l2.get(i2)[1];
                h = Math.max(h1, h2);
                i1++;
                i2++;
            }
            
            if(preMax != h){
                ans.add(new int[] {x, h}); // add only when maxheigh change, no matter bigger or smaller
                preMax = h;
            }
        }
        
        while(i1 < l1.size())
            ans.add(l1.get(i1++));
        while(i2 < l2.size())
            ans.add(l2.get(i2++));
        return ans;
    }
}