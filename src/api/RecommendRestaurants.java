package api;

import java.io.IOException;
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
 * Servlet implementation class RecommendRestaurants
 */
@WebServlet("/recommendation")
public class RecommendRestaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DBConnection connection = new DBConnection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecommendRestaurants() {
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
		if (request.getParameterMap().containsKey("user_id")) {
			String userId = request.getParameter("user_id");
			array = connection.RecommendRestaurants(userId);

		}

		RpcParser.writeOutput(response, array);
		/*
		 * JSONArray array = new JSONArray(); try { if
		 * (request.getParameterMap().containsKey("user_id")) { String userId =
		 * request.getParameter("user_id"); // return some fake restaurants zhi
		 * hou yao tian wan zheng array.put(new JSONObject().put("name",
		 * "Panda Express" ).put("location" , "downtown").put("country" ,
		 * "united statesn")); array.put(new JSONObject().put("name",
		 * "Hong Kong Express" ).put("location" , "uptown").put("country" ,
		 * "united statesn")); } } catch (JSONException e) {
		 * e.printStackTrace(); } RpcParser.writeOutput(response, array);
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
