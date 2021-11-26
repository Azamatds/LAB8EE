package Repository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class HelloService {
    @EJB
    private Download download;

    public List<String> getHello() throws SQLException, ClassNotFoundException{
        return download.getAllDemoName();
    }
}
