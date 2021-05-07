package nlayeredDemo.core;

public class Rulesv {
	 public static boolean run(boolean... logics) {
    	 for(boolean b : logics) {
    		 if(!b) return false;
    	 }
    	 return true;
     }
}
