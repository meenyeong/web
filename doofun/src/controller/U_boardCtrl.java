package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.BoardDao;
import dao.CommentDao;
import vo.Board;
import vo.CommReq;

@Controller
public class U_boardCtrl {
	private BoardDao boardDao;
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	private CommentDao commentDao;
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao=commentDao;
	}
// 글읽기
	@RequestMapping("/commu")
	public String mainlist(Model model) {				
		return list(model, "","");
		//return "user/boardList";//실제 디렉토리jsp
	}
	
	@RequestMapping("/commu={tpage}&")
	public String mainlist2(Model model,@PathVariable String tpage) {				
		return list(model, tpage ,"");
		//return "user/boardList";//실제 디렉토리jsp
	}
	
/*	@RequestMapping("/commu/{tpage}/?key={key}") //실주소 매핑값 명시 -> 아니면 오버라이드 하시던지요 ㅇㅅㅇ' 아니면 이걸 인터페이스로 만들어놓고 서야지
	public String listget(Model model,@PathVariable String tpage, @PathVariable String key) {		
		System.out.println("get key?:" + key);
		
		return list(model, tpage, key);
	}*/
	
	
	@RequestMapping("/commu={tpage}&{key}") //실주소 매핑값 명시 
	public String list(Model model,@PathVariable String tpage, @PathVariable String key) {		
		//System.out.println("키:" + key);
		
		//=request.getParameter("key");
		//String tpage=null;// = request.getParameter("tpage");
		if (key==null) { key = " ";}
		if (tpage==null) {tpage="1";}
		else if(tpage.equals("")) {tpage="1";}
		key=key.trim();
		model.addAttribute("key", key);
		
		model.addAttribute("tpage", tpage);
		try {
			List<Board> articles = boardDao.selectAll(Integer.parseInt(tpage), key);
			model.addAttribute("articles", articles); // listservice를 써준다고 보면된다
			String paging = boardDao.pageNumber(Integer.parseInt(tpage), key);
			model.addAttribute("paging", paging);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "user/boardList";//실제 디렉토리jsp
	}

	
	//글 디테일로 읽기
	@RequestMapping("/read={cseq}") //실주소 매핑값 명시
	public String read(Model model, @PathVariable int cseq) throws Exception {		
		model.addAttribute("boardVO", boardDao.read(cseq));
		model.addAttribute("CommentVO", commentDao.read(cseq));
		model.addAttribute("CommReq", new CommReq());
		
		return "user/boardRead";//실제 디렉토리jsp
	}
	
	//코멘트 지우기
	@RequestMapping(value = "/delComm={cseq}&{bcseq}", method = RequestMethod.POST )
	public String delComm(Model model, @PathVariable String cseq, @PathVariable int bcseq) throws Exception {
		model.addAttribute("commentVO", commentDao.delete(bcseq));
		
	
		String page = "redirect:/read="; 
		page += cseq; //기존 페이지로 다시 돌아감.
	return page;
		
		
	}


	
	
//글 지우기
	@RequestMapping(value="/user/delete/{cseq}", method = RequestMethod.POST )
	public String delete(Model model, @PathVariable int cseq) throws Exception {
		model.addAttribute("boardVO", boardDao.delete(cseq));
		
		return "redirect:/commu";
	}

	
//글수정1단계	
	@RequestMapping(value = "/mod={cseq}", method = RequestMethod.POST)
	public String form(Model model, @PathVariable int cseq) throws Exception {	
		
		Board boardVO=boardDao.read(cseq);
		model.addAttribute("boardVO", boardVO);
	
		return "user/mod2";//실제 디렉토리jsp	
		}
		

	}