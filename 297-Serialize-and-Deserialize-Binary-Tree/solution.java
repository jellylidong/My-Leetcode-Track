/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "null";
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null)
            sb.append("null" + ",");
        else{
            sb.append(root.val + ",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        List<String> list = Arrays.asList(ss);
        Queue<String> q = new LinkedList<>(list);
        
        return buildTree(q);
    }
    
    public TreeNode buildTree(Queue<String> q){
        String cur = q.poll();
        if(cur.equals("null"))
            return null;
        else{
            TreeNode root = new TreeNode(Integer.parseInt(cur));
            root.left = buildTree(q);
            root.right = buildTree(q);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));