package com.dev;

import java.util.Calendar;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*
 * 定义放在延迟队列中的对象，需要实现Delayed接口
 */
public class DelayedTask implements Delayed {

    private int _expireInSecond = 0;
    private String no=null;
    private String threadName=null;

    public DelayedTask(int delaySecond,String threadName,String no) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, delaySecond);
        _expireInSecond = (int) (cal.getTimeInMillis() / 1000);
        this.no=no;
        this.threadName=threadName;
    }
    
    public String getNo() {
		return no;
	}
    public String getThreadName() {
		return threadName;
	}

    public int compareTo(Delayed o) {
        long d = (getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    public long getDelay(TimeUnit unit) {
        Calendar cal = Calendar.getInstance();
        return _expireInSecond - (cal.getTimeInMillis() / 1000); 
    }
}
