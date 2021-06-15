class Merge {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        auto cmp = [](auto element1, auto element2) {
            return element1[0] < element2[0];
        };
        sort(intervals.begin(), intervals.end(), cmp);
        vector<vector<int>> res;
        for (auto interval : intervals) {
            if (res.empty() || res.back()[1] < interval[0]) {
                res.push_back(interval);
            } else {
                res.back()[1] = max(res.back()[1], interval[1]);
            }
        }
        return res; 
    }
};
