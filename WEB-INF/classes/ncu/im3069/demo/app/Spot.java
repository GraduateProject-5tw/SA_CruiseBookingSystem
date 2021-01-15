package ncu.im3069.demo.app;

import org.json.*;

public class Spot {

    /** id，景點編號 */
    private int id;
    
    /** id，停靠點編號 */
    private int stop_port_id;

    /** name，景點名稱 */
    private String name;

    /** image，照片位置 */
    private String image;

    /** describe，景點描述 */
	private String describe;

    /**
     * 實例化（Instantiates）一個新的（new）Spot( 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增景點時
     *
     * @param id 景點編號
     */
	public Spot(int id, int stop_port_id) {
		this.id = id;
		this.stop_port_id = stop_port_id;
	}

    /**
     * 實例化（Instantiates）一個新的（new）Spot 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增景點時
     * @param stop_port_id 停靠點編號
     * @param name 景點名稱
     * @param image 景點圖片
     */
	public Spot(int stop_port_id, String name, String image) {
		this.name = name;
		this.image = image;
	}

    /**
     * 實例化（Instantiates）一個新的（new）Spot 物件<br>
     * 採用多載（overload）方法進行，此建構子用於修改景點時
     *
     * @param id 景點編號
     * @param name 景點名稱
     * @param price 景點價格
     * @param image 景點圖片
     * @param describe 景點敘述
     */
	public Spot(int id, int stop_port_id, String name, String image, String describe) {
		this.id = id;
		this.stop_port_id = stop_port_id;
		this.name = name;
		this.image = image;
		this.describe = describe;
	}

    /**
     * 取得景點編號
     *
     * @return int 回傳景點編號
     */
	public int getID() {
		return this.id;
	}
	/**
     * 取得停靠點編號 
     *
     * @return int 回傳停靠點編號 
     */
	public int getStopPortID() {
		return this.stop_port_id;
	}

    /**
     * 取得景點名稱
     *
     * @return String 回傳景點名稱
     */
	public String getName() {
		return this.name;
	}


    /**
     * 取得景點圖片
     *
     * @return String 回傳景點圖片
     */
	public String getImage() {
		return this.image;
	}

    /**
     * 取得景點述
     *
     * @return String 回傳景點敘述
     */
	public String getDescribe() {
		return this.describe;
	}
	
    /**
     * 取得景點資訊
     *
     * @return JSONObject 回傳景點資訊
     */
	public JSONObject getData() {
        /** 透過JSONObject將該項景點所需之資料全部進行封裝*/
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("stop_port_id", getStopPortID());
        jso.put("name", getName());
        jso.put("image", getImage());
        jso.put("describe", getDescribe());

        return jso;
    }
}