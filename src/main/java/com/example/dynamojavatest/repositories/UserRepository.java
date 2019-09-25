package com.example.dynamojavatest.repositories;

import com.example.dynamojavatest.models.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserData, String> {
}
