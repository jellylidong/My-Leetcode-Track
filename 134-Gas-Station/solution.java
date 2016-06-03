public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // for(int i = 0; i < gas.length; i++){
        //     int curGas = 0;
        //     for(int j = 0; j < gas.length; j++){
        //         int curP = (i+j)%gas.length;
        //         curGas += gas[curP] - cost[curP];
        //         if(curGas < 0)
        //             break;
        //     }
        //     if(curGas >= 0)
        //         return i;
        // }
        
        // return -1;
        
        //the above solution is O(n^2), got TLE
        
        //an O(n) solution
        //if A can not get B, then any stattion between A and B can not get B
        //if amount of gas >= amount of cost, there must be a solution
        
        int curGas = 0; // the left gas for each new station
        int curLeft = 0; // the total left gas
        int ans = 0;
        
        for(int i = 0; i < gas.length; i++){
            curGas += gas[i] - cost[i];
            curLeft += gas[i] - cost[i];
            if(curGas < 0){
                curGas = 0;
                ans = i+1;
            }
        }
        
        return curLeft >= 0? ans: -1;
    }
}