
package DataAccess;


import common.Library;
import java.util.Locale;


public class LoginDao {
    private Library l;
    public LoginDao(){
    l = new Library();
    }
    private static LoginDao instance = null;
    public static LoginDao Instance(){
        if(instance == null){
            synchronized (LoginDao.class){
                if(instance == null){
                    instance = new  LoginDao();
                }
            }
        }
        return instance;
    }
    public void login(Locale language){
        l.getWordLanguage(language, "enterAccountNumber");
        int accountNumber = l.checkInputAccount(language);
        l.getWordLanguage(language, "enterPassword");
        String passString = l.checkInputPassword(language);
        String captchaGenerated = l.generateCaptchaText();
        while (true) {
            if (l.checkInputCaptcha(captchaGenerated, language)) {
                l.getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                l.getWordLanguage(language, "errCaptchaIncorrect");
                System.out.println();
            }
        }
    }
}
