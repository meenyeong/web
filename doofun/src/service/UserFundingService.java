package service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.FundingDao;
import vo.Funding;
import vo.UserFundingView;

public class UserFundingService {
	
	private Funding funding;
	private FundingDao fundingDao;
	private UserFundingView fview;
	@Autowired
	public UserFundingService(FundingDao fundingDao) {
		this.fundingDao =fundingDao ;	
	}

	// read funding where id="key"
	public List<Funding> readAll(String key) throws SQLException {
		List<Funding> results = fundingDao.selectbyId(key);
		return results;
	}

	public List<UserFundingView> myfunding(String id) throws Exception{
		List<UserFundingView> results = fundingDao.myfunding(id);
		return results;
	}

}
