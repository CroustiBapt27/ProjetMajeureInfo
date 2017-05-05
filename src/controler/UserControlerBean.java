package controler;

import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.LoginBean;
import model.UserModelBean;
import model.UserSubmissionModelBean;
import dao.DaoFabric;
import dao.UserDao;

@ManagedBean
@ApplicationScoped // application scope pour offrir un point d'entrée unique à l'ensemble des clients
public class UserControlerBean {
	
	private UserDao userDao;
	
	public UserControlerBean() {
		this.userDao=DaoFabric.getInstance().createUserDao();
	}
	
	public String checkUser(LoginBean loginBean){
		
		UserModelBean user = this.userDao.checkUser(loginBean.getLogin(),loginBean.getPwd());
		
		if( user!=null){
			//récupère l'espace mémoire de JSF
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			//place l'utilisateur dans l'espace de mémoire de JSF
			sessionMap.put("loggedUser", user);
			//redirect the current page
			return "admin.xhtml";
		}
		else {
			//redirect the current page
			System.out.println("ELSE PD");
			return "userLogin.xhtml";
		}
	}
	
	public void checkAndAddUser(UserSubmissionModelBean userSubmitted){
		//Vérifier les propriétés de l'utilisateur
		boolean valid=true;
		
		// check surname attribute lenght (other check could be made e.g regex)
		if(userSubmitted.getSurname().length()>10 || userSubmitted.getSurname().length()<3){
			valid=false;
		}
		
		// check lastname attribute lenght (other check could be made e.g regex)
		if(userSubmitted.getLastname().length()>10 || userSubmitted.getLastname().length()<3){
			valid=false;
		}
		
		int age=Integer.valueOf(userSubmitted.getAge());
		if( age <1 || age >150){
			valid=false;
		}
		
		// check login attribute lenght (other check could be made e.g regex)
		if(userSubmitted.getLogin().length()>10 || userSubmitted.getLogin().length()<3){
			valid=false;
		}
		
		if(userDao.checkLogin(userSubmitted.getLogin())){
			valid=false;
		}
		
		// check pwd attribute lenght (other check could be made e.g regex)
		if(userSubmitted.getPwd().length()>10 || userSubmitted.getPwd().length()<3){
			valid=false;
		}	

		//ajout de l'utilisateur à la base de données
		if(valid)				
			this.userDao.addUser(userSubmitted);
	}
}
