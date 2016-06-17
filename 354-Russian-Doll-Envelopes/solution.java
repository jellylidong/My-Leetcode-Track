public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //similar to longest increasing sequence
        
        //we need to sort envelopes with ascending w, 
        //when w equasl, we sort with descending l
        //thus we can go through all envelopes and find longest increasing l sequence
        
        //why do so?
        //because w are already increasing, 
        //so we only need increading l,
        //then we can make sure the next evelope can contains the previous one
        
        //why do we use descending l?
        //eg 
        //if we use ascending l, the sorted array is [[3,3], [3,4]]
        //then at the beginning [3,3] is inserted, then we come to [3,4], its inserted after [3,3]
        //then it becomes [3,3], [3,4], that is to say the length of longest increasing sequence is 2
        //but actually [3,4] is not able to contains[3,3], so it's wrong
        //so we use descending l, the sorted array is [3,4], [3,3]
        //at the beginning [3,4] is inserted, then we come to [3,3], 
        //it will not be put a positon before (or at) [3,4], the length won't change, it's still 1
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