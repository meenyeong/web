package controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.FundingDao;
import service.UserFundingService;
import vo.Funding;
import vo.LoginSubmit;
import vo.ProjectView;
import vo.UserFundingView;

@Controller
public class U_FundingController {
	private UserFundingService userFundingService;

	private int projectNum = 0;

	public void setUserFundingService(UserFundingService userFundingService) {
		this.userFundingService = userFundingService;
	}

	private FundingDao fundingDao;

	public void setFundingDao(FundingDao fundingDao) {
		this.fundingDao = fundingDao;
	}

	// 펀딩한 프로젝트 보기
	@RequestMapping(value = "/lookmine") // , method = RequestMethod.POST)
	public String lookmine(HttpSession session, Model model) throws Exception {
		// @RequestParam(value = "id", defaultValue = "") String id, Model model) throws
		// SQLException {

		/*List<Funding> Fundings;*/
		List<UserFundingView> fundings;
		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {
			String id = userSubmit2.getId().trim();

			/*Fundings = userFundingService.readAll(id);
			model.addAttribute("projectRequest", Fundings);*/ // 일단 jsp에서 쓸 변수명 고정
			fundings = userFundingService.myfunding(id);
			/*if(fundings == null) {
				model.addAttribute("funder", 0);
			}else {
				model.addAttribute("funder", 1);*/			
			model.addAttribute("fundings", fundings);
			}			
			return "project/lookmine";
		}


	// 보드에서 프로젝트 번호 선택하기
	@RequestMapping(value = "/choice2", method = RequestMethod.GET)
	public String myproject(HttpSession session, Model model) throws Exception {
		List<ProjectView> ProjectVOs;

		LoginSubmit userSubmit2 = (LoginSubmit) session.getAttribute("userSubmit");
		if (userSubmit2 == null) {
			return "user/loginForm";
		} else {

			String id = userSubmit2.getId();

			List<UserFundingView> fundings;
			fundings  = userFundingService.myfunding(id);
			List<Funding> fundings2 = userFundingService.readAll(id);
			model.addAttribute("projectRequest", fundings); // 일단 jsp에서 쓸 변수명 고정
			/*model.addAttribute("funding", fundings2);*/
			return "user/choiceMyFund";
		}
	}

	@RequestMapping(value = "/choice2", method = RequestMethod.POST)
	public String choiced(@ModelAttribute("project") String project) {
		// model.addAttribute("choice_pnum");

		return "user/temp";
	}
}
