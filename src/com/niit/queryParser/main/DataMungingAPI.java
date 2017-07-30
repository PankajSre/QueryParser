package com.niit.queryParser.main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.niit.queryParser.fileReader.DataFileReader;
import com.niit.queryParser.parameters.QueryParameters;
import com.niit.queryParser.query.Query;
import com.niit.queryParser.query.QueryParser;


public class DataMungingAPI {

	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String query=scanner.nextLine();
		String fileName="C:\\Users\\Administrator\\Desktop\\Eclipse_Oxygen\\TTTv3\\TTTv3ProjectOne\\src\\";
		
		Query queryObject=new Query();
		queryObject.executeQuery(query);
		QueryParser queryParser = new QueryParser();
		
		QueryParameters queryParameters= queryParser.parseQuery(query);
		
		DataFileReader dataFileReader = new DataFileReader();
		
		Map<Integer, List<String>> rowSetData=dataFileReader.getDataInformation(fileName+queryParameters.getFilePath());
		
		for(Map.Entry<Integer, List<String>> resultSet : rowSetData.entrySet() )
		{
			
			System.out.println(resultSet.getValue());
		}
		
		
	}
}
