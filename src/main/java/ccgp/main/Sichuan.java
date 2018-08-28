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

import ccgp.dao.SichuanDao;
import ccgp.domain.Ccgp;
import ccgp.utils.Constant;

public class Sichuan {
	public Logger logger = LogManager.getLogger(Sichuan.class.getName());

	Date maxTime = null;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 

	public void siChuan() {
		logger.debug("��ʼ���� �Ĵ�");

		SichuanDao sdao = new SichuanDao();
		maxTime = sdao.getMaxTime();
		ArrayList<Ccgp> list = new ArrayList<Ccgp>();
		String[] urlList = Constant.sichuan;
		for (int i = 0; i < urlList.length; i++) {
			list = analysis(urlList[i],list);
		}
		sdao.save(list);
		logger.debug("������� �Ĵ�");

	}

	private ArrayList<Ccgp> analysis(String url, ArrayList<Ccgp> list) {
		for (int i = 1; i < 10; i++) {
			Document doc = null;
			try {
				doc=Jsoup.connect(url+i).timeout(30000).get();
			} catch (IOException e) {
				logger.info("�Ĵ�����ʧ��");
				logger.error(e.getMessage());
			}
			Elements lis = doc.getElementsByClass("colsList").get(0).child(1).children();
			for (Element li : lis) {
				Ccgp cc = new Ccgp();
				String title = li.child(0).text();
				String href = li.child(0).attr("abs:href");
				String time = li.child(1).text();
				
				Date time1 = null;
				if (time.equals("")||time==null) {
					time1 = new Date();
				}else {
					try {
						time1 = format.parse(time);
						if (!time1.after(maxTime)) {
							return list;
						}
					} catch (ParseException e) {
						logger.info("�Ĵ�����ת���쳣");
						logger.error(e.getMessage());
					}
					
				}
				
				cc.setTitle(title);
				cc.setArea("�Ĵ�");
				cc.setHref(href);
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
