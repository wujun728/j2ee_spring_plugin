package com.km.service;

import com.km.entity.User;

import java.util.List;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/9/21.
 */
public interface UserService {

    List<User> list();

    User findUserById(Long id);

    void update(User user);

    void remove(Long id);

}
