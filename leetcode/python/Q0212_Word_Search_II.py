# class Solution(object):
#     def findWords(self, board, words):
#         """
#         :type board: List[List[str]]
#         :type words: List[str]
#         :rtype: List[str]
#         """
#         result = []
#         root = self._buildTrie(words)
#         for i in range(len(board)):
#             for j in range(len(board[0])):
#                 self._dfs(board, i, j, root, result)
#         return result

#     def _dfs(self, board, i, j, parent, result):
#         c = board[i][j]
#         index = ord(c) - ord('a')
#         if c == '#' or not parent.children[index]:
#             return
#         node = parent.children[index]
#         if node.word:
#             result.append(node.word)
#             node.word = None
        
#         board[i][j] = '#'
#         if i > 0:
#             self._dfs(board, i-1, j, node, result)
#         if j > 0:
#             self._dfs(board, i, j-1, node, result)
#         if i < (len(board)-1):
#             self._dfs(board, i+1, j, node, result)
#         if j < (len(board[0])-1):
#             self._dfs(board, i, j+1, node, result)
#         board[i][j] = c

#     def _buildTrie(self, words):
#         root = TrieNode()
#         for word in words:
#             node = root
#             for c in word:
#                 i = ord(c) - ord('a')
#                 if not node.children[i]:
#                     node.children[i] = TrieNode()
#                 node = node.children[i]
#             node.word = word
#         return root

# class TrieNode:

#     def __init__(self):
#         self.children = [None] * 26
#         self.word = None 

class Solution:
    # @param {character[][]} board
    # @param {string[]} words
    # @return {string[]}
    def findWords(self, board, words):
    #make trie
        trie={}
        for w in words:
            t=trie
            for c in w:
                if c not in t:
                    t[c]={}
                t=t[c]
            t['#']='#'
        self.res=set()
        self.used=[[False]*len(board[0]) for _ in range(len(board))]
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.find(board,i,j,trie,'')
        return list(self.res)
    
    def find(self,board,i,j,trie,pre):
        if '#' in trie:
            self.res.add(pre)
        if i<0 or i>=len(board) or j<0 or j>=len(board[0]):
            return
        if not self.used[i][j] and board[i][j] in trie:
            self.used[i][j]=True
            self.find(board,i+1,j,trie[board[i][j]],pre+board[i][j])
            self.find(board,i,j+1,trie[board[i][j]],pre+board[i][j])
            self.find(board,i-1,j,trie[board[i][j]],pre+board[i][j])
            self.find(board,i,j-1,trie[board[i][j]],pre+board[i][j])
            self.used[i][j]=False

board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]
words = ["oath","pea","eat","rain"]
solution = Solution()
print(solution.findWords(board, words))