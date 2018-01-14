package xin.carryzheng.ssmDemo.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by zhengxin on 18/1/12.
 */
public class Qiniu {

    Auth auth = Auth.create(Const.QINIU_ACCESS_KEY, Const.QINIU_SECRET_KEY);

    Zone z = Zone.autoZone();
    Configuration c = new Configuration(z);

    //创建上传对象
    UploadManager uploadManager = new UploadManager(c);
    /**
     * 获取凭证
     * @param bucketName 空间名称
     * @return
     */
    public String getUpToken(String bucketName) {
        return auth.uploadToken(bucketName);
    }
    /**
     * 上传
     * @param file 文件路径  （也可以是字节数组、或者File对象）
     * @param key 上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param bucketName 空间名称  （这里是为了获取上传凭证）
     * @throws IOException
     */
    public void upload(MultipartFile file, String key, String bucketName) throws IOException {
        try {
            // 调用put方法上传
            byte[] tmp = null;
            tmp = file.getBytes();
            Response res = uploadManager.put(tmp, key, getUpToken(bucketName));
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }

    public static String downloadUrl(String key) {
        return Const.QINIU_BUCKET_HOST_NAME + "/" + key;
    }

}
