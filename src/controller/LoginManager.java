
package controller;

import Repository.ILoginManagerRepository;
import Repository.LoginManagerRepository;
import java.util.Locale;
import view.Menu;


public class LoginManager extends Menu<String>{
    static String[] mc = {"Vietnamese.","English.","Exit."};
    ILoginManagerRepository loginManagerRepository;
    Locale vietnamese = new Locale("vi");
    Locale english = Locale.ENGLISH;
    public LoginManager(){
        super("====== TienPhong Bank ======",mc);
        loginManagerRepository = new LoginManagerRepository();
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                loginManagerRepository.login(vietnamese);
                break;
            case 2: 
                loginManagerRepository.login(english);
                break;
            case 3:
                System.out.println("Exit the program successfully!");
                System.exit(0);
                break;
        }
    }
    
}
