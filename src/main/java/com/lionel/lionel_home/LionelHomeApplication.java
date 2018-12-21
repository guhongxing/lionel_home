package com.lionel.lionel_home;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @Author guhognxing
 */
@SpringBootApplication
public class LionelHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LionelHomeApplication.class, args);
    }

    /**
     * redisson的连接配置
     *
     * @return 连接对象
     * @throws IOException 连接异常
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException {
        RedissonClient redisson = Redisson.create(
                Config.fromYAML(new ClassPathResource("redisson.yml").getInputStream()));
        return redisson;
    }
}

