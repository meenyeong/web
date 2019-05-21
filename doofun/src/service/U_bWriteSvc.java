package service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import dao.BoardDao;
import dao.CommentDao;
import vo.B4WriteReq;
import vo.Board;
import vo.CommReq;
import vo.CommentVO;

public class U_bWriteSvc {
	private BoardDao boardDao;
	private Board boardVO;
	private CommentDao commentDao;
	private CommentVO commentVO;
	
	@Autowired
	public U_bWriteSvc(BoardDao boardDao, CommentDao commentDao) {
		this.boardDao=boardDao;
		this.commentDao=commentDao;
	}
	
/*	@Autowired
	public U_bWriteSvc(CommentDao commentDao) {
		this.commentDao=commentDao;
	}
	*/
	
	//insert to board
	public void write2Board(B4WriteReq b4writeReq) throws Exception { 
		if (b4writeReq.getPnum().equals("")) 
		{	boardVO = new Board(b4writeReq.getId(), b4writeReq.getName(), b4writeReq.getCsub(), b4writeReq.getCcon());}
		
	else 
		{boardVO = new Board(b4writeReq.getId(), b4writeReq.getName(), 
				b4writeReq.getCsub(), b4writeReq.getCcon(), b4writeReq.getPnum() );}
		
	boardDao.insert(boardVO);
	}

	public void modify2Board(B4WriteReq b4writeReq) throws Exception {
		
		int pnum;
		if (b4writeReq.getPnum().equals("")) pnum=0;
		else pnum = Integer.parseInt(b4writeReq.getPnum());
		
		/*boardVO = new Board(b4writeReq.getName(), b4writeReq.getCseq(), b4writeReq.getCsub(), b4writeReq.getCcon() );
		*/boardDao.update(b4writeReq.getName(), b4writeReq.getCsub(), b4writeReq.getCcon(), b4writeReq.getCseq(), pnum );
//와 여기진짜 근본없이 짰다 
	}

	public void write2Comment(CommentVO commentVO2) throws SQLException {
		
		commentDao.insert(commentVO2);
		
	}

	public void modiComment(CommReq commReq) throws SQLException {
		commentDao.update(commReq);
		// TODO Auto-generated method stub
		
	}
	
}
