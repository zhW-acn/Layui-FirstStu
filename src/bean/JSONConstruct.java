package bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import dao.DB;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: 封装JSON数据
 * @author: acn
 * @date: 2023/11/01/10:15
 */
@Data
@NoArgsConstructor
public class JSONConstruct {
    private Integer code;
    private String msg;
    private Integer count = DB.queryStuCount();// 总数
    private Object data;

    public JSONConstruct(Integer code,String msg,int pageIndex,int pageSize){
        this.code = code;
        this.msg = msg;
        this.data = s2jsonData(pageIndex,pageSize);
    }

    /**
     * Student类转JSON格式
     * @return
     */
    public static Object s2jsonData(int pageIndex, int pageSize){
        List<Student> students = DB.queryStuByLimit(pageIndex, pageSize);
        String jsonString = JSONArray.toJSONString(students);
        Object json = JSON.toJSON(jsonString);
        System.out.println("转为JSON对象："+json);
        return json;
    }

    public static void main(String[] args) {
        System.out.println(new JSONConstruct(1, "", 1, 10));
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"msg\":\"" + msg + '\"' +
                ", \"count\":" + count +
                ", \"data\":" + data +
                '}';
    }
}
