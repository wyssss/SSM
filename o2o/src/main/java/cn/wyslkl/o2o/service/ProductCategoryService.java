package cn.wyslkl.o2o.service;

import java.io.IOException;
import java.util.List;

import cn.wyslkl.o2o.dto.ProductCategoryExecution;
import cn.wyslkl.o2o.entity.ProductCategory;
import cn.wyslkl.o2o.entity.ShopCategory;

public interface ProductCategoryService {
	
	/**
	 * 查询指定某个店铺下的所有商品类别信息
	 * 
	 * @param long shopId
	 * @return List<ProductCategory>
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	 //List<ShopCategory> getFirstLevelShopCategoryList() throws IOException;
	/**
	 * 查询指定某个店铺下的所有商品类别信息
	 * @param shopId
	 * @return List <ProductCategory>
	 */
	List<ProductCategory> getProductCategoryList(long shopId);
	
	/**
	 * 
	 * @param productCategory
	 * @return
	 * @throws RuntimeException
	 */
	ProductCategoryExecution batchAddProductCategory(
			List<ProductCategory> productCategoryList) throws RuntimeException;
	
	/**
	 * 将此类别下的商品里的类别id置为空,再删除掉该商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws RuntimeException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId,
			long shopId) throws RuntimeException;

}
