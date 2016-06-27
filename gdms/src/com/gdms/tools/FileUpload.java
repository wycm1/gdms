package com.gdms.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class FileUpload {
	public static void  fileupload(String fileFileName,File file)
	{
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
		String path=attrs.getRequest().getSession().getServletContext().getRealPath("upload/");
		if(file!=null)
		{
			File savefile = new File(new File(path), fileFileName);
			if (!savefile.getParentFile().exists())
			{
				savefile.getParentFile().mkdirs();
			}
			long len = file.length();
			byte[] bytes = new byte[(int)len];
			try {
				BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
				bufferedInputStream.read( bytes );
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileOutputStream fo=new FileOutputStream(savefile);
				fo.write(bytes);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
