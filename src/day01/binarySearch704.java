/**
 * @AUTHOR: WEILIANG55
 * @DATE: 2025/5/15 22:27
 * @DESCRIPTION:
 **/
public class binarySearch704 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        int res = search_bi(nums,target);
        System.out.println(res);
    }
    public static int search_1(int[] nums,int target) {
        //左开右开
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
    public static int search_bi(int[] nums,int target) {
        //左闭右闭
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
