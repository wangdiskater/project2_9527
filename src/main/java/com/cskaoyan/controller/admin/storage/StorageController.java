package com.cskaoyan.controller.admin.storage;

import com.cskaoyan.service.admin.storage.StorageService;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.storage.StorageSearchVo;
import com.cskaoyan.vo.storage.StorageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @version 1.0
 * @ClassName StorageController
 * @Description 图片控制
 * @Author wangdi
 * @Date 2019/10/2 17:30
 **/

@RequestMapping("/admin")
@RestController
public class StorageController {

    @Autowired
    StorageService storageService;

    /* *
     * 功能描述 显示存储list
     * @author wangdi
     * @date 2019/10/2 17:46
     * @param page @param limit @param key @param name @param sort @param order
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/storage/list",method = RequestMethod.GET)
    public BaseRespVo storageList(int page, int limit, String key, String name, String sort,String order){
        StorageSearchVo storageSearchVo = new StorageSearchVo(page,limit,key,name,sort,order);
        return storageService.storageList(storageSearchVo);
    }
    /* *
     * 功能描述 更新资源名字
     * @author wangdi
     * @date 2019/10/2 19:36
     * @param storageUpdate
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/storage/update",method = RequestMethod.POST)
    public BaseRespVo storageUpdate(@RequestBody StorageVo storageUpdate){
        return storageService.storageUpdate(storageUpdate);
    }

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

    @RequestMapping(value = "/storage/create",method = RequestMethod.POST)
    public BaseRespVo storageImg(MultipartFile file) throws IOException {
        return storageService.storageUpload(file);
    }
    /* *
     * 功能描述 删除静态资源
     * @author wangdi
     * @date 2019/10/2 20:10
     * @param storage
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @RequestMapping(value = "/storage/delete",method = RequestMethod.POST)
    public BaseRespVo storageDelete(@RequestBody StorageVo storage){
        return storageService.storageDelete(storage);
    }
}
