package cn.wyslkl.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wyslkl.o2o.dao.HeadLineDao;
import cn.wyslkl.o2o.entity.HeadLine;
import cn.wyslkl.o2o.service.HeadLineService;

@Service
public class HeadLineServiceImpl implements HeadLineService{
	@Autowired
	private HeadLineDao headLineDao;
	
	@Override
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition){
		return headLineDao.queryHeadLine(headLineCondition);
	}

}
