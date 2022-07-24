class Graph{
    public:
    int v;
    Graph(int v)
    { this->v = v; }
    unordered_map<string, unordered_set<string>> adj;
    void addEdge(string a,string b)
    {
        adj[a].insert(b);
        adj[b].insert(a);
    }
};
class Solution {
public:
    int BFS(Graph &g, string beginWord, string endWord)
    {
        unordered_map<string, int> dist;
        for(auto str: g.adj)
            dist[str.first] = 0;
        
        queue<string> q;
        q.push(beginWord);
        dist[beginWord] = 1;
        
        while(!q.empty())
        {
            string curr = q.front();
            q.pop();
            for(auto nbr: g.adj[curr])
            {
                if(dist[nbr] == 0)
                {
                    q.push(nbr);
                    dist[nbr] = dist[curr] + 1;
                    if(nbr == endWord) return dist[nbr];
                }
            }
        }
        return dist[endWord];
    }
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        if(beginWord.size() != endWord.size() || beginWord.size() != wordList[0].size())
            return 0;
        Graph g(wordList.size());
        unordered_set<string> check;
        for(auto str: wordList) 
            check.insert(str);
        if(check.find(endWord) == check.end())
            return 0;
        if(check.find(beginWord) == check.end())
        {
            check.insert(beginWord);
            wordList.push_back(beginWord);
        }
        for(auto str: wordList)
        {
            for(int i=0;i<str.size();i++)
            {
                string temp = str;
                for(int j=0;j<26;j++)
                {
                    temp[i] = char(j+97);
                    if(temp[i] == str[i])
                        continue;
                    if(check.find(temp) != check.end())
                        g.addEdge(temp, str);
                }
            }
        }
        wordList.pop_back();
        return BFS(g, beginWord, endWord);
    }
};