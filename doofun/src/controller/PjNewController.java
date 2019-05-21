package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import exception.IdPasswordNotMatchingException;
import service.NewPjService;
import vo.GiftReq;
import vo.LoginSubmit;
import vo.PlannerReq;
import vo.ProjectReq;

@Controller
@RequestMapping("/newProject")
public class PjNewController {

	private NewPjService newPjService;

	public void setNewPjService(NewPjService newPjService) {
		this.newPjService = newPjService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String addpj(ProjectReq projectRequest, GiftReq giftRequest, PlannerReq plannerRequest, HttpSession session, HttpServletResponse response) {

		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");

		if (userSubmit != null) {
			return "project/newProject";
		} else {
			return "user/loginForm";
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addpj_submit(@RequestParam("pj_img") MultipartFile pj_img,
			@RequestParam("pl_img") MultipartFile pl_img, ProjectReq projectRequest, GiftReq giftRequest,
			PlannerReq plannerRequest, HttpSession session, HttpServletResponse response) throws Exception {
		
		LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");

		String pjOriName = pj_img.getOriginalFilename();
		String plOriName = pj_img.getOriginalFilename();
		String pjext = pjOriName.substring(pjOriName.lastIndexOf('.'));
		String plext = plOriName.substring(plOriName.lastIndexOf('.'));
		
		long now = System.currentTimeMillis();
		SimpleDateFormat nowTime = new SimpleDateFormat("yyyymmddHHmmss");
		String strNow = nowTime.format(new Date(now));
		
		String pjimgName = "project_" + userSubmit.getId() + "_" + strNow + pjext;
		String plimgName = "planner_" + userSubmit.getId() + "_" + strNow + plext;

		try {
			
			String path = PjNewController.class.getResource("").getPath();
			String upload = path.substring(0, path.length() - 97);

			File pjimgFile = new File(upload + "doofun/WebContent/upload/" + pjimgName);
			File plimgFile = new File(upload + "doofun/WebContent/upload/" + plimgName);

			pj_img.transferTo(pjimgFile);
			pl_img.transferTo(plimgFile);

		} catch (IOException e) {
			return "project/addProjectFail";
		}

		try {

			newPjService.projectInsert(projectRequest, userSubmit.getId(), pjimgName);
			newPjService.selectPnum(projectRequest, userSubmit.getId());
			newPjService.giftInsert(giftRequest, projectRequest);
			newPjService.plannerInsert(plannerRequest, projectRequest, userSubmit.getId(), plimgName);
			newPjService.commentInsert();
			newPjService.commentInsert();
			newPjService.requestInsert();
			newPjService.heartInsert();
			newPjService.UserInsert(userSubmit.getId());
			

			return "redirect:main";

		} catch (IdPasswordNotMatchingException e) {
			return "project/addProjectFail";
		}
	}

}