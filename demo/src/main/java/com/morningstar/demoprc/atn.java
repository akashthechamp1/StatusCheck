package com.morningstar.demoprc;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class atn {
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		WebDriver d  = new FirefoxDriver();
		d.get("https://myhris.adrenalin.in/myadrenalin/login.aspx");
		WebElement email=d.findElement(By.id("txtID"));
		WebElement pwd=d.findElement(By.id("txtPwd"));
		WebElement comp=d.findElement(By.id("txtCompName"));
		WebElement hidden=d.findElement(By.id("hdntxtPwd"));
		WebElement press=d.findElement(By.id("LocalizedButton1"));
		email.sendKeys("WDA-04992");
		
		pwd.sendKeys("Samsung101b*");
		
		comp.sendKeys("MSTAR");
		press.click();
		
	WebElement zolog=d.findElement(By.id("txtName"));
		WebElement sub=d.findElement(By.id("btnSubmit"));
		zolog.sendKeys("Clock in Clock out status");
		sub.click();
		  
		
		
		
		//date
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String m=new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime());
		Format formatter = new SimpleDateFormat("yyyy-MMM-dd");
	    String today = formatter.format(new Date());
	    
	    System.out.println( today);
	   String begindate="", enddate;
	   enddate=today;
	   if(m.equals("Mon"))
	   {
		   int daysToDecrement = 0;
		   calendar.add(Calendar.DATE, daysToDecrement);
		   date = calendar.getTime();
		   String today1 = formatter.format(date);
		   begindate=today1;
	   }
	   if(m.equals("Tue"))
	   {
		   int daysToDecrement = -1;
		   calendar.add(Calendar.DATE, daysToDecrement);
		   date = calendar.getTime();
		   String today1 = formatter.format(date);
		    System.out.println( today1);
		    begindate=today1;
	   }
	   if(m.equals("Wed"))
	   {
		   int daysToDecrement = -2;
		   calendar.add(Calendar.DATE, daysToDecrement);
		   date = calendar.getTime();
		   String today1 = formatter.format(date);
		    System.out.println( today1);
		    begindate=today1;
	   }
	   if(m.equals("Thu"))
	   {
		   int daysToDecrement = -3;
		   calendar.add(Calendar.DATE, daysToDecrement);
		   date = calendar.getTime();
		   String today1 = formatter.format(date);
		    System.out.println( today1);
		    begindate=today1;
	   }
	   if(m.equals("Fri"))
	   {
		   int daysToDecrement = -4;
		   calendar.add(Calendar.DATE, daysToDecrement);
		   date = calendar.getTime();
		   String today1 = formatter.format(date);
		    System.out.println( today1);
		    begindate=today1;
	   }
	 

       Thread.sleep(30000);
	   d.findElement(By.id("DP_FROM_DATE_popupButton")).click();

	  
	  
	
	
}}

