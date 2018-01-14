package xin.carryzheng.ssmDemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xin.carryzheng.ssmDemo.base.BaseService;
import xin.carryzheng.ssmDemo.dao.UserDao;
import xin.carryzheng.ssmDemo.entity.User;
import xin.carryzheng.ssmDemo.service.IUserService;

import java.util.List;

/**
 * Created by zhengxin on 18/1/12.
 */

@Service
public class UserServiceImpl extends BaseService implements IUserService{


    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable(value = {"users"})
    public List<User> userList() {
        logger.info("service userList invoked");
        return userDao.selectAll();
    }

    @Override
    @Cacheable(value = {"user"}, key = "#userId")
    public User getUserByUserId(Long userId) {
        return userDao.selectByUserId(userId);
    }

    @Override
    @CacheEvict(value = {"user"}, key = "#userId", condition = "#userId != null")
    public Integer saveOrUpdate(Long userId, String name) {
        User user = new User();
        user.setName(name);

        if(null != userId){
            user.setUserId(userId);
            return userDao.update(user);
        }

        return userDao.insert(user);
    }
}
