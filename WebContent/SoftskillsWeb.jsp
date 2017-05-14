<%@page import="Entities.User"%>
<%@page import="brugerautorisation.Brugeradmin"%>
<%@page import="Service.ServerI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Util.FireBaseDriver" %>
<%@page import="Util.*" %>
<%@page import="java.io.*" %>
<%@page import="org.codehaus.jackson.map.*" %>
<%@page import="org.apache.*" %>
<%@ page import="java.util.Scanner,javax.xml.namespace.QName,javax.xml.ws.Service,java.net.URL,java.net.MalformedURLException" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
       <title>Softskills Toolbox</title>
    </head>
    <body>
    
    
    

    
        <%
        
        //jacobs server
        URL url = new URL("http://ubuntu4.javabog.dk:9959/softskills?wsdl");
        QName qname = new QName("http://Service/", "ServermanagerService");
        QName qnameport = new QName("http://Service/", "ServermanagerPort");
        Service service = Service.create(url, qname);
        ServerI s = service.getPort(qnameport,ServerI.class);
        
        URL url1 = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
        QName qname1 = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
        QName qnameport2 = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplPort");
        Service service2 = Service.create(url1, qname1);
        Brugeradmin ba = service2.getPort(qnameport2,Brugeradmin.class);
        
  
        
  String name = request.getParameter("name");
  String pass = request.getParameter("pass");
  
  
  if (name == null || pass == null) {
    %>
    <div class="form">
    <form class="login-form" method="post" id="form1">
      <input type="text" name="name" id="input1" autofocus placeholder="studienummer"/>
      <input type="password" name="pass" id="input2" placeholder="kodeord"/>
      <input type="submit" name="OK" value="Log ind">
    </form>
    </div>
      
    <%
  } else {
	  while(true){
          User user;
          Boolean loggedin = false;
          try {
              loggedin = s.login(name, pass);
                  
          } catch(Exception e) {
              System.out.println(e);
          }
          if (loggedin) {
        	 Firebase firebase = new Firebase();
        	 user = firebase.getUser(name);
        	  
        	  
              break;
          }
         
            else {
                out.println("<p>Forkert bruger eller password</p>");
            }
        }

%>
<br>
                                                                                                    
<div class="form">
<div class="login-form">
<form method="POST" action="MinServlet">
<p>Velkommen <%out.println(name);%></p>

<input type="text" name="user" value="<%out.println(name);%>" readonly hidden/>

<input type="submit" name="guessKnap" value="Gå til kontrolpanel">

</form>
</div>
</div>
<%
   
}
    %>

    </body>
</html>