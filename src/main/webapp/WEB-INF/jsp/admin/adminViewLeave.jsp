<%@ include file="../common/commonJs.jsp" %>

<form:form name="LeaveCorrectionForm" id="LeaveCorrectionForm" method="post" novalidate="novalidate" action="" ng-controller="constantsController">

	<div id="rightdata" ng-controller="leaveCorrectionController">
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{adminviewleave}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{selecteddata}} />
	            <a href="/lms-app">Sign Out</a>
	            <c:if test="${SucessMessage != null}">
	  		      <div class="success" style="margin:-45px 0 0 300px;"><h4 class="textfont">${SucessMessage}</h4></div>
			    </c:if>
	          </div>
	  </div>
	  
	  <div class="leavecorrectionleftcontent">
	       <span class="rc">{{department}}</span>
			   <select name="deptId" id="deptId">
		    		<c:forEach items="${deptList}" var="dept">
			    		<option value="${dept.id}"  selected='selected'>${dept.description} </option>
			   		</c:forEach>
				</select>
	  		<span class="rc" style="margin-left:10px;">{{employeeleavetype}}</span>
	  			<select name="leaveType" id="leaveType">
  					<c:forEach items="${leaveTypes}" var="ltype">
	       			<option value="${ltype.id}" selected='selected'>${ltype.description}</option>
	   				</c:forEach>
			</select>
	   </div>
	   <div class="leavecorrectionrightcontent">
	       <span class="rc">{{alfromdate}}</span>
			<div class="control-group input-append">
				<input name="fromDate" id="fromDate" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="ngfromdate" 
				       data-date-format="dd/mm/yyyy" data-date-days-Of-Week-Disabled =[0,6]
				       data-date-today-Highlight='true' bs-datepicker readonly ng-change="lcfromdate($event)" required/>
	           	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
	        </div>
	        <span class="rc" style="margin-left:10px;">{{altodate}}</span>
	        <div class="control-group input-append">	
				<input name="toDate" id="toDate" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="ngtodate" 
				       data-date-format="dd/mm/yyyy" data-date-days-Of-Week-Disabled =[0,6]
				       data-date-today-Highlight='true' bs-datepicker readonly ng-change="lctodate($event)" required/>
            	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
            </div>
            <input type="button" name="search" value="search" ng-click="[submitted=true,leaveCorrectionsSearch(adduser,$event)]"/>
            <span class="error" style="width: 30%; margin-left: 70px;" ng-model="fromdatereq" ng-show="fromdatereq">{{fromdaterequired}}</span>
            <span class="error" style="width: 30%; margin-left: 275px;" ng-model="todatereq" ng-show="todatereq">{{todaterequired}}</span> 
            <span class="error" style="width: 30%; margin-left: 275px;" ng-model="todategreaterfromdate" ng-show="todategreaterfromdate">{{todategreater}}</span>
	  </div>
	  
	  <div class="leaveCorrectionContent">
	        <span class="error" style="width: 30%; margin-left: 300px; margin-top: -40px; margin-bottom: 6px;" ng-model="nodata" ng-show="nodata">No Data To Display.</span> 
	       <div>
		      <div class="leaveCorrectiongridStyle" ng-grid="gridOptions"></div>
	       </div>
	  </div>
	</div>
</form:form>