package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.FundingDao;
import vo.Fseq;
import vo.GiftCount;
import vo.LoginSubmit;
import vo.Payment;
import vo.PaymentReq;
import vo.ProjectView;
import vo.Request;
import vo.RequestReq;
import vo.Useq;

@Controller
public class PjFundingController {
	int projectNum = 0;
	String projectName = null;
	String id = "";

	private FundingDao fundingDao;
	
	public void setfundingDao(FundingDao fundingDao) {
		this.fundingDao = fundingDao;
	}
	
	@RequestMapping(value = "/funding{pnum}", method = RequestMethod.POST)
	public String go_funding(Model model, ProjectView project, GiftCount gift, PaymentReq paymentReq,
			@PathVariable int pnum, HttpSession session, HttpServletResponse response) throws SQLException {
		projectNum = pnum;

		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");

		if (userSubmit != null) {
			id = userSubmit.getId();
			project = fundingDao.selectbyPnum(pnum);
			gift = fundingDao.selGiftCount(pnum);
			projectName = project.getPj_sub();

			model.addAttribute("project", project);
			model.addAttribute("gift", gift);
			return "project/fundingView";

		} else {
			return "user/loginForm";

		}
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String go_payment(Model model, ProjectView project, GiftCount gift, PaymentReq paymentReq, Payment payment, Fseq fseq)
			throws Exception {

		payment.setId(id);
		payment.setPnum(projectNum);
		payment.setNumber(paymentReq.getNumber());
		payment.setFunded(paymentReq.getFunded());

		fundingDao.fundingInsert(payment);
		
		model.addAttribute("payment", payment);
		model.addAttribute("name", projectName);
		return "project/compPay";

	}
	
	@RequestMapping(value = "/pay_complete", method = RequestMethod.POST)
	public String pay(Model model, Fseq fseq) throws Exception {

		fseq = fundingDao.selectFseq(id);
		fundingDao.paymentUpdate(fseq.getFseq());
		fundingDao.userUpdate(id);
		
		return "redirect:/main";
	}

	// 펀딩한 프로젝트 요청하기(form)
	@RequestMapping(value = "/requestToadmin={pnum}", method=RequestMethod.GET)
	public String request(Model model,@PathVariable int pnum, RequestReq request) {
		projectNum = pnum;
		model.addAttribute("pnum", pnum);
		return "project/request";
	}
	
	// 펀딩한 프로젝트 요청하기(전송)
	@RequestMapping(value = "/requestToadmin={pnum}", method=RequestMethod.POST)
	public String request_submit(Model model,@PathVariable int pnum, RequestReq request) throws Exception {
		fundingDao.requestUpdate(pnum, request.getReq_content());
		return "user/mypage";
	}
	
	// 요청 피드백 보기
	@RequestMapping("/answer={pnum}")
	public String answer(Model model,@PathVariable int pnum, Request request) throws Exception {
		request = fundingDao.selRequest(pnum);
		model.addAttribute("request", request);
		return "project/reqFeedback";
	}
}
