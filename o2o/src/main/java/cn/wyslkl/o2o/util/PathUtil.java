package cn.wyslkl.o2o.util;

import java.io.File;

public class PathUtil {
	private static String seperator=System.getProperty("file.separator");
	public static String getImgBasePath() {
	/*	String os=System.getProperty("os.name");
		String basePath="";
		if(os.toLowerCase().startsWith("win")) {
			
		}else {
			basePath="/home/wys/image/";
		}
		**/
		String basePath="";
		basePath="D:/csdn/";
		basePath=basePath.replace("/", seperator);
		return basePath;
	}
	/**
	 * public static  String getShopImagePath(long shopId) {
	
		String imagePath="upload/item/shop/"+shopId+"/";
		return imagePath.replace("/", seperator);
	}
	*/
	public static String getShopImagePath(long shopId) {
		StringBuilder shopImagePathBuilder = new StringBuilder();
		shopImagePathBuilder.append("/upload/images/item/shop/");
		shopImagePathBuilder.append(shopId);
		shopImagePathBuilder.append("/");
		String shopImagePath = shopImagePathBuilder.toString().replace("/",
				seperator);
		return shopImagePath;
	}
	
	public static void deleteFile(String storePath) {
		File file = new File(getImgBasePath() + storePath);
		if (file.exists()) {
			if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			file.delete();
		}
	}

}
