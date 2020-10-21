package com.dnd.util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {
		T object = null;
		try {
			object = tClass.newInstance(); // khoi tao doi tuong
			BeanUtils.populate(object, request.getParameterMap()); // chuyen url chua parameters -> T model tuong ung
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}
		return object;
	}
}
