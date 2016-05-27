public class Solution {
    // public boolean verifyPreorder(int[] pre) {
    //     int parent = Integer.MIN_VALUE;
    //     int parentid = -1;
    //     for(int i = 0; i < pre.length; i++){
    //         if(pre[i] < parent)
    //             return false;
    //         while(parentid >= 0 && pre[i] > pre[parentid]){
    //             // parentid--;
    //             parent = pre[parentid];
    //             parentid--;
    //         }
    //         parentid++;
    //         pre[parentid] = pre[i];
            
    //     }
        
    //     return true;
    // }
    
    public boolean verifyPreorder(int[] pre) {
        int parent = Integer.MIN_VALUE;
        //the parent value is the value of node p that closes to current node n, 
        //where p is the parent node of n and n is in p's left subtree
        
        
        Stack<Integer> stk = new Stack<>();
        
        for(int n: pre){
            if(n < parent)
                return false;
            
            while(!stk.isEmpty() && n > stk.peek())
                parent = stk.pop();
            stk.push(n);
        }
        
        return true;
    }
}

/*explain
for a preorder-tree array,
it's composed of three part, root, left, right from 0 to len
the root and left part is in desending order, so if we come to a number that is > previous one
it means now we are in the right part

*/