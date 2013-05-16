package com.ckt.coffer;

public interface ObjectInterface {
	//restore the data to target
	public void syncToTarget();
	public void fileToTarget();
	
	//save the data to this app
	public void syncToFile();
	public void syncToCoffer();

}
