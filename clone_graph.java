class Solution {

    private Node dfs(Node node, HashMap<Node, Node> hash_map) {
        if(hash_map.containsKey(node)) return hash_map.get(node);
        Node newNode = new Node(node.val, new ArrayList<>());
        hash_map.put(node, newNode);
        for(Node nbr: node.neighbors) {
            if(!hash_map.containsKey(nbr)) {
                newNode.neighbors.add(dfs(nbr, hash_map));
            } else
                newNode.neighbors.add(hash_map.get(nbr));
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> hash_map = new HashMap<>();
        // using DFS
        return dfs(node, hash_map);
        // using BFS
        // Queue<Node> queue = new LinkedList<>();

        // Node newNode = new Node(node.val, new ArrayList<>());
        // queue.add(node);
        // hash_map.put(node, newNode);

        // while(queue.size() > 0) {
        //     Node rem = queue.remove();
        //     for(Node nbr: rem.neighbors) {
        //         if(hash_map.containsKey(nbr) == false) {
        //             Node temp = new Node(nbr.val, new ArrayList<>());
        //             queue.add(nbr);
        //             hash_map.put(nbr, temp);
        //         }
        //         hash_map.get(rem).neighbors.add(
        //             hash_map.get(nbr)
        //         );
        //     }
        // }
        // return newNode;
    }
}