package com.example.dynamojavatest.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.example.dynamojavatest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersManager {



    // @Bean
    // public UsersManager geUserManager() {
    // return new UsersManager();
    // }

    @Autowired
    private DynamoDBMapper mapper;


    @Autowired
    private UserRepository userRepo;

    public List<UserData> listUsers() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        return mapper.scan(UserData.class, scanExpression);
    }

    public UserData addUserData(UserData newUserData) {
        newUserData.setId(UUID.randomUUID().toString());
        return saveUser(newUserData);
    }

    public UserData saveUser(UserData user) {
        mapper.save(user);
        return user;
    }

    public UserData getById(String Id) {

        return userRepo.findById(Id).orElseGet(() -> {

            Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
            eav.put(":Id", new AttributeValue().withS(Id));
            DynamoDBQueryExpression<UserData> queryExpression =
                    new DynamoDBQueryExpression<UserData>().withKeyConditionExpression("Id = :Id")
                            .withExpressionAttributeValues(eav);
            List<UserData> users = mapper.query(UserData.class, queryExpression);
            if (users.size() < 1) {
                return null;
            }


            UserData tmpUser = users.get(0);
            // = userController.getById(Id);
            userRepo.save(tmpUser);
            return tmpUser;
        });
    }

}
