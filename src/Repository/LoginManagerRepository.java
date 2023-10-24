
package Repository;

import DataAccess.LoginDao;
import java.util.Locale;


public class LoginManagerRepository implements ILoginManagerRepository{
    
    
    @Override
    public void Login(Locale language) {
        LoginDao.Instance().login(language);
    }
}
