package com.example.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举a
        for (int first = 0; first < n; ++first) {
            // 如果第一个数大于零，则后续不可能找出两个数使得a+b+c=0
            if (nums[first] > 0) {
                break;
            }
            // 需要和上一次枚举的数不同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c对应的指针初始化指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证b的指针在c的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着b后续的增加，就不会有满足a+b+c=0且b<c的c了，可以退出循环
                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
