package interview;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 验证问题：
 * 往set里面put一个学生对象，然后将这个学生对象的学号改了，再put进去，可以放进set么？并讲出为什么 
 * 答：不可以放入，因为修改学号并不会修改这个学生对象的hashcode，set不能存放相同（使用equals判断成立）的元素
 *    修改hashcode的生成方法即可放入
 */
public class TestSet {

    /**
     * @param args
     */
    Object o;
    public static void main(String[] args) {
        
        Set<Student> set=new HashSet<Student>();
        Student s1=new Student("1", "xxh");        
//        往集合中放入学生对象s1
        set.add(s1);
        System.out.println(s1.hashCode());
//        修改s1的学号
        s1.setSid("2");
        System.out.println(s1.hashCode());
//        尝试放入修改后的s1
        if(set.add(s1)){
            System.out.println("可以放入");
        }else{
            System.out.println("不可以放入");
        }
//        通过迭代器查询集合中的元素
        Iterator<Student> it=set.iterator();
        while(it.hasNext()){
            Student s=it.next();
            System.out.println(s.hashCode()+"Set中的学生学号"+s.getSid()+" 姓名"+s.getSname());
        }
    }

}

class Student{
    private String sid;
    private String sname;
    
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Student(String sid, String sname) {
        super();
        this.sid = sid;
        this.sname = sname;
        
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(sid);
    }

}