from heapq import heappop, heappush

"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param lists: a list of ListNode
    @return: The head of one sorted list.
    """
    def mergeKLists(self, lists):
        # return self._mergeKListsByHeap(lists)
        # return self._mergeKListsByDevideAndConquer(lists)
        if not lists:
            return None
        return self._recursiveDevideAndConquer(lists, 0, len(lists) - 1)

    def _recursiveDevideAndConquer(self, lists, start, end):
        if start == end:
            return lists[start]
        elif start == end - 1:
            return self._mergeTwoLists(lists[start], lists[end])
        elif start > end:
            return None

        left = self._recursiveDevideAndConquer(lists, start, start + (end - start) / 2)
        right = self._recursiveDevideAndConquer(lists, start + (end - start) / 2 + 1, end)
        return self._mergeTwoLists(left, right)

    def _mergeKListsByHeap(self, lists):
        if not lists:
            return None
        
        head = current = ListNode(0)
        heap = []
        for l in lists:
            if l:
                heappush(heap, (l.val, l))
                
        while heap:
            node = heappop(heap)[1]
            current.next = node
            current = current.next
            if current.next:
                heappush(heap, (current.next.val, current.next))
                                   
        return head.next

    def _mergeKListsByDevideAndConquer(self, lists):
        # write your code here]
        if not lists:
            return None
        total, step = len(lists), 1
        while step < total:
            for i in range(0, total - step, step):
                lists[i] = self._mergeTwoLists(lists[i], lists[i + step])
            step *= 2
        return lists[0]

    def _mergeTwoLists(self, l1, l2):
        # write your code here
        head = current = ListNode(0)
        while l1 and l2:
            if l1.val <= l2.val:
                current.next = ListNode(l1.val)
                l1 = l1.next
            else:
                current.next = ListNode(l2.val)
                l2 = l2.next
            current = current.next
        if l1:
            current.next = l1
        else:
            current.next = l2
        return head.next