package com.ken.algorithm;

public class BinarySearch {

    /**
     * 将n个元素分成大致相等的两部分，
     * 取a[n/2]与x做比较，如果x=a[n/2],则找到x,算法中止；
     * 如果x大于中间值（a[n/2]），低位下标等于mid+1；
     * 如果x小于中间值（a[n/2]），高位小标等于mid-1。
     * 时间复杂度 O(log2 n) ,以2为底, n的对数.
     * @param a
     * @param num
     * @return
     */
    public static int binarySearch(int []a,int num){
        int len=a.length;
        int high=len-1;
        int low=0;
        while(low<=high){
            int mid=(high+low)>>1;
            if(a[mid]==num)
                return mid;
            else if(a[mid]<num)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

    public static int binarySearch_(int []a,int low, int high,int num){
        if(low<=high){
            int mid=(low+high)>>1;
            if(a[mid]==num)
                return mid;
            else if(a[mid]<num)
                low=mid+1;
            else
                high=mid-1;
            return binarySearch_(a,low,high,num);
        }else
            return -1;
    }

    public static void main(String args[]){
        //非递归
        int []a={1,10,30,34,40,45,59};
        //int index=binarySearch(a, 30);
        int index=binarySearch(a, 20);
        System.out.println(index);
        //递归
       /* int []a={1,10,30,34,40,45,59};
        int index=binarySearch_(a, 0,a.length-1,10);
        System.out.println(index);*/
    }
}
