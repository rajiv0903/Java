package com;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TestMain {

	public static void main(String[] args) throws Exception{
		
		//1510976648280
		//1510976664925
		System.out.println(System.currentTimeMillis());
		long prev = 1510976648280L;
		Thread.sleep(2000L);
		long curr = System.currentTimeMillis();
		
		long diff = curr - prev;
		System.out.println((int) (diff/(1000*60*60)));
		
		 long millisSinceEpoch = LocalDateTime.parse("2017/11/19 18:10:45", DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss"))
		            .atZone(ZoneId.of("Etc/GMT-5"))
		            .toInstant()
		            .toEpochMilli();
		 
		 System.out.println(ZoneId.getAvailableZoneIds());
		
		 diff = millisSinceEpoch - prev;
			System.out.println((int) (diff/(1000*60*60)));
			
	}
}
