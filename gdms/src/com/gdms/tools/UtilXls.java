package com.gdms.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class UtilXls {
	public static File WriteXls(String fileName, Map<String, List> map) {
		File file = new File(fileName);
		WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		WritableSheet sheet = workbook.createSheet("sheet", 0);
		List list1 = null;
		for (Map.Entry<String, List> entry : map.entrySet()) {
			// System.out.println(entry.getKey()+"--->"+entry.getValue());
			list1 = entry.getValue();
			if (list1 != null) {
				break;
			}
		}
		Label label[] = new Label[map.size() * list1.size()];
		System.out.println(map.size() * list1.size());
		int j = 0;
		int k = 0;
		for (Map.Entry<String, List> entry : map.entrySet()) {
			label[k++] = new Label(j, 0, entry.getKey());
			j++;
		}
		j = 0;
		int m = 1;
		for (Map.Entry<String, List> entry : map.entrySet()) {
			for (int l = 1; l < entry.getValue().size(); l++) {
				label[k++] = new Label(j, m++, (String) entry.getValue().get(l));
			}
			j++;
			m = 1;
		}
		for (int i = 0; i < label.length; i++) {
			try {
				sheet.addCell(label[i]);
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			workbook.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	/**
	 * 传入workbook对象，返回一个Map<String,String[]> key为每行第一个的值，值为这一列的其余的值
	 * @param workbook
	 * @return
	 */
	public static Map<String,String[]> xlsToMap(Workbook workbook) {
		Sheet sheet = workbook.getSheet(0);
		String[] heads = new String[sheet.getColumns()];
		List<String[]> contentsList = new ArrayList();
		Map map = new HashMap();
		for (int i = 0; i < sheet.getColumns(); i++) {
			heads[i] = sheet.getCell(i, 0).getContents();
		}
		for (int i = 0; i < sheet.getColumns(); i++) {
			String[] cols = new String[sheet.getRows()-1];
			for (int j = 1; j < sheet.getRows(); j++) {
				cols[j-1] = sheet.getCell(i, j).getContents();
			}
			contentsList.add(cols);
		}
//		if(heads.length==contentsList.size())
		for(int j=0; j< heads.length; j++){
			map.put(heads[j],contentsList.get(j));
		}
		return map;
	}
	public static void main(String argv[]) throws Exception{
		Workbook workbook = Workbook.getWorkbook(new File("D:\\2015书费情况.xls"));
		Map map = xlsToMap(workbook);
		System.out.println(map.size());
		System.out.println("执行");
	}
}
