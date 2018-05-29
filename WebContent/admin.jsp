<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hangman play</title>
</head>
<body>



	<div class="bg">
		<div class="container">
			<div class="leftPanel">
				
				<div id="logo">
					<img src="images/logo.png">
				</div>
			</div>

			<div class="rightPanel">
				<div class="loginDetails">
				<form>
					 <input
							type="submit" id="buttonStyle" name="submit" value="Add new words">
							
							<input
							type="submit" id="buttonStyle" name="submit" value="Add user">
							<input
							type="submit" id="buttonStyle" name="submit" value="Delete user">
							<input
							type="submit" id="buttonStyle" name="submit" value="Show all user">
						<input type="button" value="GO BACK" id="buttonStyle"
							onclick="window.location.href='index.jsp'">
				</form>
				</div>

			</div>


		</div>


	</div>



</body>
</html>