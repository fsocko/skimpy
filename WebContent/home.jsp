
<% String pageTitle = "Home"; %>
<% String currentPage = "home"; %>
<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="BusinessLogic.*"%>

<%

	DecimalFormat cleanDecimal = new DecimalFormat("0.0");

  	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
		return;
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
										<p><%=cleanDecimal.format(session.getAttribute("calories")) %> kcal</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Protein</span>
									</div>
									<div class="col-sm-8">
										<p><%=cleanDecimal.format(session.getAttribute("protein")) %> g</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Carbohydrates</span>
									</div>
									<div class="col-sm-8">
										<p><%=cleanDecimal.format(session.getAttribute("carbs")) %> g</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Sugar</span>
									</div>
									<div class="col-sm-8">
										<p><%=cleanDecimal.format(session.getAttribute("sugar")) %>	g</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Fat</span>
									</div>
									<div class="col-sm-8">
										<p><%=cleanDecimal.format(session.getAttribute("fat")) %> g</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Saturates</span>
									</div>
									<div class="col-sm-8">
										<p><%=cleanDecimal.format(session.getAttribute("saturates")) %>	g</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Fibre</span>
									</div>
									<div class="col-sm-8">
										<p><%=cleanDecimal.format(session.getAttribute("fibre")) %>	g</p>
									</div>
									<div class="col-sm-4">
										<span class="label label-info">Salt</span>
									</div>
									<div class="col-sm-8">
										<p><%=cleanDecimal.format(session.getAttribute("salt")) %> g</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<div class="col-md-12">
								<h4>Nutrition Tracker</h4>
							</div>
						</div>
					</div>
					<div class="col-sm-12">
						<div class="row">
							<div class="col-md-12">
								<div class="progress">
									<div class="progress-bar" style="width: <%=((NutritionOptimisation)session.getAttribute("sessionNutrition")).percent()%>%;"></div>
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
		</div>
	</div>
</div>
</body>

</html>
