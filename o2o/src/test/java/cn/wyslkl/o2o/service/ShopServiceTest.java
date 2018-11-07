package cn.wyslkl.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import cn.wyslkl.o2o.BaseTest;
import cn.wyslkl.o2o.dao.ShopDao;
import cn.wyslkl.o2o.dto.ImageHolder;
import cn.wyslkl.o2o.dto.ShopExecution;
import cn.wyslkl.o2o.entity.Area;
import cn.wyslkl.o2o.entity.PersonInfo;
import cn.wyslkl.o2o.entity.Shop;
import cn.wyslkl.o2o.entity.ShopCategory;
import cn.wyslkl.o2o.enums.ShopStateEnum;
import cn.wyslkl.o2o.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;
	
	@Test
	public void testGetShopList() {
		Shop shopCondition=new Shop();
		ShopCategory sc=new ShopCategory();
		sc.setShopCategoryId(1L);
		shopCondition.setShopCategory(sc);
		ShopExecution se=shopService.getShopList(shopCondition,5,2);
		System.out.println("店铺列表数为:"+se.getShopList().size());
		System.out.println("店铺总数为："+se.getCount());
	}
	
	@Test
	@Ignore
	public void testModifyShop() throws ShopOperationException,FileNotFoundException{
		Shop shop=new Shop();
		shop.setShopId(64L);
		shop.setShopName("修改后的店铺名称");
		File shopImg=new File("D:/csdn/女神.jpg");
		InputStream is=new FileInputStream(shopImg);
		ImageHolder imageHolder=new ImageHolder("女神.jpg",is);
		ShopExecution shopExecution=shopService.modifyShop(shop,imageHolder);
		System.out.println("新的图片地址"+shopExecution.getShop().getShopImg());
		
	}
	
	@Test
	@Ignore
	public void testAddShop() throws FileNotFoundException{
		Shop shop=new Shop();	
		PersonInfo personinfo=new PersonInfo();
		Area area=new Area();
		ShopCategory shopCategory=new ShopCategory();
		personinfo.setUserId(1L);
		area.setAreaId(2L);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(personinfo);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("七杯茶");
		shop.setShopDesc("珍珠奶茶");
		shop.setShopAddr("师大瑶湖");
		shop.setPhone("13647001870");
		shop.setPriority(99);
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg=new File("D:/csdn/xiaohuangren.jpg");//D:\csdn\xiaohuangrennew.jpg
		InputStream is= new FileInputStream(shopImg);
		ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
		ShopExecution se=shopService.addShop(shop,imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(),se.getState());//D:/csdn/xiaohuangren.jpg
		
		
		
	}

}
