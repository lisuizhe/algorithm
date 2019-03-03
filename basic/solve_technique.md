# Contents

- [General technique](#general-technique)
- [From given conditions](#from-given-conditions)
- [From the problem](#from-the-problem)
- [Not catagorized](#not-catagorized)

# General technique

1. First write an example
2. Brute Force
3. Optimize
  - BUD (Bottlenecks/Unnecessary works/Duplicated works)
  - DIY
  - Simplify and Generalize
  - Base Case and Build
  - Data Structure Brainstorm
    - Hash Table first
    - LinkedList
    - Array(List)
    - Stack/Queue
    - Heap
    - (Binary(Search) / AVL / Red-Black)Tree
    - Trie
    - Graph
    - String
    - Bitmap
4. BCR
  - how best we can
  - from current runtime to BCR -> hint use some data structures/algorithms

# From given conditions

## Array

1. Two sorted arrays -> two pointers to each element of each array
  - merge two sorted arrays / find common element in two sorted arrays

## LinkedList

1. Runner or Second Pointer
  - find medium of linked list
  - find whether linked list is cyclic

2. Recursive

## Stack

1. Search and Backtrack
2. Interatively implement recursive algorithm
  - DFS

## Queue

1. BFS
2. Cache
  - LRU cache
  - LFU cache

## Deque

1. Slicing Window

# From the problem

## Hash Table

1. Find unique/permutation of characters

## Heap

1. Find maximum/minimum/medium element continously -> use 1(or 2 or more) heap to keep tracking max/min/mid 
  - find medium as stream from a stream of input integer

## Tree

1. Graph as Tree will only have (number_of_nodes - 1) edges

## Graph

1. Visit every node -> DFS(simpler to write)
2. Find (shortest) path between two node -> BFS
3. Find shortest path between two node fatest than BFS -> Bidirectional Search
4. **TODO:** Topological sort
5. **TODO:** Dijkstra's algorithm

## Recursion

1. bottom-up: f(n) from f(n-1)(and f(n-2), f(n-3)...)
2. up-bottom
3. solve first/second half of dataset and merge result

## DP

## Backtract

1. store state and backtract
  - eight queen(queen[] = [-1 for i in range(8)] -> if found queen[i]=0~7 -> if not found queen[i] = -1)

# Not catagorized

## Think from the end/bottom instead of the start/up