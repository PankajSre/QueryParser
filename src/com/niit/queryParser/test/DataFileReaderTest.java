package com.niit.queryParser.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.queryParser.fileReader.DataFileReader;
import com.niit.queryParser.parameters.QueryParameters;
import com.niit.queryParser.query.Query;
import com.niit.queryParser.query.QueryParser;

public class DataFileReaderTest {

	static QueryParser queryParser;
	static DataFileReader dataFileReader;
	String fileName="C:\\Users\\Administrator\\Desktop\\Eclipse_Oxygen\\TTTv3\\TTTv3ProjectOne\\src\\";
	@BeforeClass
	public static void init()
	{
		queryParser= new QueryParser();
		dataFileReader = new DataFileReader();
	}
	
	@Test
	public void testCSVFileData()
	{
		QueryParameters queryParameters=queryParser.parseQuery("select * from emp.csv where name=pankaj");
		Map<Integer, List<String>> fileData=dataFileReader.getDataInformation(fileName+queryParameters.getFilePath());
		Set<Integer> keySet=fileData.keySet();
		Assert.assertEquals(3, keySet.size());
	}
	
	@Test
	public void testReadFileData()
	{
		QueryParameters queryParameters=queryParser.parseQuery("select empName from emp.csv where name=pankaj");
		Map<Integer, List<String>> fileData=dataFileReader.getDataInformation(fileName+queryParameters.getFilePath());
		Set<Integer> keySet=fileData.keySet();
      
 for(Map.Entry<Integer, List<String>> listData : fileData.entrySet())
     {
    	 System.out.println(listData.getValue());
     }
		Assert.assertEquals(3, keySet.size());
	}
	
}
