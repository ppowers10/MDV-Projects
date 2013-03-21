package com.ppdesdev.lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.util.Log;

public class Files {
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
	
	public static Boolean storeObjectFile(Context context, String fileName, Object content, Boolean external){
		try {
			File file;
			FileOutputStream fos;
			ObjectOutputStream oos;
			if (external) {
				file = new File(context.getExternalFilesDir(null), fileName);
				fos = new FileOutputStream(file);
			}else{
				fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
			}
			oos = new ObjectOutputStream(fos);
			oos.writeObject(fos);
			oos.close();
			fos.close();
		} catch (IOException e) {
			Log.e("Write Error", fileName);
		}
		
		return true;
	}
}
