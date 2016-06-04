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
    HashSet<UndirectedGraphNode> visited = new HashSet<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode cur;
        if(!map.containsKey(node)){
             cur = new UndirectedGraphNode(node.label);
             map.put(node, cur);
        }
        else
            cur = map.get(node);
        for(UndirectedGraphNode n: node.neighbors){
            if(!visited.contains(n)){
                if(map.containsKey(n))
                    cur.neighbors.add(map.get(n));
                else{
                    UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                    map.put(n, newNode);
                    cur.neighbors.add(newNode);
                }
                cloneGraph(n);
            }
        }
        visited.add(cur);
        return cur;
    }
}