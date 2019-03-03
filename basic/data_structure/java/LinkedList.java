class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode(T val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    public static <T> void connect(ListNode<T> prev, ListNode<T> next) {
        prev.next = next;
    }

    public static <T> ListNode<T> reverse(ListNode<T> head) {
        ListNode<T> prev = null;
        ListNode<T> current = head;
        while (current != null) {
            ListNode<T> tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev;
    }

    public static <T> boolean isCircle(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == slow) {
                break;
            }
        }

        if (fast != null && slow != null && (fast == slow)) {
            return false;
        } else {
            return true;
        }
    }

    public static <T> T findMedian(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        if (slow == null) {
            return null;
        } else {
            return slow.val;
        }
    }
}

class DListNode<T> {
    public T val;
    public DListNode<T> prev, next;

    public DListNode(T val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DLinkedList {
    public static <T> void connect(DListNode<T> prev, DListNode<T> next) {
        prev.next = next;
        next.prev = prev;
    }

    public static <T> DListNode<T> reverse(DListNode<T> head) {
        DListNode<T> tmp = null; 
        DListNode<T> current = head;
        while (current != null) {
            tmp = current;
            current = tmp.next;
            tmp.next = tmp.prev;
            tmp.prev = current;
        }
        return tmp;
    }
}

