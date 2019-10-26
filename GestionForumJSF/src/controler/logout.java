package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class logout {
	public String goout(int id) {
		System.out.println(id);
		return ("index");
	}

}
