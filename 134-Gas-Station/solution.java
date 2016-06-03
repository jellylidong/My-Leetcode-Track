public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            int curGas = 0;
            for(int j = 0; j < gas.length; j++){
                int curP = (i+j)%gas.length;
                curGas += gas[curP] - cost[curP];
                if(curGas < 0)
                    break;
            }
            if(curGas >= 0)
                return i;
        }
        
        return -1;
    }
}