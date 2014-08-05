<%@ include file="../common/commonJs.jsp"%>

<form:form modelAttribute="ChangePasswordForm" name="changepassword" id="changepassword" method="post"  
           action="/lms-app/submitChangePassword" novalidate="novalidate" ng-controller="constantsController">

	<div id="rightdata" ng-controller="changePasswordController">
		<div id="rightcontent">
		  <h5>{{changepasswordtabs}}</h5>
		  	<div class="signout">
   			    <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
			    <a href="/lms-app">Sign Out</a>
			     <c:if test="${SucessMessage != null}">
		  		    <div class="success success-align" style="margin-left:310px;"><h4 class="textfont">${SucessMessage}</h4></div>
				 </c:if>
		  		 <c:if test="${FailureMessage != null}">
		  		    <div class="alert-error alert-error-align"><h4 class="textfont">${FailureMessage}</h4></div>
				 </c:if>
	        </div>
    		 <div class="changepasswordele"> 
					<input  type="hidden" name="userName" id="userName" value = "${userName}"/>
					<input  type="hidden" name="empName" id="empName" value = "${empName}"/>
					       
					<input  type="password" name="oldPassword" placeholder="Current Password" style="margin-left: 2px; width: 35%;" ng-model="passwordcurrent" maxlength="10" required/><br>
				      <div>
				        <span class="error" style="width: 35%;" ng-show="submitted && changepassword.oldPassword.$error.required">{{currentpasswordrequired}}</span> <!-- LMS-014 -->
				      </div>
					    <input  type="password" name="newPassword" placeholder="New Password" style="margin-left: 2px; width: 35%;" ng-model="passwordnew" ng-change="hidemeter()" maxlength="10" password-meter required/>
					  <div style="float: right; margin-right: 24.5em; margin-top: 7px;">
					    <span id="metererror">{{error}}</span>
				     </div><br>
				      <div>
				        <span class="error" style="width: 35%;" ng-show="submitted && changepassword.newPassword.$error.required">{{newpasswordrequired}}</span>
				        <span class="error" style="width: 35%;" ng-model="newpasswordlength" ng-show="newpasswordlength">{{newpasswordminlength}}</span>
				        <span class="error" ng-model="confirmerror" ng-show="confirmerror">{{confirmationpassword}}</span>
				      </div>
						      
				     <input  type="password" name="confirmNewPasswod" placeholder="Confirm Password" style="margin-left: 2px; width: 35%;" ng-model="passwordconfirm" ng-change="clearerror()" maxlength="10" required/><br>
				       <div>
				         <span class="error" style="width: 35%;" ng-show="submitted && changepassword.confirmNewPasswod.$error.required">{{confirmationpasswordrequired}}</span>
				         <span class="error" ng-model="showerror" ng-show="showerror">{{passwordmismatch}}</span>
				       </div>
						      
					  <div id="submit">
						   <input type="submit" name="submit" value="Save" ng-click="[submitted=true,savepassword(changepassword,$event)]"/>
						   <input type="reset" name="reset" style="margin-left:108px;" value="Cancel" ng-click="[submitted=false,reset()]"/>
					  </div>
			  </div>
		  </div>
	  </div>
</form:form>