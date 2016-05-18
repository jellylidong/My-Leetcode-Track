public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
            
        int[] x = {A,C,E,G};
        int[] y = {B,D,F,H};
        
        Arrays.sort(x);
        Arrays.sort(y);
        // for(int i: x){
        //     System.out.print(i+" ");
        // }
        int dup = area(x[1], y[1], x[2], y[2]);
        if((A <= E && C <= E) || (A >= G && C >= G) || (B <= F && D <= F) || (D >= H && B >= H))
            dup = 0;
        
        return area(A,B,C,D) + area(E,F,G,H)-dup;
    }
    
    public int area(int A, int B, int C, int D){
        int l1 = Math.abs(A-C);
        int l2 = Math.abs(B-D);
        // System.out.println(l1*l2);
        return l1*l2;
    }
}