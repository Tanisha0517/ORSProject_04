package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.BankBean;
import in.co.rays.proj4.model.BankModel;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/BankReportCtl")

public class BankReportCtl extends BaseReportCtl<BankBean> {

	public List<BankBean> getList() {
		BankModel model = new BankModel();
		@SuppressWarnings("unchecked")
		List<BankBean> banks = model.list();
		return banks;
	}

	public String getView() {
		return ORSView.BANK_REPORT_VIEW;
	}

	public String getCompiledReportKey() {
		return "BANK_LIST_COMPILED_REPORT";
	}

}