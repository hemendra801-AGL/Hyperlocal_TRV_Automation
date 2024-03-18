package org.trvConfigs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

public class ConfigReader {

	public Properties pr;

	final String prfilepath="C://Users//AGL//eclipse-workspace//Hyperlocal_TRV_Automation//src//main//java//org//trvConfigs//config.properties";

	public ConfigReader() 
	{
		BufferedReader br;
		try 
		{
			br=new BufferedReader(new FileReader(prfilepath));
			pr=new Properties();
			try
			{
				pr.load(br);
				br.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Properties file not found "+ prfilepath);
		}		
	}

	public String getDataFromConfig(String testdata)
	{
		String get_Data = pr.getProperty(testdata);    
		if(get_Data!=null)
			return get_Data;
		else throw new RuntimeException("Mobile No not found in the config file");		
	}

	public String getLocalSystemName() throws Exception {
		InetAddress localHost = InetAddress.getLocalHost();
		String deviceName = localHost.getHostName();
		return deviceName;
	}
}

