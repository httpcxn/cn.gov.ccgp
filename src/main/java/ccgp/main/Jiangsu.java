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

import ccgp.dao.JiangsuDao;
import ccgp.domain.Ccgp;
import ccgp.utils.Constant;

public class Jiangsu {
	public Logger logger = LogManager.getLogger(Jiangsu.class.getName());

	JiangsuDao jdao = new JiangsuDao();
	public void jiangSu() {
		logger.debug("开始处理 江苏");

		ArrayList<Ccgp> list = new ArrayList<Ccgp>();
		String[] urlList = Constant.jiangsu;
		for (int i = 0; i < urlList.length; i++) {
			list = analysis(urlList[i],list);
		}
		jdao.save(list);
		logger.debug("处理结束 江苏");

	}

	private  ArrayList<Ccgp> analysis(String url, ArrayList<Ccgp> list) {
		String[] urls = url.split("/");
		String status = urls[urls.length-1];
		Date maxTime = jdao.getMaxTime(status);
		Document doc = null;
		String newUrl="";
		for(int i=0;i<10;i++) {
			if (i==0) {
				newUrl=url+"index.html";
			}else {
				newUrl=url+"index_"+i+".html";
			}
			try {
				doc = Jsoup.connect(newUrl).timeout(30000).get();
			} catch (IOException e) {
				logger.error("江苏链接失败");
				logger.error(e.getMessage());
			}
			Elements lis = doc.getElementById("newsList").child(0).children();
			for (Element li : lis) {
				Ccgp cc = new Ccgp();
				String title = li.child(0).text();
				String href = li.child(0).attr("abs:href");
				String time = li.ownText();
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				Date time1 = null;
				try {
					time1 = format.parse(time);
					if (!time1.after(maxTime)) {
						return list;
					}
				} catch (ParseException e) {
					logger.error("江苏日期转换异常");
					logger.error(e.getMessage());
				}
				
				cc.setArea("江苏");
				cc.setHref(href);
				cc.setTitle(title);
				cc.setStatus(status);
				cc.setTime(time1);
				
				logger.info(cc.toString());
				try {
					list.add(cc);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
		return list;
	}
}
