class Solution {
    public int countPoints(String rings) {
        int count = 0;
        char[] arr = rings.toCharArray();
        int[] rods = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] == 'R') {
                rods[arr[i + 1] - '0'] *= 2;
            } else if (arr[i] == 'G') {
                rods[arr[i + 1] - '0'] *= 3;
            } else {
                rods[arr[i + 1] - '0'] *= 5;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (rods[i] % 2 == 0 && rods[i] % 3 == 0 && rods[i] % 5 == 0) {
                count++;
            }
        }

        return count;

    }
}

