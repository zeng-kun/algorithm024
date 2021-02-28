//在这道题中我想到了什么？
//1 数组：排序、2指针、3指针;
//2 搜索+时间复杂度O(logN) ：二分查找
// 作者：reedfan
public int search(int[] nums, int target) {
    //考虑边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;

        //当两边界未重合之前，执行循环
        while (start <= end) {
            //这样做的好处：防止越界       
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序
            if (nums[start] <= nums[mid]) {
                //前半部分找
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //后半部分有序
                if (target <= nums[end] && target > nums[mid]) {
                    //后半部分找
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;

    }