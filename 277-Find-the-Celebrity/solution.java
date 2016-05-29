/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    // public int findCelebrity(int n) {
    //     int count = 0;
    //     int ans = -1;
    //     for(int a = 0; a < n; a++){
    //         for(int b = 0; b < n; b++){
    //             if(a != b){
    //                  if(knows(b, a)){
    //                     if(!knows(a, b)){
    //                         count++;
    //                         if(count == n-1){
    //                             return a;
    //                         }
    //                     }
    //                     else{
    //                         count = 0;
    //                         break;
    //                     }
    //                 }
    //                 else{
    //                     count = 0;
    //                     break;
    //                 }
    //             }
               
    //         }
    //     }
    //     return ans;
    // }
    
    //remember the O(n) method
    /*explain
    assume k is the candidate, 
    number 0 to k-1 can not be the candidate, because they know on of 0 to k-1;
    for number k+1 to n-1, they can't be a candidate because k doesn't know them
    
    so k is the only possible candidate
    */
    public int findCelebrity(int n) {
        int ans = -1;
        if(n <= 0)
            return ans;
        ans = 0;    
        for(int i = 1; i <= n-1; i++){
            if(knows(ans, i))
                ans = i;
        }
        
        //check if ans is a real celebrity
        for(int i = 0; i < n; i++){
            if(i != ans){
                //if candidate knows sb or sb don't know candidate, then it's note a real candidate
                if(knows(ans, i) || !knows(i, ans))
                    return -1;
            }
        }
        
        return ans;
    }
}