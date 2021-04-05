package com.cskaoyan.controller.wx.storage;

import com.cskaoyan.service.admin.storage.StorageService;
import com.cskaoyan.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @version 1.0
 * @ClassName StorageController
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/6 22:29
 **/
@RestController
@RequestMapping("/wx")
public class WxStorageController {
    @Autowired
    StorageService storageService;
    /* *
     * 功能描述 图片上传
     * @author wangdi
     * @date 2019/9/30 20:40
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     *
     *  ---- 图片上传 ---
     * 返回图片的json
     * {"errno":0,"data":{"id":757,"key":"ukskcugqj50ghvsgmx6l.JPEG","name":"addasi.JPEG","type":"image/jpeg","size":2996,"url":"http://192.168.2.100:8081/wx/storage/fetch/ukskcugqj50ghvsgmx6l.JPEG","addTime":"2019-09-30 08:38:29","updateTime":"2019-09-30 08:38:29"},"errmsg":"成功"}
     *
     *
     */

    @RequestMapping(value = "/storage/upload",method = RequestMethod.POST)
    public BaseRespVo storageImg(MultipartFile file) throws IOException {
        return storageService.storageUpload(file);
    }
}
