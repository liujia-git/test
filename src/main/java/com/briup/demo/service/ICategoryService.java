package com.briup.demo.service;
/**
 * 栏目相关的Service层
 * @author zcg
 *
 */

import java.util.List;

import com.briup.demo.bean.Category;
import com.briup.demo.utils.CustomerException;

public interface ICategoryService {
	
	/**
	 * 查询所有的栏目
	 */
	public List<Category> findAllCategorys() throws CustomerException;
	
	/**
	 * 添加或修改栏目信息
	 */
	public void saveOrUpdateCategory(Category category) throws CustomerException;
	
	/**
	 * 根据id删除栏目信息
	 */
	public void deleteCategoryById(int id) throws CustomerException;
	
	/**
	 * 根据id查找指定的栏目信息
	 */
	public Category findCategoryById(int id) throws CustomerException;
}












