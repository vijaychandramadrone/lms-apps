<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- LMS-023 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!--  Jquery Js Files -->
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
	
	<!-- Anguluar Js Files -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.min.js"></script>
	<script type="text/javascript" src="http://angular-ui.github.com/ng-grid/lib/ng-grid.debug.js"></script>
	<script type="text/javascript" src="http://oss.maxcdn.com/angular.strap/2.0.0/angular-strap.min.js"></script>
    <script type="text/javascript" src="http://www.eyecon.ro/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <!-- <script type="text/javascript" src="https://raw.github.com/SamWM/jQuery-Plugins/master/numeric/jquery.numeric.js"></script> -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsandcss/Jquery/jquery.maskedinput.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsandcss/Jquery/date.js"></script> <!-- http://code.google.com/p/datejs/ -->
	<script type="text/javascript" src="<%=request.getContextPath()%>/jsandcss/customAngularJs/controllers.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/jsandcss/ng-grid/ng-grid-csv-export.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsandcss/ng-grid/ng-grid-flexible-height.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jsandcss/angular-dialog/createDialog.js"></script>	
	
</head>
</html>