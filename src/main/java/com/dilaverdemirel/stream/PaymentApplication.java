package com.dilaverdemirel.stream;

import com.dilaverdemirel.spring.outbox.scheduler.FailedOutboxMessageSchedulerService;
import com.dilaverdemirel.stream.payment.stream.channel.PaymentServiceStockOperationPublishChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.dilaverdemirel.spring.outbox.repository",
        "com.dilaverdemirel.stream.payment.repository"
})
@EntityScan(basePackages = {
        "com.dilaverdemirel.spring.outbox.domain",
        "com.dilaverdemirel.stream.payment.domain"
})
@ComponentScan({
        "com.dilaverdemirel.spring.outbox",
        "com.dilaverdemirel.stream"
})
@EnableBinding({
        PaymentServiceStockOperationPublishChannel.class
})
@SpringBootApplication
@EnableScheduling
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Bean
    public FailedOutboxMessageSchedulerService failedOutboxMessageSchedulerService() {
        return new FailedOutboxMessageSchedulerService();
    }
}
