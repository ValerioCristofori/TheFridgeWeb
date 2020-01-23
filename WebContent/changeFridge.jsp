<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="changeFridgeUI" scope="request"
             class="logic.boundary.ChangeFridgeUI"/>

<jsp:setProperty name="changeFridgeUI" property="*"/>

<jsp:useBean id="userUI" scope="request"
             class="logic.implementation.UserUI"/>

<jsp:setProperty name="userUI" property="*"/>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>The Fridge: change fridge</title>
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	
	<script>	
		function buttonAccept(i){
			
			document.getElementById('action').value = "accept";
			document.getElementById('variable').value = i;
			//passare i alla servlet
			document.getElementById("inviteForm").submit();
			
		}
		
		function buttonDecline(i){
			
			document.getElementById('action').value = "decline";
			document.getElementById('variable').value = i;
			
			document.getElementById("inviteForm").submit();
			
		}
		
		function fridgeClicked(i){
			document.getElementById('action').value = "change";
			document.getElementById('fridgeInp').value = i;
			
			document.getElementById("inviteForm").submit();
		} 
		
		function myFridgeClicked(){
			document.getElementById('actionProfileId').value = "changeInMyFridge";
			document.getElementById("profileForm").submit();
		}
		
		
	
	</script>
</head>
<body>
	<div>
		<header>
			<%
			if( userUI.checkAdminUI() ) {
	    	%>
	    		<nav>
					<ul class="nav-links">
						<li><a href="home.jsp" style="font-family: 'Montserrat', sans-serif;">HOME</a></li>
						<li><a href="addFood.jsp" style="font-family: 'Montserrat', sans-serif;">ADD FOOD</a></li>
					</ul>
					<div class="rect_head">
						<a href="home.jsp"><img src="images/LOGOnero.png" class="dark-logo" alt="fridge"  width="100" ></a>
					</div>	
					<ul class="nav-links">
						<li><a href="recipes.jsp" style="font-family: 'Montserrat', sans-serif;">RECIPES</a></li>
						<li><a href="inviteUsers.jsp" style="font-family: 'Montserrat', sans-serif;">INVITE USERS</a></li>
					</ul>
				</nav>
			<%
	    	}else {
	    		//if user session
	    		%>
	    		<nav>
				<ul class="nav-links">
					<li><a href="home.jsp" style="font-family: 'Montserrat', sans-serif;">HOME</a></li>
					
				</ul>
				<div class="rect_head">
					<a href="home.jsp"><img src="images/LOGOnero.png" class="dark-logo" alt="fridge"  width="100" ></a>
				</div>
				<ul class="nav-links">
					<li><a href="recipes.jsp" style="font-family: 'Montserrat', sans-serif;">RECIPES</a></li>
					
				</ul>
				</nav>
	    	<% 	
	    	}
			%>
			
	
		</header>
	</div>
	
		 
		<div class="profile_div" style="align: center; float: left;">
			
				<div>
					<div class="profile_image" style="margin-left: 90px;" >
						<img src="images/ominoIcon.png" class="omino" alt="fridge"  width="60"  >
					</div>
					<div>
						<form action="change" method="get">
							<label>Username: </label><br>
							<label><%= changeFridgeUI.getUsername() %></label><br>
							
							<label>Email:</label><br>
							<label><%= changeFridgeUI.getEmail() %></label>
						</form>
					</div>
					
				<br><br>	
				</div >
				<form action="profile" id="profileForm" method="post" >
					<input type="hidden" name="actionProfileName" id="actionProfileId" />
					<label style="font-family: 'Montserrat', sans-serif; font-size: 14px; margin-left: 90px;">Your fridge</label>
					<button onclick="myFridgeClicked()" style="border: none; background-color: transparent; margin-top: 30px; margin-left: 60px;" ><img src="images/fridgeWeb.png" alt="fridge"  width="130"  ></button><br>
				
				
					<input type="submit" name="actionProfileName" value="Delete account" style="font-family: 'Montserrat', sans-serif; background-color: #E14D43; margin-top: 150px; "><br><br>
		  		</form>
		  </div>
		  <div style="float: right;margin-top: 40px;">	
			 <form id="inviteForm" action="change" method="post">
			 <div class="case" style="margin-right:150px; padding-top:10px;">
			 	
				 	<input type="hidden" name="action" id="action" />
				 	<input id="variable" type="hidden" name="index"  />
				 	
				 	<table id="dataTable"  style="width:100%">
					 	<tbody>
						  <tr>
						    <th style="font-family: 'Montserrat', sans-serif;">Invitation by</th>
						    <th style="font-family: 'Montserrat', sans-serif;">Message</th>
						    
						  </tr>	
						   	
						  	<%	changeFridgeUI.takeInvitations();
						  		for( int i=0; i<changeFridgeUI.getInvitingUsers().size() ; i++ ){
						  			String name =  changeFridgeUI.getInvitingUsers().get(i);
						  			String message =  changeFridgeUI.getMessages().get(i);
						  			
						  			%>
						  			<tr style="text-align:center;">
							  			<td style="font-family: 'Montserrat', sans-serif; margin-left: 50px; " >
							            	<label for="name"><%=name %></label>
							            	
							        	</td>
							        	<td style="font-family: 'Montserrat', sans-serif; margin-left: 50px; " >
							            	<label for="message"><%=message %></label>
							            	
							        	</td>
							        	<td>
							        		
						        			<button onclick="buttonAccept('<%=i%>')" style="border: none; background-color: transparent;" ><img src="images/v.png" alt="v"  width="43"  ></button>
							        	</td>
							        	<td>
							        		
						        			<button onclick="buttonDecline('<%=i%>')" style="border: none; background-color: transparent;" ><img src="images/croce.png" alt="croce"  width="30"  ></button>
							        	</td>
						        	
						        	</tr>
						        		
						        	<%
						  		}	
						  		%>
						  		
						  		
			    
						</tbody>
					</table>
					
				
				
			 </div>
		 	
		 	<div class="case" style="margin-top: 30px; padding:60px;">		 		
		 			
			 		<input id="fridgeInp" name="fridge" type="hidden"  />
			 		<div>
			 		<%	try{
				 			String[] fridges = changeFridgeUI
				 				.startFridgesInterfaces()
				 				.toArray( new String[changeFridgeUI
				 				                     .startFridgesInterfaces().size()]);
				 			int i=0;
				 			for( String fridge: fridges ){
				 				
				 				%>
				 				<div style="float: right;">
				 				<!-- <input id="indexId" type="hidden" name="index" /> -->
						        	<button onclick="fridgeClicked('<%=i%>')" style="border: none; background-color: transparent;" ><img src="images/fridgeWeb.png" alt="fridge"  width="130"  ></button>
				 					<label style="font-family: 'Montserrat', sans-serif; font-size: 11px"><%=fridge %></label>
				 				</div>
				 				<%
				 				i++;
				 			}
			 			}
			 			catch(NullPointerException npe){
			 				%>
			 				<h3 style="font-family: 'Montserrat', sans-serif; color:white;" align="CENTER" >You have no shared fridge</h3>
			 				<%
			 			}
			 		%>
			 		</div>
		 		
		 	</div>
		 	</form>
		 	
		 
		 </div>
		
	

</body>
</html>