package com.cskaoyan.mapper;

import com.cskaoyan.vo.storage.StorageSearchVo;
import com.cskaoyan.vo.storage.StorageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageMapper {
    List<StorageVo> selectStorage(@Param("storageSearch") StorageSearchVo storageSearchVo);

    int updateStorageNameById(@Param("storage") StorageVo storageUpdate);

    int insertStorage(@Param("storage") StorageVo imgUploadVo);

    int deleteStorageById(@Param("id") int id);
}
