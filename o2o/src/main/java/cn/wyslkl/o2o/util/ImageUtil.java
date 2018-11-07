package cn.wyslkl.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.wyslkl.o2o.dto.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;


public class ImageUtil {
	private static final SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r=new Random();
	public static String generateThumbnail(ImageHolder thumbnail,String targetAddr) {
		String realFileName=getRandomFileName();
		String fileName=thumbnail.getImageName();
		InputStream thumbnailInputStream=thumbnail.getImage();
		//String realFileName="xioahuangrennew2";
		String extension=getFileExtension(fileName);
		//String extension=".jpg";
		makeDirPath(targetAddr);
		String relativeAddr=targetAddr+realFileName+extension;
		//String relativeAddr=realFileName+extension;
		File dest=new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			//Thumbnails.of(thumbnail.getInputStream()).size(200, 200)
			Thumbnails.of(thumbnailInputStream).size(200, 200)
			.outputQuality(0.8f).toFile(dest);
		}catch(IOException e) {
			throw new RuntimeException("创建缩略图失败："+e.toString());			
		}
		return relativeAddr;
	}
	
	public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
		String realFileName = ImageUtil.getRandomFileName();
		String extension = getFileExtension(thumbnail.getImageName());
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnail.getImage()).size(337, 640).outputQuality(0.5f).toFile(dest);
		} catch (IOException e) {
			throw new RuntimeException("创建缩略图失败：" + e.toString());
		}
		return relativeAddr;
	}
	
	/*
	 * 创建目标路径所涉及的目录，即/home/work/wys/xxx.jpg,
	 * 那么home work wys这三个文件夹都得自动创建
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath=PathUtil.getImgBasePath()+targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		
	}
	
	/**
	 * 获取输入文件流的扩展名
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String  fileName) {
		//String originalFileName= cFile.getOriginalFilename();
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
	 * @return
	 */
	public static String getRandomFileName() {
		// 获取随机的五位数
		int rannum=r.nextInt(89999)+10000;
		String nowTimeStr=sDateFormat.format(new Date());
		return nowTimeStr+rannum;
	}
	
	/**
	 * 如果storePath是文件则删除该文件
	 * 如果storePath是目录路径则删除该目录下的所有文件
	 * @param storePath
	 */
	public static void deleteFileOrPath(String storePath) {
		File fileOrPath=new File(PathUtil.getImgBasePath()+storePath);
		if(fileOrPath.exists()) {
			if(fileOrPath.isDirectory()) {
				File files[]=fileOrPath.listFiles();
				for(int i=0;i<files.length;i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}
	
}
