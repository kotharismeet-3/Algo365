class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Topological Sort, Khan's Algo

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int topo_sorted = 0;
        while(q.size() > 0) {
            int node = q.remove();
            topo_sorted++;
            for(int nbr: adj.get(node)) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) q.add(nbr);
            }
        }

        return topo_sorted == numCourses;
    }
}