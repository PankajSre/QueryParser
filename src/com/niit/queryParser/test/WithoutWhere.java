package com.niit.queryParser.test;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.queryParser.parameters.QueryParameters;
import com.niit.queryParser.query.QueryParser;

public class WithoutWhere {

	
	static QueryParser queryParser;
	
	@BeforeClass
	public static void init()
	{
	
	 queryParser = new QueryParser();
	
	}
	@Ignore
	@Test
	public void testQueryValidation()
	{
		   
       QueryParameters queryParameter=queryParser.parseQuery("select * ");
		
		
	}
	@Test
	public void testWithoutWhereQuery()////Check for * as column name
	{
		QueryParameters queryParameters= queryParser.parseQuery("select * from emp.csv where id>100");
		String params=queryParameters.getFields().get(0);
		Assert.assertEquals("*",params);
	}
	@Test
	public void testWithoutWhereNegativeQuery()//Check for not * as column name
	{
       QueryParameters queryParameter=queryParser.parseQuery("select * from emp.csv");
		String params=queryParameter.getFields().get(0);
		Assert.assertNotSame("pankaj", params);
	}
	@Test
	public void testWithWhereQuery()//Check for file name
	{
       QueryParameters queryParameter=queryParser.parseQuery("select * from emp.csv where name=pankaj");
		String params=queryParameter.getFilePath();
     
		Assert.assertEquals("emp.csv",params);
	}
	@Test
	public void testWithColumnsQuery()
	{
       QueryParameters queryParameter=queryParser.parseQuery("select name,address from emp.csv");
		String params=queryParameter.getFields().get(1);
     
		Assert.assertEquals("address",params);
	}
	@Test
	public void testWithGroupByQuery()
	{
       QueryParameters queryParameter=queryParser.parseQuery("select name,address from emp.csv where name=Pankaj group by address");
		String params=queryParameter.getGroupBy();
     
		Assert.assertEquals("address",params);
	}
	
	@Test
	public void testWithOrderByQuery()
	{
       QueryParameters queryParameter=queryParser.parseQuery("select name,address from emp.csv where name=Pankaj group by address order by name");
		String params=queryParameter.getOrderBy();
     
		Assert.assertEquals("name",params);
	}
}
