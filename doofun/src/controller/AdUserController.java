package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdProjectDao;
import dao.UserDao;
import vo.LoginSubmit;
import vo.User;
import vo.UserReq;

@Controller
public class AdUserController {
	String page = null;
	private UserDao userDao;
	private AdProjectDao projectDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setAdProjectDao(AdProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
	@RequestMapping("/adminUser")
	public String mainlist(Model model, HttpSession session, UserReq req) throws Exception {		
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		model.addAttribute("req", req);
		return list(model, session, req, "");
		}
	}			
	
	@RequestMapping("/adminUser={tpage}")
		public String list(Model model,HttpSession session,UserReq req, @PathVariable String tpage) throws Exception {		
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {	
			if (tpage==null) {tpage="1";}		
		if(tpage.equals("")) {tpage="1";}		
		req.setTpage(tpage);
		page = req.getTpage();
		try {			
				model.addAttribute("user", userDao.selected(Integer.parseInt(tpage))); 
				model.addAttribute("paging", userDao.adminPage(Integer.parseInt(tpage)));
			} catch (Exception e) {
				e.printStackTrace();
			}		
		return "admin/adminUser";
	}
	}

	
	@RequestMapping("/adminUserDetail={useq}")
	public String detail(Model model,HttpSession session, @PathVariable int useq) throws Exception {
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		model.addAttribute("view", userDao.readView(useq));
		model.addAttribute("user",userDao.read(useq));
		model.addAttribute("project",projectDao.readbyUseq(useq));
		return "admin/adminUserDetail";
	}
	}	

	@RequestMapping("/adminUserdrop={useq}")
	public String drop(Model model, HttpSession session,UserReq req, @PathVariable int useq) throws Exception {	
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		userDao.userdrop(useq);
		User user = new User();
		user.setUserdrop(true);		
		
		return list(model,session, req, page);
	}
	}

	@RequestMapping("/adminUsersave={useq}")
	public String save(Model model, HttpSession session,UserReq req,@PathVariable int useq) throws Exception {	
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		userDao.usersave(useq);
		User user = new User();
		user.setUserdrop(false);		
		
		return list(model,session, req, page);
		}
	}
	
	@RequestMapping("/adminUserSid={key}")
	public String search1(Model model,HttpSession session, @PathVariable String key) throws Exception{
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		key=key.trim();			
		model.addAttribute("key", key);
		model.addAttribute("user", userDao.searchbyId(key));
		return "admin/adminUser";
		}
	}

	@RequestMapping("/adminUserSname={key}")
	public String search2(Model model,HttpSession session, @PathVariable String key) throws Exception{
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		key=key.trim();				
		model.addAttribute("key", key);
		model.addAttribute("user", userDao.searchbyName(key));
		return "admin/adminUser";
		}
	}	
}
