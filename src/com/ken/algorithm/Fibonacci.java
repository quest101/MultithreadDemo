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
     * 쳲��������У�
     * ??�����е�ǰ�����1���ӵ�3�ʼ�������ÿһ��������ǰ������֮�ͣ�
     * ��50��Ҫ��long���ͣ���int�᷵�ظ�ֵ(����int���Ȳ���)
     */
    public static long fibonacci(){
        long f1,f2,f3=0l,n=50;
        f1=f2=1;
        System.out.println(f1+" "+f2+" ");
        for(int i=3;i<=n;i++){
            f3=f1+f2; //��������ǰ����֮��
            f1=f2; //����ǰ����f1��f2
            f2=f3;
            System.out.print(f3+" ");
            if(i%10==0){ //���10�к���
                System.out.println();
            }
        }
        return f3;
    }

    public long fib(int n) throws IllegalAccessException{
        if(n <= 0) {//��߽�׳��
            //System.out.println("����� n Ӧ�ô���0");
            //return -1;
            throw new IllegalAccessException("Must be > 0 ");
        }else if(n <= 2) {
            //System.out.println("����� n Ӧ��С��2��"+n);
            return 1;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }

    public void doTest(int nLoops) {
        // ��ѭ��
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
