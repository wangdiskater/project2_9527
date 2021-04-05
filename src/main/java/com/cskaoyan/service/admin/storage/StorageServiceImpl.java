package com.cskaoyan.service.admin.storage;

import com.cskaoyan.mapper.StorageMapper;
import com.cskaoyan.utils.OssUtils;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.ListVo;
import com.cskaoyan.vo.storage.StorageSearchVo;
import com.cskaoyan.vo.storage.StorageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @version 1.0
 * @ClassName StorageServiceImpl
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/2 17:45
 **/

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageMapper storageMapper;

    @Override
    public BaseRespVo storageList(StorageSearchVo storageSearchVo) {
        //判断两次是真的蠢
        if(storageSearchVo.getKey() != null &&!storageSearchVo.getKey().equals("")){
            storageSearchVo.setKey("%" + storageSearchVo.getKey() + "%");
        }
        if(storageSearchVo.getName() != null && !storageSearchVo.getName().equals("")){
            storageSearchVo.setName("%" + storageSearchVo.getName() + "%");
        }
        PageHelper.startPage(storageSearchVo.getPage(),storageSearchVo.getLimit());
        List<StorageVo> storageVos = storageMapper.selectStorage(storageSearchVo);
        PageInfo<StorageVo> storageVoPageInfo = new PageInfo<>(storageVos);
        long total = storageVoPageInfo.getTotal();
        return BaseRespVo.success(new ListVo(total,storageVos));
    }

    @Override
    public BaseRespVo storageUpdate(StorageVo storageUpdate) {
        storageUpdate.setUpdateTime(new Date());
        int update = storageMapper.updateStorageNameById(storageUpdate);
        if(update == 1){
            return BaseRespVo.success(storageUpdate);
        }
        return null;
    }

    /* *
     * 功能描述 图片上传
     * @author wangdi
     * @date 2019/10/5 20:26
     * @param file
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo storageUpload(MultipartFile file) throws IOException {
        String path = "https://9527-storage.oss-cn-beijing.aliyuncs.com/";

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = uuid + file.getOriginalFilename();
        //文件类型判断有点蠢
        if(!fileName.endsWith("jpg") && !fileName.endsWith("png") && !fileName.endsWith("jpeg") ){
            return null;
        }

        long size = file.getSize();
        StorageVo imgUploadVo = new StorageVo();
        imgUploadVo.setName(file.getOriginalFilename());
        imgUploadVo.setSize(size);
        imgUploadVo.setAddTime(new Date());
        imgUploadVo.setUpdateTime(new Date());
        imgUploadVo.setKey(fileName);
        if(fileName.endsWith("jpg")){
            imgUploadVo.setType("image/jpeg");
        } else if(fileName.endsWith("png")){
            imgUploadVo.setType("image/png\n");
        }

        imgUploadVo.setUrl(path + fileName);
        int insert = storageMapper.insertStorage(imgUploadVo);

        //图片插入到阿里云
        boolean b = OssUtils.imgUpload(file,fileName);

        if(insert == 1){
            return BaseRespVo.success(imgUploadVo);
        }
        return null;

    }

    @Override
    public BaseRespVo storageDelete(StorageVo storage) {
        int delete = storageMapper.deleteStorageById(storage.getId());
        if(delete == 1){
            return BaseRespVo.success("");
        }
        return null;
    }
}
