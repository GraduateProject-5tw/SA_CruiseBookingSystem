package ncu.im3069.demo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import ncu.im3069.demo.app.CruisesHelper;
import ncu.im3069.tools.JsonReader;

/**
 * Servlet implementation class CruisesController
 */
@WebServlet(name = "api/cruise.do", urlPatterns = { "/api/cruise.do" })
public class CruisesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CruisesHelper ch =  CruisesHelper.getHelper();

    public CruisesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
        JsonReader jsr = new JsonReader(request);
        
        /** 若直接透過前端AJAX之data以key=value之字串方式進行傳遞參數，可以直接由此方法取回資料 */
        String id_list = jsr.getParameter("id_list");
        String sp_id = jsr.getParameter("stop_port_id");
        String id = jsr.getParameter("id");
        JSONObject resp = new JSONObject();
        /** 判斷該字串是否存在，若存在代表要取回購物車內產品之資料，否則代表要取回全部資料庫內產品之資料 */
        if (!id_list.isEmpty()) {   //代表有特定cruises的id在list (cart.html呼叫)
            JSONObject query = ch.getByIdList(id_list);  //CruisesHelper中定義
            resp.put("status", "200");
            resp.put("message", "所有購物車之商品資料取得成功");
            resp.put("response", query);
          }
        else if (!sp_id.isEmpty()&&id.isEmpty()) {
        	System.out.println("搜尋用");
        	JSONObject query = ch.getByStopPortId(sp_id);
            resp.put("status", "200");
            resp.put("message", "搜尋之郵輪班次資料取得成功");
            resp.put("response", query);
          }
        else if (!id.isEmpty()) {
        	System.out.println("介紹用");
        	JSONObject query = ch.getByCruiseId(id);
            resp.put("status", "200");
            resp.put("message", "詳細郵輪班次資料取得成功");
            resp.put("response", query);
          }
        else {
          JSONObject query = ch.getAll();  //CruisesHelper中定義
          resp.put("status", "200");
          resp.put("message", "所有商品資料取得成功");
          resp.put("response", query);
        }

        jsr.response(resp, response); //回傳到Cruises 75行
	}

	
}

