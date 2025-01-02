class Solution {
public:
static bool myComparator(int a , int b){
    string s1=to_string(a) , s2=to_string(b);
    return s1+s2> s2+s1;
}
    string largestNumber(vector<int>& nums) {
        string s="" , ns="";
        sort(nums.begin(),nums.end(),myComparator);
        for(int i:nums){
            s+=to_string(i);
        }
        if(s[0]=='0'){
            return "0";
        }
        return s;
        
    }
};
