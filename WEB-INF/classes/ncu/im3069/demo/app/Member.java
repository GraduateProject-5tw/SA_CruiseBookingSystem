package ncu.im3069.demo.app;

import org.json.*;

import java.sql.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class Member
 * Member類別（class）具有會員所需要之屬性與方法，並且儲存與會員相關之商業判斷邏輯<br>
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class Member {
    
    /** id，會員編號 */
    private int id;
    
    /** email，會員電子郵件信箱 */
    private String email;
    
    /** name，會員姓名 */
    private String name;
    
    
    private String phone;
    
    /** password，會員密碼 */
    private String password;
    
    
    /** login_date，更新時間的分鐘數 */
    private int login_date;
    
    /** password，會員信用卡 */
    private String credit_card ;
    
    /** mh，MemberHelper之物件與Member相關之資料庫方法（Sigleton） */
    private MemberHelper mh =  MemberHelper.getHelper();
    
    /**
     * 實例化（Instantiates）一個新的（new）Member物件<br>
     * 採用多載（overload）方法進行，此建構子用於建立會員資料時，產生一名新的會員
     *
     * @param email 會員電子信箱
     * @param password 會員密碼
     * @param email 會員電話
     * @param name 會員姓名    
     * @param email 會員信用卡
     * @param email 更新時間的分鐘數
     */
    public Member(String email, String password, String phone, String name, String credit_card, int login_date) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.credit_card = credit_card;
        this.login_date = login_date;
        update();
    }

    /**
     * 實例化（Instantiates）一個新的（new）Member物件<br>
     * 採用多載（overload）方法進行，此建構子用於更新會員資料時，產生一名會員同時需要去資料庫檢索原有更新時間分鐘數與會員組別
     * 
     * @param id 會員編號
     * @param email 會員電子信箱
     * @param email 會員電話
     * @param password 會員密碼
     * @param name 會員姓名
     * @param email 會員信用卡
     */
    public Member(int id, String email, String phone, String password, String name, String credit_card) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.credit_card = credit_card;
        /** 取回原有資料庫內該名會員之更新時間分鐘數與組別 */
        getLoginTimesStatus();
        
    }
    
    
    public Member(String email, String password , String phone, String name, String credit_card) {
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.credit_card = credit_card;
        update();
    }
    
    /**
     * 實例化（Instantiates）一個新的（new）Member物件<br>
     * 採用多載（overload）方法進行，此建構子用於查詢會員資料時，將每一筆資料新增為一個會員物件
     *
     * @param id 會員編號
     * @param email 會員電子信箱
     * @param password 會員密碼
     * @param name 會員姓名
     * @param login_date 更新時間的分鐘數
     * @param email 會員信用卡
     */
    public Member(int id, String email, String phone, String password, String name, int login_date, String credit_card) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.login_date = login_date;
        this.credit_card = credit_card;
    }
    
    /**
     * 取得會員之編號
     *
     * @return the id 回傳會員編號
     */
    public int getID() {
        return this.id;
    }

    /**
     * 取得會員之電子郵件信箱
     *
     * @return the email 回傳會員電子郵件信箱
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     * 取得會員之姓名
     *
     * @return the name 回傳會員姓名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 取得會員之密碼
     *
     * @return the password 回傳會員密碼
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * 取得會員之電話
     *
     * @return the password 回傳會員電話
     */

    public String getPhone() {
        return this.phone;
    }
    
    /**
     * 取得更新資料時間之分鐘數
     *
     * @return the login times 回傳更新資料時間之分鐘數
     */
    public int getLoginDate() {
        return this.login_date;
    }
    
    /**
     * 取得會員資料之信用卡
     *
     * @return credit card 回傳會員信用卡
     */
    public String getCreditCard() {
        return this.credit_card;
    }
    
    /**
     * 更新會員資料
     *
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        /** 新建一個JSONObject用以儲存更新後之資料 */
        JSONObject data = new JSONObject();
        /** 取得更新資料時間（即現在之時間）之分鐘數 */
        Calendar calendar = Calendar.getInstance();
        this.login_date = calendar.get(Calendar.DATE);
        /** 檢查該名會員是否已經在資料庫 */
        if(this.id != 0) {
            /** 若有則將目前更新後之資料更新至資料庫中 */
            mh.updateLoginDate(this);
            /** 透過MemberHelper物件，更新目前之會員資料置資料庫中 */
            data = mh.update(this);
        }
        
        return data;
    }
    
    /**
     * 取得該名會員所有資料
     *
     * @return the data 取得該名會員之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該名會員所需之資料全部進行封裝*/ 
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());
        jso.put("phone", getPhone());
        jso.put("email", getEmail());
        jso.put("password", getPassword());
        jso.put("login_date", getLoginDate());
        jso.put("credit_card", getCreditCard());
        
        return jso;
    }
    
    /**
     * 取得資料庫內之更新資料時間分鐘數與會員組別
     *
     */
    private void getLoginTimesStatus() {
        /** 透過MemberHelper物件，取得儲存於資料庫的更新時間分鐘數與會員組別 */
        JSONObject data = mh.getLoginTimesStatus(this);
        this.login_date = data.getInt("login_date");
    }
    

    
}