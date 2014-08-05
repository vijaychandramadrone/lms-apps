<script type="text/javascript">
        function doAjaxPost() {
        // get the form values
        var role = $('#role').val();
        $.ajax({
	        type: "POST",
	        url: location.protocol + "//" + location.host+"/lms-app/FindReportingPersonList",
	        data: "role=" + role,
	        success: function(response) {
	        	if(response.status == "SUCCESS") {
	        		var optionsAsString = "";
	        		 $('select[name="reportingto"]' ).empty();
	                for(i =0 ; i < response.result.length ; i++) {
	        		  optionsAsString = "<option value='" + response.result[i].empId + "'>" + response.result[i].empName + "</option>";
	        		  $( 'select[name="reportingto"]' ).append( optionsAsString );
	        		 }
	             }
		        },
	        error: function(e){
	        	alert('Error: ' + e);
	        	}
       		 });
        }
 </script>


<%@ include file="../common/commonJs.jsp" %>

<form:form name="adduser" id="adduser" method="post" novalidate="novalidate" action="/lms-app/submitAdduser" ng-controller="constantsController">

	<div id="rightdata" ng-controller="adduserController">
	  <div id="topcontent" style="margin-bottom:2px;">
	     	<h5>{{adminadduser}}</h5>
	         <div class="signout">
	             <h5>${EmpForm.firstName} ${EmpForm.lastName}</h5>
	            <input type = "hidden" name = "userName" value="${userName}" />
	            <input type = "hidden" name = "empId" value="${EmpForm.id}" />
	            <input type = "hidden" name = "selecteddata" value ={{mySelections}} />
	            <a href="/lms-app">Sign Out</a>
	            <c:if test="${SucessMessage != null}">
			       <div class="success" style="margin:-45px 0 0 300px;"><h4 class="textfont">${SucessMessage}</h4></div>
			    </c:if>
			    <c:if test="${FailureMessage != null}">
			       <div class="alert-error" style="margin:-45px 0 0 300px;"><h4 class="textfont">${FailureMessage}</h4></div>
			    </c:if>
	          </div>
	  </div>
	  <div id="adminleftcontent">
	   <table>
	    <tbody>
	      <tr><td><span class="rc">{{firstname}}</span></td>
	          <td><input type="text" name="firstname" ng-model="ngfirstname" maxlength="20" width-reducer char-only required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td> 
    	     </td>
	     </tr>
	      <tr><td><span class="rc">{{lasttname}}</span></td>
	          <td><input type="text" name="lastname" ng-model="nglastname" maxlength="20" width-reducer char-only required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	     </td>
	     </tr>
	     <tr><td><span class="rc">{{empid}}</span></td>
	          <td><input type="text" name="newEmpId" ng-model="ngempid" maxlength="5" ng-init="ngempid=${maxEmpId}" num-only width-reducer required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	     </td>
	     </tr>
	      <tr><td><span class="rc">{{employeeemail}}</span></td>
	          <td><input type="email" name="email" ng-model="ngemail" maxlength="30" width-reducer required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
	    	     <span class="error" style="width: 85%;margin-top:-5px; margin-bottom:4px;" ng-show="submitted && adduser.email.$error.email">{{invalidemail}}</span>
    	     </td>
	     </tr>
	      <tr><td><span class="rc">{{contact}}</span></td>
	          <td><input type="text" name="phone" ng-model="ngphone" ng-change="hideerror()" maxlength="12" width-reducer num-only required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	       <span class="error" style="margin-bottom: 4px; margin-top: -5px; width: 85%;"  ng-model="phoneminlen" ng-show="phoneminlen">{{phonenumberminlength}}</span></td>
    	     </td>
	     </tr>
	      <tr><td><span class="rc">{{admpassword}}</span></td>
	          <td><input type="password" name="password" ng-model="ngpassword" maxlength="10" ng-minlength="7" width-reducer required/>
	      </tr>
	      <tr>
    	     <td></td>
    	     <td>
    	       <span class="error" style="width: 85%; margin-top:-5px; margin-bottom:4px;" ng-show="submitted && adduser.password.$error.minlength">{{newpasswordminlength}}</span>
    	     </td>
	     </tr>
       	 <tr><td><span class="rc">{{secemail}}</span></td>
	   			 <td><input type="email" name="secemail"  maxlength="30" ng-model="ngsecemail" width-reducer/>
		 </tr>
	     <tr>
	  	 <td></td>
 			<td>
 			  <span class="error" style="width: 85%;margin-top:-5px; margin-bottom:4px;" ng-show="submitted && adduser.secemail.$error.email">{{invalidemail}}</span>
 			</td>
		 </tr>
	     
	    </tbody>
	   </table>
	  </div>
	  <div id="adminmiddlecontent">
		   <table>
		   	 <tbody>
		   	         <tr>
				       	<td><span class="rc">{{joiningdate}}</span></td>
						<td>
							<div class="control-group input-append">
								<input name="dateofjoin" id="dateofjoin" style="background-color: #FFFFFF; width:115px" class="input-small" type="text" ng-model="dateofjoin" 
								       data-date-format="dd/mm/yyyy" data-date-today-Highlight='true' bs-datepicker readonly ng-change="olddate($event)" required/>
				            	<button type="button" class="btn" data-toggle="datepicker"><i class="icon-calendar"></i></button>
			               	 </div>
			            </td>
			          </tr>
			          <tr>
			    	     <td></td>
			    	     <td>
				    	    <span class="error" style="width: 105%; margin-top:-5px; margin-bottom:4px;" ng-model="dateishigher" ng-show="dateishigher">{{joindateincorrect}}</span> 
			    	     </td>
				     </tr>
		   	         <tr><td><span class="rc">{{employeedesignation}}</span></td>
	          			 <td><select name="desig" style="width:165px;">
      						<c:forEach items="${desiglist}" var="desig">
	       						<option value="${desig.id}">${desig.description}</option>
	   						</c:forEach>
				</select>
			</td>
	      			 </tr>
	                 <tr>
    	     			<td></td>
    	     			<td>
    	     			</td>
	     			 </tr>
				   	 <tr>
					   <td><span class="rc">{{department}}</span></td>
				       <td><select name="dept" style="width:165px;">
	      					<c:forEach items="${deptlist}" var="dept">
		       					<option value="${dept.id}">${dept.description}</option>
		   					</c:forEach>
						</select>
			</td>
				      </tr>
				     <tr><td><span class="rc">{{role}}</span></td>
				            <td><select name="role" id="role" onchange="doAjaxPost()" style="width:165px;">
  				  	 		<c:forEach items="${rolelist}" var="role">
       				 			<option value="${role.id}">${role.description}</option>
   							</c:forEach>
							</select></td>
				      </tr>
				      <tr>
			    	     <td></td>
			    	     <td>
			    	     </td>
				     </tr>
				     <tr><td><span class="rc">{{reportingto}}</span></td>
				            <td><select name="reportingto" id="reportingto" style="width:165px;">
  				  	 		<c:forEach items="${repolist}" var="report">
       				 			<option value="${report.empId}">${report.empName}</option>
   							</c:forEach>
							</select></td>
				      </tr>
				      <tr>
			    	     <td></td>
			    	     <td>
			    	     </td>
				     </tr>
				      <tr><td><span class="rc">{{address}}</span></td>
				          <td><textarea style="padding: 4px 6px; height:70px;" ng-model="ngaddress" name="address" id="address" 
				          width-reducer required maxlength="100"></textarea></td>
				      </tr>
				      <tr>
			    	     <td></td>
			    	     <td> 
			    	     </td>
				     </tr>
		    </tbody>
		</table>
	</div>
	<div id="adminrightcontent">
		<table>
			<tbody>
				<tr><td><span class="rc">{{city}}</span></td>
		            <td><input type="text" name="city" ng-model="ngcity" maxlength="20" width-reducer char-only required/>
			    </tr>
			    <tr>
		    	    <td></td>
		    	    <td>
		    	    </td>
			    </tr>
			    <tr><td><span class="rc">{{state}}</span></td>
			        <td><input type="text" name="state" ng-model="ngstate" width-reducer char-only required/>
			    </tr>
			    <tr>
		    	    <td></td>
		    	    <td>
		    	    </td>
			    </tr>
			    <tr><td><span class="rc">{{pincode}}</span></td>
			        <td><input type="text" name="pincode" ng-model="ngpincode" maxlength="6" ng-change="hideerror()" width-reducer num-only required/>
			    </tr>
			    <tr>
		    	    <td></td>
		    	    <td>
		    	      <span class="error" style="width: 80%; margin-bottom:-4px;"  ng-model="pinminlen" ng-show="pinminlen">{{pinlength}}</span>
		    	    </td>
			    </tr>
			    <tr>
		    	    <td></td>
		    	    <td>
		    	    <span class="error" style="width: 80%; margin-top:35px;  margin-bottom: -80px;" ng-model="submitted" ng-show="((submitted && adduser.firstname.$error.required) || (submitted && adduser.lastname.$error.required) ||
		    	                                                                                                            (submitted && adduser.email.$error.required) || (submitted && adduser.password.$error.required) ||
		    	                                                                                                            (submitted && adduser.dateofjoin.$error.required) || (submitted && adduser.designation.$error.required) ||
		    	                                                                                                            (submitted && adduser.address.$error.required) || (submitted && adduser.city.$error.required) ||
		    	                                                                                                            (submitted && adduser.state.$error.required) || (submitted && adduser.pincode.$error.required) ||
		    	                                                                                                            (submitted && adduser.level.$error.required) || (submitted && adduser.reportingto.$error.required) ||
		    	                                                                                                            (submitted && adduser.newEmpId.$error.required) || (submitted && adduser.phone.$error.required))">{{mandatoryfields}}</span>
		    	    </td>
			    </tr>
			</tbody>
		</table>
		<div class="adminbuttonsalign">
	        <input type="submit" name="submit" value="Save" ng-click="[submitted=true,saveuser(adduser,$event)]"/> 
			<input type="reset"  style="margin-left:10px;" name="reset"   value="Cancel" ng-click="[submitted=false,resetuser()]"/>
		</div>
	  </div>
	</div>
</form:form>