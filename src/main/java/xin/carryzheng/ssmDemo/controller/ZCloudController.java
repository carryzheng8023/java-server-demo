package xin.carryzheng.ssmDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xin.carryzheng.ssmDemo.base.BaseController;
import xin.carryzheng.ssmDemo.util.Const;
import xin.carryzheng.ssmDemo.util.FileUpload;
import xin.carryzheng.ssmDemo.util.Qiniu;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by zhengxin on 18/1/12.
 */
@Controller
@RequestMapping("/zCloud")
public class ZCloudController extends BaseController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
    @ResponseBody
    public String upload(@RequestParam(value="file") MultipartFile file) {

        Map<String,Object> map = new HashMap<>();

        try {
            if(file!=null){
                // 上传到七牛后保存的文件名
                String key= FileUpload.fileUp(file);
                new Qiniu().upload(file, key, Const.QINIU_BUCKET_NAME);
                String url = Qiniu.downloadUrl(key);
                map.put("url", url);

            }
        }catch (Exception e){

            e.printStackTrace();
        }finally {

            return this.getResultObjectData(1, "文件上传成功", map);
        }



    }


}
