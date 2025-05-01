class Solution {
public:
    bool isSubsequence(string s, string t) {
        if(s.size() == 0){
            return true;
        }
        int i,j;
        i = j = 0;
        while (j < t.size()) {
            if(s.at(i) == t.at(j)) {
                i++;
            }
            j++;
            if (i == s.size()){
                return true;
            }
        }
        
        return false;
    }
};