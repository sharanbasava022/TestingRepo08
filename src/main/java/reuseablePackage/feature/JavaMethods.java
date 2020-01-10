package reuseablePackage.feature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class JavaMethods {

	
	public boolean StringEquals(String actual, String expected)
	{
		boolean value=actual.equals(expected);
		return value;
	}
	
	public int ExcelRowCount(String xlPath,String sheetName) throws Exception, IOException
	{
	FileInputStream fis=new FileInputStream(xlPath);
	Workbook w1= WorkbookFactory.create(fis);
	Sheet s1=w1.getSheet(sheetName);
	int rowCount = s1.getLastRowNum();
	return rowCount;
	}


	public void MongoDBUpdate(String status,String reportRuncount, String fileName){
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		MongoDatabase database = mongo.getDatabase("collections");
		MongoCollection<Document> collection = database.getCollection("tracking");
		Document updateQuery = new Document();
		updateQuery.append("$inc",
		new Document().append("ExecutedCount",1)).append("$set",
		new Document().append("Testcases.$.status",status));
		Document searchQuery = new Document();
		searchQuery.append("RunNo", reportRuncount).append("Testcases.scriptName",fileName);
		collection.updateOne(searchQuery, updateQuery);
	}
	

	}


