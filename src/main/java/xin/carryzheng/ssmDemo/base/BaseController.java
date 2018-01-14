package xin.carryzheng.ssmDemo.base;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengxin on 18/1/12.
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected String getResultObjectData(Integer code, String msg, Object data) {

        Map<String,Object> resultData = new HashMap<>();
        resultData.put("code", code);
        resultData.put("msg", msg);
        resultData.put("data", data);
        JSONObject jsonObject = JSONObject.fromObject(resultData);

        String jsonString = jsonObject.toString();

        logger.info("resultData:" + jsonString);

        return jsonString;
    }
}
