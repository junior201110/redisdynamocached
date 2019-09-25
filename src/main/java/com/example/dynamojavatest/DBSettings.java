package com.example.dynamojavatest;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBSettings {
    /**
     * @return AmazonDynamoDB return the client
     */
    // @Bean
    // public DynamoDB getDynamoDB() {
    // return new DynamoDB(getClient());
    // }

    /**
     * @return AmazonDynamoDB return the client
     */
    @Bean
    public AmazonDynamoDB getClient() {
        return AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                .build();
    }

    @Bean
    public DynamoDBMapper getMapper() {
        return new DynamoDBMapper(getClient());

    }

}
