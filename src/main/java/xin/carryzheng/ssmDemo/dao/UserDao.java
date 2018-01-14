package xin.carryzheng.ssmDemo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xin.carryzheng.ssmDemo.entity.User;

import java.util.List;

/**
 * Created by zhengxin on 18/1/12.
 */
public interface UserDao {


    List<User> selectAll();

    @Select("SELECT user_id, name FROM `user` WHERE user_id = #{userId}")
    User selectByUserId(@Param("userId") long userId);

    Integer insert(User user);

    Integer update(User user);

}
