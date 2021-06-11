package com.kang.multhread.thread;

public class waitNotifyTest {

    public static User u = new User();

    public static class User{
        private int id;
        private String name;
        public User(){}
        public String toString(){
            return "User [id="+id+",name="+name+"]";
        }
    }

    public static class waitThread extends Thread{
        public void run(){
            try{
                synchronized (u){
                    System.out.println("wait start...");
                    u.wait();
                    System.out.println("wait end...");
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static class notifyThread extends Thread{
        public void run(){
            try{
                synchronized (u) {
                    System.out.println("notify start...");
                    u.notify();
                    System.out.println("notify end...");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new waitThread().start();
        new notifyThread().start();
    }
}
