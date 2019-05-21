package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ProjectDao;
import vo.GiftReq;
import vo.PlannerReq;
import vo.Pnum;
import vo.PnumView;
import vo.ProjectReq;
import vo.ProjectView;

public class NewPjService {

	private ProjectDao projectDao;
	public int project_number;

	@Autowired
	public void setNewPjService(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
	public void projectInsert(ProjectReq projectReq, String id, String imgname) throws Exception {
		ProjectView projectview = new ProjectView(projectReq.getPj_sub(), imgname, projectReq.getPj_cate(),
												  projectReq.getPj_goal(), projectReq.getPj_start(), projectReq.getPj_fin(), projectReq.getStory());
		
		projectDao.projectInsert(projectview, id);
	}
	
	public void selectPnum(ProjectReq projectReq, String id) throws Exception {
		ProjectView projectview = new ProjectView(projectReq.getPj_sub());

		project_number = projectDao.selectPnum(projectview, id);
	}
	
	public void giftInsert(GiftReq giftReq, ProjectReq projectReq) throws Exception {
		ProjectView projectview = new ProjectView(project_number, 
												  Integer.parseInt(giftReq.getMin_price1()), giftReq.getGift_name1(),
												  Integer.parseInt(giftReq.getMin_price2()), giftReq.getGift_name2(), 
												  Integer.parseInt(giftReq.getMin_price3()), giftReq.getGift_name3());
		projectDao.giftInsert(projectview);
	}

	public void plannerInsert(PlannerReq plannerReq, ProjectReq projectReq, String id, String imgname) throws Exception {
		ProjectView projectview = new ProjectView(project_number, imgname, plannerReq.getPl_name(), plannerReq.getPl_info());

		projectDao.plannerInsert(projectview, id);
	}

	public void commentInsert() throws Exception {
		projectDao.commentInsert(project_number);
	}
	
	public void requestInsert() throws Exception {
		projectDao.requestInsert(project_number);
	}

	public void heartInsert() throws Exception {
		projectDao.heartInsert(project_number);
	}
	public void UserInsert(String id) throws Exception {
		projectDao.userInsert(id);
	}
}
