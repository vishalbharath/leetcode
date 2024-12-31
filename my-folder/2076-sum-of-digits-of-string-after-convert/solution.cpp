class Solution {
public:
    int getLucky(string s, int k) {
        string num="";
        for(char x : s){
            num += to_string(x-'a' +1);
        }
        while(k>0){
            int tmp=0;
            for(char x : num){
                tmp += x-'0';
            }
            num = to_string(tmp);
            k--;
        }
        return stoi(num);
        
    }
};
