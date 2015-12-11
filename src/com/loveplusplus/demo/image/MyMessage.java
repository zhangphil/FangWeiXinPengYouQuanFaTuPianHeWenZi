package com.loveplusplus.demo.image;

import java.util.ArrayList;

public class MyMessage {

	public int code;
	public String msg;
	
	public ArrayList<MyBean> list;

	@Override
	public String toString() {
		return "MyMessage [code=" + code + ", msg=" + msg + ", list=" + list + "]";
	}

	
	
}
