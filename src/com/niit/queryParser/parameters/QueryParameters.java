package com.niit.queryParser.parameters;

import java.util.List;
import java.util.Map;

import com.niit.queryParser.restrictions.Restrictions;
import com.niit.queryParser.result.Criteria;

public class QueryParameters {

	private List<String> fields;
	private String filePath;
	private String whereCondition;
	List<Restrictions> restrictions;
	private boolean allColumns;
	private String groupBy;
	private String orderBy;
	List<String> logicalOperator;
	
	public boolean isAllColumns() {
		return allColumns;
	}
	public void setAllColumns(boolean allColumns) {
		this.allColumns = allColumns;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getWhereCondition() {
		return whereCondition;
	}
	public void setWhereCondition(String whereCondition) {
		this.whereCondition = whereCondition;
	}
	
	public List<Restrictions> getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(List<Restrictions> restrictions) {
		this.restrictions = restrictions;
	}
	public String getGroupBy() {
		return groupBy;
	}
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public List<String> getLogicalOperator() {
		return logicalOperator;
	}
	public void setLogicalOperator(List<String> logicalOperator) {
		this.logicalOperator = logicalOperator;
	}
	
	
	
}
