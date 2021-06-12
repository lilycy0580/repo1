import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.impl.AccountServiceImpl;
import jdk.jfr.StackTrace;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringTest {
    // ApplicationContext 开启单例模式
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDaoImpl accountdao = ac.getBean("accountDao", AccountDaoImpl.class);
        AccountServiceImpl accountService = ac.getBean("accountService", AccountServiceImpl.class);
        System.out.println(accountdao);
        System.out.println(accountService);
    }

    @Test   // BeanFactory 使用debug模式显示多例模式
    public void testBeanFactory(){
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountDaoImpl dao = factory.getBean("accountDao", AccountDaoImpl.class);
        System.out.println(dao);
    }
}
