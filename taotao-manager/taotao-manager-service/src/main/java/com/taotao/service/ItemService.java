package com.taotao.service;

import java.util.List;

import com.taotao.pojo.TbItem;

/**   
* @Title: ItemService.java
* @Package com.taotao.service
* @Description: TODO(商品管理Service)
* @author ChenXc 
* @date 2017年10月28日 下午8:46:07
* @version V1.0   
*/
public interface ItemService {
	
	/**
	 * 根据商品ID查询商品信息
	 * @param item
	 * @return
	 */
	TbItem getItemById(long itemId) throws Exception;
	
	/**
	 * 查询商品列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<TbItem> getItemList(int pageIndex, int pageSize) throws Exception;
}
