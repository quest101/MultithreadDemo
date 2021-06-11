package com.ken.concurrent.lock.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class LocksTest {

    public static void main(String[] args) throws InterruptedException {
        // �ǹ�ƽ��
        ReentrantLock lock = new ReentrantLock();
        // ��ƽ��
        ReentrantLock fairLock = new ReentrantLock(true);

        lock.lock();
        lock.tryLock();
        lock.lockInterruptibly();
        try {

            //do something

        } finally {
            lock.unlock();
        }

    }
}
