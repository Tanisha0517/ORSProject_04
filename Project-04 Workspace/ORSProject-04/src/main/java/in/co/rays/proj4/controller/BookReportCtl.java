package in.co.rays.proj4.controller;

import java.util.List;

import in.co.rays.proj4.bean.BankBean;
import in.co.rays.proj4.bean.BookBean;
import in.co.rays.proj4.model.BankModel;
import in.co.rays.proj4.model.BookModel;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ctl/BookReportCtl")

public class BookReportCtl extends BaseReportCtl<BookBean> {

	public List<BookBean> getList() {
		BookModel model = new BookModel();
		@SuppressWarnings("unchecked")
		List<BookBean> books = model.list();
		return books;
	}

	public String getView() {
		return ORSView.BOOK_REPORT_VIEW;
	}

	public String getCompiledReportKey() {
		return "BOOK_LIST_COMPILED_REPORT";
	}

}
