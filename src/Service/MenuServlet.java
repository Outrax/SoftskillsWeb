package Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import Entities.User;

/**
 * Servlet implementation class MinServlet
 */
@WebServlet(name = "MinServlet", urlPatterns = {"/MinServlet"})
public class MenuServlet extends HttpServlet {
       
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        
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



//out.println("<!DOCTYPE html>");
//out.println("<html>");
//out.println("<head>");
//
//out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\">");
//out.println("<title>Softskills Toolbox</title>");
//out.println("</head>");
//out.println("<body>");
//out.println("<h1>Softskills Toolbox</h1>");
//
//out.println("</body>");
//out.println("</html>");
            User user = null;
            
            
            
            
            




        }
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//RequestDispatcher view = request.getRequestDispatcher("/Application/index.html");
        //view.forward(request, response);
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<title>Softskills Toolbox - Dashboard</title>");

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
        				
        					out.println("<a href='#' class='dropdown-toggle' data-toggle='dropdown'><svg class='glyph stroked male-user'><use xlink:href='#stroked-male-user'></use></svg> Bruger <span class='caret'></span></a>");
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
        			out.println("<input type='text' class='form-control' placeholder='Søg'>");
        				out.println("</div>");
        			out.println("</form>");
        		out.println("<ul class='nav menu'>");
        		out.println("<li class='active'><a href='MinServlet'><svg class='glyph stroked dashboard-dial'><use xlink:href='#stroked-dashboard-dial'></use></svg> Kontrolpanel</a></li>");
        			out.println("<li><a href='ResultatServlet'><svg class='glyph stroked line-graph'><use xlink:href='#stroked-line-graph'></use></svg> Resultater</a></li>");
        			out.println("<li><a href='panels.html'><svg class='glyph stroked app-window'><use xlink:href='#stroked-app-window'></use></svg> Alerts &amp; Panels</a></li>");
        			out.println("<li><a href='icons.html'><svg class='glyph stroked star'><use xlink:href='#stroked-star'></use></svg> Icons</a></li>");
        			out.println("<li role='presentation' class='divider'></li>");
        			
        			out.println("</ul>");
        		
        		out.println("</div><!--/.sidebar-->");
        		
        	out.println("<div class='col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main'>");			
        	out.println("<div class='row'>");
        		out.println("<ol class='breadcrumb'>");
        			out.println("<li><a href='#'><svg class='glyph stroked home'><use xlink:href='#stroked-home'></use></svg></a></li>");
        				out.println("<li class='active'>Kontrolpanel</li>");
        				out.println("</ol>");
        			out.println("</div><!--/.row-->");
        		
        		out.println("<div class='row'>");
        		out.println("<div class='col-lg-12'>");
        			out.println("<h1 class='page-header'>Dashboard</h1>");
        				out.println("</div>");
        			out.println("</div><!--/.row-->");
        		
        		out.println("<div class='row'>");
        		out.println("<div class='col-xs-12 col-md-6 col-lg-3'>");
        			out.println("<div class='panel panel-blue panel-widget '>");
        				out.println("<div class='row no-padding'>");
        					out.println("<div class='col-sm-3 col-lg-5 widget-left'>");
        						out.println("<svg class='glyph stroked bag'><use xlink:href='#stroked-bag'></use></svg>");
        							out.println("</div>");
        						out.println("<div class='col-sm-9 col-lg-7 widget-right'>");
        						out.println("<div class='large'>120</div>");
        							out.println("<div class='text-muted'>Solgte profiler</div>");
        							out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				out.println("</div>");
        			out.println("<div class='col-xs-12 col-md-6 col-lg-3'>");
        			out.println("<div class='panel panel-orange panel-widget'>");
        				out.println("<div class='row no-padding'>");
        					out.println("<div class='col-sm-3 col-lg-5 widget-left'>");
        						out.println("<svg class='glyph stroked app-window-with-content'><use xlink:href='#stroked-app-window-with-content'></use></svg>");
        							out.println("</div>");
        						out.println("<div class='col-sm-9 col-lg-7 widget-right'>");
        						out.println("<div class='large'>52</div>");
        							out.println("<div class='text-muted'>Ufærdige profiler</div>");
        							out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				out.println("</div>");
        			out.println("<div class='col-xs-12 col-md-6 col-lg-3'>");
        			out.println("<div class='panel panel-teal panel-widget'>");
        				out.println("<div class='row no-padding'>");
        					out.println("<div class='col-sm-3 col-lg-5 widget-left'>");
        						out.println("<svg class='glyph stroked male-user'><use xlink:href='#stroked-male-user'></use></svg>");
        							out.println("</div>");
        						out.println("<div class='col-sm-9 col-lg-7 widget-right'>");
        						out.println("<div class='large'>24</div>");
        							out.println("<div class='text-muted'>Nye brugere</div>");
        							out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				out.println("</div>");
        			out.println("<div class='col-xs-12 col-md-6 col-lg-3'>");
        			out.println("<div class='panel panel-red panel-widget'>");
        				out.println("<div class='row no-padding'>");
        					out.println("<div class='col-sm-3 col-lg-5 widget-left'>");
        						out.println("<svg class='glyph stroked eye'><use xlink:href='#stroked-eye'/></svg>");
        							out.println("</div>");
        						out.println("<div class='col-sm-9 col-lg-7 widget-right'>");
        						out.println("<div class='large'>25</div>");
        							out.println("<div class='text-muted'>Brugere online</div>");
        							out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				out.println("</div>");
        			out.println("</div><!--/.row-->");
        		
        		out.println("<div class='row'>");
        		out.println("<div class='col-lg-12'>");
        			out.println("<div class='panel panel-default'>");
        				out.println("<div class='panel-heading'>Overblik</div>");
        					out.println("<div class='panel-body'>");
        					out.println("<div class='canvas-wrapper'>");
        						out.println("<canvas class='main-chart' id='line-chart' height='200' width='600'></canvas>");
        							out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				out.println("</div>");
        			out.println("</div><!--/.row-->");
        		
        		out.println("<div class='row'>");
        		out.println("<div class='col-xs-6 col-md-3'>");
        			out.println("<div class='panel panel-default'>");
        				out.println("<div class='panel-body easypiechart-panel'>");
        					out.println("<h4>Solgte profiler</h4>");
        						out.println("<div class='easypiechart' id='easypiechart-blue' data-percent='92' ><span class='percent'>92%</span>");
        						out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				out.println("</div>");
        			out.println("<div class='col-xs-6 col-md-3'>");
        			out.println("<div class='panel panel-default'>");
        				out.println("<div class='panel-body easypiechart-panel'>");
        					out.println("<h4>Ufærdige profiler</h4>");
        						out.println("<div class='easypiechart' id='easypiechart-orange' data-percent='65' ><span class='percent'>65%</span>");
        						out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				out.println("</div>");
        			out.println("<div class='col-xs-6 col-md-3'>");
        			out.println("<div class='panel panel-default'>");
        				out.println("<div class='panel-body easypiechart-panel'>");
        					out.println("<h4>Nye brugere</h4>");
        						out.println("<div class='easypiechart' id='easypiechart-teal' data-percent='56' ><span class='percent'>56%</span>");
        						out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				out.println("</div>");
        			out.println("<div class='col-xs-6 col-md-3'>");
        			out.println("<div class='panel panel-default'>");
        				out.println("<div class='panel-body easypiechart-panel'>");
        					out.println("<h4>Brugere online</h4>");
        						out.println("<div class='easypiechart' id='easypiechart-red' data-percent='27' ><span class='percent'>27%</span>");
        						out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				out.println("</div>");
        			out.println("</div><!--/.row-->");
        								
        		out.println("<div class='row'>");
        		out.println("<div class='col-md-8'>");
        			
        			out.println("<div class='panel panel-default chat'>");
        				out.println("<div class='panel-heading' id='accordion'><svg class='glyph stroked two-messages'><use xlink:href='#stroked-two-messages'></use></svg> App notifikationer</div>");
        					out.println("<div class='panel-body'>");
        					out.println("<ul>");
        						out.println("<li class='left clearfix'>");
        							out.println("<span class='chat-img pull-left'>");
        								out.println("<img src='http://placehold.it/80/30a5ff/fff' alt='User Avatar' class='img-circle' />");
        									out.println("</span>");
        								out.println("<div class='chat-body clearfix'>");
        								out.println("<div class='header'>");
        									out.println("<strong class='primary-font'>Testbesked 1</strong> <small class='text-muted'>32 minutter siden</small>");
        										out.println("</div>");
        									out.println("<p>");
        									out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ante turpis, rutrum ut ullamcorper sed, dapibus ac nunc. Vivamus luctus convallis mauris, eu gravida tortor aliquam ultricies.");
        										out.println("</p>");
        										out.println("</div>");
        								out.println("</li>");
        							out.println("<li class='left clearfix'>");
        							out.println("<span class='chat-img pull-left'>");
        								out.println("<img src='http://placehold.it/80/30a5ff/fff' alt='User Avatar' class='img-circle' />");
        									out.println("</span>");
        								out.println("<div class='chat-body clearfix'>");
        								out.println("<div class='header'>");
        									out.println("<strong class='primary-font'>Testbesked 2</strong> <small class='text-muted'>6 minutter siden</small>");
        										out.println("</div>");
        									out.println("<p>");
        									out.println("Mauris dignissim porta enim, sed commodo sem blandit non. Ut scelerisque sapien eu mauris faucibus ultrices. Nulla ac odio nisl. Proin est metus, interdum scelerisque quam eu, eleifend pretium nunc. Suspendisse finibus auctor lectus, eu interdum sapien.");
        										out.println("</p>");
        										out.println("</div>");
        								out.println("</li>");
        							out.println("<li class='left clearfix'>");
        							out.println("<span class='chat-img pull-left'>");
        								out.println("<img src='http://placehold.it/80/30a5ff/fff' alt='User Avatar' class='img-circle' />");
        									out.println("</span>");
        								out.println("<div class='chat-body clearfix'>");
        								out.println("<div class='header'>");
        									out.println("<strong class='primary-font'>Testbesked 3</strong> <small class='text-muted'>32 minutter siden</small>");
        										out.println("</div>");
        									out.println("<p>");
        									out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ante turpis, rutrum ut ullamcorper sed, dapibus ac nunc. Vivamus luctus convallis mauris, eu gravida tortor aliquam ultricies.");
        										out.println("</p>");
        										out.println("</div>");
        								out.println("</li>");
        							out.println("</ul>");
        						out.println("</div>");
        					
        					out.println("<div class='panel-footer'>");
        					out.println("<div class='input-group'>");
        						out.println("<input id='btn-input' type='text' class='form-control input-md' placeholder='Skriv din besked til brugere her...' />");
        							out.println("<span class='input-group-btn'>");
        							out.println("<button class='btn btn-success btn-md' id='btn-chat'>Send</button>");
        								out.println("</span>");
        							out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        				
        				out.println("</div><!--/.col-->");
        			
        			out.println("<div class='col-md-4'>");
        			
        			out.println("<div class='panel panel-blue'>");
        				out.println("<div class='panel-heading dark-overlay'><svg class='glyph stroked clipboard-with-paper'><use xlink:href='#stroked-clipboard-with-paper'></use></svg>To-do Liste</div>");
        					out.println("<div class='panel-body'>");
        					out.println("<ul class='todo-list'>");
        						out.println("<li class='todo-list-item'>");
        						out.println("<div class='checkbox'>");
        								out.println("<input type='checkbox' id='checkbox' />");
        									out.println("<label for='checkbox'>Lav planer for idag</label>");
        									out.println("</div>");
        								out.println("<div class='pull-right action-buttons'>");
        								out.println("<a href='#'><svg class='glyph stroked pencil'><use xlink:href='#stroked-pencil'></use></svg></a>");
        									out.println("<a href='#' class='flag'><svg class='glyph stroked flag'><use xlink:href='#stroked-flag'></use></svg></a>");
        									out.println("<a href='#' class='trash'><svg class='glyph stroked trash'><use xlink:href='#stroked-trash'></use></svg></a>");
        									out.println("</div>");
        								out.println("</li>");
        							out.println("<li class='todo-list-item'>");
        							out.println("<div class='checkbox'>");
        								out.println("<input type='checkbox' id='checkbox' />");
        									out.println("<label for='checkbox'>Opdatere DISC profilen</label>");
        									out.println("</div>");
        								out.println("<div class='pull-right action-buttons'>");
        								out.println("<a href='#'><svg class='glyph stroked pencil'><use xlink:href='#stroked-pencil'></use></svg></a>");
        									out.println("<a href='#' class='flag'><svg class='glyph stroked flag'><use xlink:href='#stroked-flag'></use></svg></a>");
        									out.println("<a href='#' class='trash'><svg class='glyph stroked trash'><use xlink:href='#stroked-trash'></use></svg></a>");
        									out.println("</div>");
        								out.println("</li>");
        							out.println("<li class='todo-list-item'>");
        							out.println("<div class='checkbox'>");
        								out.println("<input type='checkbox' id='checkbox' />");
        									out.println("<label for='checkbox'>Følge op på profiler</label>");
        									out.println("</div>");
        								out.println("<div class='pull-right action-buttons'>");
        								out.println("<a href='#'><svg class='glyph stroked pencil'><use xlink:href='#stroked-pencil'></use></svg></a>");
        									out.println("<a href='#' class='flag'><svg class='glyph stroked flag'><use xlink:href='#stroked-flag'></use></svg></a>");
        									out.println("<a href='#' class='trash'><svg class='glyph stroked trash'><use xlink:href='#stroked-trash'></use></svg></a>");
        									out.println("</div>");
        								out.println("</li>");
        							
        							out.println("<li class='todo-list-item'>");
        							out.println("<div class='checkbox'>");
        								out.println("<input type='checkbox' id='checkbox' />");
        									out.println("<label for='checkbox'>Gøre rent på skrivebord</label>");
        									out.println("</div>");
        								out.println("<div class='pull-right action-buttons'>");
        								out.println("<a href='#'><svg class='glyph stroked pencil'><use xlink:href='#stroked-pencil'></use></svg></a>");
        									out.println("<a href='#' class='flag'><svg class='glyph stroked flag'><use xlink:href='#stroked-flag'></use></svg></a>");
        									out.println("<a href='#' class='trash'><svg class='glyph stroked trash'><use xlink:href='#stroked-trash'></use></svg></a>");
        									out.println("</div>");
        								out.println("</li>");
        							out.println("</ul>");
        						out.println("</div>");
        					out.println("<div class='panel-footer'>");
        					out.println("<div class='input-group'>");
        						out.println("<input id='btn-input' type='text' class='form-control input-md' placeholder='Tilføj en ny opgave' />");
        							out.println("<span class='input-group-btn'>");
        							out.println("<button class='btn btn-primary btn-md' id='btn-todo'>Tilføj</button>");
        								out.println("</span>");
        							out.println("</div>");
        						out.println("</div>");
        					out.println("</div>");
        								
        				out.println("</div><!--/.col-->");
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
        	out.println("$('#calendar').datepicker({");
        			out.println("});");

        		out.println("!function ($) {");
        			out.println("$(document).on('click','ul.nav li.parent > a > span.icon', function(){");       
        		    	out.println("$(this).find('em:first').toggleClass('glyphicon-minus');");
        		        out.println("});");
        		    out.println(" $('.sidebar span.icon').find('em:first').addClass('glyphicon-plus');");
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
