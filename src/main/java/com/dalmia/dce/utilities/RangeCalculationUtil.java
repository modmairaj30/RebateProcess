package com.dalmia.dce.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalmia.dce.dao.ShemCreationDetailDao;

@Component 
public class RangeCalculationUtil {
	@Autowired
	ShemCreationDetailDao schemcreationDetaiDao;


	public  Map<String, String> rangeCalculation(RangeObject rangeObj) {
		Map<String, String> map = new HashMap<String, String>();

		String property = rangeObj.getProperty();
		String type = rangeObj.getType();
		List<String> range = rangeObj.getRange();
		List<String> values = rangeObj.getValues();
		List<String> excludeValues = rangeObj.getExcludeValues();
		int i = 0;
		
		if (type.equals("int")) {

			if (range.size() > 0) {
				
				//i = Integer.parseInt(range.get(0).toString());
				String from =range.get(0).toString();
				String to=range.get(1).toString();
				 i = Integer.valueOf(from);
				 range.get(0);
				//// Range
				while (i <= Integer.valueOf(to)){
					map.put(i + "", property);
					i = i + Integer.valueOf(from);;
				}
			}
		} else if (type.equals("str")) {
			try {
				if (range.size() > 0) {
					//ShemCreationDetailDao rangeStringDao = new ShemCreationDetailDao();
					map = schemcreationDetaiDao.getRange(property, range.get(0), range.get(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (values.size() > 0) {
			//// Values
			i = 0;
			while (i < values.size()) {
				map.put(values.get(i), property);
				i++;
			}
		}

		if (excludeValues.size() > 0) {
			//// excludeValues

			i = 0;
			while (i < excludeValues.size()) {
				if (map.containsKey(excludeValues.get(i))) {
					map.remove(excludeValues.get(i));
				}
				i++;
			}
		}
		return map;

	}

}
