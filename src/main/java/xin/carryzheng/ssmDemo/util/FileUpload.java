package xin.carryzheng.ssmDemo.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Created by zhengxin on 18/1/12.
 */
public class FileUpload {

    /**
     * @param file //文件对象
     * @return 文件名
     */
    public static String fileUp(MultipartFile file) {
        String extName = ""; // 扩展名格式：
        if (file.getOriginalFilename().lastIndexOf(".") >= 0) {
            extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        }
        return UUID.randomUUID().toString() + extName;
    }
}
