package com.cskaoyan.mapper;

import com.cskaoyan.bean.Address;
import com.cskaoyan.bean.FootPrint;
import com.cskaoyan.bean.User;
import com.cskaoyan.vo.user.*;
import com.cskaoyan.vo.wx.address.AddressSaveVo;
import com.cskaoyan.vo.wx.address.AddressDetailVo;
import com.cskaoyan.vo.wx.foot.FeedBackVo;
import com.cskaoyan.vo.wx.foot.FootprintVo;
import com.cskaoyan.vo.wx.login.RegisterVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //前台显示所有收货地址
    List<AddressVo> queryAllAddress();

    //用户管理--会员管理模块
    List<UserVo> queryAllUser(@Param("username") String username, @Param("mobile") String mobile);

    //用户管理---会员收藏
    List<UserCollectVo> queryAllUserCollect(@Param("userId") String userId, @Param("valueId") String valueId);

    //用户管理---会员足迹
    List<FootPrintVo> queryAllUserFootPrint(@Param("userId") String userId,@Param("goodsId") String goodsId);

    //用户管理-----搜索历史
    List<HistoryVo> queryUserHistory(@Param("keyword") String keyword,@Param("userId") String userId);

    //用户管理-----意见反馈
    List<FeedbackVo> queryUserFeedBack(@Param("username") String username, @Param("id") String id);

    //根据userid 查询用户信息
    UserVo queryUserById(@Param("id") int id);


    //查询用户的地址
    List<AddressVo> queryUserAddress(@Param("userId") String userId,@Param("name") String name);

    //返回用户数量
    int queryUserCount();

    //前台通过id查询详细收货地址
    AddressDetailVo queryAddressDetail(int id);

    //前台新增收货地址
    void insertAddress(@Param("asv") AddressSaveVo addressSaveVo, int userId);

    //返回前台一个id值
    int queryAddressCount();

    //前台通过id删除收货地址
    void deleteAddress(int id);

    //前台更新收货地址
    void updateAddress(@Param("asv") AddressSaveVo addressSaveVo);

    //通过用户名和密码查找用户信息
    User queryUserByUsernamePsw(@Param("username") String username, @Param("password") String password);

    //插入新的用户
    int inserUser(@Param("user") RegisterVo registerVo);

    //判断是否存在用户名

    int existUser(@Param("username") String username, @Param("mobile") String mobile);

    //修改用户密码
    int updateUserPassword(@Param("user") RegisterVo registerVo);


    int existUser(@Param("username") String username);

    //前台添加意见反馈
    void feedBackSubmit(@Param("feedBack") FeedBackVo feedBackVo, int userId, String username);

    //前台获取足迹列表
    List<FootprintVo> queryFootPrint();

    //获取addressId
    Address queryAddressId();

    //修改默认地址的时候 删除原默认地址
    void updateIsDefault();

    //添加ip信息
    int updateIp(@Param("username") String username, @Param("ip") String ipAddress);

    //添加足迹
    int addFootPrint(@Param("footPrint") FootPrint footPrint);
    //判断是否存在该商品的足迹
    int existGoodsFootPrint(@Param("goodsId") int id);
    //删除旧的商品足迹
    int deleteFootPrint(@Param("footPrint") FootPrint footPrint);


    //验证是否登录
//    int queryUserLoginByUserName(@Param("username") String username);

    //修改用户登录状态
//    int updateUserLoginStatus(@Param("username") String username);
}
