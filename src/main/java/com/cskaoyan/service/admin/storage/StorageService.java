package com.cskaoyan.service.admin.storage;

import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.storage.StorageSearchVo;
import com.cskaoyan.vo.storage.StorageVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {

    BaseRespVo storageList(StorageSearchVo storageSearchVo);

    BaseRespVo storageUpdate(StorageVo storageUpdate);

    BaseRespVo storageUpload(MultipartFile file) throws IOException;

    BaseRespVo storageDelete(StorageVo storage);
}
