import java.util.*;

class Solution {

    class DSU {
        int[] parent;
        int[] size; 

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            
            if (rootI != rootJ) {
                if (size[rootI] < size[rootJ]) {
                    parent[rootI] = rootJ;
                    size[rootJ] += size[rootI];
                } else {
                    parent[rootJ] = rootI;
                    size[rootI] += size[rootJ];
                }
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        
        DSU dsu = new DSU(c + 1);
        
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        boolean[] isOnline = new boolean[c + 1];
        Arrays.fill(isOnline, true); 

        Map<Integer, PriorityQueue<Integer>> onlineStationsInGrid = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            onlineStationsInGrid.computeIfAbsent(root, k -> new PriorityQueue<>()).add(i);
        }

        List<Integer> results = new ArrayList<>();

        for (int[] query : queries) {
            int type = query[0];
            int station = query[1];

            if (type == 1) { 
                if (isOnline[station]) {
                    results.add(station);
                } else {
                    int root = dsu.find(station);
                    PriorityQueue<Integer> pq = onlineStationsInGrid.get(root);

                    while (!pq.isEmpty() && !isOnline[pq.peek()]) {
                        pq.poll(); 
                    }

                    if (pq.isEmpty()) {
                        results.add(-1);
                    } else {
                        results.add(pq.peek());
                    }
                }
            } else if (type == 2) { 
                isOnline[station] = false;
            }
        }

        int[] finalResults = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            finalResults[i] = results.get(i);
        }
        
        return finalResults;
    }
}