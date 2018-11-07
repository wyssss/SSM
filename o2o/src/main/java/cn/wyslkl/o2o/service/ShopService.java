package cn.wyslkl.o2o.service;







import java.io.InputStream;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.wyslkl.o2o.dto.ImageHolder;
import cn.wyslkl.o2o.dto.ShopExecution;
import cn.wyslkl.o2o.entity.Shop;

public interface ShopService {
	/**
	 * 根据shopCondition分页返回相应店铺列表
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
	/**
	 * 通过店铺Id获取店铺信息
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	
	/**
	 * 更新店铺信息，包括对图片的处理
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopExecution modifyShop(Shop shop,ImageHolder thumbnail);
	
	
	
	/**
	 * 注册店铺信息,包括对图片的处理
	 * @param shop
	 * @param shopImg
	 * @param fileName
	 * @return
	 */
	ShopExecution addShop(Shop shop,ImageHolder thumbnail);

}
