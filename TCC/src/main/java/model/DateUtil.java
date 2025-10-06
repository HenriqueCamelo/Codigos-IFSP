package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public String traduzirMes(String data) {
	    if (data == null) return "";
	    return data.replace("jan", "Jan")
	               .replace("fev", "Feb")
	               .replace("mar", "Mar")
	               .replace("abr", "Apr")
	               .replace("mai", "May")
	               .replace("jun", "Jun")
	               .replace("jul", "Jul")
	               .replace("ago", "Aug")
	               .replace("set", "Sep")
	               .replace("out", "Oct")
	               .replace("nov", "Nov")
	               .replace("dez", "Dec");
	}
	
	public String formatarData(String data) {
		if (data == null || data.isEmpty()) return data;
		
		
		try {
			data = traduzirMes(data.replace(".", "").trim());
			SimpleDateFormat inputFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
	        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
	        return outputFormat.format(inputFormat.parse(data));
			
		} catch (Exception e) {
		    System.out.println("Erro ao converter datas: " + e.getMessage());
		    return data;
		}
	}
}
