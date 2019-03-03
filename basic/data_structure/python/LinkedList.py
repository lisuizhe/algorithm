class List(object):
    def __init__(self, val):
        self.val = val
        self.next = None

    def reverse(self, head):
        prev = None
        current = head
        while current:
            tmp = current.next
            current.next = prev
            prev = current
            current = tmp

        return prev

    def isCircle(self, head):
        slow, fast = head, head
        while slow and fast:
            slow = slow.next
            fast = fast.next
            if fast:
                fast = fast.next
            if fast == slow:
                break;
        if slow and fast and (slow == fast):
            return True
        else:
            return False

    def findMedian(self, head):
        slow, fast = head, head
        while fast:
            slow = slow.next
            fast = fast.next
            if fast:
                fast = fast.next
        if slow:
            return slow.val
        else:
            return None

class DListNode(object):
    def __init__(self, val):
        self.val = val
        self.prev = self.next = None

    def reverse(self, head):
        tmp = None
        current = head
        while current:
            tmp = current
            current = tmp.next
            tmp.next = tmp.prev
            tmp.prev = current
        return tmp