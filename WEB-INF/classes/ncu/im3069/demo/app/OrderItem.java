package ncu.im3069.demo.app;

import org.json.JSONObject;
import ncu.im3069.demo.util.Arith;

public class OrderItem {

    /** id，訂單細項編號 */
    private int id;

    /** pd，郵輪班次編號 */
    private Cruises pd;

    /** quantity，人數 */
    private int quantity;

    /** price，郵輪行程價格 */
    private double price;

    /** subtotal，小計 */
    private double subtotal;
    
    //private String name;

    /** ph，CruisesHelper 之物件與 OrderItem 相關之資料庫方法（Sigleton） */
    private CruisesHelper ph =  CruisesHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）OrderItem 物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立訂單細項時
     *
     */
    public OrderItem(Cruises pd, int quantity) {
        this.pd = pd;
        this.quantity = quantity;
        this.price = this.pd.getPrice();
        this.subtotal = Arith.mul((double) this.quantity, this.price);
    }

    /**
     * 實例化（Instantiates）一個新的（new）OrderItem 物件<br>
     * 採用多載（overload）方法進行，此建構子用於修改訂單細項時
     *
     * @param order_product_id 訂單明細編號
     * @param order_id 訂單編號
     * @param cruises_id 郵輪編號
     * @param price 郵輪行程價格
     * @param quantity 人數
     * @param subtotal 小計
     */

    public OrderItem(int order_product_id,  int order_id, int cruises_id, double price, int quantity, double subtotal) {
        this.id = order_product_id;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
        getCruiseFromDB(cruises_id);
    }
    /**
     * 從 DB 中取得郵輪
     */
    private void getCruiseFromDB(int cruises_id) {
        String id = String.valueOf(cruises_id);
        this.pd = ph.getById(id);
    }

    /**
     * 取得產品
     *
     * @return Cruises 回傳產品
     */
    public Cruises getCruises() {
        return this.pd;
    }

    /**
     * 設定訂單細項編號
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 取得訂單細項編號
     *
     * @return int 回傳訂單細項編號
     */
    public int getId() {
        return this.id;
    }

    /**
     * 取得郵輪行程價格
     *
     * @return double 回傳產品價格
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * 取得小計
     *
     * @return double 回傳產品細項小計
     */
    public double getSubTotal() {
        return this.subtotal;
    }

    /**
     * 取得總人數
     *
     * @return int 回傳總人數
     */
    public int getQuantity() {
        return this.quantity;
    }

    //public String getName() {
       // return this.name;
    //} 
    
    /**
     * 取得產品細項資料
     *
     * @return JSONObject 回傳郵輪細項資料
     */
    public JSONObject getData() {
        JSONObject data = new JSONObject();
        data.put("id", getId());
        data.put("cruises", getCruises().getData());
        data.put("price", getPrice());
        data.put("quantity", getQuantity());
        data.put("subtotal", getSubTotal());
        //data.put("name", getName());

        return data;
    }
}
