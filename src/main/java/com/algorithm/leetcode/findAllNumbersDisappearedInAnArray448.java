package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class findAllNumbersDisappearedInAnArray448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 暴力方法
	 */
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//	       List<Integer> arr =  new ArrayList<Integer>();
//	       for(int i = 1; i <= nums.length; i++){
//	       		arr.add(i);
//		   }
//		   for(Integer i : nums){
//		   		arr.remove(i);
//		   }
//		   return arr;
//	 }
	/**
	 * 桶排序方法
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> arr =  new ArrayList<Integer>(nums.length);
		for ( int i  = 0;i <=  nums.length;++i){
			/**
			 * 交换一直排序
			 */
			while (nums[nums[i] ] != nums[i]){
				nums[nums[i] ]  = nums[nums[i]]  ^ nums[i];
				nums[i] = nums[nums[i]]  ^ nums[i];
				nums[nums[i]]  = nums[nums[i]]  ^ nums[i];
			}
		}
		for(int i = 1;i  <= nums.length ; i++){
			if(nums[i - 1] != i){
				arr.add(i);
			}
		}
		return arr;
	}
}
