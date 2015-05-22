<!doctype html>

<html>

<head>
<title>Welcome!</title>
<meta name="viewport" content="width=device-width">

<link rel="icon" type="image/png" href="images/icon.png">

<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<style type="text/css">
.navbar {
	padding: 5px 10px;
}
/* Main marketing message and sign up button */
.jumbotron {
	background-color: transparent;
}

.jumbotron .btn {
	font-size: 21px;
	padding: 14px 24px;
}
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="navbar navbar-default">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a href="#" class="navbar-brand"><b>Skimpy</b></a>
			</div>
			<div class="pull-right btn-group btn-group-lg">
				<a href="http://localhost:8080/Skimpy/login.jsp"
					class="btn btn-primary btn-lg">Log In</a>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-8">
				<div class="jumbotron">
					<h1>Welcome!</h1>
					<p class="lead">
						Skimpy is an application that will help you manage your health and
						your wallet. Skimpy compares the prices of foods with the
						three of the UK's leading supermarkets.
					</p>
					<p>
						<a class="btn btn-lg btn-success"
							href="http://localhost:8080/Skimpy/signup.jsp">Sign Up Today!</a>
					</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="well">
					<h1>We Compare:</h1>
					<div class="row">
						<div class=".col-sm-4">
							<a href="http://www.asda.com" target="_blank"><img
								src="images/asda.png" alt="Asda" style="width: 90%; height: 100px; margin:5%"></a>
						</div>
					</div>
					<div class="row">
						<div class=".col-sm-4">
							<a href="http://www.tesco.com" target="_blank"><img
								src="images/tesco.png" alt="Tesco"
								style="width: 90%; height: 100px; margin:5%"></a>
						</div>
					</div>
					<div class="row">
						<div class=".col-sm-4">
							<a href="http://www.sainsburys.co.uk" target="_blank"><img
								src="images/sains.png" alt="Sainsbury's"
								style="width: 90%; height: 100px; margin:5%"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>

</html>