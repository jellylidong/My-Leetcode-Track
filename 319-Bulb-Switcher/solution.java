public class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}

/*explain
bulb i can be switched on round r only when r devides i, ie i%d == 0
bulb i ends up on only when it's switched odd times
bulb i has odd number of divisors only when it's a square number
for example, 12 is not a square number, 
it has divisor pair 12 = 1*12, 3*4, 4*3, 12*1, 
ie bulb 12 will be switched in round 1,3,4,12;
bulb 16 is a squre number, it has divisor pari 16 = 1*16 = 2*8 = 4*4 = 8*2 = 16*1
so bulb 16 will be switched in round 1,2,4,8,16, odd times, so it's finally on

so only bulbs in squre position (start with 1) will end up on
then the problem becomes find all the square number of [1...n]
obviously it's sqrt(n)

*/