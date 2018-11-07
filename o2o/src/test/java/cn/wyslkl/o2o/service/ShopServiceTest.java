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
		System.out.println("�����б���Ϊ:"+se.getShopList().size());
		System.out.println("��������Ϊ��"+se.getCount());
	}
	
	@Test
	@Ignore
	public void testModifyShop() throws ShopOperationException,FileNotFoundException{
		Shop shop=new Shop();
		shop.setShopId(64L);
		shop.setShopName("�޸ĺ�ĵ�������");
		File shopImg=new File("D:/csdn/Ů��.jpg");
		InputStream is=new FileInputStream(shopImg);
		ImageHolder imageHolder=new ImageHolder("Ů��.jpg",is);
		ShopExecution shopExecution=shopService.modifyShop(shop,imageHolder);
		System.out.println("�µ�ͼƬ��ַ"+shopExecution.getShop().getShopImg());
		
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
		shop.setShopName("�߱���");
		shop.setShopDesc("�����̲�");
		shop.setShopAddr("ʦ������");
		shop.setPhone("13647001870");
		shop.setPriority(99);
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("�����");
		File shopImg=new File("D:/csdn/xiaohuangren.jpg");//D:\csdn\xiaohuangrennew.jpg
		InputStream is= new FileInputStream(shopImg);
		ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
		ShopExecution se=shopService.addShop(shop,imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(),se.getState());//D:/csdn/xiaohuangren.jpg
		
		
		
	}

}
