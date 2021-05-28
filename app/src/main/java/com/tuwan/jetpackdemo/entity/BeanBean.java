package com.tuwan.jetpackdemo.entity;

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 * <p>
 * <p>
 * Created by austenYang on 2021/5/28-11:51
 * ================================================
 */
public class BeanBean<Data> {
    public int code;
    public String msg;
    public Data data;

    public boolean isOk() {
        return code == 0;
    }
}
