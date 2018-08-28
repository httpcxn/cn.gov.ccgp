package zhiLianHeGui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ccgp.utils.JDBCUtils;

public class HeGuiMain {

	public static void main(String[] args) {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		ArrayList<Domain> list = new ArrayList<Domain>();
		for (int k = 1; k < 91; k++) {
			Document doc = null;
			try {
				doc = Jsoup.connect("http://sou.zhaopin.com/jobs/searchresult.ashx?jl=上海&kw=合规&sm=0&isfilter=0&fl=538&isadv=0&sg=4a55ef13352c4d8da4d2e9e8ee99de6b&p="+k)
						.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
								+ "(KHTML, like Gecko) Chrome/62.0.3192.0 Safari/537.36")
						.header("Host", "sou.zhaopin.com")
						.timeout(30000)
						.get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Elements tables = doc.getElementById("newlist_list_content_table").children();
//			String attr = doc.getElementsByClass("pagesDown-pos").attr("href");
//			if (attr==""||attr==null) {
//				break;
//			}
			for (int i = 1; i < tables.size(); i++) {
				Domain domain = new Domain();
				String zhiwu = tables.get(i).child(0).child(0).child(0).child(1).child(0).text();
				String gongsi = tables.get(i).getElementsByClass("gsmc").get(0).child(0).text();
				String address = tables.get(i).getElementsByClass("gzdd").get(0).text();
				String yx = tables.get(i).getElementsByClass("zwyx").get(0).text();
				domain.setAddress(address);
				domain.setGongsi(gongsi);
				domain.setYx(yx);
				domain.setZhiwu(zhiwu);
				list.add(domain);
			}
		}
		for (Domain domain : list) {
			Object[] params= {
					domain.getZhiwu(),
					domain.getGongsi(),
					domain.getAddress(),
					domain.getYx(),
			};
			String sql = "INSERT INTO zhilian (zhiwu,gongsi,address,yx) VALUES (?,?,?,?)";
			try {
				qr.insert(sql, new ScalarHandler<Object>(),params);
			} catch (SQLException e) {
				System.out.println("保存失败");
				e.printStackTrace();
			}
		}
	}
}
