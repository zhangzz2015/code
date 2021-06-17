class Insert {
public:
	vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> res;
        bool inserted = false;
        for (auto cur : intervals) {
            if (cur[1] < newInterval[0]) {
                res.push_back(cur);
            } else if (cur[0] > newInterval[1]) {
                if (!inserted) {
                    res.push_back(newInterval);
                    inserted = true;
                }
                res.push_back(cur);
            } else {
                newInterval[0] = min(newInterval[0], cur[0]);
                newInterval[1] = max(newInterval[1], cur[1]);
            }
        }
        if (!inserted) {
            res.push_back(newInterval);
        }
        return res;
    }
};
