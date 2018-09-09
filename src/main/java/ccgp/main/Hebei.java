package ccgp.main;
import ccgp.dao.HebeiDao;
import ccgp.domain.Ccgp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Hebei {
    private String str ="";
    private String status = "";//信息的分类
    private String url = "";
    private String  title="";
    private String  time="";
    private String  area="";
    private String  people="";
    private String  href="";
    private Logger logger = LogManager.getLogger(Hebei.class.getName());
    public void Hebei1(String oldurl){
        logger.debug("开始处理:"+oldurl);
        str=oldurl+"index_";
        status = str.substring(str.length()-11, str.length()-7);
        System.out.println(str.length()-11);
        System.out.println(str.length()-7);
        System.out.println(status);
        //获取数据库中的最大时间
        HebeiDao hb=new HebeiDao();
        Date maxTime = hb.getTime(status);
        logger.debug("当前数据库中最新数据时间"+maxTime.toString());
        ArrayList<Ccgp> list = analysis(maxTime,oldurl);
        if (list!=null && !list.isEmpty()) {
            hb.hebei(list);
            logger.debug("写入完成...");
        }
        logger.debug("结束处理:"+oldurl);
        System.out.println("oldurl"+oldurl);
    }
    //解析网页并把信息存入集合中
    private ArrayList<Ccgp> analysis(Date maxTime, String oldurl) {
        ArrayList<Ccgp> list = new ArrayList<Ccgp>();
        for (int i = 0; i < 25; i++) {
            if (i == 0) {
                url = oldurl + "index.html";
            } else {
                url = str + i + ".html";
            }
            try {
                Document document = Jsoup.connect(url).timeout(30000).get();
                Element u = document.getElementsByClass("a3").get(3);//获取招标公告的title
                Element ul = document.getElementsByClass("txt").get(0);//
                Element u2 = document.getElementsByClass("txt").get(1);//获取招标公告的地址
                Element u3 = document.getElementsByClass("txt").get(2);//获取采购单位的信息
                //Elements elements1 = document.select("table").select("tr");
                try {
                    //Elements lis = ul.children();
                     title = u.text();
                     time = ul.text();
                     area = u2.text();
                     people = u3.text();
                     href=u.attr("abs:href");//采购网址的获取
                    System.out.println(title+time + area + people+href);//cxn添加的
/*
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
*/
                /*   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date time1 = format.parse(time);
                    if (time1.before(maxTime) || time1.equals(maxTime)) {
                        return list;
                    }*/
                   // SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                   // Date time1= format.parse(time);
                    Ccgp cc = new Ccgp();
                    cc.setTitle(title);
                    cc.setArea(area);
                    cc.setPeople(people);
                    //cc.setTime(time1);
                    cc.setStatus(status);
                    cc.setHref(href);
                    logger.info(cc.toString());
                    list.add(cc);
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
