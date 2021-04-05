package com.cskaoyan.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @version 1.0
 * @ClassName SmsUtils
 * @Description 发送短信验证码组件
 * @Author wangdi
 * @Date 2019/10/5 20:01
 **/

public class SmsUtils {
    /* *
     * 功能描述 发送短信
     * @author wangdi
     * @date 2019/10/5 20:03
     * @param code
     * @param mobile
     * @return void
     */
    public static boolean sendMessage(String code, String mobile) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAI4Fr5gfYhcVjLMqeRGbuT", "IrkcHu6dZyrjPZRushgO76P5392HJ1");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "王道训练营");
        request.putQueryParameter("TemplateCode", "SMS_173765187");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
