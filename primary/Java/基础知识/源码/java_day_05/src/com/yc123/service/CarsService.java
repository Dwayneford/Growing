package com.yc123.service;

import com.yc123.inteface.PayFor;
import com.yc123.inteface.PayForTow;

public class CarsService implements PayForTow, PayFor{

	@Override
	public boolean alipay() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String bankpay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void easypay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wxpay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void huabeiPay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void easypayTwo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wxpayTwo() {
		// TODO Auto-generated method stub
		
	}

}
