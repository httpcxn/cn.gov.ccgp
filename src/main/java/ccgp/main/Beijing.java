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

import ccgp.dao.BeijingDao;
import ccgp.domain.Ccgp;
import ccgp.utils.Constant;

public class Beijing {
	
	BeijingDao beijingDao = new BeijingDao();
	public Logger logger = LogManager.getLogger(Beijing.class.getName());
	public void beiJing() {
		logger.debug("开始处理 北京");
		ArrayList<Ccgp> list = new ArrayList<Ccgp>();
		String[] urlList = Constant.beijing;
		for (int i = 0; i < urlList.length; i++) {
			list = analysis(urlList[i],list);
		}
		beijingDao.save(list);
		logger.debug("结束处理 北京");
	}
	
	private  ArrayList<Ccgp> analysis(String url, ArrayList<Ccgp> list) {
		String[] urls = url.split("/");
		String status = urls[urls.length-1];
		Date maxTime = beijingDao.getMaxTime(status);
		Document doc=null;
		String newUrl="";
		//北京爬取不应该是10页，
		for(int i=0;i<10;i++) {
			if (i==0) {
				newUrl=url+"index.html";
			}else {
				newUrl=url+"index_"+i+".html";
			}
			try {
				doc = Jsoup.connect(newUrl).timeout(30000).get();
			} catch (IOException e) {
				logger.error("北京链接失败");
				logger.error(e.getMessage());
			}
			try {
				Elements lis = doc.getElementsByClass("xinxi_ul").get(0).children();
				for (Element li : lis) {
					String title = li.child(0).text();
					String href = li.child(0).attr("abs:href");
					String time = li.child(1).text();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
					Date time1 = null;
					try {
						time1 = format.parse(time);
						if (!time1.after(maxTime)) {
							return list;
						}
					} catch (ParseException e) {
						logger.error("北京日期转换异常");
						logger.error(e.getMessage());
					}
					Ccgp cc = new Ccgp();
					cc.setTitle(title);
					cc.setTime(time1);
					cc.setHref(href);
					cc.setStatus(status);
					cc.setArea("北京");
					logger.info(cc.toString());
					list.add(cc);
				}
			} catch (Exception e) {
				logger.info("北京解析失败");
				logger.error(e.getMessage());
			}
		}
		
		return list;
	}
}
