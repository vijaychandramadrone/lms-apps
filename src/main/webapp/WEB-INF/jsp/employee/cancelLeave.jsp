<%@ include file="../common/commonJs.jsp" %>

<form:form name="cancelleave" id="cancelleave" method="post" novalidate="novalidate" action="/lms-app/submitCancelLeave" ng-controller="constantsController">

	<div id="rightdata" ng-controller="cancelleaveController" >
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{cancelleavetab}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{selecteddata}} />
	            <a href="/lms-app">Sign Out</a>
	            <c:if test="${SucessMessage != null}">
			      <div class="success success-align"><h4 class="textfont">${SucessMessage}</h4></div>
			   </c:if>
	          </div>
	  </div>
	  <div id="cancelleaveleftcontent">
	       <div id="cancelleavegrid" ng-init='init(data1=${jsonString})'>
		      <div class="cancelleavegridStyle" ng-grid="gridOptions"></div>
	       </div>
	  </div> 
	  <div id="cancelleaverightcontent">
		  <table cellpadding="4">
	        <tbody>
	          <tr>
				<td class="rc">{{employeeemail}}</td>
				<td>${EmpForm.primaryEmail}</td>
			</tr>
			<tr>
				<td class="rc">{{reportingto}}</td>
				<td>${EmpForm.reporting_to}</td>
			</tr>
			</tbody>
		  </table>
	      <div class="rc" style="margin-top:50px; padding:5px;">Reason For Cancellation:</div>
	      <textarea style="margin-left:5px; width:300px; height:100px;" ng-model="cnclreason" name="reason" required maxlength="100"></textarea>
	      <span class="error" style="width: 75%; margin-left:5px;  margin-bottom: -35px;" ng-show="submitted && cancelleave.reason.$error.required">{{cancelreasonrequired}}</span>
	      <span class="error" style="width: 75%; margin-left:5px;  margin-bottom: -35px;" ng-model="selectleavetocancel" ng-show="selectleavetocancel">{{selectleavetocncl}}</span>
	      <span class="error" style="width: 75%; margin-left:5px;  margin-bottom: -35px;" ng-model="afterleave" ng-show="afterleave">{{leavetocncl}}</span>
		  <div style="padding: 45px 3px; margin-left:5px;">
	           <input type="submit" name="submit" value="Submit" ng-click="[submitted=true,submitcancelleave(cancelleave,$event)]"/> 
	   		   <input type="reset"  style="margin-left:10px;" name="reset"   value="Cancel" ng-click="[submitted=false,resetcancelleave()]"/>
		  </div>
	  </div>
	</div>

</form:form>