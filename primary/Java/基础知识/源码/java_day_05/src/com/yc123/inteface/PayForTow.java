package com.yc123.inteface;

public interface PayForTow extends PayFor{
		//�������
		public static final double PAY_VERSION=1.0;
		public static final String PAY_FOR_NAME="����֧���ӿڷ���";
		//����֧��
		public void huabeiPay();
		
		//��֧��
		public void easypayTwo();
			
		//΢��֧��
		public void wxpayTwo();

}
