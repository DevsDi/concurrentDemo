package com.dev;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.DelayQueue;

public class DelayMain {


	public static void main(String[] args) throws InterruptedException {
		final DelayMain main = new DelayMain();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				
				public void run() {
					try {
						String no="T"+UUID.randomUUID().toString().substring(0, 6);
						main.start(new DelayedTask(1, Thread.currentThread().getName(),no));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}).start();
			Thread.sleep(10);
		}
	
	}

	private synchronized void start(DelayedTask task) throws InterruptedException {
		 DelayQueue<DelayedTask> delayQueue=new DelayQueue<DelayedTask>();
		delayQueue.add(task);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		while (delayQueue.size() != 0) {
			// 如果没到时间，该方法会返回
			DelayedTask delayedTask = delayQueue.poll();
			if (delayedTask != null) {
				System.out.println("线程："+delayedTask.getThreadName()+"	单号：" + delayedTask.getNo() + "	时间:"	+ sdf.format(new Date()));
			}
			Thread.sleep(100);
		}
	}

}
