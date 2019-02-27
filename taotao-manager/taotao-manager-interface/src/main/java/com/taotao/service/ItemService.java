package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;

/**
 * 商品相关处理的service
 * @author YuChen_Xu
 */
public interface ItemService {
	/**
	 * 根据当前的页码和每页的行数进行分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
