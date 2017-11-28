package com.common.board.util;

import java.io.*;
import java.net.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class boardUtil {
	
	/* 파일 업로드 관련 함수*/
	public static String getUniqueFileName() {
		long currentTime = System.currentTimeMillis();   
        SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateTimeString = simDf.format(new java.util.Date(currentTime));
        int randomNumber = (int)(Math.random()*100000);   
        String uniqueFileName = "" + dateTimeString + randomNumber;   
        
        return uniqueFileName;
	}
	
	public static String renameUploadFile(String uploadPath, String fileName) {
		String uniqueFileName = getUniqueFileName();
		
		File oldFile = new File(uploadPath + "\\" + fileName);
		File newFile = new File(uploadPath + "\\" + uniqueFileName);
		String newUniqueFileName="";		
		
		int count=1;
		while(newFile.exists()){
			 newUniqueFileName = uniqueFileName + "_" + count;
			 count = count + 1;
			 newFile = new File(uploadPath + "\\" + newUniqueFileName);
		 }
		 
		oldFile.renameTo(newFile);
		
		return newFile.getName();
	}

	public static void fileCopy(String filePath, String copyFilePath) throws IOException{
		File readFile = new File(filePath);
		File writeFile = new File(copyFilePath);
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(readFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(writeFile));
		
		byte[] b = new byte[4096];
		int n = 0;
		while((n = bis.read(b)) != -1) {
			bos.write(b, 0, n);
			bos.flush();
		}
		
		bis.close();
		bos.close();
		System.out.println("복사완료");
	}
	
	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		file.delete();
	}
	
	public static void downloadFile(ServletContext context, HttpServletRequest request, HttpServletResponse response, String fileName, String origfileName) {
		// TODO Auto-generated method stub
		try {
			String savePath = "upload";
			String sDownloadPath = context.getRealPath(savePath);
			String sFilePath = sDownloadPath + "\\" + fileName;
			String sCopyFilePath = sDownloadPath + "\\" + origfileName;
			
			// 파일 copy
			fileCopy(sFilePath, sCopyFilePath);
			
			// 대상파일 변경
			fileName = origfileName;
			sFilePath = sCopyFilePath;
			
			byte b[] = new byte[4096];
			FileInputStream in = new FileInputStream(sFilePath);
			String sMimeType = context.getMimeType(sFilePath);
			System.out.println("sMimeType>>>" + sMimeType);

			if (sMimeType == null)
				sMimeType = "application/octet-stream";

			response.setContentType(sMimeType);
			String agent = request.getHeader("User-Agent");
			boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);

			if (ieBrowser) {
				fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
			} else {
				fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
			}

			response.setHeader("Content-Disposition", "attachment; filename= " + fileName);

			ServletOutputStream out2 = response.getOutputStream();
			int numRead;

			while ((numRead = in.read(b, 0, b.length)) != -1) {
				out2.write(b, 0, numRead);
			}
			out2.flush();
			out2.close();
			in.close();
			
			// copy본 삭제 
			deleteFile(sCopyFilePath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
