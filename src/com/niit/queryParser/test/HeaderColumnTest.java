package com.niit.queryParser.test;

import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.queryParser.parameters.QueryParameters;
import com.niit.queryParser.query.Query;
import com.niit.queryParser.query.QueryParser;
import com.niit.queryParser.fileReader.HeaderInformation;

public class HeaderColumnTest {

	static HeaderInformation headerInfo;
	static QueryParser queryParser;
	
	@BeforeClass
	public static void init()
	{
		headerInfo= new HeaderInformation();
		queryParser= new QueryParser();
	}
	String fileName="C:\\Users\\Administrator\\Desktop\\Eclipse_Oxygen\\TTTv3\\TTTv3ProjectOne\\src\\";
	@Test
	public void testHeaderColumnCount()
	{
		QueryParameters queryParameters=queryParser.parseQuery("select * from emp.csv where name=pankaj");
		Map<String, Integer> headerColumns=headerInfo.getHeaderInfo(fileName+queryParameters.getFilePath());
		System.out.println(headerColumns);
		Assert.assertEquals(4, headerColumns.keySet().size());		
	}
	@Test
	public void testNegativeHeaderColumnCount()
	{
		QueryParameters queryParameters=queryParser.parseQuery("select * from emp.csv where name=pankaj");
		Map<String, Integer> headerColumns=headerInfo.getHeaderInfo(fileName+queryParameters.getFilePath());
		
		Assert.assertNotSame(3, headerColumns.keySet().size());		
	}
	@Test
	public void testHeaderColumnName()
	{  QueryParameters queryParameters=queryParser.parseQuery("select * from emp.csv where name=pankaj");
		Map<String, Integer> headerColumns=headerInfo.getHeaderInfo(fileName+queryParameters.getFilePath());
		Set<String> keys=headerColumns.keySet();
		Assert.assertEquals(true, keys.contains("empName"));		
	}
	@Test
	public void testNegativeHeaderColumnName()
	{  QueryParameters queryParameters=queryParser.parseQuery("select * from emp.csv where name=pankaj");
		Map<String, Integer> headerColumns=headerInfo.getHeaderInfo(fileName+queryParameters.getFilePath());
		Set<String> keys=headerColumns.keySet();
		Assert.assertNotSame(true, keys.contains("name"));		
	}
}
