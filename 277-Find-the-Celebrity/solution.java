/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int count = 0;
        int ans = -1;
        for(int a = 0; a < n; a++){
            for(int b = 0; b < n; b++){
                if(a != b){
                     if(knows(b, a)){
                        if(!knows(a, b)){
                            count++;
                            if(count == n-1){
                                return a;
                            }
                        }
                        else{
                            count = 0;
                            break;
                        }
                    }
                    else{
                        count = 0;
                        break;
                    }
                }
               
            }
        }
        return ans;
    }
}