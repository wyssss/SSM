package cn.wyslkl.o2o.service;

import java.util.List;

import cn.wyslkl.o2o.entity.ShopCategory;

public interface ShopCategoryService {
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);

}
