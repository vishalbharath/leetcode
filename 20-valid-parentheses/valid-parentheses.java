class Solution {
    public boolean isValid(String s) {
        int top = -1;
        char arr[] = new char[s.length()];
        for(char ch : s.toCharArray()){
            if(ch == '{' || ch == '(' || ch=='['){
                arr[++top] = ch;

            }
            else{
                if(top==-1){
                    return false;
                }
                char open = arr[top--];
                if( (ch == ')' && open != '(') ||
                    (ch == '}' && open != '{') ||
                    (ch == ']' && open != '[') ){
                    return false;
                }
            }

        }
        if(top==-1)return true;
        else return false;
    }
}