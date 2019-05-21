package controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserProjectService;
import vo.FundingSum;
import vo.LoginSubmit;
import vo.Pnum;
import vo.ProjectView;
import vo.Request;
import vo.User;

@Controller
public class U_ProjectController {
	private UserProjectService userProjectService;
	public static int scantemp=0;

	public void setUserProjectService(UserProjectService userProjectService) {
		this.userProjectService = userProjectService;
	}

	// 남은 일자랑 현재까지 펀딩된 금액 계산해서 heartProject(VO)에 집어넣기
	public void ddayNsum(List<ProjectView> project) throws Exception {
		Calendar now = Calendar.getInstance();
		String nowYear = String.valueOf(now.get(Calendar.YEAR));
		String nowMonth = String.valueOf(now.get(Calendar.MONTH) + 1);
		String nowDay = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		if (now.get(Calendar.MONTH) + 1 < 10) {
			nowMonth = "0" + nowMonth;
		}
		if (now.get(Calendar.DAY_OF_MONTH) < 10) {
			nowDay = "0" + nowDay;
		}

		for (int i = 0; i < project.size(); i++) {
			String Dday = String.valueOf(project.get(i).getPj_fin());
			String toDay = nowYear + nowMonth + nowDay;
			Date beginDate = formatter.parse(toDay);
			Date endDate = formatter.parse(Dday);

			long diff = endDate.getTime() - beginDate.getTime();
			long diffDays = diff / (24 * 60 * 60 * 1000);

			int projectPnum = project.get(i).getPnum();
			double sum = 0;
			double goal = 0;
			double p = 0;
			int percent = 0;
			
			FundingSum funding = userProjectService.selfromFunding(projectPnum);
			int heartCnt = userProjectService.heartCount(projectPnum);

			if (funding == null) {
				project.get(i).setSum(0);
				project.get(i).setPercent(0);
			} else {
				project.get(i).setSum(funding.getSum());
				sum = funding.getSum();
				goal = Double.parseDouble(project.get(i).getPj_goal());
				p = (sum / goal) * 100;
				
				if(p == 100) {
					percent = (int)p;
				}else {
					percent = (int)Math.ceil(p);
				}
				project.get(i).setPercent(percent);
			}
			project.get(i).setDday(diffDays);
			project.get(i).setPercent(percent);
			project.get(i).setHeartcount(heartCnt);
		}
	}

	//프로젝트 둘러보기	
	@RequestMapping(value = "/lookaround")
	public String mainlist(Model model) throws Exception {
		model.addAttribute("look", 0);
		model.addAttribute("key",null);
		return list(model, 1, "");
	}

	@RequestMapping(value = "/lookaround={num}&",method=RequestMethod.POST)
	public String mainlist(Model model, @PathVariable int num) throws Exception {	
		model.addAttribute("look", 0);
		return list(model, num, "");
		
	}
	@RequestMapping(value = "/lookaround={num}&",method=RequestMethod.GET)
	public String mainlist2(Model model, @PathVariable int num) throws Exception {		
		model.addAttribute("look", 0);
		return list(model, num, "");
	}
	@RequestMapping(value = "/lookaround={num}&pick")
	public String picklist(Model model, @PathVariable int num) throws Exception {//, @PathVariable String num
			if (num == 0) {
				num = 1;
			}		
			List<ProjectView> pickProject;
			pickProject = userProjectService.read4("editor", num*8);
			ddayNsum(pickProject);
			model.addAttribute("projectRequest", pickProject);
			model.addAttribute("look",1);
			model.addAttribute("key", "에디터Pick");
			
		return "project/userView";
	}
	@RequestMapping(value = "/lookaround={num}&like")
	public String likelist(Model model, @PathVariable int num) throws Exception {	
			List<ProjectView> likeProject;
			likeProject = userProjectService.read4("heart", num*8);
			ddayNsum(likeProject);
			model.addAttribute("projectRequest", likeProject);
			model.addAttribute("look",2);
			model.addAttribute("key", "인기순");
		return "project/userView";
	}
	@RequestMapping(value = "/lookaround={num}&soon")
	public String soonlist(Model model, @PathVariable int num) throws Exception {	
			List<ProjectView> soonProject;
			soonProject = userProjectService.read4("soon", num*8);
			ddayNsum(soonProject);
			model.addAttribute("projectRequest", soonProject);
			model.addAttribute("look",3);
			model.addAttribute("key", "마감순");
			
			return "project/userView";
	}
	@RequestMapping(value = "lookaround={num}&recent")
			public String recentlist(Model model, @PathVariable int num) throws Exception {	
		List<ProjectView> recentProject;
		recentProject = userProjectService.read4("recent", num*8);
		ddayNsum(recentProject);
		model.addAttribute("projectRequest", recentProject);
		model.addAttribute("look",4);
		model.addAttribute("key", "최신순");
	return "project/userView";
}

	@RequestMapping(value = "/lookaround={num}&cate={catekey}")
	   public String catelist2(Model model, @PathVariable int num, @PathVariable String catekey) throws Exception { 
		List<ProjectView> ProjectVOs;
		try {
			if (catekey == null) {
				catekey = " ";
			}
			catekey = catekey.trim();		
			model.addAttribute("key", catekey);			
			ProjectVOs = userProjectService.readByCategory(num,catekey);
			ddayNsum(ProjectVOs);
			model.addAttribute("projectRequest", ProjectVOs);
			model.addAttribute("look",5);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "project/userView";		
	}

	@RequestMapping(value = "/lookaround={num}&key={key}")
	public String list(Model model, @PathVariable int num, @PathVariable String key) throws Exception {
		List<ProjectView> ProjectVOs = null;
		scantemp=0;
		try {			
			if (key == null) {
				key = " ";	
				/*model.addAttribute("key",null);*/
			}		
			key = key.trim(); 
			if (num == 0) {
				num = 1;
			}
		
			model.addAttribute("key",key);
			model.addAttribute("look", 0);	
			model.addAttribute("num", num);			
			ProjectVOs = userProjectService.readAll(num, key);
			ddayNsum(ProjectVOs);
			if (key.equals(" ".trim())) {model.addAttribute("key2", "모두");}
			
			model.addAttribute("projectRequest", ProjectVOs);	
			if (scantemp==1) model.addAttribute("no_result", "검색 결과가 없습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "project/userView";
	}

	//메인페이지 4개씩 둘러보기
	@RequestMapping(value = "/main") // , method = RequestMethod.POST)
	public String mainpage(Model model) throws Exception {

		List<ProjectView> recentProject;
		recentProject = userProjectService.read4("recent", 4);
		ddayNsum(recentProject);
		model.addAttribute("recentProject", recentProject);

		List<ProjectView> soonProject;
		soonProject = userProjectService.read4("soon", 4);
		ddayNsum(soonProject);
		model.addAttribute("soonProject", soonProject);

		List<ProjectView> heartProject;
		heartProject = userProjectService.read4("heart", 4);
		ddayNsum(heartProject);
		model.addAttribute("heartProject", heartProject);

		List<ProjectView> editorProject;
		editorProject = userProjectService.read4("editor", 4);
		ddayNsum(editorProject);
		model.addAttribute("editorProject", editorProject);

		return "main";
	}

	// 내가 찜한 프로젝트 리스트 불러오기
	@RequestMapping("/mypick")
	public String mypicklist(HttpSession session, Model model, Request request) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {

			User user = (User) userProjectService.userSelectById(userSubmit2.getId());
			int useq = user.getUseq();

			List<Pnum> mypickPnum;
			mypickPnum = userProjectService.mypick(useq);

			List<ProjectView> mypickProject = new ArrayList<ProjectView>();
			ProjectView project;
			for (int i = 0; i < mypickPnum.size(); i++) {
				project = userProjectService.readMypick(mypickPnum.get(i).getPnum());
				mypickProject.add(project);
			}
			model.addAttribute("mypickProject", mypickProject);

			return "project/mypicklist";
		}
	}


	// 내가 만든 프로젝트 리스트 불러오기
	@RequestMapping("/myproject")
	public String myprojectlist(HttpSession session, Model model, Request request) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {
			String id = null;
			id = userSubmit2.getId().trim();

			List<ProjectView> ingProject = userProjectService.readMine(1, id, 3);
		
			ddayNsum(ingProject);
			model.addAttribute("ingProject", ingProject);
		
			List<ProjectView> reviewProject;
			reviewProject = userProjectService.readMine2(1, id, 3);
			
			ddayNsum(reviewProject);
			model.addAttribute("reviewProject", reviewProject);
			
			List<ProjectView> finProject;
			finProject = userProjectService.readMine(5, id, 3);
			
				
			ddayNsum(finProject);
			model.addAttribute("finProject", finProject);
			
			List<ProjectView> rejectProject;
			rejectProject = userProjectService.readMine2(3, id, 3);
			
				ddayNsum(rejectProject);
				model.addAttribute("rejectProject", rejectProject);
			
			return "project/fundinglist";
		}
	}

	//내가 만든 프로젝트-더보기(진행중/검토중/마감/반려)
	@RequestMapping("/more=ing")
	public String myingproject(HttpSession session, Model model) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {
			String id = null;
			id = userSubmit2.getId().trim();
			List<ProjectView> ingProject = userProjectService.readMine(1, id, 200);
			
				ddayNsum(ingProject);
				model.addAttribute("project", ingProject);
			
			model.addAttribute("more", 1);
			return "project/fundinglistMore";
		}
	}

	@RequestMapping("/more=review")
	public String myreviewproject(HttpSession session, Model model) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {
			String id = null;
			id = userSubmit2.getId().trim();
			List<ProjectView> reviewProject = userProjectService.readMine2(1, id, 200);
			
				ddayNsum(reviewProject);
				model.addAttribute("project", reviewProject);
			
			model.addAttribute("more", 2);
			return "project/fundinglistMore";
		}
	}

	@RequestMapping("/more=fin")
	public String myfinproject(HttpSession session, Model model) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {
			String id = null;
			id = userSubmit2.getId().trim();
			List<ProjectView> finProject = userProjectService.readMine(5, id, 200);
			
				model.addAttribute("read", 1);
				ddayNsum(finProject);
				model.addAttribute("project", finProject);
			model.addAttribute("key",0);
			model.addAttribute("more", 5);
			return "project/fundinglistMore";
		}
	}

	@RequestMapping("/more=reject")
	public String myrejectproject(HttpSession session, Model model) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {
			String id = null;
			id = userSubmit2.getId().trim();
			List<ProjectView> rejectProject = userProjectService.readMine2(3, id, 200);
			
				model.addAttribute("read", 1);
				ddayNsum(rejectProject);
				model.addAttribute("project", rejectProject);
			
			model.addAttribute("more", 4);
			return "project/fundinglistMore";
		}
	}

	// 보드에서 프로젝트 번호 선택하기
	@RequestMapping(value = "/choice", method = RequestMethod.GET)
	public String myproject(HttpSession session, Model model) throws SQLException {
		List<ProjectView> ProjectVOs;

		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {
			String id = userSubmit2.getId();
			try {
				ProjectVOs = userProjectService.readingbyid(id);
				model.addAttribute("projectRequest", ProjectVOs);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return "user/choiceMypj";
		}
	}

	@RequestMapping(value = "/choice", method = RequestMethod.POST)
	public String choiced(@ModelAttribute("project") String project) {
		// model.addAttribute("choice_pnum");
		return "user/temp";
	}
	@RequestMapping(value = "/projectlist", method=RequestMethod.GET)
	public String allproject(HttpSession session, Model model, String id) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {	
			return allprojectbyid(session,model,id);
		}
		}
	@RequestMapping(value = "/projectlist", method=RequestMethod.POST)
	public String allprojectbyid(HttpSession session, Model model, String hiddenid) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {	
		
			List<ProjectView> project = userProjectService.readAll(hiddenid);
			ddayNsum(project);
			model.addAttribute("project", project);	
			model.addAttribute("id", hiddenid);
			
			return "project/allproject";
		}
	}
/*	@RequestMapping("/projectlist{id}")
	public String allprojectbyid(HttpSession session, Model model,@PathVariable String id) throws Exception {
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {	
		
			List<ProjectView> project = userProjectService.readAll(id);
			ddayNsum(project);
			model.addAttribute("project", project);	
			model.addAttribute("id", id);			
			return "project/allproject";
		}
	}*/
}
