package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import controller.AdCommuController;
import controller.AdProjectController;
import controller.AdUserController;
import controller.FaqController;
import controller.LoginController;
import controller.PjDetailController;
import controller.PjFundingController;
import controller.PjNewController;
import controller.U_FundingController;
import controller.U_ProjectController;
import controller.U_RegiController;
import controller.U_bWriteCtrl;
import controller.U_boardCtrl;
import dao.AdProjectDao;
import dao.BoardDao;
import dao.CommentDao;
import dao.FundingDao;
import dao.ProjectDao;
import dao.UserDao;
import service.LoginService;
import service.NewPjService;
import service.U_bWriteSvc;
import service.UserFundingService;
import service.UserProjectService;
import service.UserRegisterService;

@Configuration
public class ControllerConfig implements WebMvcConfigurer {

	@Autowired
	private ProjectDao pjDao;
	@Autowired
	private FundingDao fundingDao;
	@Autowired
	private NewPjService newPjService;
	@Autowired
	private LoginService loginService;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("main");
		registry.addViewController("/sitemap").setViewName("sitemap");
		
	}


	@Bean
	public PjNewController pjNewController() {
		PjNewController newPjCtrl = new PjNewController();
		newPjCtrl.setNewPjService(newPjService);
		return newPjCtrl;
	}
	
	@Bean
	public PjDetailController pjDetailController() {
		PjDetailController detailPjCtrl = new PjDetailController();
		detailPjCtrl.setprojectDao(pjDao);
		detailPjCtrl.setuserDao(userDao);
		return detailPjCtrl;
	}

	@Bean
	public PjFundingController pjFundingController() {
		PjFundingController fundingPjCtrl = new PjFundingController();
		fundingPjCtrl.setfundingDao(fundingDao);
		return fundingPjCtrl;
	}

	
	@Bean
	public LoginController loginController() {
		LoginController loginCtrl = new LoginController();
		loginCtrl.setLoginService(loginService);
		return loginCtrl;
	}

///////////////////////////////////////////////////sodam
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CommentDao commentDao;

	@Autowired
	private U_bWriteSvc u_bWriteSvc;
	
	@Autowired
	private UserRegisterService userRegSvc;

	@Bean
	public U_bWriteCtrl u_bWriteCtrl() {
		U_bWriteCtrl ubwriteCtrl = new U_bWriteCtrl();
		ubwriteCtrl.setU_bWriteSvc(u_bWriteSvc);
		return ubwriteCtrl;
	}

	@Bean
	public U_boardCtrl pListController() {
		U_boardCtrl pListController = new U_boardCtrl();
		pListController.setBoardDao(boardDao);
		pListController.setCommentDao(commentDao);
		return pListController;
	}
	
/*	@Bean
	public U_boardCtrl commentController() {
		U_boardCtrl commentController = new U_boardCtrl();
		commentController.setCommentDao(commentDao);
		return commentController;
	}*/
	
	@Bean
	public U_RegiController registerController() {
		U_RegiController regCtrl = new U_RegiController();
		regCtrl.setUserRegisterService(userRegSvc);
		return regCtrl;
	}
	
	@Autowired
	//private ProjectDao projectDao2; 아직 귀찮아서 서비스로 처리안함
	private UserProjectService userPjSvc;
	
	@Bean
	public U_ProjectController u_ProjectController() {
		U_ProjectController u_ProjectCtrl = new U_ProjectController();
		u_ProjectCtrl.setUserProjectService(userPjSvc);
		return u_ProjectCtrl;
	}
	
	
	@Autowired
	private UserFundingService userFundSvc;
	
	@Bean U_FundingController u_FundingController() {
		U_FundingController u_FundCtrl = new U_FundingController();
		u_FundCtrl.setUserFundingService(userFundSvc);
		return u_FundCtrl;
	}

//////////////////////////////////////////////////

	@Autowired
	private AdProjectDao projectDao;

	@Bean
	public AdProjectController adProjectController() {
		AdProjectController adProjectController = new AdProjectController();
		adProjectController.setAdProjectDao(projectDao);
		adProjectController.setPjDao(pjDao);
	
		return adProjectController;
	}

	@Autowired
	private UserDao userDao;

	@Bean
	public AdUserController adUserController() {
		AdUserController adUserController = new AdUserController();
		adUserController.setUserDao(userDao);
		adUserController.setAdProjectDao(projectDao);
		return adUserController;
	}
	
	@Bean
	public AdCommuController adCommuController() {
		AdCommuController adCommuController = new AdCommuController();
		adCommuController.setBoardDao(boardDao);
		adCommuController.setCommentDao(commentDao);
		return adCommuController;
	}
	@Bean
	public FaqController faqCtrl() {
		FaqController faqCtrl = new FaqController();
		return faqCtrl;
	}

}
