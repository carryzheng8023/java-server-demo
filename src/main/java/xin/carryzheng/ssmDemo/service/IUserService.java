package xin.carryzheng.ssmDemo.service;

import xin.carryzheng.ssmDemo.entity.User;

import java.util.List;

/**
 * Created by zhengxin on 18/1/12.
 */
public interface IUserService {


    List<User> userList();

    User getUserByUserId(Long userId);

    Integer saveOrUpdate(Long userId, String name);

}
