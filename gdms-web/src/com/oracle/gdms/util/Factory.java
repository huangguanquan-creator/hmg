package com.oracle.gdms.util;

import java.util.ResourceBundle;

public class Factory {
	private Factory() {
		// TODO �Զ����ɵĹ��캯�����
	}

	private static Factory fac = new Factory();
	public static Factory getInstance() {
		return fac;
	}
	
	private static ResourceBundle rb = null;
	static {
		rb = ResourceBundle.getBundle("config/application");//��ȡ�����ļ�
	}
	public Object getObject(String key) {
		String clsname = rb.getString(key);
		try {
			return Class.forName(clsname).newInstance();
		} catch (InstantiationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
}
