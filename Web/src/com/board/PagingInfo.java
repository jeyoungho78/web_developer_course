package com.board;

import java.io.*;

public class PagingInfo {
	PrintWriter out;

	public PagingInfo(PrintWriter out) {
		this.out = out;
	}
	
	public String getUnderPage(String strTotalContentCount, String strPerPageContentCount,
			String strPerPageViewPageCount, String strSelectedPage) {
		String result = "";

		int totalContentCount = Integer.valueOf(strTotalContentCount);
		int perPageContentCount = Integer.valueOf(strPerPageContentCount);
		int perPageViewPageCount = Integer.valueOf(strPerPageViewPageCount);
		int selectedPage = Integer.valueOf(strSelectedPage);

		System.out.println("totalContentCount : " + totalContentCount);
		System.out.println("perPageContentCount : " + perPageContentCount);
		System.out.println("perPageViewPageCount : " + perPageViewPageCount);
		System.out.println("selectedPage : " + selectedPage);

		// �� �������� ���ϱ�
		int totalPageCount = totalContentCount / perPageContentCount;
		int totalPageCountOverCheck = totalContentCount % perPageContentCount;

		if (totalPageCountOverCheck > 0) {
			totalPageCount = totalPageCount + 1;
		}

		// ���� �������� ������ ǥ��
		int contentStart = totalContentCount - (perPageContentCount * (selectedPage - 1));
		int contentEnd = totalContentCount - (perPageContentCount * selectedPage) + 1;

		for (int num = contentStart; num >= contentEnd; num--) {
			if (num <= 0) {
				result += "<br>";
			} else {
				result += num + "<br>";
			}
		}

		result += "<br>";

		// �ϴ��� �������� ���̴� ������ ���� ǥ��
		String pageSpace = " ";
		int underViewPageStart = 1;
		int underViewPageEnd = totalPageCount;

		if (perPageViewPageCount < totalPageCount) {
			underViewPageStart = ((selectedPage - 1) / perPageViewPageCount) * perPageViewPageCount + 1;

			// ���� �������� ��ü�������� ������ �������� �ƴ� ���
			if ((totalPageCount / perPageViewPageCount) != ((selectedPage - 1) / perPageViewPageCount)) {
				underViewPageEnd = (((selectedPage - 1) / perPageViewPageCount) + 1) * perPageViewPageCount;
			}
		}

		System.out.println("underViewPageStart : " + underViewPageStart);
		System.out.println("underViewPageEnd : " + underViewPageEnd);

		if (underViewPageStart != 1) {
			//result += "&#9664; ";
			result += "<a href=\"/RequestGetPagingInfo?totalContentCount=" + totalContentCount
					+ "&perPageContentCount=" + perPageContentCount + "&perPageViewPageCount="
					+ perPageViewPageCount + "&selectedPage=" + (underViewPageStart - 1) + "\">" + "&#9664; " + "</a>";

		}
		for (int page = underViewPageStart; page <= underViewPageEnd; page++) {
			if (page == selectedPage) {
				result += "[" + page + "] ";
			} else {
				result += "<a href=\"/RequestGetPagingInfo?totalContentCount=" + totalContentCount
						+ "&perPageContentCount=" + perPageContentCount + "&perPageViewPageCount="
						+ perPageViewPageCount + "&selectedPage=" + page + "\">" + page + "</a>" + " ";
			}
		}
		if ((perPageViewPageCount < totalPageCount) && underViewPageEnd != totalPageCount) {
			//result += " &#9654;";
			result += "<a href=\"/RequestGetPagingInfo?totalContentCount=" + totalContentCount
					+ "&perPageContentCount=" + perPageContentCount + "&perPageViewPageCount="
					+ perPageViewPageCount + "&selectedPage=" + (underViewPageEnd + 1) + "\">" + " &#9654;" + "</a>";
		}
		System.out.print(result);
		return result;
	}

}
