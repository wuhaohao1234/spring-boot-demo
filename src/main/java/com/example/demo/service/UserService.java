package com.example.demo.service;

import com.example.demo.Dao.UserDao;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User selectUserByName(String name) {
        return userDao.findUserByName(name);
    }
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }
    public List<User> insertService() {
        userDao.insertUser("SnailClimb", 22, 33.1);
        userDao.insertUser("abu", 25, 33.1);
        return userDao.findAllUser();
    }
    public void deleteService(int id) {
        userDao.deleteUser(id);
    }
    /**
     * 模拟事务。由于加上了 @Transactional注解，如果转账中途出了意外 SnailClimb 和 Daisy 的钱都不会改变。
     */
    @Transactional
    public void changemoney() {
        userDao.updateUser("SnailClimb", 22, 2000.0, 3);
        // 模拟转账过程中可能遇到的意外状况
        int temp = 1 / 0;
        userDao.updateUser("Daisy", 19, 4000.0, 4);
    }
}
