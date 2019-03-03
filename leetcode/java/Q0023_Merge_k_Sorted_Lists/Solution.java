package Q0023_Merge_k_Sorted_Lists;

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
    public ListNode mergeKLists(ListNode[] lists) {  
        if (lists == null || lists.length == 0) {
            return null;
        }
        // return mergeKListsByHeap(lists);
        // return mergeKListsByDevideAndConquer(lists);
        return recursiveDevideAndConquer(lists, 0, lists.length - 1);
    }

    private ListNode recursiveDevideAndConquer(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start == end - 1) {
            return mergeTwoLists(lists[start], lists[end]);
        } else if (start > end) {
            return null;
        }

        ListNode left = recursiveDevideAndConquer(lists, start, start + (end - start) / 2);
        ListNode right = recursiveDevideAndConquer(lists, start + (end - start) / 2 + 1, end);
        return mergeTwoLists(left, right);
    }

    /** 
    private ListNode mergeKListsByHeap(ListNode[] lists) {  
        // write your code here       
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
    }

    private ListNode mergeKListsByDevideAndConquer(ListNode[] lists) {  
        int step = 1;
        while (step < lists.length) {
            for (int i = 0; i < lists.length - step; i += step) {
                lists[i] = mergeTwoLists(lists[i], lists[i + step]);
            }
            step *= 2;
        }
        return lists[0];
    }**/

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
