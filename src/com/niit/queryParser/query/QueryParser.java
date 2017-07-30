package com.niit.queryParser.query;

import java.util.ArrayList;
import java.util.List;

import com.niit.queryParser.fileReader.DataFileReader;
import com.niit.queryParser.parameters.QueryParameters;
import com.niit.queryParser.restrictions.Restrictions;

public class QueryParser {

	String mainQuery,conditionSection,selectSection,whereColumn,orderBy,groupBy,filePath;
	boolean allColumns;
	QueryParameters queryParameters = new QueryParameters();
	public QueryParameters parseQuery(String query) {
		
		if(query.contains("order by"))
		{
			mainQuery=query.split("order by")[0].trim();
			orderBy=query.split("order by")[1].trim();
			filePath=mainQuery.split("from")[1].trim();
			mainQuery=mainQuery.split("from")[0].trim();
			selectSection=mainQuery.split("select")[1].trim();
			this.fieldsAnalyzer(selectSection);
			
		}
		if(query.contains("group by"))
		{
			mainQuery=query.split("group by")[0].trim();
			groupBy=query.split("group by")[1].trim();
			if(mainQuery.contains("where"))
			{
				conditionSection=mainQuery.split("where")[1].trim();
				this.conditionAnalyzer(conditionSection);
				mainQuery=mainQuery.split("where")[0].trim();			
			}
			filePath=mainQuery.split("from")[1].trim();
			mainQuery=mainQuery.split("from")[0].trim();
			selectSection=mainQuery.split("select")[1].trim();
			this.fieldsAnalyzer(selectSection);
		}
		else if(query.contains("where"))
		{
			mainQuery=query.split("where")[0];
			conditionSection=query.split("where")[1].trim();
			filePath=mainQuery.split("from")[1].trim();
			mainQuery=mainQuery.split("from")[0].trim();
			this.conditionAnalyzer(conditionSection);
			selectSection=mainQuery.split("select")[1].trim();
			this.fieldsAnalyzer(selectSection);
			
		}
		else
		{
			mainQuery=query.split("from")[0].trim();
			filePath=query.split("from")[1].trim();
			selectSection=mainQuery.split("select")[1].trim();
			this.fieldsAnalyzer(selectSection);
			
		}
		queryParameters.setFilePath(filePath);
		queryParameters.setGroupBy(groupBy);
		queryParameters.setWhereCondition(conditionSection);
		queryParameters.setOrderBy(orderBy);
		return queryParameters;	
	}

	private void conditionAnalyzer(String conditionSection) {
		List<Restrictions> restrictionList=new ArrayList<>();
		
		String relationalOperators[]=conditionSection.split("and|or");
		for(String relationCondition:relationalOperators)
		{
			Restrictions restrictions = new Restrictions();
			relationCondition=relationCondition.trim();
			String columnName = relationCondition.split("\\s*[>=|<=|!=|=|>|<]")[0].trim();
			String columnValue = relationCondition.split("\\s*[>=|<=|!=|=|>|<]")[1].trim();
			int startIndex = relationCondition.indexOf(columnName) + columnName.length();
			int endIndex = relationCondition.indexOf(columnValue);
			String operator = relationCondition.substring(startIndex, endIndex).trim();
			restrictions.setColumnName(columnName);
			restrictions.setValue(columnValue);
			restrictions.setOperator(operator);
			restrictionList.add(restrictions);
			
		}
		
		 queryParameters.setRestrictions(restrictionList);
		if(restrictionList.size()>1)
			this.logicalOperatorList(conditionSection);
	}
	
	private void logicalOperatorList(String conditionSection) {
		List<String> logicalOperatorList = new ArrayList<>();
		String checkForLogicalOperators[]=conditionSection.split(" ");
		for(String logicalOperator : checkForLogicalOperators)
		{
			if(logicalOperator.trim().equals("and") || logicalOperator.trim().equals("or"))
			{
				logicalOperatorList.add(logicalOperator);
			}
		}
		queryParameters.setLogicalOperator(logicalOperatorList);
		
	}

	

	

	private void fieldsAnalyzer(String selectSection) {
		List<String> columnsFields;
		if(selectSection.contains("*") && selectSection.length()==1)
		{
			columnsFields= new ArrayList<>();
			allColumns=true;
			queryParameters.setAllColumns(allColumns);
			columnsFields.add(selectSection);
			queryParameters.setFields(columnsFields);
		}
		else
		{
			columnsFields= new ArrayList<>();
			String columnList[]=selectSection.split(",");
			
			for(String columns:columnList)
			{
				columnsFields.add(columns.trim());
				
			}
			
			queryParameters.setFields(columnsFields);
			
		}
		
		
	}

	
}
