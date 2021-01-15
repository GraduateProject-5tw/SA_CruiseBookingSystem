package ncu.im3069.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import ncu.im3069.demo.app.StopPortHelper;
import ncu.im3069.tools.JsonReader;

/**
 * Servlet implementation class StopPortController
 */
@WebServlet(name = "api/stopPort.do", urlPatterns = { "/api/stopPort.do" })
public class StopPortController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StopPortHelper sPh = StopPortHelper.getHelper();

    public StopPortController() {
        super();
        // TODO Auto-generated constructor stub
    }

	//get 商品資訊
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
    	JsonReader jsr = new JsonReader(request);
    		
    	JSONObject resp = new JSONObject();
    	
    	JSONObject query = sPh.getAll();  //CruisesHelper中定義
    	resp.put("status", "200");
    	resp.put("message", "所有景點資料取得成功");
    	resp.put("response", query);

    	jsr.response(resp, response); //回傳到Cruises 75行
    }

}
