

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="com.board.data.PagingData"%>
<%@ page import="com.board.logic.PagingLogic"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@  include file="../04/dbConnectionInfo.jsp"%>
	<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver); // 드라이버로드
			con = DriverManager.getConnection(url, userid, passwd); // 데이터베이스에 연결
			stmt = con.createStatement(); // 쿼리를 실행하기 위한 객체생성 

			String sql = "SELECT COUNT(*) AS ROWCNT FROM BOARDTEST";
			rs = stmt.executeQuery(sql);

			int rowCnt = 0;
			while (rs.next()) {
				rowCnt = rs.getInt("ROWCNT");
			}

			String totalContentCount = request.getParameter("totalContentCount");
			String perPageContentCount = request.getParameter("perPageContentCount");
			String perPageViewPageCount = request.getParameter("perPageViewPageCount");
			String selectedPage = request.getParameter("selectedPage");

			// 테스트용
			totalContentCount = String.valueOf(rowCnt);
			perPageContentCount = "10";
			perPageViewPageCount = "10";
			if (selectedPage == null) {
				selectedPage = "1";
			}

			PagingLogic pl = null;

			if (totalContentCount.equals("") || perPageContentCount.equals("") || totalContentCount.equals("")
					|| perPageViewPageCount.equals("")) {
				out.print("element is empty! please input data!");
			} else {

				PagingData pd = new PagingData();
				pd.setTotalContentCount(Integer.valueOf(totalContentCount));
				pd.setPerPageContentCount(Integer.valueOf(perPageContentCount));
				pd.setPerPageViewPageCount(Integer.valueOf(perPageViewPageCount));
				pd.setSelectedPage(Integer.valueOf(selectedPage));

				pl = new PagingLogic(pd);

				out.print("  <p> totalContentCount : " + totalContentCount + "</p>");
				out.print("  <p> perPageContentCount : " + perPageContentCount + "</p>");
				out.print("  <p> perPageViewPageCount : " + perPageViewPageCount + "</p>");
				out.print("  <p> selectedPage : " + selectedPage + "</p>");
	%>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
		</tr>
		<tr>
			<td>
				<%
					out.print(pl.getListContentNumber(stmt, rs));
				%>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<%
					out.print(pl.getUnderPagingNumber());
				%>
			</td>
		</tr>
	</table>
	<%
		 }
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} // finally
	%>
</body>
</html>