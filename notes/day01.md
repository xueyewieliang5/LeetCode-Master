# 第一章 数组

今天任务：数组基础理论，704.二分查找，27移动元素，977有序数组的平方

附加：

## 数组基础理论

**存放在连续内存空间上的相同类型数据的集合** 

* 数组下标从0开始

* 数组内存空间连续

优点：查找时间复杂度是O(1);

缺点：删除或者添加元素的时候，要移动元素故是O(n)时间复杂度；

## 704.[二分查找](https://leetcode.cn/problems/binary-search/description/)

给定一个 `n` 个元素有序的（升序）整型数组 `nums` 和一个目标值 `target` ，写一个函数搜索 `nums` 中的 `target`，如果目标值存在返回下标，否则返回 `-1`。


**示例 1:**

```
输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
```

**示例 2:**

```
输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
```





**提示：**

1. 你可以假设 `nums` 中的所有元素是不重复的。
2. `n` 将在 `[1, 10000]`之间。
3. `nums` 的每个元素都将在 `[-9999, 9999]`之间。

### 二分法使用前提

首先是数组为**有序** ，其次是数组中**无重复元素** ，因为有重复元素可能会导致二分查找法返回的不是唯一下标。

### 代码

```java
public class binarySearch704 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        int res = search_1(nums,target);
        System.out.println(res);
    }
    //左开右开
    public static int search_1(int[] nums,int target) {
        int left = -1;
        int right = nums.length;
        while(left + 1 < right){
            int mid = (left + right) >> 1;
            //防止溢出int mid = left + (right - left)/2;
            if(nums[mid] > target){
                //在左半边
                right = mid;//因为是开区间，所以mid不计入
            } else if(nums[mid] < target) {
                left = mid;
            } else{
                return mid;
            }
        }
        return -1;
    }
    //左闭右闭
    public static int search_bi(int[] nums,int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left  <= right){
            int mid = (left + right) >> 1;
            //防止溢出int mid = left + (right - left)/2;
            if(nums[mid] > target){
                //在左半边
                right = mid - 1;//因为是开区间，所以mid不计入
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
}
```

## 27.移除元素

给你一个数组 `nums` 和一个值 `val`，你需要 **[原地](https://baike.baidu.com/item/原地算法)** 移除所有数值等于 `val` 的元素。元素的顺序可能发生改变。然后返回 `nums` 中与 `val` 不同的元素的数量。

假设 `nums` 中不等于 `val` 的元素数量为 `k`，要通过此题，您需要执行以下操作：

- 更改 `nums` 数组，使 `nums` 的前 `k` 个元素包含不等于 `val` 的元素。`nums` 的其余元素和 `nums` 的大小并不重要。
- 返回 `k`。

**用户评测：**

评测机将使用以下代码测试您的解决方案：

```
int[] nums = [...]; // 输入数组
int val = ...; // 要移除的值
int[] expectedNums = [...]; // 长度正确的预期答案。
                            // 它以不等于 val 的值排序。

int k = removeElement(nums, val); // 调用你的实现

assert k == expectedNums.length;
sort(nums, 0, k); // 排序 nums 的前 k 个元素
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
```

如果所有的断言都通过，你的解决方案将会 **通过**。

 

**示例 1：**

```
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2,_,_]
解释：你的函数函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
```

**示例 2：**

```
输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3,_,_,_]
解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
注意这五个元素可以任意顺序返回。
你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
```

### 代码

思路：双指针，右指针不为目标值，则交换到左指针，最后的目标可能为任意值。

```java
public class remove27 {
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,2,3};
		int val = 3;
		int res = removeElement(nums,val);
		System.out.println(res);
	}
	//使用双指针法解决
	public static int removeElement(int[] nums,int val){
		int n = nums.length;
		int left = 0;
		for(int right = 0; right < n; right++){
			if(nums[right] != val) {
				//若右指针不等于目标值，则移动到先前
				nums[left] = nums[right];
				left++;
			}
		}
		return left;
	}
}
```

## [977. 有序数组的平方](https://leetcode.cn/problems/squares-of-a-sorted-array/)

