package com.taotao.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemExample.Criterion;
import com.taotao.service.ItemService;

/**   
* @Title: ItemService.java
* @Package com.taotao.service
* @Description: TODO(用一句话描述该文件做什么)
* @author ChenXc 
* @date 2017年10月28日 下午8:46:07
* @version V1.0   
*/
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(long itemId) throws Exception {
		// TODO Auto-generated method stub
		
		TbItemExample example = new TbItemExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		itemMapper.selectByExample(example);
		
		List<TbItem> list = itemMapper.selectByExample(example);
		
		TbItem tbItem = list.get(0);
		
		return tbItem;
	}
	
	@Override
	public List<TbItem> getItemList(int pageIndex, int pageSize) throws Exception {
		
		TbItemExample example = new TbItemExample();
		
		//分页
		PageHelper.startPage(pageIndex, pageSize);
		
		List<TbItem> list = itemMapper.selectByExample(example);
		
		return list;
	}
	
}
