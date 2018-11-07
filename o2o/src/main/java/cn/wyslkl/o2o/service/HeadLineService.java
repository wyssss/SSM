package cn.wyslkl.o2o.service;

import java.io.IOException;
import java.util.List;

import cn.wyslkl.o2o.entity.HeadLine;

public interface HeadLineService {
	/**
	 * 
	 * @param headLineCondition
	 * @return
	 * @throws IOException
	 */
	List<HeadLine> getHeadLineList(HeadLine headLineCondition)
			throws IOException;


}
