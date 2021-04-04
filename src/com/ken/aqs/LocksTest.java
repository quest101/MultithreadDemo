package com.ken.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class LocksTest {


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {

            //do something

        } finally {
            lock.unlock();
        }

    }
}
