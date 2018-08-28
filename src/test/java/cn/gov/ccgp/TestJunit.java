package cn.gov.ccgp;

import java.io.IOException;

import ccgp.dao.ZycaiGouDao;
import ccgp.main.*;
import ccgp.utils.Constant;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.junit.Ignore;
import org.junit.Test;

public class TestJunit {
	@Ignore
	public void testlog() {
		Logger logger = LogManager.getLogger(TestJunit.class.getName());
		logger.info("info");
		logger.debug("debug");
		logger.warn("warn");
		logger.error("test");
	}
	@Ignore
	public void testCookie() {
		try {
			Response res = Jsoup.connect("http://www.ccgp-hubei.gov.cn:8050/quSer/search")
			.execute();
			String cookie = res.cookie("JSESSIONID");

			System.out.println(cookie);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Ignore
	public void testZYcaiGou() {
		String[] urlList = Constant.ZYurlList;

		for (int i = 0; i < urlList.length; i++) {
			ZYcaiGou zycaigou = new ZYcaiGou();
			zycaigou.ZycaiGou(urlList[i]);
		}
	}
	@Ignore
	public void testBeijing(){
		Beijing beijing = new Beijing();
		beijing.beiJing();
	}

	@Ignore
	public void testHubei(){
		Hubei hubei = new Hubei();
		hubei.huBei();
	}
	@Ignore
	public void testJiangsu(){
		Jiangsu jiangsu = new Jiangsu();
		jiangsu.jiangSu();
	}

	@Ignore
	public void testNeimeng(){
		Neimeng neimeng = new Neimeng();
		neimeng.neiMeng();
	}
	@Ignore
	public void testSichuan(){
		Sichuan sichuan = new Sichuan();
		sichuan.siChuan();

	}

}

