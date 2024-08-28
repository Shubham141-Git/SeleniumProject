package data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class DataReaderJson {
	
	public void getJsonDataToMap() throws IOException {
		
		File fle = new File( System.getProperty("user.dir")+"\\src\\test\\java\\data\\PurchaseOrder.json");
	
		FileUtils.readFileToString(fle);
	}

}
