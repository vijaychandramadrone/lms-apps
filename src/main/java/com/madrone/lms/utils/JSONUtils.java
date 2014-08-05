package com.madrone.lms.utils;

import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import com.madrone.lms.form.LeaveForm;

public class JSONUtils {

	static final ObjectMapper mapper = new ObjectMapper();


	public static LeaveForm convertJsonToObjectToClass(String jsonString) {

		jsonString = jsonString.replace("[", "");
		jsonString = jsonString.replace("]", "");
		LeaveForm leaveForm = null;

		try {
			leaveForm = new ObjectMapper().readValue(jsonString,
					LeaveForm.class);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return leaveForm;
	}
	
	public static String convertListToJson(List<?> list) {
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(list);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonString;
	}
	
}
