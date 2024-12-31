class Solution {
public:
    int repeatedStringMatch(string a, string b) {
        if(b=="") return 0;
        string res = a;
        for(int i=1;i<=b.size()/a.size()+2;i++){
            if(res.find(b) != string::npos){
                return i;
            }
            res += a;
        }
        return -1;
        
        
    }
};
