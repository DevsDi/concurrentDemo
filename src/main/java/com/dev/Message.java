package com.dev;

import java.text.SimpleDateFormat;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Message implements Delayed {
	@Setter
	@Getter
	private Integer id;
	@Setter
	private long insertTime;

	public long getDelay(TimeUnit unit) {
		// 获取失效时间
		return this.insertTime - System.currentTimeMillis();
	}

	public int compareTo(Delayed o) {
		// 比较 1是放入队尾 -1是放入队头
		Message that = (Message) o;
		if (this.insertTime > that.insertTime) {
			return 1;
		} else if (this.insertTime == that.insertTime) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", insertTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(insertTime) + "]";
	}

}
