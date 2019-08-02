package com.yc123.inteface;
/**
 * 支付接口 
 * @author direct
 */
public interface PayFor {
	//支付宝接口
	public boolean alipay();
	
	
	//银行
	public String bankpay();
	
	//易支付
	public void easypay();
	
	//微信支付
	public void wxpay();
	
}

