package cn.wyslkl.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wyslkl.o2o.BaseTest;
import cn.wyslkl.o2o.dto.ImageHolder;
import cn.wyslkl.o2o.dto.ProductExecution;
import cn.wyslkl.o2o.entity.Product;
import cn.wyslkl.o2o.entity.ProductCategory;
import cn.wyslkl.o2o.entity.Shop;
import cn.wyslkl.o2o.enums.ProductStateEnum;
import cn.wyslkl.o2o.exceptions.ShopOperationException;

public class ProductServiceTest extends BaseTest{
	@Autowired
	private ProductService productService;
	
	@Test
	@Ignore
	public void testAddProduct()throws ShopOperationException,FileNotFoundException{
		Product product=new Product();
		Shop shop=new Shop();
		shop.setShopId(64L);
		ProductCategory pc=new ProductCategory();
		pc.setProductCategoryId(2L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("鱼头渔粉");
		product.setProductDesc("10块一碗");
		product.setPriority(20);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		//创建缩略图文件流
		File thumbnailFile=new File("D:/csdn/女神.jpg");
		InputStream is=new FileInputStream(thumbnailFile);
		ImageHolder thumbnail=new ImageHolder(thumbnailFile.getName(),is);
		//创建两个商品详情图文件流并将他们添加到详情图列表中
		File productImg1=new File("D:/csdn/女神.jpg");
		InputStream is1=new FileInputStream(productImg1);
		File productImg2=new File("D:/csdn/xiaohuangren.jpg");
		InputStream is2=new FileInputStream(productImg2);
		List<ImageHolder> productImgList=new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(),is1));
		productImgList.add(new ImageHolder(productImg2.getName(),is2));
		//添加图片并验证
		ProductExecution pe=productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());
	}
	
	@Test
	public void testModifyProduct()throws ShopOperationException,FileNotFoundException{
		Product product=new Product();
		Shop shop=new Shop();
		shop.setShopId(64L);
		ProductCategory pc=new ProductCategory();
		pc.setProductCategoryId(2L);
		product.setProductId(5L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("鱼头渔粉");
		product.setProductDesc("10块一碗");
		product.setPriority(99);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		//创建缩略图文件流
		File thumbnailFile=new File("D:/csdn/女神.jpg");
		InputStream is=new FileInputStream(thumbnailFile);
		ImageHolder thumbnail=new ImageHolder(thumbnailFile.getName(),is);
		//创建两个商品详情图文件流并将他们添加到详情图列表中
		File productImg1=new File("D:/csdn/女神.jpg");
		InputStream is1=new FileInputStream(productImg1);
		File productImg2=new File("D:/csdn/女神.jpg");
		InputStream is2=new FileInputStream(productImg2);
		List<ImageHolder> productImgList=new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(),is1));
		productImgList.add(new ImageHolder(productImg2.getName(),is2));
		//添加图片并验证
		ProductExecution pe=productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(),pe.getState());
	}
	
	

}
