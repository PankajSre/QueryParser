package com.niit.queryParser.test;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import com.niit.queryParser.parameters.QueryParameters;
import com.niit.queryParser.query.QueryParser;
import com.niit.queryParser.restrictions.Restrictions;


public class WhereCustomTest {

	static QueryParser queryParser;
	
	@BeforeClass
	public static void init()
	{
		queryParser= new QueryParser();
		
	}
	//Test to check for column name in where condition
	@Test
	public void testWhereColumns()
	{
		QueryParameters queryParameters= queryParser.parseQuery("select * from emp.csv where name=pankaj and age>10");
		Restrictions restrictions=queryParameters.getRestrictions().get(1);
		
		Assert.assertEquals("age",restrictions.getColumnName());
		
	}
	//Test to check for operator in where condition
	@Test
	public void testWhereOperatorColumns()
	{
		QueryParameters queryParameters= queryParser.parseQuery("select * from emp.csv where name=pankaj and age>10");
		List<Restrictions> whereCustom=queryParameters.getRestrictions();
		
		Assert.assertEquals("=", whereCustom.get(0).getOperator());
		
	}
	//Test to check column value in where condition
	@Test
	public void testWhereValueColumns()
	{
		QueryParameters queryParameters= queryParser.parseQuery("select * from emp.csv where name=pankaj and age>10");
		List<Restrictions> whereCustom=queryParameters.getRestrictions();
		
		Assert.assertEquals(">", whereCustom.get(1).getOperator());
		
	}
	
	
}
