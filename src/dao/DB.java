package dao;

import bean.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description: 数据库查询
 * @author: acn
 * @date: 2023/11/01/9:46
 */
public class DB {
    static DataSource ds = new ComboPooledDataSource();
    static QueryRunner qr = new QueryRunner(ds);

    /**
     * 查询所有学生
     */
    public static List<Student> queryAllStu() {
        try {
            List<Student> returnStuList = qr.query("select * from t_student", new BeanListHandler<>(Student.class));
            System.out.println("查询所有Student如下：");
//            returnStuList.forEach(System.out::println);
            return returnStuList;
        } catch (SQLException e) {
            throw new RuntimeException("查询所有Student出错", e);
        }
    }

    /**
     * 查询所有学生数
     */
    public static int queryStuCount() {
        List<Student> students = queryAllStu();
        int count = students.size();
        System.out.println("Student总数为" + count);
        return count;
    }

    /**
     * 分页查询
     */
    public static List<Student> queryStuByLimit(int pageIndex, int pageSize) {
        try {
            List<Student> students = qr.query("select * from t_student limit ?,?",
                    new BeanListHandler<>(Student.class), (pageIndex - 1) * pageSize, pageSize);
            System.out.println("查询分页数据如下：");
//            students.forEach(System.out::println);
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 删除学生
     */
    public static void deleteStuById(int id) {
        try {
            System.out.println("将要删除学生id为：" + id);
            qr.update("delete from t_student where id = ?", id);
        } catch (SQLException e) {
            throw new RuntimeException("删除学生失败", e);
        }
    }

    /**
     * 添加学生
     */
    public static void addStu(Student student){
        try {
            System.out.println("将要添加学生"+student);
            qr.update("insert into t_student(stuName,stuSex,stuAge,stuClazz) values(?,?,?,?)",student.getStuName(),student.getStuSex(),student.getStuAge(),student.getStuClazz());
        } catch (SQLException e) {
            throw new RuntimeException("添加学生失败",e);
        }
    }


    /**
     * 更改学生
     */
    public static void updateStu(Student student){
        try {
            System.out.println("将要更新学生"+student);
            qr.update("update t_student set stuName = ?,stuSex = ?,stuAge = ?,stuClazz = ? where id = ?",student.getStuName(),student.getStuSex(),student.getStuAge(),student.getStuClazz(),student.getId());
        } catch (SQLException e) {
            throw new RuntimeException("更改学生失败",e);
        }
    }

}
