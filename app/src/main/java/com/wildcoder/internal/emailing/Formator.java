package com.wildcoder.internal.emailing;

import java.util.ArrayList;

import android.util.Log;

public class Formator {
	private StringBuilder startWith;
	private StringBuilder endWith;
	private ArrayList<String> columnname;
	private StringBuilder rowValues;

	public Formator() {
		startWith = new StringBuilder();
		startWith.append("<html><head><style>table, th, td");
		startWith
				.append("{border: 1px solid black; border-collapse: collapse;}");
		startWith.append("th, td { padding: 5px;}");
		startWith.append("</style></head><body>");
		startWith.append("<table style=\"width:100%\">");

		// Define end
		endWith = new StringBuilder();
		endWith.append("</table></body></html>");
	}

	public void addColumn(String column) {
		if (columnname == null)
			columnname = new ArrayList<String>();
		columnname.add(column);
	}

	public String getHtmlTable() {
		if (columnname == null) {
			return startWith.toString() + endWith.toString();
		} else {
			String tableHeaders = "<tr>";
			for (String colum : columnname) {
				tableHeaders = tableHeaders + "<th>" + colum + "</th>";
			}
			tableHeaders = tableHeaders + "</tr>";
			if (rowValues == null) {
				return startWith.toString() + tableHeaders + endWith.toString();
			} else {
				return startWith.toString() + tableHeaders
						+ rowValues.toString() + endWith.toString();
			}
		}
	}

	public void addRowValuesRespectively(ArrayList<String> list) {
		if (list == null)
			return;
		if (columnname == null) {
			Log.e("", "Define Column first");
			return;
		}
		if (rowValues == null)
			rowValues = new StringBuilder();
		String value = "<tr>";
		for (int i = 0; i < columnname.size(); i++) {
			if (i < list.size())
				value = value + "<td>" + list.get(i) + "</td>";
		}
		value = value + "</tr>";
		rowValues.append(value);
	}

}
