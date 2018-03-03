package com.wxbc.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class RedisService {
	// applicationContext.xml中有注册就注入,没有就不注入
	@Autowired(required = false)
	private ShardedJedisPool pool;

	public <T> T execute(Function<T, ShardedJedis> fun) {
		ShardedJedis jedis = null;
		try {
			jedis = pool.getResource();
			return fun.callback(jedis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return null;
	}

    /**
     * 设置key，value
    */
	public String set(final String key, final String value) {
		// 把set方法封装入对象传入到通用方法execute中,然后调取execute返回值
		return this.execute(new Function<String, ShardedJedis>() {
			@Override
			public String callback(ShardedJedis jedis) {
				return jedis.set(key, value);
			}
		});
	}

    /**
     * 设置key，value，超时时间
    */
	public String setex(final String key, final String value,
			final Integer seconds) {
		return this.execute(new Function<String, ShardedJedis>() {
			@Override
			public String callback(ShardedJedis jedis) {
				return jedis.setex(key, seconds, value);
			}
		});
	}

    /**
     * 获取value
     */
	public String get(final String key) {
		return this.execute(new Function<String, ShardedJedis>() {
			@Override
			public String callback(ShardedJedis jedis) {
				return jedis.get(key);
			}
		});
	}

    /**
     * 删除key，value
     */
	public Long delete(final String key) {
		return this.execute(new Function<Long, ShardedJedis>() {
			@Override
			public Long callback(ShardedJedis jedis) {
				return jedis.del(key);
			}
		});
	}

    /**
     * 根据key设置超时时间
     */
	public Long expire(final String key, final Integer seconds) {
		return this.execute(new Function<Long, ShardedJedis>() {
			@Override
			public Long callback(ShardedJedis jedis) {
				return jedis.expire(key, seconds);
			}
		});
	}

    /**
     * 设置hash类型key、field、value
     */
	public Long hset(final String redisKey, final String field,
			final String value) {
		// 把set方法封装入对象传入到通用方法execute中,然后调取execute返回值
		return this.execute(new Function<Long, ShardedJedis>() {
			@Override
			public Long callback(ShardedJedis jedis) {
				return jedis.hset(redisKey, field, value);
			}
		});

	}

    /**
     * 根据key、field获取value
     */
	public String hget(final String redisKey,final String field) {
		return this.execute(new Function<String, ShardedJedis>() {
			@Override
			public String callback(ShardedJedis jedis) {
				return jedis.hget(redisKey, field);
			}
		});
	}

    /**
     * 获取key下所有value
     */
	public List<String> hvals(final String redisKey) {
		return this.execute(new Function<List<String>, ShardedJedis>() {
			@Override
			public List<String> callback(ShardedJedis jedis) {
				return jedis.hvals(redisKey);
			}
		});
	}

    /**
     * 根据key、field删除value

     */
	public Long hdel(final String redisKey,final String field) {
		return this.execute(new Function<Long, ShardedJedis>() {
			@Override
			public Long callback(ShardedJedis jedis) {
				return jedis.hdel(redisKey, field);
			}
		});
	}

    /**
     * 判斷key是否存在
     * @param redisKey
     * @return
     */
    public Boolean exists(final String redisKey) {
        return this.execute(new Function<Boolean, ShardedJedis>() {
            @Override
            public Boolean callback(ShardedJedis jedis) {
                return jedis.exists(redisKey);
            }
        });
    }

}
