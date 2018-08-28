package ccgp.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ccgp.dao.ZycaiGouDao;
import ccgp.domain.Ccgp;

public class ZYcaiGou {
	private String str ="";
	private String status = "";//��Ϣ�ķ���
	private String url = "";
	private Logger logger = LogManager.getLogger(ZYcaiGou.class.getName());
	public void ZycaiGou(String oldurl) {

		logger.debug("��ʼ����:"+oldurl);
		str=oldurl+"index_";
		status = str.substring(str.length()-11, str.length()-7);
		System.out.println(str.length()-11);
		System.out.println(str.length()-7);
		System.out.println(status);
		//��ȡ���ݿ��е����ʱ��
		ZycaiGouDao zd = new ZycaiGouDao();
		Date maxTime = zd.getTime(status);
		logger.debug("��ǰ���ݿ�����������ʱ��"+maxTime.toString());
		ArrayList<Ccgp> list = analysis(maxTime,oldurl);
		if (list!=null && !list.isEmpty()) {
			zd.Zycaigou(list);
			logger.debug("д�����...");
		}
		logger.debug("��������:"+oldurl);
		System.out.println("oldurl"+oldurl);
	}

	//������ҳ������Ϣ���뼯����
	private ArrayList<Ccgp> analysis(Date maxTime, String oldurl) {
		ArrayList<Ccgp> list = new ArrayList<Ccgp>();
		for (int i = 0; i < 25; i++) {
			if (i==0) {
				url=oldurl+"index.htm";
			}else {
				url=str+i+".htm";
			}
			try {
				Document document = Jsoup.connect(url).timeout(30000).get();
				Element ul = document.getElementsByClass("c_list_bid").get(0);
				try {
					Elements lis = ul.children();
					for (Element li : lis) {
						String title = li.child(0).text();
						String href = li.child(0).attr("abs:href");
						String time = li.child(1).text();
						String area = li.child(2).text();
						String people = li.child(3).text();
						
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
						Date time1 = format.parse(time);
						if (time1.before(maxTime) || time1.equals(maxTime)) {
							return list;
						}
						
						Ccgp cc = new Ccgp();
						cc.setTitle(title);
						cc.setArea(area);
						cc.setPeople(people);
						cc.setTime(time1);
						cc.setStatus(status);
						cc.setHref(href);
						
						logger.info(cc.toString());
						list.add(cc);
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return list;
	}

}
