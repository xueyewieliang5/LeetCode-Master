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