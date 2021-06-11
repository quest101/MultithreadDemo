package com.ken.algorithm;

public class BinaryChopTest {

    public static void main(String[] args) {
        int[] arrays = {1, 6, 10, 11, 12, 100};
        for (int i = 0; i <= 10; i++) {
            int sign = recursionBinarySearch(arrays, i, 0, arrays.length - 1);
            if (sign == -1) {
                System.out.println("在数组中找不到" + i + "这个元素");
                System.out.println("目标元素" + i + "在数组的第" + sign + "位置");
            }
            sign = -1;
        }
    }

    /**
     *      * 使用二分查找和递归的结合进行查找
     *      * 时间复杂度：O(logN)
     *      * @param arrays    有序数组
     *      * @param target    要查找的元素(目标元素)
     *      * @param low        最低位
     *      * @param high        最高位
     *      * @return         找到的位置
     *     
     */
    public static int recursionBinarySearch(int[] arrays, int target, int low, int high){
        if (target < arrays[low] || target > arrays[high] || low > high) {
            return -1;
        }
        int middle = (low + high) / 2; //初始化中间位置的值
        if (arrays[middle] > target) {
            return recursionBinarySearch(arrays, target, low, middle - 1);
        } else if (arrays[middle] < target) {
            return recursionBinarySearch(arrays, target, middle + 1, high);
        } else {
            return middle;
        }
    }
}
