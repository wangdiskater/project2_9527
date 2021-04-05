package com.cskaoyan.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @version 1.0
 * @ClassName OssUtils
 * @Description 阿里云文件上传组件
 * @Author wangdi
 * @Date 2019/10/5 20:31
 **/

public class OssUtils {

    /* *
     * 功能描述 文件上传
     * @author wangdi
     * @date 2019/10/5 20:33
     * @param file
     * @return void
     */
    public static boolean imgUpload(MultipartFile file, String key) throws IOException {

        InputStream inputStream = file.getInputStream();
        String bucket = "9527-storage";
        String endPoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI4FpVAtnrMAur6rcGEvVN";
        String accessSecret = "oc2UzGc4ZIj5HpI73Mb9B9Jdyh4H4E";
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessSecret);


        //文件名
        ossClient.putObject(new PutObjectRequest(bucket,key, inputStream));

        return true;
    }
}
