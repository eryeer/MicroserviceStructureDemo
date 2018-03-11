package com.wxbc.config;

import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.data.redis.connection.RedisConnectionFactory;
        import org.springframework.session.SessionRepository;
        import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
        import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@Configuration
//@EnableSpringHttpSession
public class SpringHttpSessionConfig {

    //@Bean(name={"a", "b}) 如果配置了name，使用name的，否则使用方法的名称
    //@Bean
    public SessionRepository<?> sessionRepository(RedisConnectionFactory redisConnectionFactory) {
        RedisOperationsSessionRepository redisSessionRepository =
                new RedisOperationsSessionRepository(redisConnectionFactory);
        redisSessionRepository.setDefaultMaxInactiveInterval(300);//session超时时间5min
        return redisSessionRepository;
    }
}