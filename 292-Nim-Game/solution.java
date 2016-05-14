public class Solution {
    public boolean canWinNim(int n) {
        
        return n%4 != 0;
    }
}

/*my explain
1,2,3,4,5,6,7,8
w,w,w,l,w,w,w,l

how to analyze?
assum we can take the last stone (let n = 5), 
so there will be three possible ways we take the final stone
take 1, take 2, take 3
so we need to see if we win when the number of stone is 4,3,2 (call it previous step)
since the previous step is done by the opponent
so the game result would be = !4 || !3 || !2

after doing above for several times, we find it's a period of 4
so if n%4 == 0, we lose, otherwise we win
*/