package xin.carryzheng.ssmDemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xin.carryzheng.ssmDemo.base.BaseTest;
import xin.carryzheng.ssmDemo.entity.User;

import java.util.List;

/**
 * Created by zhengxin on 18/1/12.
 */

public class UserServiceTest extends BaseTest{

    @Autowired
    private IUserService userService;

    @Test
    public void testUserList(){
        List<User> userList = userService.userList();

        for (User u : userList){
            System.out.println(u.toString());
        }
    }



}
