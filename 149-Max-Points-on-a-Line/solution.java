/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        HashMap<Double, HashMap<Double, Integer>> map = new HashMap<>(); // slope, offset, count
        
        int ans = 0;
        if(points.length <= 2)
            return points.length;
            
        
        
        for(int i = 0; i < points.length; i++){
            map.clear();
            int overlap = 0;
            int max = 0;
            
            double x0 = (double)points[i].x;
            double y0 = (double)points[i].y;
            
            for(int j = i+1; j < points.length; j++){
                
                
                double slope = 0.0;
                double offset = 0.0;
                
                double x1 = (double)points[j].x;
                double y1 = (double)points[j].y;
                
                if(x0==x1 && y0== y1){
                    overlap++;
                    continue;
                }
                else if(x1 == x0){
                    slope = Double.MAX_VALUE;
                    offset = x0;
                }
                else if(y1 == y0){
                    slope = 0;
                    offset = y0;
                }
                else{
                    slope = (y0-y1)/(x0-x1);
                    offset = y0 - slope*x0;
                }
                
                if(map.containsKey(slope)){
                    if(map.get(slope).containsKey(offset)){
                        map.get(slope).put(offset, map.get(slope).get(offset)+1);
                    }
                    else{
                        map.get(slope).put(offset, 1);
                    }
                    
                }
                else{
                    HashMap<Double, Integer> newMap = new HashMap<>();
                    newMap.put(offset, 1);
                    map.put(slope, newMap);
                }
                max = Math.max(max, map.get(slope).get(offset));
            }
            
            ans = Math.max(max+overlap+1, ans);
        }
        
        return ans;
    }
    // [[84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230]]
    // 
}