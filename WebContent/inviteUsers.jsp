<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>The Fridge: invite users</title>
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<div>
		<header>
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
					<li><a href="recipes.jsp" style="font-family: 'Montserrat', sans-serif;">RECIPES</a></li>
					<li><a href="inviteUsers.jsp" style="font-family: 'Montserrat', sans-serif; color: sandybrown;">INVITE USERS</a></li>
				</ul>
			</nav>
	
		</header>
	</div>
	<main>
		<div class="inviteUser">
			<form action="invite" method="post" >
			<font style="color: white; font-family: 'Montserrat', sans-serif; font-size:12px; "> 
				<c:out value="${label}" />
			</font>
			<input type="text" name="username" placeholder="insert username">          
			<h5 style="margin-bottom: .7em; margin-top: .7em; color:white; font-family: 'Montserrat', sans-serif;" align="CENTER">OR</h5>
			<input type="text" name="email" placeholder="insert email"><br><br>		
			<input type="text" name="message" placeholder="insert message" style="height: 100px;"><br><br>
			<input type="submit" name="invite" value="Invite" style="font-family: 'Montserrat', sans-serif;" ><br><br>
			</form>
		</div>
		
	

	</main>

</body>
</html>