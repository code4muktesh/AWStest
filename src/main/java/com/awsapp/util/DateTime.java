package com.awsapp.util;


import java.util.*;
import java.text.*;

public class DateTime {

	
	public static String getCurrentDateTimeForMySQL(){
	java.util.Date dt = new java.util.Date();

java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return sdf.format(dt);
	}

	
	
}
