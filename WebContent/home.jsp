
<% String pageTitle = "Home"; %>
<% String currentPage = "home"; %>
<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="BusinessLogic.*"%>

<%	
  	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}
%>

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-5">
			<div class="well">
				<div class="row">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-12">
								<h4>Your GDA:</h4>
							</div>
							<div class="col-sm-12">
								<div class="row">
									<div class="col-sm-4">
										<span class="label label-info">Calories</span>
									</div>
									<div class="col-sm-8">
										<p><%=session.getAttribute("calories") %>
											kcal
										</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Protein</span>
									</div>
									<div class="col-sm-8">
										<p><%=session.getAttribute("protein") %>
											g
										</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Carbohydrates</span>
									</div>
									<div class="col-sm-8">
										<p><%=session.getAttribute("carbs") %>
											g
										</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Sugar</span>
									</div>
									<div class="col-sm-8">
										<p><%=session.getAttribute("sugar") %>
											g
										</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Fat</span>
									</div>
									<div class="col-sm-8">
										<p><%=session.getAttribute("fat") %>
											g
										</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Saturates</span>
									</div>
									<div class="col-sm-8">
										<p><%=session.getAttribute("saturates") %>
											g
										</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Fibre</span>
									</div>
									<div class="col-sm-8">
										<p><%=session.getAttribute("fibre") %>
											g
										</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Salt</span>
									</div>
									<div class="col-sm-8">
										<p><%=session.getAttribute("salt") %>
											g
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<div class="col-md-12">
								<h4>Price Optimisation</h4>
							</div>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<div class="col-md-12">
								<div class="progress">
									<div class="progress-bar" style="width: 40%;"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<div class="col-md-12">
								<h4>Nutrition Optimisation</h4>
							</div>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<div class="col-md-12">
								<div class="progress">
									<div class="progress-bar" style="width: <%=session.getAttribute("percent")%>%;"></div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="col-sm-7">
			<div class="well">
				<div class="row">
					<div class="col-sm-12">
						<div class="media">
							<a class="pull-left" href="#"> <img class="media-object"
								src="https://builder.divshot.com/img/placeholder-64x64.gif">
							</a>
							<div class="media-body">
								<div class="row">
									<div class="col-sm-8">
										<h4><%=session.getAttribute("username") %></h4>
									</div>
									<div class="col-sm-4">
										<a href="edit.jsp" class="btn pull-right btn-primary btn-md">Edit</a>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<p><%=session.getAttribute("email")%></p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="row">
							<div class="col-sm-4">
								<span class="label label-info">Height</span>
							</div>
							<div class="col-sm-8">
								<p><%=session.getAttribute("height") %>
									cm
								</p>
							</div>
							<div class="col-sm-4">
								<span class="label label-info">Weight</span>
							</div>
							<div class="col-sm-8">
								<p><%=session.getAttribute("weight") %>
									kg
								</p>
							</div>
							<div class="col-sm-4">
								<span class="label label-info">Exercise Level</span>
							</div>
							<div class="col-sm-8">
								<p><%=session.getAttribute("exercise") %></p>
							</div>
							<div class="col-sm-4">
								<span class="label label-info">Age</span>
							</div>
							<div class="col-sm-8">
								<p><%=session.getAttribute("age") %></p>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="row">
							<div class="col-sm-4">
								<span class="label label-info">BMI</span>
							</div>
							<div class="col-sm-8">
								<p><%=session.getAttribute("BMI") %></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="well">
				<img src="https://builder.divshot.com/img/placeholder-100x100.gif">
				<a> Something should go here</a>
			</div>
		</div>
	</div>
</div>
</body>

</html>