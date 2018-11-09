package com.dalmia.dce.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeCalculationUtil {

	public static Map<String,String> rangeCalculation(RangeObject rangeObj){
		Map<String,String> map= new HashMap<String,String>();
		String property=rangeObj.getProperty();
		List<Integer> range=rangeObj.getRange();
		List<String> values=rangeObj.getValues();
		List<String> excludeValues=rangeObj.getExcludeValues();
		Integer i=0;
		
		if(range.size()>0) {
		 i=range.get(0);
		
		////Range
		while(i<=range.get(1)) {
		map.put(i+"",property);
		i=i+range.get(0);
		}
		}
		
		
		if(values.size()>0) {
		////Values
		i=0;
		while(i<values.size()) {
		map.put(values.get(i),property);
		i++;
		}
		}
		
		if(excludeValues.size()>0) {
		////excludeValues
		
		i=0;
		while(i<excludeValues.size()) {
		if(map.containsKey(excludeValues.get(i))) {
			map.remove(excludeValues.get(i));
		}
		i++;
		}
		}
		return map;
		
	}
	
}
