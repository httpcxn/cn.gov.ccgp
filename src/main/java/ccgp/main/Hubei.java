package ccgp.main;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ccgp.dao.HubeiDao;
import ccgp.domain.Ccgp;
import ccgp.utils.Constant;

public class Hubei {
	public Logger logger = LogManager.getLogger(Beijing.class.getName());

	public void huBei() {
		logger.debug("开始处理 湖北");

		ArrayList<Ccgp> list = new ArrayList<Ccgp>();
		String[] urlList = Constant.hubei;
		for (int i = 0; i < urlList.length; i++) {
			list = analysis(urlList[i],list);
		}
		HubeiDao hdao = new HubeiDao();
		hdao.save(list);
		logger.debug("结束处理 湖北");

	}

	private ArrayList<Ccgp> analysis(String url, ArrayList<Ccgp> list) {
	int a = 5;
	String[] urls = url.split("/");
	String status = urls[urls.length-2];
	Document doc=null;
	for(int i=1;i<a;i++) {
		String newUrl=url+i+".html";
		try {
			doc = Jsoup.connect(newUrl).timeout(30000).get();
		} catch (IOException e) {
			logger.error("湖北链接失败");
			logger.error(e.getMessage());
		}
		try {
			Elements paginationLis = doc.getElementsByClass("pagination").get(0).children();
			String page = paginationLis.get(paginationLis.size()-1).text();
			char c = page.charAt(3);
			a=c-'0';
			Elements lis = doc.getElementsByClass("news-list-content list-unstyled margin-top-20").get(0).children();
			for (Element li : lis) {
				String title = li.child(0).text();
				String href = li.child(0).attr("abs:href");
				String time = li.child(1).text();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date time1 = null;
				try {
					time1 = format.parse(time);
				} catch (ParseException e) {
					logger.error("湖北日期转换异常");
					logger.error(e.getMessage());
				}
				Ccgp cc = new Ccgp();
				cc.setTitle(title);
				cc.setTime(time1);
				cc.setHref(href);
				cc.setStatus(status);
				cc.setArea("湖北");

				logger.info(cc.toString());
				list.add(cc);
			}
		} catch (Exception e) {
			logger.error("湖北解析失败");
			logger.error(e.getMessage());
		}
	}
	return list;
}
}
