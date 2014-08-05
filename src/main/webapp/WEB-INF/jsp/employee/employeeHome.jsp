<%@ include file="../common/commonJs.jsp" %>

<form:form name="employeehome" id="employeehome" method="post" novalidate="novalidate" action="" ng-controller="constantsController">

<div id="rightdata" ng-controller="employeehomeController">
  <div id="topcontent" style="margin-bottom:2px;">
     	<h5>{{hometab}}</h5>
         <div class="signout">
             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
            <input type = "hidden" name = "userName" value="${userName}" />
            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
            <a href="/lms-app">Sign Out</a>
          </div>
      </div>
</div>

</form:form>




