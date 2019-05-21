package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.AdProjectDao;
import dao.ProjectDao;
import vo.AdC_statusReq;
import vo.AdC_statusView;
import vo.AdSum;
import vo.AdminPjView;
import vo.AdminRequest;
import vo.AdminRequestReq;
import vo.Board;
import vo.DDay;
import vo.Funder;
import vo.FunderView;
import vo.FundingSum;
import vo.GiftCount;
import vo.LikeView;
import vo.LoginSubmit;
import vo.PjComment;
import vo.PjCommentReq;
import vo.ProjectView;
import vo.StoryReq;
import vo.UserFundingView;

@Controller
public class AdProjectController {
	private int projectNumber = 0;
	private ProjectDao pjDao;
	private AdProjectDao projectDao;

	public void setPjDao(ProjectDao pjDao) {
		this.pjDao = pjDao;
	}

	public void setAdProjectDao(AdProjectDao projectDao) {
		this.projectDao = projectDao;
	}	
	
	@RequestMapping("/adminProject")
	public String mainlist(Model model,HttpSession session) throws Exception{				
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {			
			return "admin/adminLogin";					
		} else {	
		return list(model, session, "");
		}
	}

	@RequestMapping("/adminProject={tpage}")
		public String list(Model model,HttpSession session,@PathVariable String tpage) throws Exception {			
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";		
			
		} else {	
		if (tpage==null) {tpage="1";}
		else if(tpage.equals("")) {tpage="1";}		
		model.addAttribute("tpage", tpage);	
		
		//프로젝트 종료일 지나면 '마감'처리하려고 현재시간을 int값으로 바꾸는 메소드...
	    Date date = new Date(); 
	    SimpleDateFormat sdf = new SimpleDateFormat(); 
	    sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA); 	    
		int today = Integer.parseInt(sdf.format(date));
		
		projectDao.deadline(today); //현재시간-종료일<=0이면 '마감'처리
		
		List<AdC_statusReq> c_statusList;

		c_statusList = projectDao.selC_status();
		
		for(int i = 0; i < c_statusList.size(); i++ ) {
			int pnum = c_statusList.get(i).getPnum();
			int goal = c_statusList.get(i).getGoal();
			AdSum adsum = new AdSum();
			
			adsum = projectDao.selSum(pnum);

			AdC_statusView status = new AdC_statusView();
			
			if(adsum == null) {
				status.setPnum(pnum);
				status.setGoal(goal);
				status.setSum(0);
				
				projectDao.changeCstatus2("fail", pnum);
				
			}else {
				status.setPnum(pnum);
				status.setGoal(goal);
				status.setSum(adsum.getSum());
				
				if(status.getGoal() < status.getSum()) {
					projectDao.changeCstatus2("suc", pnum);
				}else{
					projectDao.changeCstatus2("fail", pnum);
				}
			}
		}
		
		try {			
				model.addAttribute("project", projectDao.selectAll(Integer.parseInt(tpage))); 
				model.addAttribute("paging", projectDao.adminPage(Integer.parseInt(tpage)));
				
				model.addAttribute("view", projectDao.CselectAll(Integer.parseInt(tpage)));
				model.addAttribute("paging2", projectDao.adminPage2(Integer.parseInt(tpage)));		
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "admin/adminProject";
		}
	}	

	@RequestMapping(value="/adminProjectDetail={pnum}", method = RequestMethod.GET)
	public String read(Model model, ProjectView project, DDay dday, FundingSum funding,Funder funder, GiftCount gift, StoryReq storyreq,
			 UserFundingView userfunding, HttpSession session, @PathVariable int pnum) throws Exception {
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");	
		
		if (userSubmit == null) {
			return "admin/adminLogin";		
			
		} else {		

		project = pjDao.selectbyPnum(pnum);
		funding = pjDao.selfromFunding(pnum);
		gift = pjDao.selGiftCount(pnum);
		 projectNumber = project.getPnum();
	//	int projectNumber = project.getPnum();
		List<Board> articles = pjDao.searchbyPnum(pnum);

		String fin = String.valueOf(project.getPj_fin());
		String year = fin.substring(0, 4);
		String month = fin.substring(4, 6);
		String day = fin.substring(6, 8);

		double sum = 0;
		double goal = 0;
		double p = 0;
		int percent = 0;

		if (funding != null) {
			sum = funding.getSum();
			goal = Double.parseDouble(project.getPj_goal());
			p = (sum / goal) * 100;
			if(p == 100) {
	        	 percent = (int)100;
	        	 
	         }else {
	        	 percent = (int) Math.ceil(p);
	         }

		} else {
			funding = new FundingSum();
			funding.setPnum(pnum);
			funding.setSubject(project.getPj_sub());
			funding.setSum(0);
			funding.setDate_fin(project.getPj_fin());
			funding.setCount(0);
		}

		dday.setYear(year);
		dday.setMonth(month);
		dday.setDay(day);
		dday.setPercent(percent);
			
		model.addAttribute("project", project);
		model.addAttribute("funding", funding);
		model.addAttribute("dday", dday);
		model.addAttribute("gift", gift);
		model.addAttribute("articles", articles);
		model.addAttribute("pj", projectDao.readbyPnum(pnum));
	    model.addAttribute("comment", projectDao.readreq(pnum));
	    model.addAttribute("req",projectDao.adminRequest(pnum));
	     	
	    List<UserFundingView> funderList = pjDao.funderList(pnum);
        model.addAttribute("funderList", funderList);
	    
        
        funder = pjDao.adminselfromFunder(pnum);
        FunderView funderview = new FunderView();
        
        if(funder != null) {
       	 funderview.setPnum(pnum);
       	 funderview.setId(funder.getId());
       	 funderview.setFunded(funder.getFunded());
       	 funderview.setStatus(1);
            model.addAttribute("funder", funderview);
        }else {
       	 funderview.setPnum(pnum);
       	 funderview.setId("id");
       	 funderview.setFunded(0);
       	 funderview.setStatus(0);
            model.addAttribute("funder", funderview);
        }
	    LikeView likeview = pjDao.heartCount(pnum);
		if (likeview == null) {
		} else {
			model.addAttribute("likecount", likeview.getCount());
		}
		
			return "admin/adminPjDetail";
		}
	}
	
	@RequestMapping(value="/adminProjectConfirm={pnum}",method = RequestMethod.GET) 
	public String confirm(PjCommentReq comment) {
			
		return "admin/adminProjectDetail";
	}
	
	@RequestMapping(value = "/adminProjectConfirm={pnum}", method = RequestMethod.POST)
	public String confirm(PjCommentReq comment, HttpSession session,@PathVariable int pnum) throws Exception {
	/*	AdminPjView view = projectDao.readbyPnum(pnum);*/

		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";		
			
		} else {
		int result = projectDao.confirm(comment.getFeedback(), pnum);
		if (result == 1) {
			PjComment comment2 = new PjComment();			
			comment2.setFeedback(comment.getFeedback());			
			
			return "admin/adminPojectConfirm";
		} else {
			return "admin/adminPojectFail";
		}	
		}
	}
	
	
	@RequestMapping(value="/adminProjectReject={pnum}",method = RequestMethod.GET) 
	public String reject(PjCommentReq comment) {
			
		return "admin/adminProjectDetail";
	}
	
	@RequestMapping(value = "/adminProjectReject={pnum}", method = RequestMethod.POST)
	public String reject2(PjCommentReq comment, HttpSession session,@PathVariable int pnum) throws Exception {

		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";		
			
		} else {
		int result = projectDao.reject(comment.getFeedback(), pnum);
		if (result == 1) {
			PjComment comment2 = new PjComment();			
			comment2.setFeedback(comment.getFeedback());			
						
			return "admin/adminProjectReject";
		} else {
			return "admin/adminPojectFail";
		}
		}
	}
	@RequestMapping(value="/adminProjectReq={pnum}",method = RequestMethod.GET) 
	public String request(AdminRequestReq req) {
			
		return "admin/adminProjectDetail";
	}
	
	@RequestMapping(value = "/adminProjectReq={pnum}", method = RequestMethod.POST)
	public String request(AdminRequestReq req,HttpSession session, @PathVariable int pnum) throws Exception {
		
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";		
			
		} else {	
		int result = projectDao.request(req.getReq_comm(), pnum);
		if (result == 1) {
			AdminRequest req2 = new AdminRequest();			
			req2.setReq_comm(req.getReq_comm());			
						
			return "admin/adminProjectRequest";
		} else {
			return "admin/adminPojectFail";
		}
		}
	}	
	
	@RequestMapping("/adminProjectSid={key}")
	public String Search(Model model,HttpSession session, @PathVariable String key) throws Exception{		
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";					
		} else {	
		key=key.trim();				
		model.addAttribute("key", key);
		model.addAttribute("project", projectDao.searchbyId(key));
		return "admin/adminProjectSearch";
		}
	}
	@RequestMapping("/adminProjectSsub={key}")
	public String Search2(Model model, HttpSession session, @PathVariable String key) throws Exception{
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";	
			
		} else {
		key=key.trim();					
		model.addAttribute("key", key);
		model.addAttribute("project", projectDao.searchbySub(key));
		return "admin/adminProjectSearch";
		}
	}
	@RequestMapping("/adminProjectScat={key}")
	public String Search3(Model model,HttpSession session,  @PathVariable String key) throws Exception{
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";					
		} else {
		key=key.trim();				
		model.addAttribute("key", key);
		model.addAttribute("project", projectDao.searchbyCate(key));
		return "admin/adminProjectSearch";
		}
	}
	@RequestMapping("/adminProjectSpnum={key}")
	public String Search4(Model model, HttpSession session, @PathVariable int key) throws Exception{	
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";			
		} else {		
		model.addAttribute("key", key);
		model.addAttribute("project",  projectDao.searchbyPnum(key));
		return "admin/adminProjectSearch";
		}
	}
	@RequestMapping(value="/adminChangeStatus1={pnum}",method = RequestMethod.GET) 
	public String cstatus() {
			
		return "admin/adminProjectDetail";
	}
	
	@RequestMapping(value = "/adminChangeStatus1={pnum}", method = RequestMethod.POST)
	public String cstatus(HttpSession session,  @PathVariable int pnum) throws Exception {
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		int result = projectDao.changeCstatus(1,pnum);
		if (result == 1) {			
						
			return "admin/adminPjChangeStatus";
		} else {
			return "admin/adminPojectFail";
		}
		}
	}
	@RequestMapping(value="/adminChangeStatus2={pnum}",method = RequestMethod.GET) 
	public String cstatus2() {
		
		return "admin/adminProjectDetail";
	}
	
	@RequestMapping(value = "/adminChangeStatus2={pnum}", method = RequestMethod.POST)
	public String cstatus2(HttpSession session,  @PathVariable int pnum) throws Exception {
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		int result = projectDao.changeCstatus(2,pnum);
		if (result == 1) {
			System.out.println("성공");
		
			return "admin/adminPjChangeStatus";
		} else {
			return "admin/adminPojectFail";
		}
		}
	}
	@RequestMapping(value="/adminChangeStatus3={pnum}",method = RequestMethod.GET) 
	public String cstatus3() {
		
		return "admin/adminProjectDetail";
	}
	
	@RequestMapping(value = "/adminChangeStatus3={pnum}", method = RequestMethod.POST)
	public String cstatus3(HttpSession session,  @PathVariable int pnum) throws Exception {
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit == null) {
			return "admin/adminLogin";
		} else {
		int result = projectDao.changeCstatus(3,pnum);
		if (result == 1) {
			System.out.println("성공");
		
			return "admin/adminPjChangeStatus";
		} else {
			return "admin/adminPojectFail";
		}
		}
	}
	
	@RequestMapping(value="/adminProjectPick={pnum}", method=RequestMethod.POST)
	public String editorPick(Model model, HttpSession session, AdminPjView project, @PathVariable int pnum) throws Exception {
	
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");	
		if (userSubmit == null) {
			return "admin/adminLogin";					
		} else {		
		project = projectDao.readbyPnum(pnum);
		if(project.getPick() == 0){
			projectDao.pick(1,pnum);
			return "redirect:/adminProjectDetail={pnum}";
		}if(project.getPick() == 1){
			projectDao.pick(0,pnum);
			return "redirect:/adminProjectDetail={pnum}";
		}
		else {
			return "admin/adminPojectFail";
		}
		}
	}
}
