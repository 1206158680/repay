package daoI;

import java.util.List;

import model.BeanBudget;

public interface IBudgetDao {
	//预算�?
	public void addbudget(BeanBudget budget);
	//添加预算
	public BeanBudget Searchbudget(int budgetId);
	//搜索预算
	public List<BeanBudget> loadbudget(int budgetId);
	//搜索预算
	public List<BeanBudget> loadAllbudget();
	//搜索预算
	public void modifrybudget(BeanBudget budget);
	//修改预算
	public void Delbudget(BeanBudget budget);
	//删除预算
	public int SearchmaxId( int projectId,	 float budgetSum, float independentFees, float applyFees);
	
	public BeanBudget SearchbudgetByPId(int projectId);
	
}
/*
 * 

 * 
 * */
 