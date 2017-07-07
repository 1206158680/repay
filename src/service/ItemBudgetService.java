package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.ItemBudgetDao;
import model.BeanItemBudget;
import serviceI.IItemBudgetService;
import util.BaseException;
@Service
public class ItemBudgetService implements IItemBudgetService {
	@Resource
	ItemBudgetDao ibd=new ItemBudgetDao();
	@Override
	public void addItemBudget(int budgetId, int itemId, float itemBudgetCost) throws BaseException {
		// TODO Auto-generated method stub
		BeanItemBudget bit=new BeanItemBudget();
		bit.setBudgetId(budgetId);
		bit.setItemId(itemId);
		bit.setItemBudgetCost(itemBudgetCost);
		ibd.additembudget(bit);
	}

	@Override
	public void modifryItemBudget(int itemBudgetId, int budgetId, int itemId, float itemBudgetCost)
			throws BaseException {
		// TODO Auto-generated method stub
		BeanItemBudget bit=new BeanItemBudget();
		bit.setItemBudgetId(itemBudgetId);
		bit.setBudgetId(budgetId);
		bit.setItemId(itemId);
		bit.setItemBudgetCost(itemBudgetCost);
		ibd.modifryitembudget(bit);
	}

	@Override
	public void DelItemBudget(int itemBudgetId) throws BaseException {
		// TODO Auto-generated method stub
		ibd.Delitembudget(SearchItemBudget(itemBudgetId));
	}

	@Override
	public BeanItemBudget SearchItemBudget(int itemBudgetId) throws BaseException {
		// TODO Auto-generated method stub
		BeanItemBudget bit=new BeanItemBudget();
		bit=null;
		bit=ibd.Searchitembudget(itemBudgetId);
		if(bit==null){
			throw new BaseException("查无数据");
		}
		
		return null;
	}

	@Override
	public List<BeanItemBudget> LoadItemBudget() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanItemBudget> result =new ArrayList<BeanItemBudget>();
		result=ibd.loadAllitembudget();
		return result;
	}

}