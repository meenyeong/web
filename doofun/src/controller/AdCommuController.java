package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDao;
import dao.CommentDao;
import vo.CommentVO;
import vo.LoginSubmit;

@Controller
public class AdCommuController {


	private BoardDao boardDao;

	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	private CommentDao commentDao;
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao=commentDao;
	}
	@RequestMapping("/adminCommu")
	public String mainlist(Model model,HttpSession session) {				
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
			return list(model, session,"");
	}
	}
	
	
	@RequestMapping("/adminCommu={tpage}")
		public String list(Model model,HttpSession session,@PathVariable String tpage) {			
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		if (tpage==null) {tpage="1";}
		else if(tpage.equals("")) {tpage="1";}		
		model.addAttribute("tpage", tpage);
		try {				
				model.addAttribute("commu", boardDao.selected(Integer.parseInt(tpage))); 
				model.addAttribute("paging", boardDao.adminPage(Integer.parseInt(tpage)));
			} catch (Exception e) {
				e.printStackTrace();
			}		
		return "admin/adminCommu";
		}
	}
	
	@RequestMapping("/adminCommuDetail={cseq}") 
	public String read(Model model,HttpSession session, @PathVariable int cseq) throws Exception {		
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		model.addAttribute("commu", boardDao.read(cseq));	
		model.addAttribute("CommentVO", commentDao.read(cseq));
		return "admin/adminCommuDetail";
	}
	}
	
	@RequestMapping("/adminCommuSid={key}")
	public String Search(Model model,HttpSession session, @PathVariable String key) throws Exception{
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		key=key.trim();					
		model.addAttribute("key", key);
		model.addAttribute("commu", boardDao.searchbyId(key));
		return "admin/adminCommu";
	}
	}
	
	@RequestMapping("/adminCommuSpnum={key}")
	public String Search2(Model model,HttpSession session, @PathVariable int key) throws Exception{			
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		model.addAttribute("key", key);
		model.addAttribute("commu", boardDao.searchbyPnum(key));
		return "admin/adminCommu";
	}
	}
	
	@RequestMapping("/adminCommuScsub={key}")
	public String Search3(Model model,HttpSession session, @PathVariable String key) throws Exception{
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		key=key.trim();				
		model.addAttribute("key", key);
		model.addAttribute("commu", boardDao.searchbyCsub(key));
		return "admin/adminCommu";
	}
	}
}
