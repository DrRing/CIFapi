package utils;

import common.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class custructProvider {
	public static Iterator<Object[]> custructProvider(String sheetname) {
		List<Object[]> result = new ArrayList<Object[]>();
		String pathString = "src/main/webapp/resource/testCase/0514.xlsx";
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString, sheetname);
		//Log.info(cases_list);
		Iterator it = cases_list.iterator();
		while (it.hasNext()) {
			result.add(new Object[] { it.next() });
		}
		return result.iterator();
	}
}
