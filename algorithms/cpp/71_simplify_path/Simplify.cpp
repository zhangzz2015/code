class Simplify {
public:
	string simplifyPath(string path) {
		string res, tmp;
		vector<string> simp_path;
		stringstream ss(path);
		while (getline(ss, tmp, '/') {
			if (tmp == "" || tmp == ".")
				continue;
			if (tmp == ".." && !simp_path.empty())
				simp_path.pop_back();
			else if (tmp != "..")
				simp_path.push_back(tmp);
		}
		for (string str : simp_path)
			res += '/' + str;
		return res.empty() ? "/" : res;
	}
};
