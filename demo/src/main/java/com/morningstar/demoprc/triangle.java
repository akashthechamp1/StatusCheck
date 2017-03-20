package com.morningstar.demoprc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class triangle {
	public void draw()
	{
		System.out.println("THIS IS TRIANGLE");
	}


	/*public void afterPropertiesSet() throws Exception {
		
		// TODO Auto-generated method stub
		System.out.println("initializing bean init method called for triangle");
		
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.print("end of program");
	}*/
	public void init()
	{
		System.out.println("my own");
	}
	public void exit()
	{
		System.out.println("exit own");
	}

}
