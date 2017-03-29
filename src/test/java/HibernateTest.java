import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by harle on 21.03.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class HibernateTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {
        System.out.println();
    }
}
