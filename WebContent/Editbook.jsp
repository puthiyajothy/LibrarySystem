<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.srg.data.*, com.srg.model.*, com.controller.*, ComUtil.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
    
<html>
<head>
	<title>Application </title>
	<script language="javascript" type="text/javascript">  
     var xmlHttp  
     var xmlHttp
     function showState(str){
   	 //alert(str);
   	 
     if (typeof XMLHttpRequest != "undefined"){
     xmlHttp= new XMLHttpRequest();
     }
     else if (window.ActiveXObject){
     xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
     }
     if (xmlHttp==null){
     alert("Browser does not support XMLHTTP Request")
     return;
     } 
     var url ="combosubclass.jsp";
     url +="?count=" +str;
     
     xmlHttp.onreadystatechange = stateChange;
     xmlHttp.open("GET", url, true);
     stateChange();
     xmlHttp.send(null);
     }

     function stateChange(){   
     if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
     document.getElementById("subClassification").innerHTML=xmlHttp.responseText   
     }   
     }
     </script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<%
	String updatebookId=request.getParameter("id");
	Book book = BookDao.getRecordById(updatebookId);
%>


<form action="updateBook" method="get" >

<br>
<div class="container">
  
    
       <div class="col-md-12">
         <div class="tile">
         <h3 class="tile-title">Edit Books</h3><br>
         	<div class="tile-body">
						
			<table>		
			<input type="hidden" name="bookid" value="<%=book.getBookId() %>"/>
			<div class="form-row">
					    <div class="col-md-4">
					 	  <label class="control-label">Book ID:</label>
					      <input type="text" name="bookid" class="form-control" value="<%=book.getBookId() %>"/>
					 </div>
					 </div>

					 <div class="form-row">
					 <div class="col-md-4">
					 	 <label class="control-label">Book Title:</label>
					      <input type="text"  name="booktitle" class="form-control" value="<%=book.getBookTitle()%> "/>
					      </div>
					 </div>
					 </div>
					 
				</div>
<br>
				 <div class="form-row">
					 <div class="col-md-4">
					 	  <label class="control-label">Book Author:</label>
					      <input type="text" name="bookauthor" class="form-control" value="<%=book.getBookauthor() %>"/>
					 </div>
					 </div>
<br>
					 
					 <div class="form-row">
					 <div class="col-md-4">
					 	  <label class="control-label">Year of Published:</label>
					      <input type="text" name="bookpublish" class="form-control" value="<%=book.getBookpublish() %>"/>
					   </div>
					 </div>    
<br>
					<select name="mainclassificationname" id="mainClassification" onchange="showState(this.value)">
<%try{

String Query = "select * from classification";
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();	
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
PreparedStatement pstmt = con.prepareStatement(Query);
ResultSet rs = pstmt.executeQuery();
while(rs.next()){
%>
<option value="<%=rs.getString("mainclassificationname")%>"><%=rs.getString("mainclassificationname") %></option>
<% 
}
}
catch(Exception ex){
ex.printStackTrace();
} %>
</select> </td>
</tr>
<tr>
<td>sub classification:</td>
<td>
<select name="subClassification" id="subClassification"></select></td>
				
					  <div class="form-row">
					 <div class="col-md-4">
					 <br>
					<button type="submit" class="btn btn-danger">Update</button>
					</table>
					<tr>
						<td>${bookObj.bookid}</td>
						<td>${bookObj.booktitle}</td>
						<td>${bookObj.bookauthor}</td>
						<td>${bookObj.bookpublish}</td>
						<td>${bookObj.classification}</td>
					</div>	
					 </div>
					 </div>
					 </div>
					 </div>
					 </div>
					
			</div>
			</div>
			</div>
			</div>
			</div>
			</div>
				  
 </form>
</body>
</html>