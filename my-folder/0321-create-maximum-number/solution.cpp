class Solution {
public:
    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int m = nums1.size();
        int n = nums2.size();
        vector<int> res;

        auto getMaxSubarray = [](const vector<int>& array, int subarrayLength) -> vector<int> {
            vector<int> stack;
            int remaining = array.size() - subarrayLength;
            for (int num : array) {
                while (!stack.empty() && remaining > 0 && stack.back() < num) {
                    stack.pop_back();
                    remaining--;
                }
                stack.push_back(num);
            }
            stack.resize(subarrayLength);
            return stack;
        };

        auto mergeSubarrays = [](const vector<int>& subarray1, const vector<int>& subarray2) -> vector<int> {
            vector<int> result;
            int i = 0, j = 0;
            while (i < subarray1.size() || j < subarray2.size()) {
                if (j == subarray2.size() || (i < subarray1.size() && subarray1[i] > subarray2[j])) {
                    result.push_back(subarray1[i++]);
                } else if (i == subarray1.size() || (j < subarray2.size() && subarray2[j] > subarray1[i])) {
                    result.push_back(subarray2[j++]);
                } else {
                    if (lexicographical_compare(subarray1.begin() + i, subarray1.end(), subarray2.begin() + j, subarray2.end())) {
                        result.push_back(subarray2[j++]);
                    } else {
                        result.push_back(subarray1[i++]);
                    }
                }
            }
            return result;
        };

        for (int i = max(0, k - n); i <= min(k, m); i++) {
            vector<int> maxSubarray1 = getMaxSubarray(nums1, i);
            vector<int> maxSubarray2 = getMaxSubarray(nums2, k - i);
            vector<int> candidate = mergeSubarrays(maxSubarray1, maxSubarray2);
            if (lexicographical_compare(res.begin(), res.end(), candidate.begin(), candidate.end())) {
                res = candidate;
            }
        }

        return res;
    }
};

