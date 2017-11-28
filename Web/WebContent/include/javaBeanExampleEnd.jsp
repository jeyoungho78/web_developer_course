<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- BeanExample beanExample = new BeanExample(); -->


<jsp:useBean id="beanExample" class="com.bean.BeanExample"></jsp:useBean>
<%-- <jsp:setProperty property="id" name="beanExample"/>
<jsp:setProperty property="passwd" name="beanExample"/> --%>

<jsp:setProperty property="*" name="beanExample"/>


<%-- id: <%=beanExample.getId() %>
<p>
passwd: <%=beanExample.getPasswd() %> --%>

id : <jsp:getProperty property="id" name="beanExample"/>
<p>
passwd : <jsp:getProperty property="passwd" name="beanExample"/>

</body>
</html>