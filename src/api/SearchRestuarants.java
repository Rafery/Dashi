package api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;

/**
 * Servlet implementation class SearchRestuarants
 */
@WebServlet("/restaurants")
public class SearchRestuarants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DBConnection connection = new DBConnection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchRestuarants() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONArray array = new JSONArray();

		if (request.getParameterMap().containsKey("user_id") && request.getParameterMap().containsKey("lat")
				&& request.getParameterMap().containsKey("lon")) {
			String userId = request.getParameter("user_id");
			double lat = Double.parseDouble(request.getParameter("lat"));
			double lon = Double.parseDouble(request.getParameter("lon"));
			/*
			 * // return some fake restaurants zhi hou yao tian wan zheng
			 * array.put(new JSONObject().put("name", "Panda Express"));
			 * array.put(new JSONObject().put("name", "Hong Kong Express"));
			 */
			array = connection.SearchRestaurants(userId, lat, lon);
		}

		RpcParser.writeOutput(response, array);

		/*
		 * //3.0 response.setContentType("application/json");
		 * response.addHeader("Access-Control-Allow-Origin", "*"); String
		 * username = ""; if (request.getParameter("username") != null) {
		 * username = request.getParameter("username"); } JSONObject obj = new
		 * JSONObject(); try { obj.put("username", username); } catch
		 * (JSONException e) { e.printStackTrace(); } PrintWriter out =
		 * response.getWriter(); out.print(obj); out.flush(); out.close();
		 * 
		 */
		/*
		 * //2.0 response.setContentType("text/html"); PrintWriter out =
		 * response.getWriter(); out.println("<html><body>"); out.println(
		 * "<h1>This is a HTML page</h1>"); out.println("</body></html>");
		 * out.flush(); out.close();
		 */
		/*
		 * //1.0 response.setContentType("application/json");
		 * response.addHeader("Access-Control-Allow-Origin", "*"); String
		 * username = ""; PrintWriter out = response.getWriter(); if
		 * (request.getParameter("username") != null) { username =
		 * request.getParameter("username"); out.print("Hello " + username); }
		 * out.flush();//shua xin ye mian out.close();
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
