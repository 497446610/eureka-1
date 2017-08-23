package com.pt.core.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache implements Cache {

	Log logger = LogFactory.getLog(this.getClass());

	/**
	 * 缓存时间配置
	 */
	private Map<String, Integer> liveTimeMap = new HashMap<String, Integer>();

	private Integer defaultLiveTime = 2 * 60; // 默认缓存时间2分钟

	private RedisTemplate<String, Object> redisTemplate;

	private String name;

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	

	public Integer getDefaultLiveTime() {
		return defaultLiveTime;
	}

	public void setDefaultLiveTime(Integer defaultLiveTime) {
		this.defaultLiveTime = defaultLiveTime;
	}

	public Map<String, Integer> getLiveTimeMap() {
		return liveTimeMap;
	}

	public void setLiveTimeMap(Map<String, Integer> liveTimeMap) {
		this.liveTimeMap = liveTimeMap;
	}

	@Override
	public Object getNativeCache() {
		return this.redisTemplate;
	}

	@Override
	public ValueWrapper get(Object key) {
		final String keyf = (String) key;
		Object object = null;
		try {
			object = redisTemplate.execute(new RedisCallback<Object>() {
				public Object doInRedis(RedisConnection connection) throws DataAccessException {

					byte[] key = keyf.getBytes();
					byte[] value = connection.get(key);
					if (value == null) {
						return null;
					}
					return toObject(value);

				}
			});
		} catch (Exception e) {
			logger.error(e);
		}
		return (object != null ? new SimpleValueWrapper(object) : null);
	}

	private Integer getExpireTime(String key) {
		if (key == null) {
			return defaultLiveTime;
		}

		String[] strArray = key.split("-");
		String keyName = strArray[0];
		if (liveTimeMap.containsKey(keyName)) {
			return liveTimeMap.get(keyName);
		}

		return defaultLiveTime;
	}

	@Override
	public void put(Object key, Object value) {
		final String keyf = (String) key;
		final Object valuef = value;
		final long liveTime = getExpireTime(keyf);

		try {
			redisTemplate.execute(new RedisCallback<Long>() {
				public Long doInRedis(RedisConnection connection) throws DataAccessException {
					byte[] keyb = keyf.getBytes();
					byte[] valueb = toByteArray(valuef);
					connection.set(keyb, valueb);
					if (liveTime > 0) {
						connection.expire(keyb, liveTime);
					}
					return 1L;
				}
			});
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * 描述 : <Object转byte[]>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @param obj
	 * @return
	 */
	private byte[] toByteArray(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
			oos.close();
			bos.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return bytes;
	}

	/**
	 * 描述 : <byte[]转Object>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @param bytes
	 * @return
	 */
	private Object toObject(byte[] bytes) {
		Object obj = null;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bis);
			obj = ois.readObject();
			ois.close();
			bis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return obj;
	}

	@Override
	public void evict(Object key) {
		final String keyf = (String) key;
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.del(keyf.getBytes());
			}
		});
	}

	@Override
	public void clear() {
		redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
	}

	@Override
	public <T> T get(Object arg0, Class<T> arg1) {
		return null;
	}

	@Override
	public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
		return null;
	}

}
