package service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ProjectDao;
import dao.UserDao;
import vo.FundingSum;
import vo.Pnum;
import vo.Project;
import vo.ProjectView;
import vo.Request;
import vo.User;

public class UserProjectService {
   
   private Request request;
   private Project projectVO;
   private ProjectDao projectDao;
   private UserDao userDao;
   
   @Autowired
   public UserProjectService(ProjectDao projectDao, UserDao userDao) {
      this.projectDao = projectDao;
      this.userDao = userDao;
   }
   
   //read all subject
   public List<ProjectView> readAll(int num, String key) throws SQLException {
	   List<ProjectView> results = null;
      results= projectDao.selectbyKey(num, key);
      return results;
   }
   
   public List<ProjectView> readByCategory(int num, String key) throws SQLException {
      List<ProjectView> results= projectDao.selectbyCategory(num,key);
      return results;
   }

   //read subject by id
   public List<ProjectView> readbyid(String id) throws SQLException {
      List<ProjectView> results= projectDao.selectbyId(id);
      return results;
   }
   public List<ProjectView> readingbyid(String id) throws SQLException {
	      List<ProjectView> results= projectDao.selectingbyId(id);
	      return results;
	   }
   
   public Project readbyPnum(int parseInt) {
      return null;
   }

   public String pageNumber(int i, String string) {
      String temp = projectDao.pageNumber(i, string);
      return temp;
   }

   public List<ProjectView> read4(String key,int limit) throws Exception {
      List<ProjectView> results = projectDao.read4(key,limit);
      return results;
   }
   public FundingSum selfromFunding(int pnum) throws Exception {
	   FundingSum funding = projectDao.selfromFunding(pnum);
	   return funding;
   }
   public List<ProjectView> readMine(int c_status, String id, int limit) throws Exception {
	      List<ProjectView> results= projectDao.selectMine(c_status, id, limit);
	      return results;
   }
   public List<ProjectView> readMine2(int status, String id, int limit) throws Exception {
	      List<ProjectView> results= projectDao.selectMine2(status, id, limit);
	      return results;
   }
   public List<Pnum> mypick(int useq) throws Exception {
      List<Pnum> results = projectDao.mypick(useq);
      return results;
   }
   public ProjectView readMypick(int pnum) throws Exception {
	   ProjectView project= projectDao.readMypick(pnum);
	  return project;
   }
   public int heartCount(int pnum) throws SQLException {
      int cnt = projectDao.heartCount2(pnum);
      return cnt;
   }
   public User userSelectById(String id) throws Exception {
	   User user = userDao.userSelectById(id);
	   return user;
   }
   public List<ProjectView> readAll(String id) throws Exception {
	      List<ProjectView> results= projectDao.selectAll(id);
	      return results;
}
}