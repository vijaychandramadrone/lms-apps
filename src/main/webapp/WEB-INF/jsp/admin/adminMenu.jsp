 <div id="leftdata">
	<div id="navigation">
	    <ul class="top-level">
	        <li><a href="/lms-app/adminHome">Home</a>
	        </li>
	        <li>
	            <a href="#">User  >></a>
	            <ul class="sub-level">
	                <li><a href="/lms-app/addUser" ng-model="showapplyleavediv" >Add User</a></li>
	                <li><a href="/lms-app/modifyUser" ng-model="showcancelleavediv" >Modify User</a></li>
	                <li><a href="/lms-app/deleteUser" ng-model="showcancelleavediv" >Delete User</a></li>
	            </ul>
	        </li>
	        <li>
	            <a href="#">Configuration  >></a>
	            <ul class="sub-level">
	                <li><a href="/lms-app/setLeaveType" ng-model="showleavesummarydiv" >Set Leave Type</a></li>
	                <li><a href="/lms-app/setRole" ng-model="showleavesummarydiv" >Set Role</a></li>
	            </ul>
	        </li>
			<li>
	            <a href="/lms-app/leaveCorrections">Leave Corrections</a>
	        </li>
	         <li>
	            <a href="#">Employee Credentials  >></a>
	            <ul class="sub-level">
	                <li><a href="/lms-app/applyLeave" ng-model="showcancelleavediv" >Apply Leave</a></li>
	                <li><a href="/lms-app/cancelLeave" ng-model="showcancelleavediv" >Cancel Leave</a></li>
	                <li><a href="/lms-app/leaveSummary" ng-model="showcancelleavediv" >Leave Summary</a></li>
	            </ul>
	        </li>
	        <li>
	            <a href="#">Settings  >></a>
	            <ul class="sub-level">
	                <li><a href="/lms-app/changePassword" ng-model="showchangepassworddiv" ng-click="changepassword(welcome)">Change Password</a></li>
	            </ul>
	        </li>
	        <li>
	            <a href=" ">Sign Out</a>
	        </li>
	    </ul>
	</div>
 </div>
