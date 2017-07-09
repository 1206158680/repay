package controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BeanItemCost;
import model.BeanSummary;
import serviceI.IItemCostService;
import serviceI.ISummaryService;
import util.BaseException;

@Controller
public class SummaryController {
	@Autowired
	private ISummaryService SummaryService;
	@Autowired
	private IItemCostService ItemCostService;
	@RequestMapping(value = "/loadAllSummary.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String loadAllSummary() throws JSONException{
		List<BeanSummary> result=new ArrayList<BeanSummary>();
		try {
			result=SummaryService.loadSummary();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray json = new JSONArray();
		for(int i=0;i<result.size();i++){
			JSONObject jo = new JSONObject();
			jo.put("summaryId", result.get(i).getSummaryId());
			jo.put("userId",result.get(i).getUserId() );
			jo.put("company",result.get(i).getCompany() );
			jo.put("projectId",result.get(i).getProjectId() );
			jo.put("billCount",result.get(i).getBillCount() );
			jo.put("sum",result.get(i).getSum() );
			jo.put("workerId",result.get(i).getWorkerId() );
			jo.put("userName",result.get(i).getUserName() );
			jo.put("cardNumber",result.get(i).getCardNumber() );
			jo.put("money", result.get(i).getMoney() );
			jo.put("manager",result.get(i).getManager() );
			jo.put("applicationId", result.get(i).getApplicationId());
			json.put(jo);
		}
		return json.toString();
	}
	@RequestMapping(value = "/searchSummary.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String searchSummary(@RequestBody String params) throws JSONException{
		JSONObject json = new JSONObject(params);
		int summaryId=json.getInt("summaryId");
		BeanSummary result =new BeanSummary();
		JSONObject jo = new JSONObject();
		try {
			result=SummaryService.searchSummary(summaryId);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jo.put("summaryId", result.getSummaryId());
		jo.put("userId",result.getUserId() );
		jo.put("company",result.getCompany() );
		jo.put("projectId",result.getProjectId() );
		jo.put("billCount",result.getBillCount() );
		jo.put("sum",result.getSum() );
		jo.put("workerId",result.getWorkerId() );
		jo.put("userName",result.getUserName() );
		jo.put("cardNumber",result.getCardNumber() );
		jo.put("money", result.getMoney() );
		jo.put("manager",result.getManager() );
		jo.put("applicationId", result.getApplicationId());
		return jo.toString();
	}
	@RequestMapping(value = "/addSummary.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String addSummary(@RequestBody String params) throws JSONException{
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject(params);
		String userId=(String)jo.get("userId");
		String company=(String)jo.get("company");
		String projectId=(String)jo.get("projectId");
		int billCount=Integer.valueOf((String)jo.get("billCount"));
		float sum=0;
		String workerId=(String)jo.get("workerId");
		String userName=(String)jo.get("workerName");
		float money=Float.parseFloat((String)jo.get("money"));
		String cardNumber=(String)jo.get("cardNumber");
		String manager=(String)jo.get("manager"); 
		String applicationId=(String)jo.get("applicationId");
		json=jo.getJSONArray("itemCost");
		List<BeanItemCost> result =new ArrayList<BeanItemCost>();
		for(int i=0;i<json.length();i++){
			JSONObject jsonObj = json.getJSONObject(i);
			BeanItemCost bic =new BeanItemCost();
			String itemCostName=(String)jsonObj.get("itemCostName");
			float itemCost=Float.parseFloat((String)jsonObj.get("itemCost"));
			bic.setItemCostName(itemCostName);
			bic.setItemCost(itemCost);
			sum+=itemCost;
			result.add(bic);
		}	
		try {
			SummaryService.addSummary(userId, company, projectId, billCount, sum, workerId, userName, money, cardNumber, manager, applicationId);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int summaryid=SummaryService.Searchmaxnuk(userId, projectId);
			for(int i=0;i<result.size();i++){
				result.get(i).setSummary(summaryid);
				ItemCostService.addItemCost(result.get(i).getSummary(), 0, result.get(i).getItemCostName(), result.get(i).getItemCost());
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "1";
	}
	@RequestMapping(value = "/updateSummary.do", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String updateSummary(@RequestBody String params) throws JSONException, BaseException{
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject(params);
		int summaryId=Integer.valueOf((String)jo.get("summaryId"));
		String userId=(String)jo.get("userId");
		String company=(String)jo.get("company");
		String projectId=(String)jo.get("projectId");
		int billCount=Integer.valueOf((String)jo.get("billCount"));
		float sum=0;
		String workerId=(String)jo.get("workerId");
		String userName=(String)jo.get("workerName");
		float money=Float.parseFloat((String)jo.get("money"));
		String cardNumber=(String)jo.get("cardNumber");
		String manager=(String)jo.get("manager"); 
		String applicationId=(String)jo.get("applicationId");
		json=jo.getJSONArray("itemCost");
		List<BeanItemCost> result =new ArrayList<BeanItemCost>();
		for(int i=0;i<json.length();i++){
			JSONObject jsonObj = json.getJSONObject(i);
			BeanItemCost bic =new BeanItemCost();
			int itemCostId=Integer.valueOf((String)jsonObj.get("itemCostId"));
			bic=ItemCostService.SearchItemCost(itemCostId);
			
			
			float itemCost=Float.parseFloat((String)jsonObj.get("itemCost"));
			
			
			sum+=itemCost;
			ItemCostService.modifryItemCost(bic.getItemCostId(), bic.getSummary(), 0, bic.getItemCostName(), bic.getItemCost());
		}
		SummaryService.modifrySummary(summaryId, userId, company, projectId, billCount, sum, workerId, userName, money, cardNumber, manager, applicationId);
		
		return null;
	}
}