package com.niit.queryParser.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.niit.queryParser.parameters.QueryParameters;
import com.niit.queryParser.query.QueryParser;
import com.niit.queryParser.restrictions.Restrictions;

public class DataFileReader {

	HeaderInformation headerInformation;
	Map<String, Integer> headerKeyValue;
	List<Integer> headerIndex;
	List<String> headerColumn;
	public Map<Integer, List<String>> getDataInformation(String fileName) {
		Map<Integer, List<String>> csvFileData = new LinkedHashMap<>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {

			bufferedReader.readLine();
			String path = "C:\\Users\\Administrator\\Desktop\\Eclipse_Oxygen\\TTTv3\\TTTv3ProjectOne\\src\\";
			QueryParser queryParser = new QueryParser();
			QueryParameters queryParameters = queryParser.parseQuery("select empName,empAddress from emp.csv where empAge>20");

			headerInformation = new HeaderInformation();
			headerKeyValue = headerInformation.getHeaderInfo(path + queryParameters.getFilePath());
			headerIndex = new ArrayList<>();
			headerColumn = new ArrayList<>();

			for (Map.Entry<String, Integer> mapKeyValue : headerKeyValue.entrySet()) {
				headerColumn.add(mapKeyValue.getKey());
				headerIndex.add(mapKeyValue.getValue());
			}
			List<String> rowSetData = null;
			
			
			if (queryParameters.isAllColumns() && queryParameters.getWhereCondition()==null) {

				String line;

				int rowCount = 0;
				while ((line = bufferedReader.readLine()) != null) {
					rowSetData = new ArrayList<>();
					String[] colInfo = line.split(",");
					for (String rowData : colInfo) {
						rowSetData.add(rowData);

					}
					csvFileData.put(rowCount, rowSetData);
					rowCount++;
				}

			} else {
				List<Integer> selectedColumnIndex = new ArrayList<>();
				List<String> selectedColumnNames = queryParameters.getFields();

				for (String headerCol : headerColumn) {
					for (String selectedColumns : selectedColumnNames) {
						if (headerCol.equals(selectedColumns)) {
							selectedColumnIndex.add(headerColumn.indexOf(headerCol));
						}
					}

				}
				if (queryParameters.getWhereCondition() == null) {
					int resultIndex = 0;
					for (int headerIndexs : headerIndex) {
						for (int columnIndex : selectedColumnIndex) {
							if (columnIndex == headerIndexs) {
								String line;
								while ((line = bufferedReader.readLine()) != null) {
									rowSetData = new ArrayList<>();

									String[] colInfo = line.split(",");
									for (int i : selectedColumnIndex) {

										rowSetData.add(colInfo[i]);

									}
									csvFileData.put(resultIndex, rowSetData);
									resultIndex++;

								}
							}
						}

					}

				} else if (queryParameters.getWhereCondition() != null) {
					System.out.println("inside where not Null");
					List<Restrictions> restrictions = queryParameters.getRestrictions();
					List<Integer> indexOfConditionColumn = new ArrayList<>();
					String operator=queryParameters.getRestrictions().get(0).getOperator();
					int value=Integer.parseInt(queryParameters.getRestrictions().get(0).getValue());
					if (queryParameters.getLogicalOperator() == null) {
                          System.out.println("logical Operator is Null");
                          
						for (String headerCol : headerColumn) {
							for (Restrictions conditionColumns : restrictions) {
								if (headerCol.equals(conditionColumns.getColumnName())) {
									indexOfConditionColumn.add(headerColumn.indexOf(headerCol));
								}
							}
						}
                         switch (operator) {
						case ">":
							int resultIndex = 0;
							for (int headerIndexs : headerIndex) {
								for (int columnIndex : selectedColumnIndex) {
									if (columnIndex == headerIndexs) {
										String line;
										while ((line = bufferedReader.readLine()) != null) {
											rowSetData = new ArrayList<>();

											String[] colInfo = line.split(",");
											for (int i : selectedColumnIndex) {
												if(Integer.parseInt(colInfo[indexOfConditionColumn.get(0)])>value)
												{
                                             
												rowSetData.add(colInfo[i]);
												}

											}
											csvFileData.put(resultIndex, rowSetData);
											resultIndex++;

										}
									}
								}

							}

							
							break;

						default:
							break;
						}
					}
				}
			}
		} catch (Exception e) {

		}

		return csvFileData;
	}

}
