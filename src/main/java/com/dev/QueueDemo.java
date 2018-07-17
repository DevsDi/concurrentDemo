package com.dev;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class QueueDemo {
	
	public static void ConcurrentLinkedQueueM() {
		// 高性能无阻塞无界队列
		ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
		clq.offer("a");
		clq.add("b");
		clq.add("c");
		System.out.println("ConcurrentLinkedQueue原始元素：" + clq);
		System.out.println("ConcurrentLinkedQueue获取头部元素：" + clq.poll());
		System.out.println("ConcurrentLinkedQueue剩余元素：" + clq);
		System.out.println("ConcurrentLinkedQueue获取头部元素：" + clq.peek());
		System.out.println("ConcurrentLinkedQueue剩余元素：" + clq);
	}

	public static void ArrayBlockingQueueM() throws Exception {
		// 基于阻塞有界队列
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(3);
		abq.put("a");
		abq.add("b");
		abq.add("c");
		System.err.println("ArrayBlockingQueue增加新元素是否成功："+ abq.offer("d", 100, TimeUnit.MILLISECONDS)); 

		ArrayBlockingQueue<String> abq2 = new ArrayBlockingQueue<String>(3);
		System.out.println("ArrayBlockingQueue元素转移：" + abq.drainTo(abq2, 2));
		System.out.println("ArrayBlockingQueue主动方：" + abq);
		System.out.println("ArrayBlockingQueue被动方：" + abq2);
	}

	public static void LinkedBlockingQueueM() {
		// 基于阻塞 无界队列,类似ArrayBlockingQueue
		LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>();
		lbq.add("a");
		lbq.add("b");
		lbq.add("c");
		System.out.println("LinkedBlockingQueue元素："+lbq);
	}

	public static void SynchronousQueueM() {
		// 不存元素的阻塞队列
		final SynchronousQueue<String> sq = new SynchronousQueue<String>();
		// sq.add("a"); //Queue full
		new Thread(new Runnable() {

			public void run() {
				try {
					System.out.println("SynchronousQueue获取元素：" + sq.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();

		new Thread(new Runnable() {

			public void run() {
				sq.add("a");
			}
		}).start();
	}

	public static void PriorityBlockingQueueM() {

		PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<User>();

		for (int i = 1; i <= 5; i++) {
			User user = new User();
			Random random = new Random();
			int n = random.nextInt(100);

			user.setPriority(n);
			user.setUsername("dev"+i);
			queue.add(user);
		}

		for (User u : queue) {
			System.out.println(u);
		}

	}

	public static void DelayQueueM(int n) throws Exception {
		
		DelayQueue<Message> delayQueue = new DelayQueue<Message>();
		for (int i = 1; i <= 5; i++) {
			Message m = new Message(i, System.currentTimeMillis() + 1000 * new Random().nextInt(30));
			delayQueue.add(m);
		}

		while (!delayQueue.isEmpty()) {
			Message message = delayQueue.take();// 此处会阻塞
			System.out.println("延时时间结束:"+message);
		}
	}

	public static void main(String[] args) throws Exception {
//		 ConcurrentLinkedQueueM();
//		 ArrayBlockingQueueM();
//		 LinkedBlockingQueueM();
//		 SynchronousQueueM();
//		 PriorityBlockingQueueM();
		 DelayQueueM(2);
	}

}