class Solution {
    public:
        string baseNeg2(int n) {
                if (n == 0)
                            return "0";
                                    string out = "";
                                            while (n) {
                                                        out = ((n&1) ? "1" : "0") + out;
                                                                    n = -(n >> 1);
                                                                            }
                                                                                    return out;
                                                                                        }
                                                                                        };

