package com.tulane.mine;//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

import java.util.*;

/**
 * 第一种, 暴力法, 循环
 * 第二种, 类似两数之和, 将a+b的值存入hash表
 * 第三种 双指针+排序
 */
public class ThreeSum {

    /**
     * 第二种 双指针+排序 确定target坐标k, 再从target开始向右边确定i,j, 范围一开始最大, 依次收缩
     * 当nums[i] + nums[j] + nums[k] == 0, 记录3数
     * 循环target <- target向右依次移动
     * 注意点:
     * 1.收缩时, 遇相同值则跳过, 比如nums[i] == nums[i++]
     * 2.target移动时, 若nums[k] == nums[k--], 直接跳过
     * 3.当nums[k] > 0时, 结束循环, 因为排序后, i与j的值皆大于k
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        //遍历target
        for(int k = 0; k < nums.length - 2 ; k++){

            int kvalue = nums[k];
            //注意点第三点
            if(kvalue > 0){
                break;
            }

            //注意点第二点
            if(k > 0 && nums[k] == nums[k-1]){
                continue;
            }

            //确定i,j指针
            int i = k + 1;
            int j = nums.length - 1;

            for (;;) {

                if(i >= j){
                    break;
                }

                int ivalue = nums[i];
                int jvalue = nums[j];

                //判断数和
                int sum = kvalue + ivalue + jvalue;
                if (sum < 0) {
                    //i右移动, 和增大
                    i = imove(nums, ivalue, i, j);
                }else if(sum > 0){
                    //j左移动, 和减小
                    j = jmove(nums, jvalue, i, j);
                }else{
                    //符合三数要求, 记录
                    List<Integer> listTmp = Arrays.asList(kvalue, ivalue, jvalue);
                    list.add(listTmp);
                    i = imove(nums, ivalue, i, j);
                    j = jmove(nums, jvalue, i, j);
                }
            }
        }
        return list;
    }

    private int imove(int[] nums, int ivalue, int i, int j){
        for(;;){
            i++;
            if(i > j || ivalue != nums[i]){
                return i;
            }
        }
    }

    private int jmove(int[] nums, int jvalue, int i, int j){
        for(;;){
            j--;
            if(i > j || jvalue != nums[j]){
                return j;
            }
        }
    }

    /**
     * 第二种 两次循环存入hash
     * a + b + c= 0
     * 0 - c = a + b
     * TODO 如何解决自己重复用自己的问题?
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {

        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        Set<List<Integer>> list = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int ivalue = nums[i];
                int jvalue = nums[j];
                if (map.containsKey(-jvalue)) {
                    Set<List<Integer>> setTmp = map.get(-jvalue);
                    for (List<Integer> listTmp : setTmp) {
                        List<Integer> listNew = pushThreeByAsec(listTmp.get(0), listTmp.get(1), jvalue);
                        list.add(listNew);
                    }
                }

                //存入hash
                List<Integer> listTmp = pushTwoByAsec(ivalue, jvalue);

                if(map.containsKey(ivalue + jvalue)){
                    Set<List<Integer>> setTmp = map.get(ivalue + jvalue);
                    setTmp.add(listTmp);
                }else{
                    Set<List<Integer>> setTmp = new HashSet<>();
                    setTmp.add(listTmp);
                    map.put(ivalue + jvalue, setTmp);
                }
            }
        }
        return new ArrayList<>(list);
    }

    /**
     * 第一种 循环 O(n^3)
     * 需要在最后结果时, 去重
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> listTmp = pushThreeByAsec(nums[i], nums[j], nums[k]);
                        list.add(listTmp);
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }

    private List<Integer> pushTwoByAsec(int ivalue, int jvalue) {
        List<Integer> listTmp = new ArrayList<>();
        if(ivalue < jvalue){
            listTmp.add(ivalue);
            listTmp.add(jvalue);
        }else{
            listTmp.add(jvalue);
            listTmp.add(ivalue);
        }
        return listTmp;
    }

    private List<Integer> pushThreeByAsec(int ivalue, int jvalue, int kvalue) {
        List<Integer> listTmp = new ArrayList<>();
        if (ivalue < jvalue) {
            if (ivalue < kvalue) {
                listTmp.add(ivalue);
                if (kvalue < jvalue) {
                    listTmp.add(kvalue);
                    listTmp.add(jvalue);
                } else {
                    listTmp.add(jvalue);
                    listTmp.add(kvalue);
                }
            } else {
                listTmp.add(kvalue);
                listTmp.add(ivalue);
                listTmp.add(jvalue);
            }
        } else {
            if (jvalue < kvalue) {
                listTmp.add(jvalue);
                if (kvalue < ivalue) {
                    listTmp.add(kvalue);
                    listTmp.add(ivalue);
                } else {
                    listTmp.add(ivalue);
                    listTmp.add(kvalue);
                }
            } else {
                listTmp.add(kvalue);
                listTmp.add(jvalue);
                listTmp.add(ivalue);
            }
        }
        return listTmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
