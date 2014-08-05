<%@ include file="../common/commonJs.jsp" %>

<form:form modelAttribute="ForgotPasswordForm" name="forgotpasswordform" method="post"  action="/lms-app/submitForgotPassword" ng-controller="forgotPasswordController" novalidate="novalidate" >
	<div class="content" ng-controller="constantsController">
		<div class="">
		  <!-- <div class="forgotshadow">  -->
		  <div>
		    <div class="forgotcontent">
		         <div class="rc" style="text-align:center; padding:10px;"><h2>Reset your password</h2></div>
		         <p class="rc"><h4 style="text-align:center; padding:10px;">We're sorry that you are having trouble accessing your account.</h4></p>
		         <div style="margin-left:310px;">
			         <input type="email" 
									 name="userName" 
									 placeholder="Email Address" 
									 ng-model="email"
									 maxlength="30" 
									 ng-change="hideerror()"
									 required/>
									 <input type="submit" name="submit" value="Send" ng-click="[submitted=true,forgotPasswordSubmit(forgotpasswordform,$event)]"/>
									 <div>
									   <span class="error" style="width: 35%; margin-bottom: -35px;" ng-show="submitted && forgotpasswordform.userName.$error.required">{{emailrequired}}</span>
									   <span class="error" style="width: 35%; margin-bottom: -35px;" ng-show="submitted && forgotpasswordform.userName.$error.email">{{invalidemail}}</span>
									 </div>
				 </div> 
				 
				 <c:if test="${SucessMessage != null}">
	  		        <div id="success-pubilc"><h4 style="text-align:center; padding:50px; color:green;"><img style="padding-right: 3px;" src="<%=request.getContextPath()%>/jsandcss/images/check.png" alt="emailpresent"/>${SucessMessage}</h4></div>
			     </c:if>
	  		     <c:if test="${FailureMessage != null}">
	  		        <div id="error-public"><h4 style="text-align:center; padding:50px; color:red"><img style="padding-right: 3px;" src="<%=request.getContextPath()%>/jsandcss/images/button_cancel.png" alt="emailpresent"/>${FailureMessage}</h4></div>
			     </c:if>				 
		    </div>
		</div>
      </div>
	</div>
 </form:form>