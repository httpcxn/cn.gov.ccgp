package ccgp.main;
import ccgp.utils.Constant;
public class Enter {
	public static void main(String[] args) {
		System.out.println("³ÌĞòÈë¿Ú");
		String[] urlList = Constant.ZYurlList;
		for (int i = 0; i < urlList.length; i++) {
			ZYcaiGou zycaigou = new ZYcaiGou();
			zycaigou.ZycaiGou(urlList[i]);
		}

		Beijing beijing = new Beijing();
		beijing.beiJing();
		Hubei huBei = new Hubei();
		huBei.huBei();
		Jiangsu jiangsu = new Jiangsu();
		jiangsu.jiangSu();
		try{
			Neimeng neimeng = new Neimeng();
			neimeng.neiMeng();
		}catch (Exception e){
			e.printStackTrace();
		}
		Sichuan sichuan = new Sichuan();
		sichuan.siChuan();
		System.exit(0);
	}
}
