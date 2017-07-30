package com.niit.queryParser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.queryParser.fileReader.DataFileReader;
import com.niit.queryParser.parameters.QueryParameters;
import com.niit.queryParser.query.Query;
import com.niit.queryParser.result.ResultSet;

public class ResultSetTest {

	static Query query;
	static DataFileReader dataFileReader;

	
	@BeforeClass
	public static void init()
	{
		query = new Query();
		dataFileReader = new DataFileReader();
		
	}
	@Test
     public void selectAllWithoutWhereTestCase(){
		QueryParameters queryParameters=query.executeQuery("select * from C:/Scala/emp.csv");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectAllWithoutWhereTestCase",dataSet);
		
	}
	@Test
	public void selectColumnsWithoutWhereTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select City,Dept,Name from C:/Scala/emp.csv");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectColumnsWithoutWhereTestCase",dataSet);
		
	}
	@Test
	public void withWhereGreaterThanTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select City,Dept,Name from C:/Scala/emp.csv where Salary >30000");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("withWhereGreaterThanTestCase",dataSet);
		
	}
	@Test
	public void withWhereLessThanTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select City,Dept,Name from C:/Scala/emp.csv where Salary<3000");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("withWhereLessThanTestCase",dataSet);
		
	}
	@Test
	public void withWhereLessThanOrEqualToTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select City,Dept,Name from C:/Scala/emp.csv where Salary<=35000");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("withWhereLessThanOrEqualToTestCase",dataSet);
		
	}
	@Test
	public void withWhereGreaterThanOrEqualToTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select City,Dept,Name from C:/Scala/emp.csv where Salary>=35000");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("withWhereGreaterThanOrEqualToTestCase",dataSet);
		
	}
	@Test
	public void withWhereNotEqualToTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select City,Dept,Name from C:/Scala/emp.csv where Salary != 35000");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("withWhereNotEqualToTestCase",dataSet);
		
	}
	@Test
	public void withWhereEqualAndNotEqualTestCase(){
		

		QueryParameters queryParameters=query.executeQuery("select City,Name,Salary from C:/Scala/emp.csv where Salary<=38000");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("withWhereEqualAndNotEqualTestCase",dataSet);
		
	}
	@Test
	public void selectColumnsWithoutWhereWithOrderByTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select EmpId,Name,Dept from C:/Scala/emp.csv where Salary>35000");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectColumnsWithoutWhereWithOrderByTestCase",dataSet);
		
	}
    @Test
	public void selectOrderByColumnsWithWhereTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select EmpId,Name,Salary from C:/Scala/emp.csv where Salary>30000 order by Name");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectOrderByColumnsWithWhereTestCase",dataSet);
		
	}
	@Test
	public void selectOrderByWithoutWhereColumnsWithWhereTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select EmpId,Name,Salary from C:/Scala/emp.csv  order by Salary");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectOrderByWithoutWhereColumnsWithWhereTestCase",dataSet);
		
	}
	@Test
	public void selectSumColumnsWithWhereTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select sum(Salary) from C:/Scala/emp.csv");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectSumColumnsWithWhereTestCase",dataSet);
		
	}
	@Test
	public void selectCountAllColumnsTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select count(*) from C:/Scala/emp.csv");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectCountAllColumnsTestCase",dataSet);
		
	}
	@Test
	public void selectAverageSalaryColumnsTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select avg(Salary) from C:/Scala/emp.csv");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectAverageSalaryColumnsTestCase",dataSet);
		
	}
	@Test
	public void selectMinSalaryColumnsWithWhereTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select min(Salary) from C:/Scala/emp.csv");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectMinSalaryColumnsWithWhereTestCase",dataSet);
		
	}
	@Test
	public void selectMaxSalaryColumnsWithWhereTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select max(Salary) from C:/Scala/emp.csv");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectMaxSalaryColumnsWithWhereTestCase",dataSet);
		
	}
	@Test
	public void selectLogicalOperatorAndColumnsWithWhereTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select EmpId,Name,Salary from C:/Scala/emp.csv where Salary<30000 and Salary>35000");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectMaxSalaryColumnsWithWhereTestCase",dataSet);
		
	}
	@Test
	public void selectLogicalOperatorOrColumnsWithWhereTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select EmpId,Name,Salary from C:/Scala/emp.csv where Salary=35000");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectLogicalOperatorOrColumnsWithWhereTestCase",dataSet);
		
	}
   @Test
	public void selectGroupByColumnsWithWhereTestCase(){
		
		QueryParameters queryParameters=query.executeQuery("select Name,count(Salary) from C:/Scala/emp.csv group by Name");
		List<ResultSet> dataSet=dataFileReader.getDataInformation(queryParameters);
		assertNotNull(dataSet);
		display("selectGroupByColumnsWithWhereTestCase",dataSet);
		
	}
	
	
	private void display(String testCaseName, List<ResultSet> dataSet) {
		System.out.println(testCaseName);
		System.out.println("******************************************");
		List<String> resultSet;
		for(Map<Integer, String> resultData:dataSet)
		{
			if(!resultData.isEmpty())
			{
				resultSet=new ArrayList<>();
				for(Map.Entry<Integer, String> result:resultData.entrySet())
				{
					//System.out.print(result.getValue()+"  ");
					resultSet.add(result.getValue());				}
				System.out.println(resultSet);
			}
		}
		System.out.println("******************************************");
	}

}
