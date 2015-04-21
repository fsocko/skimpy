<!doctype html>
<%@include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="BusinessLogic.*" %>
<html>
  
  <head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript">
	function showValue(newValue)
	{
		if(newValue == 1){
			document.getElementById("range").innerHTML= "Desk job with little exercise"
		}
		if(newValue == 2){
			document.getElementById("range").innerHTML=	"1-3hrs/week of light exercise"	
		}
		if(newValue == 3){
			document.getElementById("range").innerHTML="3-5hrs/week of moderate exercise"
		}
		if(newValue == 4){
			document.getElementById("range").innerHTML= "5-6hrs/week of strenuous exercise"
		}
		if(newValue == 5){
			document.getElementById("range").innerHTML= "7-21hrs/week of strenuous exercise/work"
		}

	}
	</script>
    <style type="text/css">
      .navbar {
        margin-bottom: 5px;
        padding-bottom: -1px;
      }
      .nav {
        margin-bottom: 0px;
        padding-bottom: -1px;
      }
      .media {
        margin: 2px;
        padding: 0px;
      }
      .col-sm-12 .media {
        margin-bottom: 10px;
        margin-left: 0;
        padding-left: 0;
      }
      .row h4 {
        margin: 0px;
        padding: 0px;
      }
      .media-body p {
        margin: 0px;
        padding-bottom: 0px;
      }
      .birthday-drop {
        margin-bottom:5px;
      }
      .birthday-drop .form-control {
        position: relative;
        font-size: 14px;
        padding: 0px;
        display:inline-block;
        height: auto;
        width: auto;
      }
      .input-sm {
        margin-bottom: 5px;
      }
    </style>
  </head>
  
  <body>
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
                      <div class="col-sm-6">
                        <span class="label label-info">Calories</span>
                      </div>
                      <div class="col-sm-6">
                        <p><%=session.getAttribute("calories") %> kcal</p>
                      </div>
                      <div class="col-sm-6">
                        <span class="label label-info">Protein</span>
                      </div>
                      <div class="col-sm-6">
                        <p><%=session.getAttribute("protein") %> g</p>
                      </div>
                      <div class="col-sm-6">
                        <span class="label label-info">Carbohydrates</span>
                      </div>
                      <div class="col-sm-6">
                        <p><%=session.getAttribute("carbs") %> g</p>
                      </div>
                      <div class="col-sm-6">
                        <span class="label label-info">Sugar</span>
                      </div>
                      <div class="col-sm-6">
                        <p><%=session.getAttribute("sugar") %> g</p>
                      </div>
                      <div class="col-sm-6">
                        <span class="label label-info">Fat</span>
                      </div>
                      <div class="col-sm-6">
                        <p><%=session.getAttribute("fat") %> g</p>
                      </div>
                      <div class="col-sm-6">
                        <span class="label label-info">Saturates</span>
                      </div>
                      <div class="col-sm-6">
                        <p><%=session.getAttribute("saturates") %> g</p>
                      </div>
                      <div class="col-sm-6">
                        <span class="label label-info">Fibre</span>
                      </div>
                      <div class="col-sm-6">
                        <p><%=session.getAttribute("fibre") %> g</p>
                      </div>
                      <div class="col-sm-6">
                        <span class="label label-info">Salt</span>
                      </div>
                      <div class="col-sm-6">
                        <p><%=session.getAttribute("salt") %> g</p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-12">
                  <h4>Price Optimisation</h4>
                </div>
                <div class="col-sm-12">
                  <div class="progress">
                    <div class="progress-bar" style="width: 40%;"></div>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-12">
                  <h4>Nutrition Optimisation</h4>
                </div>
                <div class="col-sm-12">
                  <div class="progress">
                    <div class="progress-bar" style="width: 40%;"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-sm-7">
          <div class="well">
          	<form action="editdets.jsp" method="post" id="myForm">
	            <div class="row">
	              <div class="col-sm-12">
	                <div class="media">
	                  <a class="pull-left" href="#">    <img class="media-object" src="https://builder.divshot.com/img/placeholder-64x64.gif">  </a>
	                  <div class="media-body">
	                    <div class="row">
	                      <div class="col-sm-8">
	                        <a> Upload Picture </a><br>
	                        <a href = "change_password.jsp"> Change Password </a>
	                      </div>
	                      <div class="col-sm-4">
	                        <button class="btn pull-right btn-success btn-md" type = "submit">Save</button>
	                      </div>
	                    </div>
	                  </div>
	                </div>
	              </div>
	              <div class="col-sm-12">
	                  <div class="row">
	                    <div class="col-sm-4">
	                      <span class="label label-info">Username</span>
	                    </div>
	                    <div class="col-sm-8">
	                      <input name = "name" type="text" class="form-control input-sm" value = "<%=session.getAttribute("username") %>">
	                    </div>
	                  </div>
	                  <div class="row">
	                    <div class="col-sm-4">
	                      <span class="label label-info">e-mail</span>
	                    </div>
	                    <div class="col-sm-8">
	                      <input name = "email" type="text" class="form-control input-sm" value = "<%=session.getAttribute("email") %>">
	                    </div>
	                  </div>
	                  <div class="row">
	                    <div class="col-sm-4">
	                      <span class="label label-info">Height</span>
	                    </div>
	                    <div class="col-sm-8">
	                      <input name = "height" type="text" class="form-control input-sm" value = "<%=session.getAttribute("height") %>">
	                    </div>
	                  </div>
	                  <div class="row">
	                    <div class="col-sm-4">
	                      <span class="label label-info">Weight</span>
	                    </div>
	                    <div class="col-sm-8">
	                      <input name = "weight" type="text" class="form-control input-sm" value = "<%=session.getAttribute("weight") %>">
	                    </div>
	                  </div>
	                  <div class="row">
	                    <div class="col-sm-4">
	                      <span class="label label-info">Exercise</span>
	                    </div>
	                    <div class="col-sm-8">
	                    <%-- <input type="range" min="1" max="5" value="<%=session.getAttribute("exerciseNo") %>" step="1" onchange="showValue(this.value)" />
	                      <span id="range">"showValue(<%=session.getAttribute("exerciseNo") %>)"</span> --%>
	                      <div class="birthday-drop">
	                        <select name="exercise" class="form-control" >
	                          <option value="<%=session.getAttribute("exerciseNo") %>" selected><%=session.getAttribute("exercise") %></option>
							  <option value="1">Desk job with little exercise</option>
                              <option value="2">1-3hrs/week of light exercise</option>
                              <option value="3">3-5hrs/week of moderate exercise</option>
                              <option value="4">5-6hrs/week of strenuous exercise</option>
                              <option value="5">7-21hrs/week of strenuous exercise/work</option>
	                        </select>
	                      </div>
	                    </div>
	                  </div>
	                  <div class="row">
	                    <div class="col-sm-4">
	                      <span class="label label-info">Date of Birth</span>
	                    </div>
	                    <div class="col-sm-8">
	                      <div class="birthday-drop">
	                        <select name="date" class="form-control">
	                          <option value="<%=session.getAttribute("DD") %>" selected><%=session.getAttribute("Day") %></option>
	                          <option value="1">1</option>
	                          <option value="2">2</option>
	                          <option value="3">3</option>
	                          <option value="4">4</option>
	                          <option value="5">5</option>
	                          <option value="6">6</option>
	                          <option value="7">7</option>
	                          <option value="8">8</option>
	                          <option value="9">9</option>
	                          <option value="10">10</option>
	                          <option value="11">11</option>
	                          <option value="12">12</option>
	                          <option value="13">13</option>
	                          <option value="14">14</option>
	                          <option value="15">15</option>
	                          <option value="16">16</option>
	                          <option value="17">17</option>
	                          <option value="18">18</option>
	                          <option value="19">19</option>
	                          <option value="20">20</option>
	                          <option value="21">21</option>
	                          <option value="22">22</option>
	                          <option value="23">23</option>
	                          <option value="24">24</option>
	                          <option value="25">25</option>
	                          <option value="26">26</option>
	                          <option value="27">27</option>
	                          <option value="28">28</option>
	                          <option value="29">29</option>
	                          <option value="30">30</option>
	                          <option value="31">31</option>
	                        </select>
	                        <select name="month" class="form-control">
	                          <option value="<%=session.getAttribute("MM") %>" selected><%=session.getAttribute("Month") %></option>
	                          <option value="1">Jan</option>
	                          <option value="2">Feb</option>
	                          <option value="3">Mar</option>
	                          <option value="4">Apr</option>
	                          <option value="5">May</option>
	                          <option value="6">Jun</option>
	                          <option value="7">Jul</option>
	                          <option value="8">Aug</option>
	                          <option value="9">Sept</option>
	                          <option value="10">Oct</option>
	                          <option value="11">Nov</option>
	                          <option value="12">Dec</option>
	                        </select>
	                        <select name="year" class="form-control">
	                          <option value="<%=session.getAttribute("YYYY") %>" selected><%=session.getAttribute("Year") %></option>
	                          <option value="2015">2015</option>
	                          <option value="2014">2014</option>
	                          <option value="2013">2013</option>
	                          <option value="2012">2012</option>
	                          <option value="2011">2011</option>
	                          <option value="2010">2010</option>
	                          <option value="2009">2009</option>
	                          <option value="2008">2008</option>
	                          <option value="2007">2007</option>
	                          <option value="2006">2006</option>
	                          <option value="2005">2005</option>
	                          <option value="2004">2004</option>
	                          <option value="2003">2003</option>
	                          <option value="2002">2002</option>
	                          <option value="2001">2001</option>
	                          <option value="2000">2000</option>
	                          <option value="1999">1999</option>
	                          <option value="1998">1998</option>
	                          <option value="1997">1997</option>
	                          <option value="1996">1996</option>
	                          <option value="1995">1995</option>
	                          <option value="1994">1994</option>
	                          <option value="1993">1993</option>
	                          <option value="1992">1992</option>
	                          <option value="1991">1991</option>
	                          <option value="1990">1990</option>
	                          <option value="1989">1989</option>
	                          <option value="1988">1988</option>
	                          <option value="1987">1987</option>
	                          <option value="1986">1986</option>
	                          <option value="1985">1985</option>
	                          <option value="1984">1984</option>
	                          <option value="1983">1983</option>
	                          <option value="1982">1982</option>
	                          <option value="1981">1981</option>
	                          <option value="1980">1980</option>
	                          <option value="1979">1979</option>
	                          <option value="1978">1978</option>
	                          <option value="1977">1977</option>
	                          <option value="1976">1976</option>
	                          <option value="1975">1975</option>
	                          <option value="1974">1974</option>
	                          <option value="1973">1973</option>
	                          <option value="1972">1972</option>
	                          <option value="1971">1971</option>
	                          <option value="1970">1970</option>
	                          <option value="1969">1969</option>
	                          <option value="1968">1968</option>
	                          <option value="1967">1967</option>
	                          <option value="1966">1966</option>
	                          <option value="1965">1965</option>
	                          <option value="1964">1964</option>
	                          <option value="1963">1963</option>
	                          <option value="1962">1962</option>
	                          <option value="1961">1961</option>
	                          <option value="1960">1960</option>
	                          <option value="1959">1959</option>
	                          <option value="1958">1958</option>
	                          <option value="1957">1957</option>
	                          <option value="1956">1956</option>
	                          <option value="1955">1955</option>
	                          <option value="1954">1954</option>
	                          <option value="1953">1953</option>
	                          <option value="1952">1952</option>
	                          <option value="1951">1951</option>
	                          <option value="1950">1950</option>
	                          <option value="1949">1949</option>
	                          <option value="1948">1948</option>
	                          <option value="1947">1947</option>
	                          <option value="1946">1946</option>
	                          <option value="1945">1945</option>
	                          <option value="1944">1944</option>
	                          <option value="1943">1943</option>
	                          <option value="1942">1942</option>
	                          <option value="1941">1941</option>
	                          <option value="1940">1940</option>
	                          <option value="1939">1939</option>
	                          <option value="1938">1938</option>
	                          <option value="1937">1937</option>
	                          <option value="1936">1936</option>
	                          <option value="1935">1935</option>
	                          <option value="1934">1934</option>
	                          <option value="1933">1933</option>
	                          <option value="1932">1932</option>
	                          <option value="1931">1931</option>
	                          <option value="1930">1930</option>
	                          <option value="1929">1929</option>
	                          <option value="1928">1928</option>
	                          <option value="1927">1927</option>
	                          <option value="1926">1926</option>
	                          <option value="1925">1925</option>
	                          <option value="1924">1924</option>
	                          <option value="1923">1923</option>
	                          <option value="1922">1922</option>
	                          <option value="1921">1921</option>
	                          <option value="1920">1920</option>
	                          <option value="1919">1919</option>
	                          <option value="1918">1918</option>
	                          <option value="1917">1917</option>
	                          <option value="1916">1916</option>
	                          <option value="1915">1915</option>
	                          <option value="1914">1914</option>
	                          <option value="1913">1913</option>
	                          <option value="1912">1912</option>
	                          <option value="1911">1911</option>
	                          <option value="1910">1910</option>
	                          <option value="1909">1909</option>
	                          <option value="1908">1908</option>
	                          <option value="1907">1907</option>
	                          <option value="1906">1906</option>
	                          <option value="1905">1905</option>
	                        </select>
	                      </div>
	                    </div>
	                  </div>
	                  <div class="row">
	                    <div class="col-sm-4">
	                      <span class="label label-info">Gender</span>
	                    </div>
	                    <div class="col-sm-8">
	                      <div class="birthday-drop">
	                        <select name="gender" class="form-control">
	                          <option value="<%=session.getAttribute("genderChar") %>" selected><%=session.getAttribute("genderDisp") %></option>
	                          <option value="M">Male</option>
	                          <option value="F">Female</option>
	                        </select>
	                      </div>
	                    </div>
	                  </div>
	              </div>    
	           </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>