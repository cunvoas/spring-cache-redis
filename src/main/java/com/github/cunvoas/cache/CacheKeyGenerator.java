package com.github.cunvoas.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import com.github.cunvoas.bo.Person;

/**
 * @author CUNVOAS
 */
@Component("CacheKeyGenerator")
public class CacheKeyGenerator implements KeyGenerator {

	/**
	 * @see org.springframework.cache.interceptor.KeyGenerator#generate(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object generate(Object target, Method method, Object... params) {
		Object key=null;
		if (target instanceof Person) {
			Person p = (Person)target;
			key = Integer.valueOf(p.getId());
			
		} else if (target instanceof Integer) {
			Integer p = (Integer)target;
			key = Integer.valueOf(p);
		}
		return key;
	}

}
