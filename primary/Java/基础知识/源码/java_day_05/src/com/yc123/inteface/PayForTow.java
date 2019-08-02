package com.yc123.inteface;

public interface PayForTow extends PayFor{
		//定义变量
		public static final double PAY_VERSION=1.0;
		public static final String PAY_FOR_NAME="网络支付接口方法";
		//花呗支付
		public void huabeiPay();
		
		//易支付
		public void easypayTwo();
			
		//微信支付
		public void wxpayTwo();

}
