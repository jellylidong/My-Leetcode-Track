public class Solution {
    public int integerBreak(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        int ans = 1;
        while(n > 4){
            ans *= 3;
            n -= 3;
        }
        ans *= n;
        return ans;
    }
}

/*explain
The key part is that we need to find when to break,
ie when will the break will give us a better product (product > number)
for number 3, the max product is 2, product < number
for number 4, the max product is 2*2 = 4, product == number
for number 5, max product is 3*2=6, product > number
that is to say, when the number is > 4, we should do the break
and the break factor should < 4, otherwise the factor can be break furthermore to get larger product
*/