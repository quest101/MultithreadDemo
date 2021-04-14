package com.ken.algorithm;

public class Fibonacci {

    public static void main(String[] args) throws Exception{

        long startTime = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci();
        //long result = fibonacci.fib(50);
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime-startTime));///1000 +"s"
        fibonacci.doTest(1);
        //System.out.println(result);
    }

    /**
     * 斐波那契数列：
     * ??该数列的前两项都是1，从第3项开始，后面的每一个数都是前两个数之和；
     * 求50项要用long类型，用int会返回负值(可能int长度不够)
     */
    public static long fibonacci(){
        long f1,f2,f3=0l,n=50;
        f1=f2=1;
        System.out.println(f1+" "+f2+" ");
        for(int i=3;i<=n;i++){
            f3=f1+f2; //第三项是前两项之和
            f1=f2; //更新前两项f1和f2
            f2=f3;
            System.out.print(f3+" ");
            if(i%10==0){ //输出10行后换行
                System.out.println();
            }
        }
        return f3;
    }

    public long fib(int n) throws IllegalAccessException{
        if(n <= 0) {//提高健壮性
            //System.out.println("输入的 n 应该大于0");
            //return -1;
            throw new IllegalAccessException("Must be > 0 ");
        }else if(n <= 2) {
            //System.out.println("输入的 n 应该小于2："+n);
            return 1;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }

    public void doTest(int nLoops) {
        // 主循环
        double l;
        long start = System.currentTimeMillis();
        for(int i = 0; i < nLoops; i++){
            l = fibImpl1(50);
        }
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start));
    }

    private double fibImpl1(int n) {
        if (n < 0) throw new IllegalArgumentException("Must be >0");
        if (n==0) return 0d;
        if (n == 1) return 1d;
        double d = fibImpl1(n-2) + fibImpl1(n - 1);
        if (Double.isInfinite(d)) throw new ArithmeticException("Overflow");
        return d;
    }

}
