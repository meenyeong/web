package controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.BoardDao;
import dao.CommentDao;
import service.U_bWriteSvc;
import vo.B4WriteReq;
import vo.CommReq;
import vo.CommentVO;

@Controller
public class U_bWriteCtrl {
	private U_bWriteSvc u_bWriteSvc;


	public void setU_bWriteSvc(U_bWriteSvc u_bWriteSvc) {
		this.u_bWriteSvc = u_bWriteSvc;
	} 
	
	private BoardDao boardDao;
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	private CommentDao commentDao;
	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
// 글쓰기
	@RequestMapping(value = "/write2")
	public String handleStep2 (Model model) {
		
		// 글내용객체 새로 생성된req를 돌고있는 model에  저장
		model.addAttribute("b4WriteReq", new B4WriteReq());
		model.addAttribute("CommentVO",new CommentVO());
		
		
		return "user/step2";
	}

	@RequestMapping(value = "write3", method = RequestMethod.POST)
	public String handleStep3(B4WriteReq b4writeReq) throws Exception {
		u_bWriteSvc.write2Board(b4writeReq);
			return "redirect:/commu";
		}
	
	//덧글입력
	@RequestMapping(value = "/bcInsert", method = RequestMethod.POST)
	public String handleComment(CommentVO commentVO) {
		
		if(commentVO.getBccon() == "") {
		 return "user/commError";}
		 
else {
		
		
		
		try {
			
			u_bWriteSvc.write2Comment(commentVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String page = "redirect:/read="; 
				page += Integer.toString(commentVO.getCseq()); //기존 페이지로 다시 돌아감.
			return page;
	}
	}


	
	@RequestMapping(value =  "/mod3", method = RequestMethod.POST)
	public String handleModi(B4WriteReq b4writeReq) throws Exception {

			u_bWriteSvc.modify2Board(b4writeReq);
			String reconn = "redirect:/read="; 
			reconn += Integer.toString(b4writeReq.getCseq());
			return reconn;
		}
	
	//덧글수정하기
	@RequestMapping(value =  "/modComm", method = RequestMethod.POST)
	public String ModiComment(CommReq commReq) throws SQLException {
		if(commReq.getNewComm() == "") {
			 return "user/commError";}
		
		
	/*	System.out.println(comm.getCseq());
		System.out.println(comm.getBcseq());
		System.out.println(comm.getNewComm());
		*/
 else {		
		u_bWriteSvc.modiComment(commReq);
		
		String page = "redirect:/read="; 
		page += Integer.toString(commReq.getCseq()); //기존 페이지로 다시 돌아감.
	return page;
 }	
 }



	

}
