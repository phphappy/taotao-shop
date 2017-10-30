/**
 * 
 */
package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
* @Title: ItemService.java
* @Package com.taotao.service
* @Description: TODO(页面跳转controller)
* @author ChenXc 
* @date 2017年10月28日 下午8:46:07
* @version V1.0   
*/
@Controller
public class PageController {
	
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
}
