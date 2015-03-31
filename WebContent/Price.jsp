<%@page import="BusinessLogic.*"%>
<%@page import="interfc.*"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Prices</title>
</head>
<body>
<p>Here's your Shopping list with prices from different supermarkets:</p>
 	 
   <% MealPlanner plan = CreateMealPlan.create();
 	ArrayList<Food> food = new ArrayList<Food>();
    for (int i = 0; i < plan.getShoppingList().size(); i++) {
	      for (Food f: plan.getShoppingList().get(i)) {
	    	food.add(f);
	  }
	}

  	Food[] foodarray = food.toArray(new Food[food.size()]);
	double priceD = plan.getPrice();
	String price = String.format("%.2f", priceD ); 
	ArrayList<ArrayList<Food>> list = plan.getShoppingList();
	ArrayList<Double> tescoresult = new ArrayList<Double>();
		for(int i = 0; i < list.size(); i++){
			for(Food f : list.get(i)){
				tescoresult.add(f.getTescoPrice());}
				
	      } %>
		<%-- <%=tescoresult %> --%>
		<% ArrayList<Double> asdaresult = new ArrayList<Double>();
		for(int i = 0; i < list.size(); i++){
			for(Food f : list.get(i)){
				asdaresult.add(f.getAsdaPrice());}
	      }%>
		<%-- <%= asdaresult %> --%>
		
		<%  ArrayList<Double> cheapest = new ArrayList<Double>();
	    	for(int i=0; i<tescoresult.size();i++){
			if (asdaresult.get(i)<tescoresult.get(i)){
				cheapest.add(asdaresult.get(i));}
				else{ cheapest.add(tescoresult.get(i));
			}	
		}%>
	<%-- <%=cheapest %> --%>
<table border="1">
         <tr>
 		     <th>Item</th>
 		     <th>Amount</th>
	         <th>Tesco Price</th>
	         <th>Asda Price</th>
	         <th>Best Deal</th>
	      </tr>   
 		 <tr>
	<%
 	for (int i=0; i < list.size(); i++){
 		 for(Food f : list.get(i)){
 			/* for (int t=0;t<cheapest.size();t++){ */ %>
 		 <%
		   String item = f.getName() + "<br>";
		   String tPrice = f.getTescoPrice() + "<br>";
		   String aPrice = f.getAsdaPrice() + "<br>" ;
		   int amount = f.getAmount() ;
		   String units = f.getUnits() + "<br>" ;%>
		     
	         <td><%= item  %></td>
	         <td><%= amount  %> <%= units  %></td>
	         <td><%= tPrice  %></td>
	         <td><%= aPrice  %></td> 
	         <td><%if (f.getTescoPrice() < f.getAsdaPrice()){%><%=tPrice%><%;} else { %> <%=aPrice %><%;} %></td>
	         
	      </tr>
 	<%} %><%} %>
 	<tr>
 	<td >Total</td>
 	<td ></td>
 	<td>  <% 
		double tescoResult = 0;
		for(int i = 0; i < list.size(); i++){
			for(Food f : list.get(i)){
				tescoResult += f.getTescoPrice();}
	      }%>
		<%= String.format("%.2f", tescoResult) %></td>
 	<td><% 
		double asdaResult = 0;
		for(int i = 0; i < list.size(); i++){
			for(Food f : list.get(i)){
				asdaResult += f.getAsdaPrice();}
	      }%>
		<%= String.format("%.2f", asdaResult) %></td>
		<td><%
		double cheapestResult = 0;
		for(int i = 0; i < cheapest.size(); i++){
			
				cheapestResult += cheapest.get(i);}%>
		<%= String.format("%.2f", cheapestResult) %></td>
 	</tr>
 	</table>
 	
 	<p>If you shop wisely, you can save up to £ <%if (tescoResult < asdaResult){%><%=String.format("%.2f",( asdaResult -cheapestResult ))%><%;}
 	else { %> <%=String.format("%.2f",(tescoResult - cheapestResult ))%><%;} %>. </p>
		
  <!-- String foodarrayString = java.util.Arrays.deepToString(foodarray);  -->
    

     
    
<!--     String[] shops = {"Tesco", "Asda"};

 String[] temp = PriceOptimisation.minimumBudget(shops, foodarray);
for (String s : temp) {
    System.out.println(s);
	}  -->

 	
 	<%-- <%= foodarray[0].getPrices() %> --%>
</body>
</html>