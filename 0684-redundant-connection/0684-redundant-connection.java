class Solution {

    private int findParent(int[] parent, int root) {

        if (root == parent[root]) {
            return root;
        }

        return parent[root] = findParent(parent, parent[root]);
    }

    private boolean join(int[] parent, int u, int v) {

        int parentU = findParent(parent, u);
        int parentV = findParent(parent, v);

        parent[parentU] = parentV;
        return parentU != parentV;
    }

    public int[] findRedundantConnection(int[][] edges) {
        
        int[] parent = new int[edges.length + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (!join(parent, edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[0];
    }
}