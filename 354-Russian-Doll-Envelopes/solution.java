public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //longest increasing sequence
        
        if(envelopes.length == 0)
            return 0;
        int len = 0;
        Comparator myComparator = new envComparator();
        Arrays.sort(envelopes, myComparator);
        
        int[] dp = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            int id = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
            if(id < 0)
                id = -(id+1);
            dp[id] = envelopes[i][1];
            if(id == len)
                len++;
        }
        
        return len;
    }
    
    public class envComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] env1, int[] env2){
            // return (env1[0]-env2[0])*(env1[1]-env2[1]);
            if(env1[0] != env2[0])
                return env1[0]-env2[0];
            else return -env1[1]+env2[1];
        }
    }
}