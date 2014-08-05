<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="mainController">  
	<head>  
	    <title>
	   	 <tiles:insertAttribute name="title" ignore="true"/>
		</title>
		<%@ include file="../common/commonCss.jsp"%>
	</head>
	<body>
	    <tiles:insertAttribute name="header"></tiles:insertAttribute>

		<div class="left_block logo_desc" style="width:290px;">
		  <div class="content">
            <tiles:insertAttribute name="menu"></tiles:insertAttribute>
          </div>
		</div>
		
		<div class="loginform" style="margin-left: 285px; margin-top: 10px;">
               <tiles:insertAttribute name="body"></tiles:insertAttribute>
        </div>
        
        <%-- <div class="bottom_block footer footerbackground">
			<div class="content">
               <tiles:insertAttribute name="footer"></tiles:insertAttribute>
            </div>
        </div> --%>
        <div class="footer">
               <tiles:insertAttribute name="footer"></tiles:insertAttribute>
        </div>
	</body>  
</html>