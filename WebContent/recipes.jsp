<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id="chooseRecipesUI" scope="request"
             class="logic.boundary.ChooseRecipesUI"/>

<jsp:setProperty name="chooseRecipesUI" property="*"/>

<jsp:useBean id="userUI" scope="request"
             class="logic.implementation.UserUI"/>

<jsp:setProperty name="userUI" property="*"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>The Fridge: recipes</title>
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-multiselect.js"></script>
			
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
					<li><a href="addFood.jsp" style="font-family: 'Montserrat', sans-serif;">ADD FOOD</a></li>
				</ul>
				<div class="rect_head">
					<a href="home.jsp"><img src="images/LOGOnero.png" class="dark-logo" alt="fridge"  width="100" ></a>
				</div>
				<ul class="nav-links">
					<li><a href="recipes.jsp" style="font-family: 'Montserrat', sans-serif; color: sandybrown;">RECIPES</a></li>
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
			 <div class="addFood" align="center">
			 	<font style="color: white; font-family: 'Montserrat', sans-serif; font-size:12px; "> 
			 <label>
				  <input type="text" name="recipesnumber" placeholder="How much recipes?">
			 </label>
			 	</font>
			
			
			
			
			
			<form id="form1">
			
			<div style="padding:20px">
			
			<select id="chkveg" multiple="multiple">
			
			
				<c:forEach var="myB" items="${myBeans}">
    				Name: <c:out value="${myBean.tName}"/>
    				Fee: <c:out value="${myBean.tFee}"/>
				</c:forEach>
			    
			    <option value="cheese">Cheese</option>
			    <option value="tomatoes">Tomatoes</option>
			    <option value="mozarella">Mozzarella</option>
			    <option value="mushrooms">Mushrooms</option>
			    <option value="pepperoni">Pepperoni</option>
			    <option value="onions">Onions</option>
			
			</select>
			
			<br /><br />
			
			<input type="button" id="btnget" value="Exclude ingredient" />
			
			<script type="text/javascript">
			
			$(function() {
			
			    $('#chkveg').multiselect({
			
			        includeSelectAllOption: true
			    });
			
			    $('#btnget').click(function(){
			
			        alert($('#chkveg').val());
			    });
			});
			
			</script>
			
			
			</div>
			
			</form>
			
			
						
			<input type = "submit" value = "Start Search" style="font-family: 'Montserrat', sans-serif;"><br><br>
			
		</div>



	

</body>
</html>	