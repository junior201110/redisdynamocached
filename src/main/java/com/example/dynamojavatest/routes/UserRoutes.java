package com.example.dynamojavatest.routes;

import java.util.List;
import com.example.dynamojavatest.models.UserData;
import com.example.dynamojavatest.models.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRoutes {

    @Autowired
    private UsersManager userController;


    @GetMapping
    public List<UserData> getList() {

        List<UserData> list = userController.listUsers();

        return list;
    }

    @GetMapping("/{Id}")
    public UserData getUser(@PathVariable String Id) throws Exception {


        UserData user = userController.getById(Id);


        if (null == user) {
            throw new Exception(" Usuário não encontrado");
        }
        return user;
    }

    @PostMapping
    public UserData addUser(@RequestBody UserData userData) {

        return userController.addUserData(userData);
    }

    @PutMapping
    public UserData updateUser(@RequestBody UserData userData) throws Exception {
        if (userData.getId().trim().isEmpty()) {
            throw new Exception("Id do usuário não informado ou inválido");
        }
        return userController.saveUser(userData);
    }

}
