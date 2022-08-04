package utils;

public class UtilsDAO {
	
@SuppressWarnings("unused")
private void stringUtils() {
		    throw new IllegalStateException("Utility class");
		  }	

public String capitalize(String str)
{
    if(str == null || str.length()<=1) return str;
    return str.substring(0, 1).toUpperCase() + str.substring(1);
}
}
