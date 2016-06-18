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
        //basic idea
        //for points[i], find the numbers of points in the same line with points[i] from points[i+1 ... len]
        //note these numbers does not include points[i]
        //find the max value from these values
        //meanwhile, if points[i] == points[j], overlap++ and continue
        //after find the max value
        //update answer, ans = Math.max(max+overlap+1, ans), 
        //the +1 means points[i] itself, the overlap means points same with points[i]
        
        HashMap<Double, HashMap<Double, Integer>> map = new HashMap<>(); // slope, offset, count
        
        int ans = 0;
        if(points.length <= 2)
            return points.length;
            
        for(int i = 0; i < points.length; i++){
            //each round, generate the number of points in the same line with points[i]
            //note these points != points[i]
            //if points[j] == points[i], overlap++
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
                    //count the numbers of same points
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
            
            ans = Math.max(max+overlap+1, ans); //the real number is points[i] itself(+1) and dup points(+overlap)
        }
        
        return ans;
    }
    // [[84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230]]
    // 
}