package xin.carryzheng.ssmDemo.service;

import java.util.ArrayList;

/**
 * Created by zhengxin on 18/1/13.
 */
public interface RdsService {

    boolean put(String key, Object value);

    Object get(String key);

    void delete(String key);

    void delete(ArrayList<String> key);

}
