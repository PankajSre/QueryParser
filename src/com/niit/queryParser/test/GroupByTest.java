package com.niit.queryParser.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.queryParser.parameters.QueryParameters;
import com.niit.queryParser.query.Query;
import com.niit.queryParser.query.QueryParser;

public class GroupByTest {

	static QueryParser queryParser;
	
	@BeforeClass
	public static void init()
	{
	 queryParser = new QueryParser();	
	
	}
	//Test to check the availability of group by clause
	@Test
	public void testWithoutWhereQuery()
	{
       QueryParameters queryParameter=queryParser.parseQuery("select * from emp.csv where name=pankaj group by name");
		String params=queryParameter.getGroupBy();
		Assert.assertEquals("name",params);
	}
	//Negative test to find the availability of the group by clause
	@Test
	public void testNegativeWithoutWhereQuery()
	{
       QueryParameters queryParameter=queryParser.parseQuery("select * from emp.csv where name=pankaj group by name");
		String params=queryParameter.getGroupBy();
		Assert.assertNotSame("address",params);
	}
}
