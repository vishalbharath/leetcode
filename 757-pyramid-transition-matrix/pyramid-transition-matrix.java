class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        // memo stores bottoms that cannot lead to a valid pyramid
        Set<String> memo = new HashSet<>();
        return dfs(bottom, map, memo);
    }

    private boolean dfs(String bottom, Map<String, List<Character>> map, Set<String> memo) {
        if (bottom.length() == 1) return true;
        if (memo.contains(bottom)) return false;

        // quick check: every adjacent pair must be in map
        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!map.containsKey(bottom.substring(i, i + 2))) {
                memo.add(bottom);
                return false;
            }
        }

        List<String> nextRows = new ArrayList<>();
        buildNextRows(bottom, 0, new StringBuilder(), map, nextRows);

        for (String next : nextRows) {
            if (dfs(next, map, memo)) return true;
        }
        memo.add(bottom);
        return false;
    }

    private void buildNextRows(String bottom, int idx, StringBuilder sb,
                               Map<String, List<Character>> map, List<String> res) {
        if (idx == bottom.length() - 1) {
            res.add(sb.toString());
            return;
        }
        String key = bottom.substring(idx, idx + 2);
        List<Character> list = map.get(key);
        if (list == null) return;
        for (char c : list) {
            sb.append(c);
            buildNextRows(bottom, idx + 1, sb, map, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
