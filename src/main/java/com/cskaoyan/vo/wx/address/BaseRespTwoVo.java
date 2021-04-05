package com.cskaoyan.vo.wx.address;

import com.cskaoyan.vo.BaseRespVo;

/**
 * @Classname BaseRespAddressVo
 * @Author LM
 * @Description
 * @Data 2019/10/5 17:05
 */
public class BaseRespTwoVo {
    int errno;
    String errmsg;

    public BaseRespTwoVo() {
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
        return "BaseRespAddressVo{" +
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
    public static BaseRespTwoVo success() {
        BaseRespTwoVo baseRespAddressVo = new BaseRespTwoVo();
        baseRespAddressVo.setErrmsg("成功");
        baseRespAddressVo.setErrno(0);
        return baseRespAddressVo;
    }
    /* *
     * 功能描述 添加返回错误信息
     * @author wangdi
     * @date 2019/10/4 16:03
     * @param
     * @return com.cskaoyan.vo.BaseRespVo
     */
    public static BaseRespTwoVo fail() {
        BaseRespTwoVo baseRespAddressVo = new BaseRespTwoVo();
        baseRespAddressVo.setErrmsg("失败");
        baseRespAddressVo.setErrno(500);
        return baseRespAddressVo;
    }

    public static BaseRespTwoVo fail(int errno, String errmsg) {
        BaseRespTwoVo baseRespAddressVo = new BaseRespTwoVo();
        baseRespAddressVo.setErrmsg(errmsg);
        baseRespAddressVo.setErrno(errno);
        return baseRespAddressVo;
    }
}
