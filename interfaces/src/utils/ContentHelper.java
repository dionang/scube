package utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;

/**
*@author     PKTAN
*/

public final class ContentHelper{
	public static final String upload(File content,String path) {
		boolean foundUnique=false;
		File directory = new File(path);
		if (!directory.exists()) {
			//Files.createDirectory(directory.toPath());
			if (directory.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				if (directory.mkdirs()) {
					System.out.println("Directories is created!");
				}else{
					System.out.println("Failed to create directory!");
				}
			}
		}


		String transactionId="";
		while (!foundUnique){
			Calendar currentTime = new GregorianCalendar(TimeZone.getTimeZone("Asia/Singapore"));
			currentTime.setTimeInMillis(System.currentTimeMillis());
			long millis = currentTime.getTimeInMillis();
			transactionId = Long.toString(millis);
			File checkAvail=new File(path+transactionId);
			if (!checkAvail.exists()) {
				foundUnique=true;
			}
		}

		//subPath+=transactionId;
		path+=transactionId;

		File fileToCreate = new File(path);
		try {
			FileUtils.copyFile(content, fileToCreate);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return transactionId;
	}
} 
