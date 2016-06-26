/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
            
        if(map.containsKey(node))
            return map.get(node);
        else{
            UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
            map.put(node, cur);
            for(UndirectedGraphNode n: node.neighbors){
                cur.neighbors.add(cloneGraph(n));
            }
            
            return cur;
        }
    }
}