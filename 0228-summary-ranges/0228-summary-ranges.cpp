class Solution {
    public:
        vector<string> summaryRanges(vector<int>& nums) {
            int i, j;
            i = j = 0;
            vector<string> v;
            while(i<nums.size()){
                string x;
                j = i + 1;
                while (j < nums.size() && static_cast<long long>(nums.at(j)) - static_cast<long long>(nums.at(j - 1)) == 1){
                    j++;
                }
                if (i+1 != j){
                    x.append(to_string(nums.at(i)));
                    x.append("->");
                    x.append(to_string(nums.at(j-1)));
                } else {
                    x = to_string(nums.at(i));
                }
    
                v.push_back(x);
                i+=(j-i);
            }
            return v;
        }
};