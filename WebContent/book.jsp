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
<c:if test="${book == null}">
<form action="addbooks" method="post" onsubmit="return Validate()" name="vform" >
</c:if>
<br>
<div class="container"">
  
    
       <div class="col-md-12">
         <div class="tile">
         <h3 class="tile-title">Add New Books</h3><br>
         	<div class="tile-body">
						
						<div class="form-row">
					    <div class="col-md-4">
					 	  <label class="control-label">Book ID:</label>
					      <input type="text" name="bookid" class="form-control" placeholder="001">
					      <div id="bookid_error" class="val_error"></div>
					 </div>
					 </div>

					 <div class="form-row">
					 <div class="col-md-4">
					 	 <label class="control-label">Book Title:</label>
					      <input type="text"  name="booktitle" class="form-control" placeholder="Information System">
					       <div id="boktitle_error"  class="val_error"></div>
					      </div>
					 </div>
					 </div>
					 
				</div>
<br>
				 <div class="form-row">
					 <div class="col-md-4">
					 	  <label class="control-label">Book Author:</label>
					      <input type="text" name="bookauthor" class="form-control" placeholder="johan">
					       <div id="bookauthor_error"  class="val_error"></div>
					 </div>
					 </div>
<br>
					 
					 <div class="form-row">
					 <div class="col-md-4">
					 	  <label class="control-label">Year of Published:</label>
					      <input type="number" name="bookpublish" class="form-control" id="id1" max="" placeholder="2000">
					       <div id="bookpublish_error"  class="val_error"></div>
<br>
					<div class="form-row">
					<div class="col-md-4">
					       <td>main classification:</td>
<td>

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

</tr>
					 <br>
					<button type="submit" class="btn btn-danger" onclick="myFunction()" >Add</button>
					</div>	
					 </div>
					 </div>
					 </div>
					 </div>
					 </div>
</form>
					
 
</body>
</html>

<script type="text/javascript">

//SELECTING ALL TEXT ELEMENTS
var bookid = document.forms['vform']['bookid'];
var booktitle = document.forms['vform']['booktitle'];
var bookauthor = document.forms['vform']['bookauthor'];
var bookpublish = document.forms['vform']['bookpublish'];

// SELECTING ALL ERROR DISPLAY ELEMENTS
var bookid_error= document.getElementById('bookid_error');
var boktitle_error= document.getElementById('boktitle_error');
var bookauthor_error = document.getElementById('bookauthor_error');
var bookpublish_error = document.getElementById('bookpublish_error')

// SETTING ALL EVENT LISTENERS

bookid.addEventListener('blur', bookidVerify, true);
booktitle.addEventListener('blur', booktitleVerify, true);
bookauthor.addEventListener('blur', bookauthorVerify, true);
bookpublish.addEventListener('blur', bookpublishVerify, true);

// validation function

function Validate() {
  // validate username
   if (bookid.value == "") {
	  //bookid.style.border = "1px solid red";
    document.getElementById('bookid_div').style.color = "red";
    bookid_error.textContent = "BookId is required";
    bookid_error.focus();
    return false;
  }
  
// event handler functions
function bookidVerify() {
  if (bookid.value != "") {
   //bookid.style.border = "1px solid #5e6e66";
   document.getElementById('bookid_div').style.color = "#5e6e66";
   bookid_error.innerHTML = "";
   return true;
  }
}

}
</script>