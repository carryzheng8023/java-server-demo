package xin.carryzheng.ssmDemo.service.impl;

import org.springframework.stereotype.Service;
import xin.carryzheng.ssmDemo.redis.BaseRedis;
import xin.carryzheng.ssmDemo.service.RdsService;
import xin.carryzheng.ssmDemo.util.Const;

import java.util.ArrayList;

/**
 * Created by zhengxin on 18/1/13.
 */
@Service
public class RdsServiceImpl extends BaseRedis implements RdsService{

    @Override
    public boolean put(String key, Object value) {
        return this.setCache(key,value, Const.REDIS_DEFAULT_EXPIRE_TIME);
    }

    @Override
    public Object get(String key) {

        return this.getCache(key);
    }

    @Override
    public void delete(String key) {
        this.deleteCache(key);
    }

    @Override
    public void delete(ArrayList<String> keys) {
        this.deleteCache(keys);
    }
}
