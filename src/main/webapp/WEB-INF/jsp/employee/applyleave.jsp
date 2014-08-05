<%@ include file="../common/commonJs.jsp" %>

<form:form name="applyleave" id="applyleave" method="post" novalidate="novalidate" action="/lms-app/submitApplyLeave" ng-controller="constantsController">

	<div id="rightdata" ng-controller="applyLeaveController" >
	  <div id="topcontent" style="margin-bottom:2px;">
      	<h5>{{applyleavetab}}</h5>
          <div class="signout">
              <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
             <input type = "hidden" name = "userName" value="${userName}" />
             <input type = "hidden" name = "empId" value="${EmpForm.id}" />
             <input type = "hidden" name = "empName" value="${EmpForm.firstName} ${EmpForm.lastName}" />
             <a href="/lms-app">Sign Out</a>
              <c:if test="${SucessMessage != null}">
		        <div class="success success-align"><h4 class="textfont">${SucessMessage}</h4></div>
		      </c:if>
           </div>
       </div>
       <div id="applyleaveleftcontent" style="margin-top:2px;">  
		  <table cellpadding="4">
		    <tr>
			   <td><span class="rc">{{employeeleavetype}}</span></td>
		       <td><select name="leaveType">
  				  	 	<c:forEach items="${leaveTypes}" var="ltype">
       				 		<option value="${ltype.id}">${ltype.description}</option>
   						</c:forEach>
					</select></td>
	        </tr>
	        <tr>
		       	<td><span class="rc">{{alfromdate}}</span></td>
				<td>
					<div class="control-group input-append">
						<input name="fromDate" id="fromDate" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="fromdate" 
						       data-date-days-Of-Week-Disabled =[0,6] data-date-today-Highlight='true' bs-datepicker readonly ng-change="todaysdate($event)" required/>
		            	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
	               	 </div>
	               	 <input type="radio" ng-disabled="applyleave.toDate.$invalid" ng-model="fromdaygreeting" name="fromDateSession" id="fromDateSession" value="am" ng-change="selectfromGreeting($event)" checked> {{daygreeting1}} 
                     <input type="radio" ng-disabled="applyleave.toDate.$invalid" ng-model="fromdaygreeting" name="fromDateSession" id="fromDateSession" value="pm" ng-change="selectfromGreeting($event)"> {{daygreeting2}} <br/>
	            </td>
	         </tr>
	         <tr>
	    	     <td></td>
	    	     <td><span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;" ng-model="submitted" ng-show="submitted && applyleave.fromDate.$error.required">{{fromdaterequired}}</span></td>
	    	</tr>
	         <tr>
	              <td><span class="rc">{{altodate}}</span></td>
				  <td>
				  	<div class="control-group input-append">
					    <input name="toDate" id="toDate" style="background-color: #FFFFFF;" class="input-small" type="text" ng-model="todate"
					           data-date-days-Of-Week-Disabled =[0,6] data-date-today-Highlight='true' ng-disabled="applyleave.fromDate.$invalid" 
						       ng-change="[todaysdate($event)]"bs-datepicker readonly required/>
		        	    <button type="button" ng-disabled="applyleave.fromDate.$invalid" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
	               	 </div>
	               	 <!--  {{applyleave.fromdatepicker.$invalid+'nothing yet'}}-->
	               	 <input type="radio" ng-disabled="applyleave.toDate.$invalid" ng-model="todaygreeting" name="toDateSession" id="toDateSession" ng-change="selectfromGreeting($event)" value="am" > {{daygreeting1}} 
                     <input type="radio" ng-disabled="applyleave.toDate.$invalid" ng-model="todaygreeting" name="toDateSession" id="toDateSession" ng-change="selectfromGreeting($event)" value="pm" checked> {{daygreeting2}} <br/>
	              </td>
	       	</tr>
	       	<tr>
	    	     <td></td>
	    	     <td>
		    	     <span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;" ng-model="todategreaterfromdate" ng-show="todategreaterfromdate">{{todategreater}}</span>
	                 <span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;" ng-model="tofromgreeting" ng-show="tofromgreeting">{{tofromcombination}}</span>
		    	     <span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;" ng-model="submitted" ng-show="submitted && applyleave.toDate.$error.required">{{todaterequired}}</span>
	    	     </td>
	    	</tr>
	       	<tr>
		       	  <td><span class="rc">{{numberofdays}}</span></td>
	              <td><input type="text" name="noOfDays" style="width: 15%; background-color: #FFFFFF;" ng-model="days" readonly><br></td>
	       	</tr>
	       	<tr> 
	 	          <td><span class="rc">{{emergencyphone}}</span></td>
	              <td><input type="text" ng-model="ephone" name="emergencyPhone" maxlength="12" ng-change="hideerror()" num-only required/></td>
		    </tr>
		    <tr>
	    	     <td></td>
	    	     <td><span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;"  ng-model="submitted" ng-show="submitted && applyleave.emergencyPhone.$error.required">{{phonerequired}}</span>
	    	         <span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;"  ng-model="phoneminlen" ng-show="phoneminlen">{{phonenumberminlength}}</span></td>
	    	</tr>
	       	<tr> 
	 	          <td><span class="rc">{{reason}}</span></td>
	              <td><textarea style="padding: 4px 6px;" ng-model="lreason" name="reason" required maxlength="100" capitalize-first></textarea></td>
		    </tr>
		    <tr>
	    	     <td></td>
	    	     <td><span class="error" style="width: 80%; margin-top:-12px; margin-bottom:-4px;"  ng-model="submitted" ng-show="submitted && applyleave.reason.$error.required">{{leavereasonrequired}}</span></td>
	    	</tr>
		    
		  </table>
		</div>
	  
	  <div id="applyleaverightcontent" style="margin-top:2px;">
		  <div>
			  <table cellpadding="4">
		        <tbody>
		          <tr>
					<td class="rc">{{employeeid}}</td>
					<td>${EmpForm.id}</td>
				</tr>
				<tr>
					<td class="rc">{{employeeemail}}</td>
					<td>${EmpForm.primaryEmail}</td>
				</tr>
				<tr>
					<td class="rc">{{employeedesignation}}</td>
					<td>${EmpForm.designation.description}</td>
				</tr>
				<tr>
					<td class="rc">{{reportingto}}</td>
					<td>${EmpForm.reporting_to}</td>
				</tr>
				<tr>
					<td class="rc">{{joiningdate}}</td>
					
					<td><fmt:formatDate type="date" value="${EmpForm.dateOfJoin.time}"/></td> <!-- LMS-023 -->
				</tr>
		        </tbody>
		      </table>
		    </div>
			<div id="applyleavegrid" ng-init='init(data1=${jsonString}, data2=${emergencyPhone})'>
			  <div class="applyleavegridStyle" ng-grid="gridOptions"></div>
		    </div>
	  
 	  <div id="leavesubmit">
            <input type="submit" name="submit" value="Save" ng-click="[submitted=true,saveleave(applyleave,$event)]"/> 
    		<input type="reset"  style="margin-left:10px;" name="reset"   value="Cancel" ng-click="[submitted=false,resetapplyleave()]"/>
	  </div>
	  
	 </div> 
	</div>
</form:form>