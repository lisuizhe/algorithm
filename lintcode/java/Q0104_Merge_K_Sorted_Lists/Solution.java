package Q0104_Merge_K_Sorted_Lists;

// import java.util.Comparator;
import java.util.List;
// import java.util.PriorityQueue;

// Definition for ListNode.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // return mergeKListsByHeap(lists);
        // return mergeKListsByDevideAndConquer(lists);
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return recursiveDevideAndConquer(lists, 0, lists.size() - 1);
    }

    private ListNode recursiveDevideAndConquer(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        } else if (start == end - 1) {
            return mergeTwoLists(lists.get(start), lists.get(end));
        } else if (start > end) {
            return null;
        }

        ListNode left = recursiveDevideAndConquer(lists, start, start + (end - start) / 2);
        ListNode right = recursiveDevideAndConquer(lists, start + (end - start) / 2 + 1, end);
        return mergeTwoLists(left, right);
    }

    /* private ListNode mergeKListsByHeap(List<ListNode> lists) {  
        // write your code here       
        if (lists == null || lists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        });

        for (ListNode l : lists) {
            if (l != null) {
                heap.offer(l);
            }
        }

        ListNode head= new ListNode(0);
        ListNode current = head;
        while(!heap.isEmpty()) {
            current.next = heap.poll();
            current = current.next;
            if (current.next != null) {
                heap.offer(current.next);
            }
        }
        return head.next;
    }*/

    /*private ListNode mergeKListsByDevideAndConquer(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int step = 1;
        while (step < lists.size()) {
            for (int i = 0; i < lists.size() - step; i += step) {
                lists.set(i, mergeTwoLists(lists.get(i), lists.get(i + step)));
            }
            step *= 2;
        }
        return lists.get(0);
    }*/

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode head, current;
        head = current = new ListNode(0);
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        return head.next;
    }
}
