<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id="chooseRecipesUI" scope="request"
             class="logic.boundary.ChooseRecipesUI"/>

<jsp:setProperty name="chooseRecipesUI" property="*"/>

<jsp:useBean id="userUI" scope="request"
             class="logic.implementation.AdminCheck"/>

<jsp:setProperty name="userUI" property="*"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>The Fridge: recipes</title>
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-multiselect.js"></script>
	<script>
			
	    var expanded = false;
	
		function showCheckboxes() {
		 
		  var checkboxes = document.getElementById("checkboxes");
		  if (!expanded) {
		    checkboxes.style.display = "block";
		    expanded = true;
		  } else {
		    checkboxes.style.display = "none";
		    expanded = false;
		  }
		}
		
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
					<li><a href="home.jsp" style="font-family: 'Montserrat', sans-serif;">HOME</a></li>
					<li><a href="addFood.html" style="font-family: 'Montserrat', sans-serif;">ADD FOOD</a></li>
				</ul>
				<div class="rect_head">
					<a href="home.jsp"><img src="images/LOGOnero.png" class="dark-logo" alt="fridge"  width="100" ></a>
				</div>
				<ul class="nav-links">
					<li><a href="recipes.jsp" style="font-family: 'Montserrat', sans-serif; color: sandybrown;">RECIPES</a></li>
					<li><a href="inviteUsers.html" style="font-family: 'Montserrat', sans-serif; ">INVITE USERS</a></li>
				</ul>
			</nav>
			<%
	    	}else {
	    		//if user session
	    		%>
	    		<nav>
				<a href="changeFridge.jsp"><img src="images/ominoIcon.png" class="omino" alt="fridge"  width="60"  ></a>
				<ul class="nav-links">
					<li><a href="home.jsp" style="font-family: 'Montserrat', sans-serif;">HOME</a></li>
					
				</ul>
				<div class="rect_head">
					<a href="home.jsp"><img src="images/LOGOnero.png" class="dark-logo" alt="fridge"  width="100" ></a>
				</div>
				<ul class="nav-links">
					<li><a href="recipes.jsp" style="font-family: 'Montserrat', sans-serif; color: sandybrown;">RECIPES</a></li>
					
				</ul>
				</nav>
	    	<% 	
	    	}
			%>
			
	
		</header>
	</div>
	
		<!-- text box a sinistra in alto
			submit "start search" a destra in alto
			in mezzo a loro: check combo box per cibi da eliminare
			 -->
		 
			 
			 
			 <div style="float:left; margin-left: 50px; margin-top:50px; height: 500px;">
				 <div class="multiselect" align="LEFT" >
				    <div class="selectBox" onclick="showCheckboxes()" >
				      <h3 style="font-family: 'Montserrat', sans-serif; color: sandybrown;" align="CENTER">Exclude ingredients</h3><br>
				      <select style="height:400px; background-color:black; opacity: 0.8; border:transparent; border-radius: 10px; padding:7px; " name="foods" multiple >
				        
				      
				      
				    
				    
				      <%
				      	try{
				      	chooseRecipesUI.initListFood();
				      	for( int i = 0; i < chooseRecipesUI.getListFood().size(); i++ ){
				      		%>
				      		<option style="color:white;" value="<%=chooseRecipesUI.getListFood().get(i)%>"><%=chooseRecipesUI.getListFood().get(i) %></option>
				      		
				      		
				      		<%
				      	
				      	}
				      	}catch(Exception e){
				      		%>
				      		<option style="color:white; font-weight: bold; font-size: 14px;" >No Ingredients</option>
				      		<%
				      	}
				      %>
				      
				      
				    
					</select>
					</div>
				
				</div>
				
			</div>
			
			<div style="float:right">
			 	<form id="formRecipes" action="startSearch" method="post">
			 	<label style="font-family: 'Montserrat', sans-serif; color:#ed4337; font-weight: bold;">
			 		<c:out value="${alertLabel}"></c:out>
				</label>
				<span style="margin-left: 400px;">
				 	<font style="color: white; font-family: 'Montserrat', sans-serif; font-size:12px; "> 
				 <label>
					  <input style="background-color:black; opacity:0.7;" type="text" name="recipesnumber" placeholder="How many recipes?" >
				 </label>
				 	</font>
				</span>		
				<span>	
					<input id="btnget" type = "submit" value = "Start Search" style="font-family: 'Montserrat', sans-serif;"><br><br>
					<label style="font-family: 'Montserrat', sans-serif; color:#ed4337; font-weight: bold; font-size:20px;">
						<c:out value="${alertLabel2}"></c:out>
					</label>
				</span>
				
				<div >
						<div>
							<%
							
							if(request.getAttribute("0") == null){
								
							}
							if( request.getAttribute("0") != null){
							%>
							<img src="<%=request.getAttribute("0") %>" width="120">
							<br>
							<div class=divRecipeBody >								
								<label style="font-family: 'Montserrat', sans-serif; color:white; font-weight: bold;"><%=request.getAttribute("title0") %></label><br>
								
								<label style="font-family: 'Montserrat', sans-serif; color:white;"><%=request.getAttribute("content0") %></label>
							</div>
							<%
							}
							%>
							
						</div>
						<br>
						<div>
							<%
							if( request.getAttribute("1") != null){
							%>
							<img src="<%=request.getAttribute("1") %>" width="120">
							<br>
							<div class=divRecipeBody>
								<label style="font-family: 'Montserrat', sans-serif; color:white; font-weight: bold;"><%=request.getAttribute("title1") %></label><br>
								<label style="font-family: 'Montserrat', sans-serif; color:white;"><%=request.getAttribute("content1") %></label>
							</div>
							<%
							}
							%>
							
						</div>
						<br>
						<div>
							<%
							if( request.getAttribute("2") != null){
							%>
								<img src="<%=request.getAttribute("2") %>" width="120">
							<br>
							<div class=divRecipeBody>
								<label style="font-family: 'Montserrat', sans-serif; color:white; font-weight: bold;"><%=request.getAttribute("title2") %></label><br>
								<label style="font-family: 'Montserrat', sans-serif; color:white;"><%=request.getAttribute("content2") %></label>
							</div>
							<%
							}
							%>
							
						</div>
						<br>
						<div>
							<%
							if( request.getAttribute("3") != null){
							%>
								<img src="<%=request.getAttribute("3") %>" width="120">
							<br>
							
							<div class=divRecipeBody>
								<label style="font-family: 'Montserrat', sans-serif; color:white; font-weight: bold;"><%=request.getAttribute("title3") %></label><br>
								<label style="font-family: 'Montserrat', sans-serif; color:white;"><%=request.getAttribute("content3") %></label>
							</div>
							<%
							}
							%>
							
						</div>
						<br>
						<div>
							<%
							if( request.getAttribute("4") != null){
							%>
								<img src="<%=request.getAttribute("4") %>" width="120">
							<br>
							<div class=divRecipeBody>
								<label style="font-family: 'Montserrat', sans-serif; color:white; font-weight: bold;"><%=request.getAttribute("title4") %></label><br>
								<label style="font-family: 'Montserrat', sans-serif; color:white;"><%=request.getAttribute("content4") %></label>
							</div>
							<%
							}
							%>
							
						</div>
						
					
				</div>
					
			</form>
					
					
				
					
			</div>
			
			
			
		



	

</body>
</html>	