package com.sl.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @author SL
 *
 */
/**
 * @author SL
 *
 */
public class ImageUtil {
	
	private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final Random r =new Random();
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	/**
	 * 测试加水印
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		String path = "D:\\images\\书房1.jpg";
		String desPath = "D:\\images\\new书房1.jpg";
		Thumbnails.of(path).size(200, 200)
				//.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "书房1.jpg")), 0.25f)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:/images/tujia-logo.png")), 0.25f)
				.outputQuality(0.8f).toFile("D:\\images\\new书房2_200_200.jpg");

	}
	
	
	public static String genetateThumbnail(CommonsMultipartFile thumbail,String targetAddr) {
		String realFileName = getRandomFileName();
		String extension = getFileExtension(thumbail);
		makeDirPath(targetAddr);
		
		String relativeAddr = targetAddr+ realFileName+extension;
		File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
		try {
			
			Thumbnails.of(thumbail.getInputStream()).size(400, 400)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:/images/tujia-logo.png")), 0.25f)
			.outputQuality(0.8f).toFile(dest);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}


	/**
	 * 创建目标路径所涉及到的目录, 如果目标路径为 /xxx/yyy/ddd/123/jpg
	 * 那么要判断文件夹是否存在，不存在需要创建文件夹
	 * @param targetAddr
	 */
	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath()+targetAddr;
		
		File dirPath = new File(realFileParentPath);
		if(!dirPath.exists()){
			dirPath.mkdirs();
		}
	}


	
	/**
	 * 获取输入文件流的扩展名
	 * @param thumbail
	 * @return
	 */
	private static String getFileExtension(CommonsMultipartFile cFile) {
		String originalFileName = cFile.getOriginalFilename();
		//文件名"."之后的字符
		return originalFileName.substring(originalFileName.lastIndexOf("."));
	}


	
	/**
	 * 生成图片名： yyyyMMddHHmmss + 随机数
	 * @return
	 */
	private static String getRandomFileName() {
		
		int randomNum = r.nextInt(89999)+10000;
		String nowTimeStr = sDateFormat.format(new Date());
		
		return nowTimeStr+randomNum;
	}

}
