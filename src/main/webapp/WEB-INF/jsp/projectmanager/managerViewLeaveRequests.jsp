<%@ include file="../common/commonJs.jsp" %>

<form:form name="viewleavereq" ng-model="ngviewleavereq" id="viewleavereq" method="post" novalidate="novalidate"  ng-controller="constantsController">

	<div id="rightdata" ng-controller="ViewLeaveRequestsController" >
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{viewleaverequest}}</h5>
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
	    <div id="viewleaverequestcontent">
		 <div class="leavesummaryContent">  
	       <div ng-init='init(data1=${jsonString})'>
		      <div class="viewleaverequestgridStyle" ng-grid="gridOptions"></div>
	       </div>
	     </div>
		    <div id="viewleaverequestleftcontent">
		      <div class="viewleaverequestgridStyle1" ng-grid="gridOptions1"></div>
	       </div> 
	       <div id="viewleaverequestrightcontent">
		      <div class="rc">{{viewleaverequestcomment}}</div>
		      <textarea style="margin-left:5px; width:300px; height:60px;" ng-model="ngcomments" name="reason" required maxlength="100"></textarea>
		      <span class="error" style="width: 65%; margin-left:5px;" ng-show="submitted && viewleavereq.reason.$error.required">{{viewleaverequestcommentrequired}}</span>
		      <span class="error" style="width: 65%; margin-left:5px;" ng-model="selectleavetoapprove" ng-show="selectleavetoapprove">{{viewleaverequestapprove}}</span>
		      <span class="error" style="width: 65%; margin-left:5px;" ng-model="selectleavetoreject" ng-show="selectleavetoreject">{{viewleaverequestreject}}</span>
			 <div style="margin-top:7px; margin-left:5px;">
		           <input type="button" name="approveBtn" value="Approve" 
		           	      ng-click="[submitted=false,approveleave(viewleavereq,$event),approveBtnClick()]"/> 
		   		   <input type="button" name="rejectBtn"  value="Reject" style="margin-left:10px;"    
		   		          ng-click="[submitted=true,rejectleave(viewleavereq,$event),rejectBtnClick()]"/>
			  </div>
		  </div>
	  </div>
	</div>
</form:form>