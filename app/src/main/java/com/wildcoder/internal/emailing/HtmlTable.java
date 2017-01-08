package com.wildcoder.internal.emailing;

public class HtmlTable {
	private StringBuilder startWith;
	private StringBuilder endWith;
	private StringBuilder rowValues;

	public HtmlTable() {
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

	public String getHtmlTable() {
		if (rowValues == null) {
			return startWith.toString() + endWith.toString();
		} else {
			return startWith.toString() + rowValues.toString()
					+ endWith.toString();
		}
	}

	public void addPair(String name, String value) {
		if (rowValues == null)
			rowValues = new StringBuilder();
		rowValues
				.append("<tr><th>" + name + "</th><td>" + value + "</td></tr>");
	}
}
