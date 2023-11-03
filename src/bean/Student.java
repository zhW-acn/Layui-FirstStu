package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: StudentBean
 * @author: acn
 * @date: 2023/11/01/9:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String stuName;
    private String stuSex;
    private Integer stuAge;
    private String stuClazz;

    public Student(String stuName, String stuSex, int stuAge, String stuClazz) {
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuClazz = stuClazz;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"stuName\":\"" + stuName + '\"' +
                ", \"stuSex\":\"" + stuSex + '\"' +
                ", \"stuAge\":" + stuAge +
                ", \"stuClazz\":\"" + stuClazz + '\"' +
                '}';
    }
}
