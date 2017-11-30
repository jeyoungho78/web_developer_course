<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="com.google.gson.internal.LinkedTreeMap"%>
<%@ page import="java.util.*"%>
<%
	String key = request.getParameter("key");

	HashMap jsonData = new Gson().fromJson(key, HashMap.class);
	System.out.println(jsonData);
	System.out.println(jsonData.get("name"));
	
	ArrayList list = (ArrayList)jsonData.get("employees");
	System.out.println("employees 첫번째 name = " + ((LinkedTreeMap)list.get(0)).get("name"));
	
	Gson gson = new Gson();
	
	HashMap jsonMapData = new HashMap();
	jsonMapData.put("firstName", "길동");
	jsonMapData.put("secondName", "홍");
	
	System.out.println("jsonMapData를  json으로 변환 : " + gson.toJson(jsonMapData));
	
	ArrayList<String> alist = new ArrayList<String>();
	alist.add("firstName");
	alist.add("secondName");
	
	System.out.println("alist를  json으로 변환 : " + gson.toJson(alist));
	
	jsonMapData.put("list", alist);
	System.out.println("복합출력 : " + gson.toJson(jsonMapData));
	
%>
{"name": <%=gson.toJson(alist)%>}