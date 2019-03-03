from heapq import heappop, heappush

class Solution(object):
    def medianSlidingWindow(self, nums, k):
        lh,rh,rv = [],[],[]
        # create the initial left and right heap
        for i,n in enumerate(nums[:k]): heappush(lh, (-n,i))
        for i in range(k-k/2):
            heappush(rh, (-lh[0][0], lh[0][1]))
            heappop(lh)
        for i,n in enumerate(nums[k:]):
            rv.append(rh[0][0]/1. if k%2 else (rh[0][0] - lh[0][0])/2.)
            if n >= rh[0][0]:
                heappush(rh,(n,i+k))        # rh +1
                if nums[i] <= rh[0][0]:     # lh-1, unbalanced
                    heappush(lh, (-rh[0][0], rh[0][1]))
                    heappop(rh)
                # else: pass                # rh-1, balanced
            else:
                heappush(lh,(-n,i+k))        # rh +1
                if nums[i] >= rh[0][0]:     # rh-1, unbalanced
                    heappush(rh, (-lh[0][0], lh[0][1]))
                    heappop(lh)
                # else: pass                # lh-1, balanced
            while(lh and lh[0][1] <= i): heappop(lh)  # lazy-deletion
            while(rh and rh[0][1] <= i): heappop(rh)  # lazy-deletion
        rv.append(rh[0][0]/1. if k%2 else (rh[0][0] - lh[0][0])/2.)
        return rv

    def _medianSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[float]
        """
        if not nums or k <= 0 or k > len(nums):
            return []
        if k == 1:
            return nums
        
        large = []
        small = []
        for i in range(k):
            if not large:
                large.append(nums[i])
            elif not small:
                if large[0] < nums[i]:
                    small.append(-heappop(large))
                    large.append(nums[i])
                else:
                    small.append(-nums[i])
            else:
                if len(large) == len(small):
                    heappush(large, nums[i])
                else:
                    heappush(small, -nums[i])
                if large[0] < -small[0]:
                    tmp = heappop(large)
                    heappush(large, -heappop(small))
                    heappush(small, -tmp)
        medians = []
        if len(large) == len(small):
            medians.append((large[0] - small[0]) / 2)
        else:
            medians.append(large[0])
        for i in range(1, len(nums)-k+1):
            if nums[i-1] >= large[0]:
                large.remove(nums[i-1])
                heappush(large, nums[i+k-1])
            else:
                small.remove(-nums[i-1])
                heappush(small, -nums[i+k-1])
            if large[0] < -small[0]:
                tmp = heappop(large)
                heappush(large, -heappop(small))
                heappush(small, -tmp)
            if len(large) == len(small):
                medians.append((large[0] - small[0]) / 2)
            else:
                medians.append(large[0])
        return medians

s = Solution()
nums = [1,3,-1,-3,5,3,6,7]
k = 3
print(s.medianSlidingWindow(nums, 3))