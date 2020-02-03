<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>The Fridge: login</title>
	<link rel="stylesheet" href="css/login.css" />
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
	<header>
		<div class="rect_head">
			<img src="images/LOGOnero.png" class="dark-logo" alt="fridge"  width="100" >
		</div>	
	</header>

	
	<div class="corpo">
			<div class="parag">
				<p style="font-weight: bold; font-family: 'Montserrat', sans-serif; font-size: 22px;  ">
					Welcome to <font color=#f4a46; >TheFridge</font>.<br> 
					We have designed this platform<br> 
					to help you manage your fridge,<br>
					share it with whoever you want<br>
					and offer you some recipes to do<br>
					with your food.<br><br>
					We hope you find it useful!
				</p>
			</div>
			<div class="signin">
				<form action="login" method="post" >
					<h2  style="color: white; font-family: 'Montserrat', sans-serif; margin-bottom:10px;">Sign in</h2>
					<div style="margin-bottom:5px;">
						<font style="color: white; font-family: 'Montserrat', sans-serif; font-size:12px; "> 
							<c:out value="${label}" />
						</font>
					</div>
					<input id="username" type="text" name="username" placeholder="Username or email" style="font-family: 'Montserrat', sans-serif;" >
					<br><br>
					<input id="password" type="password" name="password" placeholder="Password" style="font-family: 'Montserrat', sans-serif;" >
					<br><br>
					<div class="row">
			            <div class="col-lg-4 text-center">
			                <input name="login" type="submit" value="Sign in" style="font-family: 'Montserrat', sans-serif;">
			                <br><br>
			                <h5 style="color: white; font-family: 'Montserrat', sans-serif; font-size: 10px; letter-spacing: 1px;">Don't have account?
								<a href="signup.jsp" style="font-family: 'Montserrat', sans-serif; color: sandybrown; font-size: 10px;">Sign up</a>
							</h5>
			            </div>
		       		</div>
				</form>
			</div>
	</div>
	
</body>
</html>