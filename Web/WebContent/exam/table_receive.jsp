<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <% Enumeration<String> enumer = request.getParameterNames();
	    String name = "";
	    String value = "";
	    
		while(enumer.hasMoreElements()){
			name = enumer.nextElement();        // "randomNum" , "spaceCellCnt"
			value = request.getParameter(name); //  13         , 3
			
			if(name.equals("randomNum")){
				int randomNum = Integer.valueOf(value);
				String url = "";
				
				if(randomNum % 4 == 0){
					url = "./table_receive2.jsp";
				} else {
					url = "./table.jsp";
				}
				
				request.setAttribute(name, value);
				RequestDispatcher dis = request.getRequestDispatcher(url);
				dis.forward(request, response);
	 %>
	   	<p> key : <%=name %>&nbsp;&nbsp;value : <%=value %>
	 <% 	}
		} %>
	 
	 <%-- <p><p>
	 <% Map<String, String[]> map = request.getParameterMap();
	    String key = "";
	    String[] values = null;   
	 
	 	Set<String> keyset = map.keySet();
	    Iterator<String> itr = keyset.iterator();
	    while(itr.hasNext()){
	    	key = (String)itr.next();
	    	values = (String[])map.get(key);
	    	
	    	for(String val : values){
	  %>
	  		<p> key : <%=key %>&nbsp;&nbsp;value : <%=val %>
	  <%  	}
	    }
	 %> --%> 
	
</body>
</html>