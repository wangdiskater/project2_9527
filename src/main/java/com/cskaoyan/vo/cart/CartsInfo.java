package com.cskaoyan.vo.cart;

/**
 * @Auther Piter_Liu
 * @Description
 * @Date 2019/10/5
 */

public class CartsInfo<T> {
    T cartList;
    T cartTotal;

    public T getCartList() {
        return cartList;
    }

    public void setCartList(T cartList) {
        this.cartList = cartList;
    }

    public T getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(T cartTotal) {
        this.cartTotal = cartTotal;
    }
}
