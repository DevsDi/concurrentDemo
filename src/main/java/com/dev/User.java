package com.dev;
public class User implements Comparable<User>{

    private Integer priority;
    private String username;
    
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @Description:当前对象和其他对象做比较，当前优先级大就返回-1，优先级小就返回1
     * 值越小优先级越高
     */
    public int compareTo(User user) {
        return this.priority.compareTo(user.getPriority());
    }

	@Override
	public String toString() {
		return "User [priority=" + priority + ", username=" + username + "]";
	}
    
    
}