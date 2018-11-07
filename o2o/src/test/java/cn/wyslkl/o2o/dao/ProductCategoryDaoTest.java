package cn.wyslkl.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wyslkl.o2o.BaseTest;
import cn.wyslkl.o2o.entity.ProductCategory;

public class ProductCategoryDaoTest extends BaseTest{
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Test
	@Ignore
	public void testQueryByShopId() throws Exception{
		long shopId=64;
		List<ProductCategory> productCategoryList=productCategoryDao.queryProductCategoryList(shopId);
		System.out.println("�õ����Զ�����Ʒ�����Ϊ��"+productCategoryList.size());
	}
	
	@Test
	public void testBatchInsertProductCategory() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryName("��Ʒ���8");
		productCategory.setPriority(1);
		productCategory.setCreateTime(new Date());
		productCategory.setShopId(64L);
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setProductCategoryName("��Ʒ���9");
		productCategory2.setPriority(2);
		productCategory2.setCreateTime(new Date());
		productCategory2.setShopId(81L);
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		productCategoryList.add(productCategory);
		productCategoryList.add(productCategory2);
		int effectedNum = productCategoryDao
				.batchInsertProductCategory(productCategoryList);
		assertEquals(2, effectedNum);
	}

}
