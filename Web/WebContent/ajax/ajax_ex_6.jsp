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
	System.out.println("employees ù��° name = " + ((LinkedTreeMap)list.get(0)).get("name"));
	
	Gson gson = new Gson();
	
	HashMap jsonMapData = new HashMap();
	jsonMapData.put("firstName", "�浿");
	jsonMapData.put("secondName", "ȫ");
	
	System.out.println("jsonMapData��  json���� ��ȯ : " + gson.toJson(jsonMapData));
	
	ArrayList<String> alist = new ArrayList<String>();
	alist.add("firstName");
	alist.add("secondName");
	
	System.out.println("alist��  json���� ��ȯ : " + gson.toJson(alist));
	
	jsonMapData.put("list", alist);
	System.out.println("������� : " + gson.toJson(jsonMapData));
	
%>
{"name": <%=gson.toJson(alist)%>}