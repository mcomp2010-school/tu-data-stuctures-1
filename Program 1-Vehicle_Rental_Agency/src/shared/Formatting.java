package shared;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//==============================================================
//Program 1 – Vehicle Rental Agency Program
//==============================================================
//Emanuel Rivera
//COSC 336-101
//September 22,2010
//--------------------------------------------------------------

public class Formatting {

    public static String ConvertDatetoSqlDate(String input) {
	String strDate = input;
	try {
	    SimpleDateFormat DATESource = new SimpleDateFormat("MM/dd/yy");
	    Date date = DATESource.parse(strDate);
	    SimpleDateFormat DATEFinish = new SimpleDateFormat("yyyy-MM-dd");
	    strDate = DATEFinish.format(date);
	    // System.out.println("Converted date is : " + strDate);

	} catch (ParseException pe) {
	    // System.out.println("Parse Exception : " + pe);
	    return "*ERROR*";
	}

	return strDate;
    }

    public static void main(String[] args) {
	// string containing date in one format

    }

    // //////////////////////////////////////FORMATTING
    public String STab(String Input) {
	return Input + "\t";
    }

    public String STab(String string, int fldLen) {
	int len = fldLen - string.length();
	if (len <= 0)
	    return string.substring(0, string.length());
	StringBuffer buf = new StringBuffer(fldLen);
	for (int n = 0; n < len; n++)
	    buf.append(' ');
	buf.insert(0, string);
	return new String(buf);
    }

}
