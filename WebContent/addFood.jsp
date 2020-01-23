<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>The Fridge: modify fridge</title>
	<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
    $( function() {
        var availableTags = [
    	"Aceto balsamico", "Aceto di mele","Aceto di vino    ","Aceto di vino rosso    ","Aglio     ","Albume d'uovo    ","Alcool alimentare    ",
		"Amido di mais    ","Arancia    ","Arancia  scorza     ","Avocado    ","Basilico     ","Bicarbonato    ","Brodo di carne    ","Brodo vegetale    ","Burro    ",
		"Burro  eventuale     ","Cacao in polvere    ","Candito d'arancia    ","Candito di cedro    ","Cannella    ","Cannella  eventuale     ","Capperi    ","Carciofo    ",
		"Carota    ","Cioccolato    ","Cipolla     ","Cipolla di Tropea    ","Cipolla di Tropea  eventuale     ","Cipolla fresca    ","Cipolla rossa    ",
		"Condimento sott'olio per insalate di pasta o di riso    ","Curcuma  eventuale     ","Erba cipollina  eventuale     ","Essenza di mandorle    ","Fagioli cannellini    ",
		"Fagioli cannellini secchi    ","Fagiolini    ","Farina    ","Farina di ceci    ","Finocchio    ","Galletti  funghi freschi     ","Grana grattugiato    ",
		"Grana grattugiato  eventuale     ","Latte    ","Lenticchie rosse decorticate    ","Lievito per dolci    ","Limone  scorza     ","Limone  succo     ",
		"Maiale  lonza o prosciutto     ","Maiale  Macinato di maiale     ","Mandarino    ","Mandorle    ","Mandorle  eventuali     ","Manzo  macinato di manzo     ",
		"Mela    ","Melanzana    ","Menta    ","Merluzzo    ","Nocciole  farina     ","Noce moscata    ","Noce moscata  eventuale     ","Olio di semi di arachide    ",
		"Olio extravergine dâ€™oliva     ","Olio extravergine dâ€™oliva  eventuale     ","Olive nere    ","Olive nere  eventuali     ","Origano    ","Palombo    ","Pane    ",
		"Pane raffermo o secco    ","Pangrattato    ","Parmigiano grattugiato    ","Parmigiano grattugiato  eventuale     ","Pasta    ","Pasta  tagliatelle   eventuale     ",
		"Patata    ","Pecorino romano  eventuale     ","Pepe    ","Pepe  eventuale     ","Peperoncino    ","Peperoncino  eventuale     ","Peperone    ","Pesce spada    ","Pinoli    ",
		"Pinoli  eventuali     ","Pollo  petto     ","Pomodori ciliegini    ","Pomodori secchi    ","Pomodoro     ","Porcini  funghi freschi     ","Porcini secchi    ","Porro    ",
		"Prezzemolo    ","Ricotta di mucca    ","Riso arborio    ","Riso carnaroli    ","Riso originario    ","Riso vialone nano    ","Rosmarino    ","Rosmarino  eventuale     ",
		"Rosolio di menta    ","Rum    ","Salmone    ","Salsa di soia    ","Salsiccia    ","Salvia    ","Scalogno    ","Sedano    ","Tahin    ","Tilsiter    ","Timo    ",
		"Timo  eventuale     ","Tofu    ","Uova    ","Uova  eventuali     ","Uvetta    ","Vanillina    ","Vino bianco    ","Yogurt    ","Zafferano    ","Zucca    ","Zucchero    ",
		"Zucchero a velo    ","Zucchero a velo vanigliato    ","Zucchero di canna    ","Zucchine    "
      ];
      $( "#tags" ).autocomplete({
        source: availableTags
      });
    } );
    </script>
</head>
<body>
	<div>
		<header>
			
			<nav>
			<a href="changeFridge.jsp"><img src="images/ominoIcon.png" class="omino" alt="fridge"  width="60"  ></a>
				<ul class="nav-links">	
					<li><a href="home.jsp" style="font-family: 'Montserrat', sans-serif;">HOME</a></li>
					<li><a href="addFood.jsp" style="font-family: 'Montserrat', sans-serif; color: sandybrown;">ADD FOOD</a></li>
				</ul>
				<div class="rect_head">
					<a href="home.jsp"><img src="images/LOGOnero.png" class="dark-logo" alt="fridge"  width="100" ></a>
				</div>	
				<ul class="nav-links">
					<li><a href="recipes.jsp" style="font-family: 'Montserrat', sans-serif;">RECIPES</a></li>
					<li><a href="inviteUsers.jsp" style="font-family: 'Montserrat', sans-serif;">INVITE USERS</a></li>
				</ul>
			</nav>
	
		</header>
	</div>	
	
		<div class="addFood">
			<form action="addFood" method="post" >
			<div style="margin-bottom: 15px;">
				<font style="color: white; font-family: 'Montserrat', sans-serif; font-size:12px; "> 
					<c:out value="${label}" />
				</font>
			</div>
			<input id="tags" type="text" name="name" placeholder="insert name"><br><br>
			<input type="text" name="quantity" placeholder="insert quantity" autocomplete="off"><br><br>
			<input type="date" name="date" placeholder="insert expiration date" autocomplete="off" ><br><br>
			<input type="submit" name="add" value="Add Food" style="font-family: 'Montserrat', sans-serif;"><br><br>
			</form>
		</div>




	

</body>
</html>