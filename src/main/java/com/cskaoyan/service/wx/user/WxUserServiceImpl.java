package com.cskaoyan.service.wx.user;

import com.cskaoyan.bean.Order;
import com.cskaoyan.mapper.MallManageMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.mapper.WxOrderMapper;
import com.cskaoyan.vo.BaseRespVo;
import com.cskaoyan.vo.wx.user.UserOrderVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @ClassName WxUserServiceImpl
 * @Description todo
 * @Author wangdi
 * @Date 2019/10/6 10:42
 **/

@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    WxOrderMapper wxOrderMapper;

    /* *
     * 功能描述 显示用户主页信息
     * @author wangdi
     * @date 2019/10/6 11:00
     * @param userId
     * @return com.cskaoyan.vo.BaseRespVo
     */
    @Override
    public BaseRespVo userIndex(int userId) {

        List<Order> orders = wxOrderMapper.queryOrderByUserId(userId,0);
        int unrecv=0;     //301
        int uncomment=0;  //401 402  添加可以评论商品的个数
        int unpaid=0;     //101
        int unship=0;     //201
        for (Order order : orders) {
            int order_status = order.getOrder_status();
            switch (order_status){
                case 301:{
                    unrecv++;
                    break;
                }
                case 401:
                case 402:{
                    if(order.getComments() >0 ){
                        uncomment += order.getComments();
                    }
                    break;
                }
                case 101:{
                    unpaid++;
                    break;
                }
                case 201:{
                    unship++;
                    break;
                }
            }
        }
        UserOrderVo userOrderVo = new UserOrderVo(unrecv,uncomment,unpaid,unship);
        HashMap<String, UserOrderVo> userMap = new HashMap<>();
        userMap.put("order",userOrderVo);

        return BaseRespVo.success(userMap);
    }
}
