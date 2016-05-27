public class Solution {
    public boolean verifyPreorder(int[] pre) {
        int parent = Integer.MIN_VALUE;
        int parentid = -1;
        for(int i = 0; i < pre.length; i++){
            if(pre[i] < parent)
                return false;
            while(parentid >= 0 && pre[i] > pre[parentid]){
                parentid--;
                parent = pre[parentid];
            }
            pre[++parentid] = pre[i];
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