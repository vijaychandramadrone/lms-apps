 <div id="leftdata">
	<div id="navigation">
	    <ul class="top-level">
	         <li><a href="/lms-app/managerHome">Home</a>
	        </li>
	         <li>
	            <a href="#">Approve/Reject>></a>
	            <ul class="sub-level">
	                <li><a href="/lms-app/approveLeave" ng-model="showapplyleavediv" >View Leave Requests</a></li>
	            </ul>
	        </li>
	        <li>
	            <a href="#">Reports  >></a>
	            <ul class="sub-level">
	                <li><a href="/lms-app/approvalList" ng-model="showleavesummarydiv" >View Approved Leaves</a></li>
	                <li><a href="/lms-app/rejetionList" ng-model="showleavesummarydiv" >View Rejected Leaves</a></li>
	                <li><a href="/lms-app/cancellationList" ng-model="showleavesummarydiv" >View Cancelled Leaves</a></li>
	            </ul>
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
