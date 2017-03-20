package com.morningstar.demoprc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class beanpostdi implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object postProcessBeforeInitialization(Object BEAN, String NAME) throws BeansException {
	System.out.println("INSIDE BIN INITIALIZATION AND BEAN NAME IS "+NAME);
	
		// TODO Auto-generated method stub
		return null;
	}

}
