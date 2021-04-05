package com.cskaoyan.vo;

import com.cskaoyan.vo.wx.address.BaseRespTwoVo;

/**
 * @version 1.0
 * @ClassName BaseRespVo
 * @Description 返回给前端json数据的viewObject
 * @Author wangdi
 * @Date 2019/9/30 11:02
 **/

public class BaseRespVo {
    private Object data;
    String errmsg;
    int errno;

    public BaseRespVo() {
    }

    public BaseRespVo(Object data) {
        this.data = data;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    @Override
    public String toString() {
        return "BaseRespVo{" +
                "data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }
    /* *
     * 功能描述 调用返回给前端正常的数据
     * @author wangdi
     * @date
     * @param s
     * @return com.cskaoyan.vo.BaseRespVo
     */
    public static BaseRespVo success(Object data) {
        BaseRespVo baseRespVo = new BaseRespVo(data);
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        return baseRespVo;
    }
    /* *
     * 功能描述 添加返回错误信息
     * @author wangdi
     * @date 2019/10/4 16:03
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    public static BaseRespVo fail() {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg("失败");
        baseRespVo.setErrno(500);
        return baseRespVo;
    }

    public static BaseRespVo fail(int errno,String errmsg) {
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrmsg(errmsg);
        baseRespVo.setErrno(errno);
        return baseRespVo;
    }
}
