package ccgp.utils;

public class Constant {
	Constant(){System.out.print("Constant执行了"); }
	public static String[] ZYurlList = {
			"http://www.ccgp.gov.cn/cggg/zygg/gkzb/",//公开招标
			"http://www.ccgp.gov.cn/cggg/zygg/zbgg/",//中标公告
			"http://www.ccgp.gov.cn/cggg/zygg/gzgg/",//更正公告
			"http://www.ccgp.gov.cn/cggg/zygg/qtgg/",//其他公告
	};

	public static String[] beijing = {
			"http://www.ccgp-beijing.gov.cn/xxgg/sjzfcggg/sjzbgg/",//省级招标公告
			"http://www.ccgp-beijing.gov.cn/xxgg/sjzfcggg/sjzbjggg/",//省级中标公告
			"http://www.ccgp-beijing.gov.cn/xxgg/sjzfcggg/sjgzgg/",//省级更正公告
			"http://www.ccgp-beijing.gov.cn/xxgg/sjzfcggg/sjqtgg/",//省级其它公告
			"http://www.ccgp-beijing.gov.cn/xxgg/qjzfcggg/qjzbgg/",//区级招标公告
			"http://www.ccgp-beijing.gov.cn/xxgg/qjzfcggg/qjzbjggg/",//区级中标公告
			"http://www.ccgp-beijing.gov.cn/xxgg/qjzfcggg/qjgzgg/",//区级更正公告
			"http://www.ccgp-beijing.gov.cn/xxgg/qjzfcggg/qjqtgg/",//区级其它公告
	};
	public static String[] jiangsu = {
			"http://www.ccgp-jiangsu.gov.cn/cgxx/cggg/",//采购公告
			"http://www.ccgp-jiangsu.gov.cn/cgxx/cgyg/",//采购预告
			"http://www.ccgp-jiangsu.gov.cn/cgxx/gzgg/",//更改公告
	};
	public static String[] sichuan = {
			"http://www.ccgp-sichuan.gov.cn/CmsNewsController.do?method=recommendBulletinList&"
			+ "moreType=provincebuyBulletinMore&channelCode=shiji_gzgg&rp=25&page=",//市级更正公告
			
			"http://www.ccgp-sichuan.gov.cn/CmsNewsController.do?method=recommendBulletinList&"
			+ "moreType=provincebuyBulletinMore&channelCode=shiji_cggg&rp=25&page=",//市级采购公告
			
			"http://www.ccgp-sichuan.gov.cn/CmsNewsController.do?method=recommendBulletinList&"
			+ "moreType=provincebuyBulletinMore&channelCode=cggg&rp=25&page=",//省级采购
			
			"http://www.ccgp-sichuan.gov.cn/CmsNewsController.do?method=recommendBulletinList&"
			+ "moreType=provincebuyBulletinMore&channelCode=gzgg&rp=25&page=",//省级更正
	};
	public static String[] hubei={
			"http://www.ccgp-hubei.gov.cn/notice/cggg/pzbgg/index_",//省级招标公告
			"http://www.ccgp-hubei.gov.cn/notice/cggg/pzhbgg/index_",//省级中标公告
			"http://www.ccgp-hubei.gov.cn/notice/cggg/pgzgg/index_",//省级更正公告
			"http://www.ccgp-hubei.gov.cn/notice/cggg/pqtgg/index_",//省级其它公告

			"http://www.ccgp-hubei.gov.cn/notice/cggg/czbgg/index_",//市县级招标公告
			"http://www.ccgp-hubei.gov.cn/notice/cggg/czhbgg/index_",//市县级中标公告
			"http://www.ccgp-hubei.gov.cn/notice/cggg/cgzgg/index_",//市县级更正公告
			"http://www.ccgp-hubei.gov.cn/notice/cggg/cqtgg/index_",//市县级其它公告
			
	};
	public static String[] hebei={
			"http://www.ccgp-hebei.gov.cn/province/cggg/zbgg/",//招标公告
			//"http://www.ccgp-hebei.gov.cn/province/cggg/zhbgg/",//中标公告
			"http://www.ccgp-hebei.gov.cn/province/cggg/fbgg/",//废标公告
			"http://www.ccgp-hebei.gov.cn/province/cggg/gzgg/",//更正公告
	};
}
