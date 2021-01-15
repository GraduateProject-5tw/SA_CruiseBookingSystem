package ncu.im3069.demo.app;

import org.json.*;

public class StopPort {

    /** id，停靠點編號 */
    private int id;

    /** id，停靠點名稱 */
    private String name;

    /**
     * 實例化（Instantiates）一個新的（new）StopPort 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增停靠點時
     *
     * @param id 停靠點編號
     */
	public StopPort(int id) {
		this.id = id;
	}

 

    /**
     * 實例化（Instantiates）一個新的（new）StopPort 物件<br>
     * 採用多載（overload）方法進行，此建構子用於修改停靠點時
     *
     * @param id 停靠點編號
     * @param name 停靠點名稱
     */
	public StopPort(int id, String name) {
		this.id = id;
		this.name = name;
	}

    /**
     * 取得停靠點編號
     *
     * @return int 回傳停靠點編號
     */
	public int getID() {
		return this.id;
	}

    /**
     * 取得停靠點名稱
     *
     * @return String 回傳停靠點名稱
     */
	public String getName() {
		return this.name;
	}

   
    /**
     * 取得停靠點資訊
     *
     * @return JSONObject 回傳停靠點資訊
     */
	public JSONObject getData() {
        /** 透過JSONObject將該項停靠點所需之資料全部進行封裝*/
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());

        return jso;
    }
}