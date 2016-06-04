/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    /*
    {0,0,0}
    {0,1,5#1,2,5#2,3#3,4,4#4,5,5#5}
    */
    
    // HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    // HashSet<UndirectedGraphNode> visited = new HashSet<>();
    // public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    //     if(node == null)
    //         return null;
    //     UndirectedGraphNode cur;
    //     if(!map.containsKey(node)){
    //          cur = new UndirectedGraphNode(node.label);
    //          map.put(node, cur);
    //     }
    //     else
    //         cur = map.get(node);
            
    //     visited.add(node);
    //     for(UndirectedGraphNode n: node.neighbors){
            
    //             if(map.containsKey(n))
    //                 cur.neighbors.add(map.get(n));
    //             else{
    //                 UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
    //                 map.put(n, newNode);
    //                 cur.neighbors.add(newNode);
    //             }
    //             if(!visited.contains(n))
    //                 cloneGraph(n);
            
    //     }
        
    //     return cur;
    // }
    
    //above code works well, just another more method with similar thought but more concise code
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
            
        UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
        for(UndirectedGraphNode n: node.neighbors){
            cur.neighbors.add(cloneGraph(n));
        }
        
        return cur;
    }
}