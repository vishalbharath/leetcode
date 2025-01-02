class Solution {
public:
    int maxScore(string s) {
    int res = INT_MIN;
    int tot1 = 0;
    for (auto x : s)
        tot1 += (x == '1');
    int zero = 0;
    for (int i = 0; i < s.size() - 1; i++) { 
        zero += (s[i] == '0');
        tot1 -= (s[i] == '1');
        res = max(res, zero + tot1);
    }
    return res;
}
};
