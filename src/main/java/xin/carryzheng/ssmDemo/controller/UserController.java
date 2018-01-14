package xin.carryzheng.ssmDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xin.carryzheng.ssmDemo.base.BaseController;
import xin.carryzheng.ssmDemo.entity.User;
import xin.carryzheng.ssmDemo.service.IUserService;

import java.util.List;

/**
 * Created by zhengxin on 18/1/12.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/{pathVariable}/list", method = RequestMethod.GET, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private String list(@PathVariable("pathVariable") String pathVariable, @RequestParam("requestParam") String requestParam) {


        logger.info("user list invoked");
        logger.info("pathVariable:" + pathVariable);
        logger.info("requestParam:" + requestParam);

        List<User> userList = userService.userList();

        return getResultObjectData(1, "success", userList);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private String detail(@RequestParam("userId") Long userId) {


        logger.info("user detail invoked");


        User user = userService.getUserByUserId(userId);

        return getResultObjectData(1, "success", user);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private String add(@RequestParam("name") String name) {

        logger.info("name:::" + name);

        userService.saveOrUpdate(null,name);

        return getResultObjectData(1, "success", null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    private String update(@RequestParam("userId") Long userId, @RequestParam("name") String name) {

        logger.info("userId:::" + userId);
        logger.info("name:::" + name);

        userService.saveOrUpdate(userId,name);

        return getResultObjectData(1, "success", null);
    }


}
