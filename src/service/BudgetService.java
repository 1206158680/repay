package service;

import java.util.Date;
import java.util.List;

import model.BeanBudget;
import serviceI.IBudgetService;
import util.BaseException;

public class BudgetService implements IBudgetService {

	@Override
	public void addBudget(String projectName, String projectType, String projectTypeId, String field, String fieldId,
			String source, String sourceId, Date prostartDate, Date proendDate, float budgetSum, String projectId)
			throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifryBudget(int budgetId, String projectName, String projectType, String projectTypeId, String field,
			String fieldId, String source, String sourceId, Date prostartDate, Date proendDate, float budgetSum,
			String projectId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void DelBudget(int budgetId) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public BeanBudget SearchBudget(int budgetId) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeanBudget> LoadBudget() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}