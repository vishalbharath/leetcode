class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int freq = map.get(s.charAt(i));
                map.put(s.charAt(i), freq + 1);
            }
        }

        int freq = 0;
        int c = 0;

        for (Map.Entry<Character, Integer> me : map.entrySet()) {
            if (freq != me.getValue()) {
                freq = me.getValue();
                c++;
            }
        }

        if (c == 1) {
            return true;
        }
        return false;
    }

}
