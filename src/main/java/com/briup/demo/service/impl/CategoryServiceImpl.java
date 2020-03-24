package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;
/**
 * 栏目管理相关功能逻辑实现类
 * @author zcg
 *
 */
@Service
public class CategoryServiceImpl implements ICategoryService{
	//栏目的dao
	@Autowired
	private CategoryMapper categoryMapper;
	
	//文章的dao
	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public List<Category> findAllCategorys() throws CustomerException {
		return categoryMapper.selectByExample(new CategoryExample());
	}

	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerException {
		if(category == null) {
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
		
		if(category.getId()==null) {
			categoryMapper.insert(category);
		}else {
			categoryMapper.updateByPrimaryKey(category);
		}
		
	}

	@Override
	public void deleteCategoryById(int id) throws CustomerException {
		//删除栏目的同时，需要先删除栏目中包含的文章信息。
		ArticleExample example = new ArticleExample();
		example.createCriteria().andCategoryIdEqualTo(id);
		articleMapper.deleteByExample(example);
		
		categoryMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public Category findCategoryById(int id) throws CustomerException {
		return categoryMapper.selectByPrimaryKey(id);
	}

}












