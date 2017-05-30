	package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	FileInputStream fis ;
	Properties pro ;
	public ConfigDataProvider(){
		
		File src = new File(System.getProperty("user.dir")+"/Configuration/config.properties");
		
		try {
			 fis = new FileInputStream(src);
			
			 pro = new Properties();
			
			
				pro.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Unable to load the file");
			System.out.println("The exception message is "+e.getMessage());
		}
	}

	
	public String getValue(String Key)

	{
		
		
		return pro.getProperty(Key);
	}
	

	
	
	
}
