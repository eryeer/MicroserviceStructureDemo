package com.wxbc.redis;

public interface Function<T, E> {
	
	//回调函数
	public T callback(E e);
}
