package ncu.im3069.demo.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import ncu.im3069.demo.app.SpotHelper;
import ncu.im3069.tools.JsonReader;

@WebServlet("/api/spot.do")
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
        String id_list = jsr.getParameter("id_list");
        String sp_id = jsr.getParameter("stop_port_id");
        
        JSONObject resp = new JSONObject();
        /** 判斷該字串是否存在，若存在代表要取回購物車內產品之資料，否則代表要取回全部資料庫內產品之資料 */
        if (!id_list.isEmpty()) {   //代表有特定product的id在list (cart.html呼叫)
            JSONObject query = sh.getByIdList(id_list); //productHelper中定義
            resp.put("status", "200");
            resp.put("message", "所有購物車之商品資料取得成功");
            resp.put("response", query);
          }
        else if (!sp_id.isEmpty()) {
        	System.out.println("搜尋用");
        	JSONObject query = sh.getByStopPortId(sp_id);
            resp.put("status", "200");
            resp.put("message", "搜尋之景點資料取得成功");
            resp.put("response", query);
          }
        else {
          JSONObject query = sh.getAll();  //productHelper中定義
          resp.put("status", "200");
          resp.put("message", "所有景點資料取得成功");
          resp.put("response", query);
        }

        jsr.response(resp, response); //回傳到product 75行
	}

	
}
