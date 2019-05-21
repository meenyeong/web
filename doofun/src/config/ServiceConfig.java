package config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

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
public class ServiceConfig {

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		ds.setJdbcUrl("jdbc:mysql://192.168.0.21:3306/team2");
		ds.setUser("team2");
		ds.setPassword("team2");

		return ds;
	}

	@Bean
	public UserDao userDao() {
		return new UserDao(dataSource());
	}

	@Bean
	public ProjectDao projectDao() {
		return new ProjectDao(dataSource());
	}

	@Bean
	public NewPjService newPjService() {
		NewPjService newPjSvc = new NewPjService();
		newPjSvc.setNewPjService(projectDao());
		return newPjSvc;
	}

	@Bean
	public LoginService loginService() {
		LoginService loginSvc = new LoginService();
		loginSvc.setUserDao(userDao());
		return loginSvc;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(100000000);
		return multipartResolver;
	}

	////////////////////////////////////////////////////
	@Bean
	public BoardDao boradDao() {
		return new BoardDao(dataSource());
	}

	@Bean
	U_bWriteSvc ubWriteSvc() {
		return new U_bWriteSvc(boradDao(), commentDao());
	}

	@Bean
	public CommentDao commentDao() {
		return new CommentDao(dataSource());
	}

	@Bean
	public UserRegisterService userRegSvc() {
		return new UserRegisterService(userDao());
	}

	@Bean
	UserProjectService userProjectService() {
		return new UserProjectService(projectDao(), userDao());
	}

	@Bean
	public FundingDao fundingDao() {
		return new FundingDao(dataSource());
	}

	@Bean
	UserFundingService userFundingService() {
		return new UserFundingService(fundingDao());
	}

	////////////////////////////////////////////////////
	@Bean
	public AdProjectDao adProjectDao() {
		return new AdProjectDao(dataSource());
	}

}
