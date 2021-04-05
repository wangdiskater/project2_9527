package com.cskaoyan.controller.wx.cart;


import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.CartMapper;
import com.cskaoyan.service.wx.cart.CartService;
import com.cskaoyan.vo.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Auther Piter_Liu
 * @Description  购物车模块
 * @Date 2019/10/5
 */
@RestController
@RequestMapping("wx/cart")
public class WxCartController {

    @Autowired
    CartService cartService;

    /**
     * @return 显示加载购物车信息
     */
    @RequestMapping("index")
    public BaseRespVo showAllCartGoods(){
        return cartService.showAllCartGoods();
    }

    /**
     * @param products 选择或取消商品
     * @return
     */
    @RequestMapping(value = "checked" ,method = RequestMethod.POST)
    public BaseRespVo cartChecked(@RequestBody Products products){
        return cartService.cartChecked(products);
    }

    /**
     * @param product 更新购物车商品
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public BaseRespVo updateGoodsCount(@RequestBody UpdateProduct product){
        return cartService.updateGoodsCount(product);
    }

    /**
     * @param products 删除购物车商品
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseRespVo deleteCart(@RequestBody Products products){
        return cartService.deleteCart(products);
    }

    /**
     * @return 加载显示购物车商品数量
     */
    @RequestMapping(value = "goodscount",method = RequestMethod.GET)
    public BaseRespVo goodscount(){
       return cartService.goodscount();
    }

    /**
     * @param addGoods 加入购物车
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public BaseRespVo addCart(@RequestBody Fastadd addGoods){
        Session session2 = SecurityUtils.getSubject().getSession();
        Integer userId = (Integer) session2.getAttribute("userId");
        if(userId == null){
            return BaseRespVo.fail(100,"登陆过期，请登陆");
        }
        return cartService.addCart(addGoods,userId);
    }

    /**
     * @param addGoods 快速购买商品
     * @return
     */
    @RequestMapping(value = "fastadd",method = RequestMethod.POST)
    public BaseRespVo fastadd(@RequestBody Fastadd addGoods){
        Session session2 = SecurityUtils.getSubject().getSession();
        Integer userId = (Integer) session2.getAttribute("userId");
        if(userId == null){
            return BaseRespVo.fail(100,"登陆过期，请登陆");
        }
        return cartService.fastadd(addGoods,userId);
    }

    /**
     * @param cartId
     * @param addressId
     * @param couponId
     * @param grouponRulesId
     * @return  下单前信息确认
     */
    @RequestMapping("checkout")
    public BaseRespVo checkout(int cartId, int addressId, int couponId, int grouponRulesId){
        return cartService.checkout(cartId,addressId,couponId,grouponRulesId);
    }
}
