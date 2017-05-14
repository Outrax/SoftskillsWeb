package Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import Entities.User;
import Util.Firebase;

/**
 * Servlet implementation class ResultatServlet
 */
@WebServlet("/ResultatServlet")
public class ResultatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {


        	URL url = new URL("http://ubuntu4.javabog.dk:9959/softskills?wsdl");
            QName qname = new QName("http://Service/", "ServermanagerService");
            QName qnameport = new QName("http://Service/", "ServermanagerPort");
            Service service = Service.create(url, qname);
            ServerI s = service.getPort(qnameport,ServerI.class);
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String bruger = request.getParameter("user");
		Firebase firebase = new Firebase();
   	 	User user = firebase.getUser(bruger);
		//RequestDispatcher view = request.getRequestDispatcher("/Application/index.html");
        //view.forward(request, response);
		
		out.println("!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<title>Softskills - Resultater</title>");

		out.println("<link href='Application/css/bootstrap.min.css' rel='stylesheet'>");
		out.println("<link href='Application/css/datepicker3.css' rel='stylesheet'>");
		out.println("<link href='Application/css/styles.css' rel='stylesheet'>");

		out.println("<!--Icons-->");
		out.println("<script src='Application/js/lumino.glyphs.js'></script>");

		out.println("<!--[if lt IE 9]>");
		out.println("<script src='Application/js/html5shiv.js'></script>");
		out.println("<script src='Application/js/respond.min.js'></script>");
		out.println("<![endif]-->");

		out.println("</head>");

		out.println("<body>");
		out.println("<nav class='navbar navbar-inverse navbar-fixed-top' role='navigation'>");
			out.println("<div class='container-fluid'>");
				out.println("<div class='navbar-header'>");
					out.println("<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#sidebar-collapse'>");
							out.println("<span class='sr-only'>Toggle navigation</span>");
							out.println("<span class='icon-bar'></span>");
							out.println("<span class='icon-bar'></span>");
							out.println("<span class='icon-bar'></span>");
							out.println("</button>");
						out.println("<a class='navbar-brand' href='#'><span>Softskills</span>Backend</a>");
						out.println("<ul class='user-menu'>");
						out.println("<li class='dropdown pull-right'>");
							out.println("<a href='#' class='dropdown-toggle' data-toggle='dropdown'><svg class='glyph stroked male-user'><use xlink:href='#stroked-male-user'></use></svg>"+"Velkommen "+user.getFullName()+"<span class='caret'></span></a>");
								out.println("<ul class='dropdown-menu' role='menu'>");
								out.println("<li><a href='#'><svg class='glyph stroked male-user'><use xlink:href='#stroked-male-user'></use></svg> Profil</a></li>");
									out.println("<li><a href='#'><svg class='glyph stroked gear'><use xlink:href='#stroked-gear'></use></svg> Indstillinger</a></li>");
									out.println("<li><a href='#'><svg class='glyph stroked cancel'><use xlink:href='#stroked-cancel'></use></svg> Log ud</a></li>");
									out.println("</ul>");
								out.println("</li>");
							out.println("</ul>");
						out.println("</div>");
									
					out.println("</div><!-- /.container-fluid -->");
				out.println("</nav>");
				
			out.println("<div id='sidebar-collapse' class='col-sm-3 col-lg-2 sidebar'>");
			out.println("<form role='search'>");
				out.println("<div class='form-group'>");
					out.println("	<input type='text' class='form-control' placeholder='Søg'>");
						out.println("</div>");
					out.println("</form>");
				out.println("<ul class='nav menu'>");
				out.println("<li><a href='MinServlet?user="+user.getEmail()+"'><svg class='glyph stroked dashboard-dial'><use xlink:href='#stroked-dashboard-dial'></use></svg> Kontrolpanel</a></li>");
					out.println("<li class='active'><a href='ResultatServlet''><svg class='glyph stroked line-graph'><use xlink:href='#stroked-line-graph'></use></svg> Resultater</a></li>");
					out.println("<li role='presentation' class='divider'></li>");
					
					out.println("</ul>");
				
				out.println("</div><!--/.sidebar-->");
				
			out.println("<div class='col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main'>");		
			out.println("<div class='row'>");
				out.println("<ol class='breadcrumb'>");
					out.println("<li><a href='#'><svg class='glyph stroked home'><use xlink:href='#stroked-home'></use></svg></a></li>");
						out.println("	<li class='active'>Resultater</li>");
						out.println("</ol>");
					out.println("</div><!--/.row-->");
				
				out.println("<div class='row'>");
				out.println("<div class='col-lg-12'>");
					out.println("<h1 class='page-header'>Charts</h1>");
						
						out.println("</div>");
					out.println("</div><!--/.row-->");
				
				out.println("<div class='row'>");
				out.println("<div class='col-lg-12'>");
					out.println("<div class='panel panel-default'>");
						out.println("<div class='panel-heading'>Line Chart</div>");
							out.println("<div class='panel-body'>");
							out.println("<div class='canvas-wrapper'>");
								out.println("<canvas class='main-chart' id='line-chart' height='200' width='600'></canvas>");
									out.println("</div>");
								out.println("</div>");
							out.println("</div>");
						out.println("</div>");
					out.println("</div><!--/.row-->");
				
				out.println("<div class='row'>");
				out.println("<div class='col-lg-12'>");
					out.println("<div class='panel panel-default'>");
						out.println("<div class='panel-heading'>Bar Chart</div>");
							out.println("<div class='panel-body'>");
							out.println("<div class='canvas-wrapper'>");
								out.println("<canvas class='main-chart' id='bar-chart' height='200' width='600'></canvas>");
									out.println("</div>");
								out.println("</div>");
							out.println("</div>");
						out.println("</div>");
					out.println("</div><!--/.row-->");
				
				out.println("<div class='row'>");
				out.println("<div class='col-md-6'>");
					out.println("<div class='panel panel-default'>");
						out.println("<div class='panel-heading'>Pie Chart</div>");
							out.println("<div class='panel-body'>");
							out.println("<div class='canvas-wrapper'>");
								out.println("<canvas class='chart' id='pie-chart' ></canvas>");
									out.println("</div>");
								out.println("</div>");
							out.println("</div>");
						out.println("</div>");
					out.println("<div class='col-md-6'>");
					out.println("<div class='panel panel-default'>");
						out.println("<div class='panel-heading'>Doughnut Chart</div>");
							out.println("<div class='panel-body'>");
							out.println("<div class='canvas-wrapper'>");
								out.println("<canvas class='chart' id='doughnut-chart' ></canvas>");
									out.println("</div>");
								out.println("</div>");
							out.println("</div>");
						out.println("</div>");
					out.println("</div><!--/.row-->");
				
				out.println("<div class='row'>");
				out.println("<div class='col-xs-6 col-md-3'>");
					out.println("<div class='panel panel-default'>");
						out.println("<div class='panel-body easypiechart-panel'>");
							out.println("<h4>Label:</h4>");
								out.println("<div class='easypiechart' id='easypiechart-blue' data-percent='92' ><span class='percent'>92%</span>");
								out.println("</div>");
								out.println("</div>");
							out.println("</div>");
						out.println("</div>");
					out.println("<div class='col-xs-6 col-md-3'>");
					out.println("<div class='panel panel-default'>");
						out.println("<div class='panel-body easypiechart-panel'>");
							out.println("<h4>Label:</h4>");
								out.println("<div class='easypiechart' id='easypiechart-orange' data-percent='65' ><span class='percent'>65%</span>");
								out.println("</div>");
								out.println("</div>");
							out.println("</div>");
						out.println("</div>");
					out.println("<div class='col-xs-6 col-md-3'>");
					out.println("<div class='panel panel-default'>");
						out.println("<div class='panel-body easypiechart-panel'>");
							out.println("<h4>Label:</h4>");
								out.println("<div class='easypiechart' id='easypiechart-teal' data-percent='56' ><span class='percent'>56%</span>");
								out.println("</div>");
								out.println("</div>");
							out.println("</div>");
						out.println("</div>");
					out.println("<div class='col-xs-6 col-md-3'>");
					out.println("<div class='panel panel-default'>");
						out.println("<div class='panel-body easypiechart-panel'>");
							out.println("<h4>Label:</h4>");
								out.println("<div class='easypiechart' id='easypiechart-red' data-percent='27' ><span class='percent'>27%</span>");
								out.println("</div>");
								out.println("	</div>");
							out.println("</div>");
						out.println("</div>");
					out.println("</div><!--/.row-->");
													
				out.println("</div>	<!--/.main-->");
			  

			out.println("<script src='Application/js/jquery-1.11.1.min.js'></script>");
			out.println("<script src='Application/js/bootstrap.min.js'></script>");
			out.println("<script src='Application/js/chart.min.js'></script>");
			out.println("<script src='Application/js/chart-data.js'></script>");
			out.println("<script src='Application/js/easypiechart.js'></script>");
			out.println("<script src='Application/js/easypiechart-data.js'></script>");
			out.println("<script src='Application/js/bootstrap-datepicker.js'></script>");
			out.println("<script>");
			out.println("!function ($) {");
					out.println("$(document).on('click','ul.nav li.parent > a > span.icon', function(){");         
				    	out.println("$(this).find('em:first').toggleClass('glyphicon-minus');");      
				        out.println("});"); 
				    out.println("$('.sidebar span.icon').find('em:first').addClass('glyphicon-plus');");
				    out.println("}(window.jQuery);");

				out.println("$(window).on('resize', function () {");
					out.println("if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')");
				  out.println("})");
				out.println("$(window).on('resize', function () {");
					out.println("if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')");
				  out.println("})");
				out.println("</script>");
				out.println("</body>");

		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		name = request.getParameter("name");
        processRequest(request, response);
	}
	
	/**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}