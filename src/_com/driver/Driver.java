package _com.driver;
/**
 * This is the driver program which will be called by monitor
 * program by passing different parameters.
 * 
 *
 */
 import java.util.*;
 
public class Driver {
	/**
	 * Driver main program.
	 * @param args
	 */
	public Driver(){
		
	}
	public void  Initialization() {
		de.uniba.wiai.lspi.chord.service.PropertiesLoader.loadPropertyFile();
		
		int successor_list_size =1;
		
		double stabalization_delay_float = 2; 
		
		double fix_finger_delay_float = 2; 
	
		double check_pre_delay_float = 1; 
		System.setProperty("de.uniba.wiai.lspi.chord.service.impl.ChordImpl.StabilizeTask.interval",
				"" + (int)(stabalization_delay_float*10));
		System.setProperty("de.uniba.wiai.lspi.chord.service.impl.ChordImpl.FixFingerTask.interval",
				"" + (int)(fix_finger_delay_float*10));
		System.setProperty("de.uniba.wiai.lspi.chord.service.impl.ChordImpl.CheckPredecessorTask.interval",
				"" + (int)(check_pre_delay_float*10));
		System.setProperty("de.uniba.wiai.lspi.chord.service.impl.ChordImpl.successors", "" + successor_list_size);
		// Create BootStrap Node
	}
	public void _IP1_Helper(_IP1.driver.DriverHelper d,String s) {
		d.runQueries(s);
	}
public void _IP2_Helper(_IP2.driver.DriverHelper d,String s) {
		d.runQueries(s);
	}
	public void _LEVEL3_Helper(int n,String s) {
		if(n==1) {
			_IP1.driver.DriverHelper helper = new _IP1.driver.DriverHelper();
			//_IP1.driver.Driver d=new _IP1.driver.Driver();
			//d.Initialization();
			helper.createBootStrapNode(16);
			helper.createNNodes(8);
			helper.insertData();
			_IP1_Helper(helper, s);
		//	helper.runQueries(s);
		}
		else if(n==2)
		{
			_IP2.driver.DriverHelper help=new _IP2.driver.DriverHelper();
		//	_in.driver.Driver d=new _in.driver.Driver();
			//d.Initialization();
			help.createBootStrapNode(16);
			help.createNNodes(8);
			help.insertData();
			_IP2_Helper(help,s);
			//help.runQueries(s);
			//System.out.println("NEED TO IMPLEMENT");
	
		}
//		else if(s.toLowerCase().contains(".org")) {
//
//			_org.driver.DriverHelper help1=new _org.driver.DriverHelper(args);
//			_org.driver.Driver d=new _org.driver.Driver();
//			d.Initialization();
//			help1.createBootStrapNode(16);
//			help1.createNNodes(8);
//			help1.insertData();
//			_org_helper(help1,s);
//			//help.runQueries(s);
//		}
//		else if(s.toLowerCase().contains(".edu")) {
//
//	
//			_edu.driver.DriverHelper help2=new _edu.driver.DriverHelper(args);
//			_edu.driver.Driver d=new _edu.driver.Driver();
//			d.Initialization();
//			help2.createBootStrapNode(16);
//			help2.createNNodes(8);
//			help2.insertData();
//			_edu_helper(help2,s);
//			//help.runQueries(s);
//		}
//		else if(s.toLowerCase().contains(".net")) {
//
//			_net.driver.DriverHelper help3=new _net.driver.DriverHelper(args);
//			_net.driver.Driver d=new _net.driver.Driver();
//			d.Initialization();
//			help3.createBootStrapNode(16);
//			help3.createNNodes(8);
//			help3.insertData();
//			_net_helper(help3,s);
//			//help.runQueries(s);
//		}
		else {
			System.out.println("NEED TO IMPLEMENT THIS AGAIN");
		}

	}
	public void LEVEL3_HELPER() {
		
	}
	public static void main(String[] args) {

		}
}