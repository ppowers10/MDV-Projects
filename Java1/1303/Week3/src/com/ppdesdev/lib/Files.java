/*
 * 	project		CongressLeaders
 * 
 * 	package		com.ppdesdev.lib
 * 
 * 	@author		patrickpowers
 * 
 * 	date		Apr 18, 2013
 * 
 */
package com.ppdesdev.lib;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.util.Log;

public class Files {
	
	//storing the JSON string file
	public static Boolean storeStringFile(Context context, String fileName, String content, Boolean external){
		try {
			File file;
			FileOutputStream fos;
			if (external) {
				file = new File(context.getExternalFilesDir(null), fileName);
				fos = new FileOutputStream(file);
			}else{
				fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
			}
			fos.write(content.getBytes());
			fos.close();
		} catch (IOException e) {
			Log.e("Write Error", fileName);
		}
		return true;
	}
	
	//reading the string file
	public static String readStringFile(Context context, String fileName, Boolean external){
		String content = "";
		try {
			File file;
			FileInputStream fin;
			if (external) {
				file = new File(context.getExternalFilesDir(null), fileName);
				fin = new FileInputStream(file);
			}else{
				file = new File(fileName);
				fin = context.openFileInput(fileName);
			}
			BufferedInputStream bin = new BufferedInputStream(fin);
			byte[] contentBytes = new byte[1024];
			int bytesRead = 0;
			StringBuffer contentBuffer = new StringBuffer();
			
			while((bytesRead = bin.read(contentBytes)) != -1) {
				content = new String(contentBytes, 0, bytesRead);
				contentBuffer.append(content);
			}
			content = contentBuffer.toString();
			fin.close();
		} catch (FileNotFoundException e) {
			Log.e("Read Error", "File Not Found " + fileName);
		}catch (IOException e){
			Log.e("Read Error", "I/O Error");
		}
		return content;
	}

}
