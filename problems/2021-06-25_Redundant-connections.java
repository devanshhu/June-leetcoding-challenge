/*
-----------------------------------------PROBLEM------------------------
In this problem, a tree is an undirected graph that is connected and has no cycles.
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:
    Input: edges = [[1,2],[1,3],[2,3]]
    Output: [2,3]

Example 2:
    Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
    Output: [1,4]

-------------------------------------------------------------------------
------------------------------------------SOLUTION----------------------
The idea is to find a cycle in graph & return the edge where we find it cyclic. 
-------------------------------------------------------------------------



*/



class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // Create a map to keep track of all the connections. Maps every edge -> SET < connected edges >
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = edges.length;
        // Adding all the n nodes to our map.
        for(int i=0;i<=n;i++ )
            map.put(i, new HashSet<>());
    //For every edge check for cyclicity & return the edge if cycle is found         
    for(int[] edge : edges){
        // every edge will have it's own instance of visited.
        if(isCyclic(new HashSet<>(),map, edge[0],edge[1])) return edge;
         // Since this is undirected graph, add both connections : edge[0] -> edge[1] && edge[1] -> edge[0]
         map.get(edge[0]).add(edge[1]);
         map.get(edge[1]).add(edge[0]);
         
    }
        //Could not find cycle hence return 
        return null;
        
    }
    
    private boolean isCyclic(Set<Integer> visited, Map<Integer, Set<Integer>> map, int source, int target){
        // if source node is same as target node then we have found a cycle.
        if(source == target) return true;
        // Add the source node to visited array.
        visited.add(source);
        // for every edge that goes from source node, iterate & if it is visited already do nothing.
        // Else run cyclic algo from that node to the target node. If a cycle will exist, there will be a recursion where source == target.  
        for(int next: map.get(source)){
            if(!visited.contains(next)){
                if(isCyclic(visited, map, next, target)) return true;
            }
        }
        // There are no cycles in the graph
        return false;
    }
    
}