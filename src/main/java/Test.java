import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.entitys.Course;
import com.entitys.Teacher;
import com.mapper.CourseMapper;
import com.mapper.TeacherMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		Reader r = Resources.getResourceAsReader("Configuration.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(r);
		SqlSession session = factory.openSession();
		TeacherMapper tm = session.getMapper(TeacherMapper.class);
		List<Teacher> ts = tm.selectAll();
		for (Teacher t : ts) {
			System.out.println(t.getName());
			System.out.println("-------------------------------");
			List<Course> cs = t.getCourses();
			for (Course c : cs) {
				System.out.println(c.getCname()+"\t"+t.getName());
			}
		}
//		CourseMapper cm = session.getMapper(CourseMapper.class);
//		Course c = cm.selectOne(1);
//		List<Course> cms = cm.selectAll();
//		for (Course c : cms) {
//			System.out.println(c.getCname()+"\t"+c.getTeacher().getName());			
//		}
//		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
//		Teacher t = mapper.selectOne(1);
//		List<Course> cs = t.getCourses();
//		System.out.print(t.getName());
//		System.out.println("------------------------------");
//		for (Course c : cs) {
//			System.out.println(c.getCid()+"\t"+c.getCname());
//		}
		session.close();
	}

}
