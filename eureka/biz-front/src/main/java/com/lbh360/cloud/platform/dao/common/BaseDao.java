package com.lbh360.cloud.platform.dao.common;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageRowBounds;

import tk.mybatis.mapper.common.Mapper;

public abstract class BaseDao<M extends Mapper<T>, T> {
	@Autowired
	protected M mapper;

	public void setMapper(M mapper) {
		this.mapper = mapper;
	}

	public T selectOne(T entity) {
		return mapper.selectOne(entity);
	}

	public T selectByPrimaryKey(Object id) {
		return mapper.selectByPrimaryKey(id);
	}

	public List<T> select(T entity) {
		return mapper.select(entity);
	}

	public List<T> selectAll() {
		return mapper.selectAll();
	}

	public Long selectCount(T entity) {
		return new Long(mapper.selectCount(entity));
	}

	public void insert(T entity) {
		mapper.insert(entity);
	}

	public void insertSelective(T entity) {
		mapper.insertSelective(entity);
	}

	public void delete(T entity) {
		mapper.delete(entity);
	}

	public void deleteByPrimaryKey(Object id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void updateByPrimaryKey(T entity) {
		mapper.updateByPrimaryKey(entity);
	}

	public void updateByPrimaryKeySelective(T entity) {
		mapper.updateByPrimaryKeySelective(entity);
	}

	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	public int selectCountByExample(Object example) {
		return mapper.selectCountByExample(example);
	}

	List<T> selectByExample(Map<String, Object> condition) {
		return mapper.selectByExample(condition);
	}

	List<T> selectByExampleAndRowBounds(Map<String, Object> condition, PageRowBounds pageRowBounds) {
		return mapper.selectByExampleAndRowBounds(condition, pageRowBounds);
	}

}
