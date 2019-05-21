package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.ProjectDao;
import dao.UserDao;
import vo.Board;
import vo.DDay;
import vo.Funder;
import vo.FunderView;
import vo.FundingSum;
import vo.GiftCount;
import vo.LikeReq;
import vo.LikeView;
import vo.LoginSubmit;
import vo.ProjectView;
import vo.StoryReq;
import vo.User;
import vo.UserFundingView;

@Controller
public class PjDetailController {

   private int projectNumber = 0;
   private ProjectDao projectDao;
   private UserDao userDao;

   public void setprojectDao(ProjectDao projectDao) {
      this.projectDao = projectDao;
   }
   public void setuserDao(UserDao userDao) {
      this.userDao = userDao;
   }

   @RequestMapping(value = "/project{pnum}", method = RequestMethod.GET)
   public String detail(Model model, ProjectView project, DDay dday, FundingSum funding, Funder funder, GiftCount gift, StoryReq storyreq,
		   UserFundingView userfunding,
         HttpSession session, @PathVariable int pnum) throws Exception {
      String userId = null;
      LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");   

      project = projectDao.selectbyPnum(pnum);
      funding = projectDao.selfromFunding(pnum);
      gift = projectDao.selGiftCount(pnum);
      projectNumber = project.getPnum();
      List<Board> articles = projectDao.searchbyPnum(pnum);

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
      
      model.addAttribute("userId", userId);
      model.addAttribute("project", project);
      model.addAttribute("funding", funding);
      model.addAttribute("dday", dday);
      model.addAttribute("gift", gift);
      model.addAttribute("articles", articles);

      if (userSubmit == null) {
         int nouser = 0;
         model.addAttribute("user", nouser);
         userId = "guest";
      } else {
         userId = userSubmit.getId();
         String id = userSubmit.getId().trim();
         User user = (User) userDao.userSelectById(id);
         int useq = user.getUseq();
         model.addAttribute("user", useq);
         model.addAttribute("like", projectDao.heartSelect(pnum, useq));

         
         List<UserFundingView> funderList = projectDao.funderList(pnum);
         model.addAttribute("funderList", funderList);
         
         LikeView likeview = projectDao.heartCount(pnum);
         if (likeview == null) {
         } else {
            model.addAttribute("likecount", likeview.getCount());
         }

         model.addAttribute("userId", userId);
         
         funder = projectDao.selfromFunder(pnum, userSubmit.getId());
         FunderView funderview = new FunderView();

			if (funder != null) {
				if (funder.getPayment() == 1) {
					funderview.setPnum(pnum);
					funderview.setId(funder.getId());
					funderview.setFunded(funder.getFunded());
					funderview.setStatus(1);
					funderview.setPayment(1);
					model.addAttribute("funder", funderview);
				} else {
					funderview.setPnum(pnum);
					funderview.setId("id");
					funderview.setFunded(0);
					funderview.setStatus(0);
					funderview.setPayment(0);
					model.addAttribute("funder", funderview);
				}
			}else {
				funderview.setPnum(pnum);
				funderview.setId("id");
				funderview.setFunded(0);
				funderview.setStatus(0);
				funderview.setPayment(0);
				model.addAttribute("funder", funderview);
			}
		}
      return "project/detailView";
   }

   @RequestMapping(value="/projectLike{pnum}",method = RequestMethod.POST)
   public String heart(Model model, HttpSession session, LikeReq like, @PathVariable int pnum) throws Exception {
      model.addAttribute("pnum", pnum);

      int useq;
      LoginSubmit userSubmit = (LoginSubmit) session.getAttribute("userSubmit");
      if (userSubmit == null) {
         useq = 0;
      } else {
         String id = userSubmit.getId().trim();
         User user = (User) userDao.userSelectById(id);
         useq = user.getUseq();

         if (projectDao.heartSelect(pnum, useq) != null) {
            like = projectDao.heartSelect(pnum, useq);
            if (like.getLike_yn() == 0) {
               projectDao.heartUpdate(pnum, useq, 1);
            }
            if (like.getLike_yn() == 1) {
               projectDao.heartUpdate(pnum, useq, 0);
            }
         }
         if (projectDao.heartSelect(pnum, useq) == null) {
            projectDao.heartInsert(pnum, useq);
         }
      }
      return "redirect:/project{pnum}";
   }

   @RequestMapping(value="modify_story{pnum}", method = RequestMethod.GET)
   public String modifyStory(StoryReq storyReq, @PathVariable int pnum) throws Exception {
      
      projectDao.storyUpdate(projectNumber, storyReq.getModify());
      
      return "redirect:/project{pnum}";
   }
}