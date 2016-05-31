



//!!!!!!!!!!!!!!!!11

//this is a really corner-case problems
//"#,7,6,9,#,#,#"
//"7,2,#,2,#,#,#,6,#"
public class Solution {
    // public boolean isValidSerialization(String preorder) {
        
    //     String[] ss = preorder.split(",");
        
    //     if(ss[0].equals("#") && ss.length > 1)
    //         return false;
        
    //     int out = 0;
    //     int in = 0;
        
    //     //must hadle the first node, if first node is #
    //     //case 1, if there's no other nodes, return true
    //     //case 2, if there are other nodes, return false
    //     if(!ss[0].equals("#"))
    //         out = 2;
        
        
    //     for(int i = 1; i < ss.length; i++){
    //         if(ss[i].equals("#"))
    //             in++;
    //         else{
    //             in++;
    //             out += 2;
    //         }
            
    //         // System.out.println(ss[i] + " " + in + " " + out);
    //         if(out < in)
    //             return false;
    //     }
        
    //     return out == in;
    // }
    
    
    //!!!!!!!!!!!!!!!!!!!
    //the above code can not handle some cases with 3#, ie ...###...
    // public boolean isValidSerialization(String preorder) {
    //     String[] ss = preorder.split(",");
        
    //     //we keep track of the diff of out and in degrees
    //     //for every new node, diff-- because each node must have an in degree
    //     //after diff--, if diff < 0, then return false because out should always >= in
    //     //then if this node is not #, out += 2
        
    //     //another trick is initialize diff = 1 so that it can also handle the case for root node(root node has 0 in degree)
    //     //finally, diff should be 0 for a correct inorder travesal
        
    //     int diff = 1;
    //     for(String s: ss){
    //         diff--;
    //         if(diff < 0)
    //             return false;
    //         if(!s.equals("#"))
    //             diff += 2;
    //     }
        
    //     return diff == 0;
    // }
    
    
    //another method, stack
     public boolean isValidSerialization(String preorder) {
        Stack<String> stk = new Stack<>();
        String[] ss = preorder.split(",");
        
        for(int i = 0; i < ss.length; i++){
            if(ss[i].equals("#")){
                while(!stk.isEmpty() && stk.peek().equals("#")){
                    stk.pop();
                    if(stk.isEmpty())
                        return false;
                    stk.pop();
                }
                stk.push("#");
            }
            else
                stk.push(ss[i]);
        }
        
        return stk.size() == 1 && stk.peek().equals("#");
     }
    
}