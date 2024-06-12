package com.example.reflectionspring.common.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@RequiredArgsConstructor
@EnableMongoRepositories(basePackages = "com.example.reflectionspring")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongodbUri;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return databaseName; // 사용할 데이터베이스 이름 지정
    }

    @Override
    public MongoClient mongoClient() {
        // MongoDB 연결 URI 설정. 예: 복제 세트, 사용자 인증 정보 포함
        return MongoClients.create(mongodbUri);
    }

    @Override
    public MongoCustomConversions customConversions() {
        // 필요한 경우 여기에 커스텀 컨버터 설정
        return super.customConversions();
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        // MongoDB 트랜잭션 매니저를 스프링 빈으로 등록
        return new MongoTransactionManager(dbFactory);
    }
}