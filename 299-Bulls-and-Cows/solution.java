public class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bull = 0;
        int cow = 0;
        for(int i = 0; i < secret.length(); i++){
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            
            if(s == g)
                bull++;
            else{
                if(count[s] < 0) cow++;
                if(count[g] > 0) cow++;
                count[s]++;
                count[g]--;
            }
        }
        
        return bull+"A"+cow+"B";
    }
}

/*explain
if s == g
    bull++
else
for numbers in secret, every time a number s appears, count[s]++;
for numbers in guess, every ime a number g appears, count[g]--;
so when count[s] < 0, it means number s has appeared in guess before, so cow++
when count[g] > 0, it means number g has appeared in secret before, so cow++
*/