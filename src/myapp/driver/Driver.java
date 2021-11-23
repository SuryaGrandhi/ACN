package myapp.driver;
/**
 * This is the driver program which will be called by monitor
 * program by passing different parameters.
 * 
 *
 */
 import java.util.*;
 //import _com.driver.DriverHelper;
// import _in.driver.*;
public class Driver {
	/**
	 * Driver main program.
	 * @param args
	 */
	
	//For supporting Cname Reord
	// Write separate function for content in main
	//
	public static  _com.driver.DriverHelper h1;
	public static _in.driver.DriverHelper h2;
	public static _org.driver.DriverHelper h3;
	public static _edu.driver.DriverHelper h4;
	public static _net.driver.DriverHelper h5;
	public Driver() {
		
	}
	public static void _in_helper(String s) {
		h2.runQueries(s);
	}
public static void _com_helper(String s) {
	String re=h1.runQueries(s);
		if(re!=null) {
			if(re.toLowerCase().contains(".com")) {
			_com_helper(re);
			
			}
			else if(re.toLowerCase().contains(".in"))
			{
				_in_helper(re);
		
			}
			else if(re.toLowerCase().contains(".org")) {

				_org_helper(re);
			}
			else if(re.toLowerCase().contains(".edu")) {
           _edu_helper(re);
		
				
			}
			else if(re.toLowerCase().contains(".net")) {
            _net_helper(re);
			}
			else {
			//	System.out.println("NEED TO IMPLEMENT THIS AGAIN");
			}

		}
	}
public static void _org_helper(String s) {
	h3.runQueries(s);
}

public static void _edu_helper(String s) {
	h4.runQueries(s);
}
public static void _net_helper(String s) {
	h5.runQueries(s);
}

	public static void main(String[] args) {

	System.out.println("Enter DOMAIN NAME :");
		Scanner sc = new Scanner(System.in);
		String s=sc.next();
		if(s.toLowerCase().contains(".com")) {
			h1 = new _com.driver.DriverHelper(args);
			_com.driver.Driver d=new _com.driver.Driver();
			d.Initialization();
			h1.createBootStrapNode(16);
			h1.createNNodes(8);
			h1.insertData();
			_com_helper(s);
		//	helper.runQueries(s);
		}
		else if(s.toLowerCase().contains(".in"))
		{
			h2=new _in.driver.DriverHelper(args);
			_in.driver.Driver d=new _in.driver.Driver();
			d.Initialization();
			h2.createBootStrapNode(16);
			h2.createNNodes(8);
			h2.insertData();
			_in_helper(s);
			//help.runQueries(s);
			//System.out.println("NEED TO IMPLEMENT");
	
		}
		else if(s.toLowerCase().contains(".org")) {

			h3=new _org.driver.DriverHelper(args);
			_org.driver.Driver d=new _org.driver.Driver();
			d.Initialization();
			h3.createBootStrapNode(16);
			h3.createNNodes(8);
			h3.insertData();
			_org_helper(s);
			//help.runQueries(s);
		}
		else if(s.toLowerCase().contains(".edu")) {

	
			h4=new _edu.driver.DriverHelper(args);
			_edu.driver.Driver d=new _edu.driver.Driver();
			d.Initialization();
			h4.createBootStrapNode(16);
			h4.createNNodes(8);
			h4.insertData();
			_edu_helper(s);
			//help.runQueries(s);
		}
		else if(s.toLowerCase().contains(".net")) {

		h5=new _net.driver.DriverHelper(args);
			_net.driver.Driver d=new _net.driver.Driver();
			d.Initialization();
			h5.createBootStrapNode(16);
			h5.createNNodes(8);
			h5.insertData();
			_net_helper(s);
			//help.runQueries(s);
		}
		else {
			System.out.println("NEED TO IMPLEMENT THIS AGAIN");
		}

		return;
	}

}