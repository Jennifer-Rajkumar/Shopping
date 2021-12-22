package exercise.model;

import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exercise.item.ItemDAOImpl;
import exercise.item.ItemDTO;
import exercise.shopping.ShoppingServiceImpl;

public class GoShoppingAction extends Action {

	public GoShoppingAction() {
		
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ShoppingServiceImpl obj = new ShoppingServiceImpl();
		obj.setItemDao(new ItemDAOImpl());
		
		HttpSession session=request.getSession();  
        
		TreeSet<ItemDTO> ts = obj.getItems("vegetable");
		session.setAttribute("vegetable",ts);
        
        ts = obj.getItems("fruit");
        session.setAttribute("fruit",ts);
        
        ts = obj.getItems("groceries");
        session.setAttribute("groceries",ts);
        
		return "goshop.success";
		
	}
	
}
