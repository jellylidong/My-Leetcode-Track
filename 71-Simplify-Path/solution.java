public class Solution {
    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        // System.out.println("1"+ss[0] + " " + "2"+ss[1]);
        // System.out.println(ss.length);
        Stack<String> stk = new Stack<>();
        for(String s: ss){
            if(s.equals("..")){
                if(!stk.isEmpty())
                    stk.pop();
            }
            else if(s.equals("."))
                continue;
            else if(!s.equals("")) // split will give a "" if there's nothing before delima
                stk.push(s);
                
        }
        
        String ans = "";
        while(!stk.isEmpty()){
            ans = stk.pop() + "/";
        }
        
        return "/" + ans.substring(0, ans.length()-1);
    }
}