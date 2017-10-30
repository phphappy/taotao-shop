package com.taotao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**   
* @Title: ItemService.java
* @Package com.taotao.service
* @Description: TODO(用一句话描述该文件做什么)
* @author ChenXc 
* @date 2017年10月28日 下午8:46:07
* @version V1.0   
*/
@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * 根据商品ID查询商品信息
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	public TbItem getItemById(@PathVariable Long itemId) {
		
		TbItem tbItem = null;
		try {
			tbItem = itemService.getItemById(itemId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tbItem;
	}
	
	/**
	 * 获取商品列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public String getItemList(Integer pageIndex, Integer pageSize) {
		
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<TbItem> tList = itemService.getItemList(pageIndex, pageSize);
			
			PageInfo<TbItem> pageInfo = new PageInfo<>(tList);
			long count = pageInfo.getTotal();
			
			map.put("itemList", tList);
			map.put("count", count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSON.toJSONString(map);
	}
}
