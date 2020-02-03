<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id="viewFridgeUI" scope="request"
             class="logic.boundary.ViewFridgeUI"/>

<jsp:setProperty name="viewFridgeUI" property="*"/>

<jsp:useBean id="userUI" scope="request"
             class="logic.implementation.UserUI"/>

<jsp:setProperty name="userUI" property="*"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>The Fridge: home</title>
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<script >
		function buttonClicked(i){
			document.getElementById('indexId').value = i;
			document.getElementById("formDelete").submit();
			
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
				<a href="changeFridge.jsp"><img src="images/ominoIcon.png" class="omino" alt="fridge"  width="60"  ></a>
				<ul class="nav-links">
					<li><a href="home.jsp" style="font-family: 'Montserrat', sans-serif; color: sandybrown;">HOME</a></li>
					<li><a href="addFood.jsp" style="font-family: 'Montserrat', sans-serif;">ADD FOOD</a></li>
				</ul>
				<div class="rect_head">
					<a href="home.jsp"><img src="images/LOGOnero.png" class="dark-logo" alt="fridge"  width="100" ></a>
				</div>
				<ul class="nav-links">
					<li><a href="recipes.jsp" style="font-family: 'Montserrat', sans-serif;">RECIPES</a></li>
					<li><a href="inviteUsers.jsp" style="font-family: 'Montserrat', sans-serif; ">INVITE USERS</a></li>
				</ul>
			</nav>
			<%
	    	}else {
	    		//if user session
	    		%>
	    		<nav>
				<a href="changeFridge.jsp"><img src="images/ominoIcon.png" class="omino" alt="fridge"  width="60"  ></a>
				<ul class="nav-links">
					<li><a href="home.jsp" style="font-family: 'Montserrat', sans-serif; color: sandybrown;">HOME</a></li>
					
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
		
		 <div class="container" align="center">
		 	<div id="scroller">
			 <form name="formDelete" action="home" method="post">
			 <table style="width:100%">
			 	<thead>
				  <tr>
				    <th style="font-family: 'Montserrat', sans-serif; background-color: sandybrown;">Name</th>
				    <th style="font-family: 'Montserrat', sans-serif; background-color: sandybrown;">Quantity</th>
				    <th style="font-family: 'Montserrat', sans-serif; background-color: sandybrown;">Expiration Date</th>
				  </tr>	
				<tbody>   
				  	<%	viewFridgeUI.showContent();
				  		for( int i=0; i<viewFridgeUI.getContent().size() ; i++ ){
				  			String name =  viewFridgeUI.getContent().get(i).get(0);
				  			String quantity =  viewFridgeUI.getContent().get(i).get(1);
				  			String date =  viewFridgeUI.getContent().get(i).get(2);
				  			%>
				  			<tr style="text-align:center;">
				  			<td id="nameColumn" style="font-family: 'Montserrat', sans-serif; margin-left: 50px; " >
				            	<label for="name"><%=name %></label>
				            	
				        	</td>
				        	<td id="quantityColumn" style="font-family: 'Montserrat', sans-serif; margin-left: 50px; " >
				            	<label for="quantity"><%=quantity %></label>
				            	
				        	</td>
				        	<td id="dateColumn" style="font-family: 'Montserrat', sans-serif; margin-left: 50px; " >
				            	<label for="date"><%=date %></label>
				            	
				        	</td>
				        	<td>
				        		<input id="indexId" type="hidden" name="index"  />
				        		<button onclick="buttonClicked('<%=i%>')" style="border: none; background-color: transparent;" ><img src="images/croce.png" alt="croce"  width="30"  ></button>
				        	</td>
				        	</tr>
				        	
				        	<%
				  		}	
				  		%>
				  		
				  		
	    
				</tbody>
			</table> 
			</form>
			</div>
		</div>	

	

</body>
</html>