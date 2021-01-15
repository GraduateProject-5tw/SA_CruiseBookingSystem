package ncu.im3069.demo.app;

import java.sql.Timestamp;

import org.json.*;

public class Cruises {

    /** id，郵輪編號 */
    private int id;

    /** id，郵輪名稱 */
    private String name;

    /** id，郵輪行程價格*/
    private double price;


    private Timestamp sailing_date;

    /** id，郵輪圖片 */
    private String image;

	private String describe;

    /**
     * 實例化（Instantiates）一個新的（new）Cruises 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增郵輪時
     *
     * @param id 郵輪編號
     */
	public Cruises(int id) {
		this.id = id;
	}

    /**
     * 實例化（Instantiates）一個新的（new）Cruises 物件<br>
     * 採用多載（overload）方法進行，此建構子用於新增郵輪時     
     *
     * @param name 郵輪名稱
     * @param price 郵輪行程價格
     * @param image 郵輪圖片
     */
	public Cruises(String name, double price, String image) {
		this.name = name;
		this.price = price;
		this.image = image;
	}

    /**
     * 實例化（Instantiates）一個新的（new）Cruises  物件<br>
     * 採用多載（overload）方法進行，此建構子用於修改郵輪時
     *
     * @param id 郵輪編號
     * @param name 郵輪名稱
     * @param price 郵輪行程價格
     * @param image 郵輪圖片
     * @param describe 郵輪敘述
     */
	public Cruises(int id, String name, Timestamp sailing_date, double price, String image, String describe) {
		this.id = id;
		this.name = name;
		this.sailing_date = sailing_date;
		this.price = price;
		this.image = image;
		this.describe = describe;
	}

    /**
     * 取得郵輪編號
     *
     * @return int 回傳郵輪編號
     */
	public int getID() {
		return this.id;
	}

    /**
     * 取得郵輪名稱
     *
     * @return String 回傳郵輪名稱
     */
	public String getName() {
		return this.name;
	}

	/**
     * 取得郵輪敘述
     *
     * @return String 回傳郵輪敘述
     */
	public Timestamp getSailingDate() {
		return this.sailing_date;
	}

    /**
     * 取得郵輪行程價格
     *
     * @return double 回傳郵輪行程價格
     */
	public double getPrice() {
		return this.price;
	}

    /**
     * 取得郵輪圖片
     *
     * @return String 回傳郵輪圖片
     */
	public String getImage() {
		return this.image;
	}

    /**
     * 取得郵輪敘述
     *
     * @return String 回傳郵輪敘述
     */
	public String getDescribe() {
		return this.describe;
	}

    /**
     * 取得郵輪資訊
     *
     * @return JSONObject 回傳郵輪資訊
     */
	public JSONObject getData() {
        /** 透過JSONObject將該項郵輪所需之資料全部進行封裝*/
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());
        jso.put("date", getSailingDate());
        jso.put("price", getPrice());
        jso.put("image", getImage());
        jso.put("describe", getDescribe());

        return jso;
    }
}