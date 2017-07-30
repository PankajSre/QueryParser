package com.niit.queryParser.query;

import com.niit.queryParser.parameters.QueryParameters;


public class Query {
	QueryParameters queryParameters=new QueryParameters();;
	public QueryParameters executeQuery(String query) 
	{
		if (isValidQuery(query)) 
		{
			QueryParser queryParser = new QueryParser();
			queryParser.parseQuery(query);
		} 
		else 
		{
			System.out.println("Invalid Query....Please Try Again!!!");
		}
		
		return queryParameters;
	}

	private boolean isValidQuery(String queryString) 
	{
		if(queryString.contains("select") && queryString.contains("from") || (queryString.contains("where") ||queryString.contains("order by")|| queryString.contains("group by")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
