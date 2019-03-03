class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left, right = 0, len(height) - 1
        leftMax, rightMax = 0, 0
        result = 0

        while left < right:
            if height[left] < height[right]:
                if height[left] >= leftMax:
                    leftMax = height[left]
                else:
                    result += (leftMax - height[left])
                left += 1
            else:
                if height[right] >= rightMax:
                    rightMax = height[right]
                else:
                    result += (rightMax - height[right])
                right -= 1

        return result