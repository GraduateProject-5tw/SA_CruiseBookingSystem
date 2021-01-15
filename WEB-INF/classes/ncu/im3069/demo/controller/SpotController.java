package ncu.im3069.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import ncu.im3069.demo.app.SpotHelper;
import ncu.im3069.tools.JsonReader;

/**
 * Servlet implementation class spot
 */
@WebServlet(name = "api/spot.do", urlPatterns = { "/api/spot.do" })
public class SpotController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SpotHelper sh =  SpotHelper.getHelper();

    public SpotController() {
        super();
        // TODO Auto-generated constructor stub
    }

    		//get 商品資訊
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
        JsonReader jsr = new JsonReader(request);
        
        /** 若直接透過前端AJAX之data以key=value之字串方式進行傳遞參數，可以直接由此方法取回資料 */
        String sp_id = jsr.getParameter("stop_port_id");
        String id = jsr.getParameter("id");
        
        JSONObject resp = new JSONObject();
        /** 判斷該字串是否存在，若存在代表要取回購物車內產品之資料，否則代表要取回全部資料庫內產品之資料 */
        if (!sp_id.isEmpty()) {
        	System.out.println("搜尋用");
        	JSONObject query = sh.getByStopPortId(sp_id);
            resp.put("status", "200");
            resp.put("message", "搜尋之景點資料取得成功");
            resp.put("response", query);
          }
        else if (!id.isEmpty()) {
        	System.out.println("介紹用");
        	JSONObject query = sh.getBySpotId(id);
            resp.put("status", "200");
            resp.put("message", "詳細郵輪班次資料取得成功");
            resp.put("response", query);
          }
        else {
          JSONObject query = sh.getAll();  //CruisesHelper中定義
          resp.put("status", "200");
          resp.put("message", "所有景點資料取得成功");
          resp.put("response", query);
        }

        jsr.response(resp, response);  //回傳到Cruises 75行
	}

	
}
