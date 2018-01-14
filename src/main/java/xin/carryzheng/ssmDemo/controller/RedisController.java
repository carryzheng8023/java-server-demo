package xin.carryzheng.ssmDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.carryzheng.ssmDemo.base.BaseController;
import xin.carryzheng.ssmDemo.service.IRedisService;
import xin.carryzheng.ssmDemo.service.RdsService;

/**
 * Created by zhengxin on 18/1/13.
 */
@Controller
@RequestMapping("/redis")
public class RedisController extends BaseController{


    @Autowired
    private IRedisService redisService;

    @Autowired
    private RdsService rdsService;

    @RequestMapping(value = "/put", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})//添加
    @ResponseBody
    public String put(@RequestParam("key") String key, @RequestParam("value") String value) throws Exception{

        boolean result = rdsService.put(key, value);
        return this.getResultObjectData(1,"success", result);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})//获取
    @ResponseBody
    public String put(@RequestParam("key") String key) throws Exception{

        Object result = rdsService.get(key);
        return this.getResultObjectData(1,"success", result);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})//删除
    @ResponseBody
    public String delete(@RequestParam("key") String key) throws Exception{

        rdsService.delete(key);
        return this.getResultObjectData(1,"success", null);
    }


    @RequestMapping(value = "/cacheable", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})//查找
    @ResponseBody
    public String cacheable(@RequestParam("key") int key) throws Exception{

        String msg = redisService.cacheable(key);
        return this.getResultObjectData(1,"success", msg);
    }


    @RequestMapping(value = "/cachePut", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})//增改
    @ResponseBody
    public String cachePut(@RequestParam("key") int key) throws Exception{
        String msg = redisService.cachePut(key);
        return this.getResultObjectData(1,"success", msg);
    }


    @RequestMapping(value = "/cacheEvict", method = RequestMethod.GET, produces = {"application/json; charset=utf-8"})//删除
    @ResponseBody
    public String cacheEvict(@RequestParam("key") int key) throws Exception{
        String msg = redisService.cacheEvict(key);
        return this.getResultObjectData(1,"success", msg);
    }


}
