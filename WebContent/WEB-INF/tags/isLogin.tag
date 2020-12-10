<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%--
HttpSession httpSession = request.getSession(false);
if(httpSession != null || httpSession.getAttribute("authUser")==null){
--%> 
<c:if test="${not empty sessionScope.authUser }">
<jsp:doBody/>
</c:if>
<%--} --%>