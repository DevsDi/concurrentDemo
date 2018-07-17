package com.dev;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
		
		/**
		 * 
	public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }
		 * */
		list.add("a");
		System.out.println(list);
	}

}
