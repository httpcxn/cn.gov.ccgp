package ccgp.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import ccgp.dao.NeimengDao;
import ccgp.domain.Ccgp;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Neimeng {
	public Logger logger = LogManager.getLogger(Neimeng.class.getName());
	NeimengDao ndao = new NeimengDao();

	public void neiMeng(){
		logger.debug("开始处理 内蒙");

		int totalPage=1;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(date);
		RequestConfig config = RequestConfig.custom().setConnectTimeout(20000).setSocketTimeout(20000).build();  
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();  
        ArrayList<Ccgp> list = new ArrayList<Ccgp>();
        
        for (int i = 0; i < totalPage; i++) {
        	HttpGet httpGet = new HttpGet("http://www.ccgp-neimenggu.gov.cn/zfcgwslave/web/index.php?"
        			+ "r=zfcgw/anndata&type_name=1"
        			+ "&annstartdate_S="+time
        			+ "&byf_page="+(i+1)
        			+ "&fun=cggg"
        			+ "&_=1525411411240");
        	CloseableHttpResponse response = null;
        	try {
        		response = httpClient.execute(httpGet);
        	} catch (Exception e) {
        		logger.error("内蒙获取地区列表失败");
        		logger.error(e.getMessage());
        	}
        	int statusCode = response.getStatusLine().getStatusCode();  
            if(statusCode !=200){  
                httpGet.abort();  
                throw new RuntimeException("HttpClient,error status code :" + statusCode);  
            }  
            HttpEntity entity = response.getEntity();  
            String result = null;  
            if (entity != null) {
            	try {
            		result = EntityUtils.toString(entity, "utf-8");
            		EntityUtils.consume(entity);  
            		response.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
            JSONArray array = JSONArray.fromObject(result);
            Object object = array.get(0);
            JSONArray allArray = JSONArray.fromObject(array.get(1));
            JSONObject allObj = JSONObject.fromObject(allArray.get(0));
            int totalCount = Integer.parseInt(allObj.getString("page_all"));
            if ((totalCount%18)>0) {
            	totalPage=totalCount/18+1;
            }else {
            	totalPage=totalCount/18;
            }
            JSONArray array2 = JSONArray.fromObject(object);
            for (Object object2 : array2) {
            	String area = JSONObject.fromObject(object2).getString("ADNAME");
            	String title = JSONObject.fromObject(object2).getString("TITLE_ALL");
            	String time1 = JSONObject.fromObject(object2).getString("SUBDATE");
            	String type = JSONObject.fromObject(object2).getString("PURNAME");
            	String id = JSONObject.fromObject(object2).getString("wp_mark_id");
            	
            	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            	Date time11 = null;
            	try {
            		time11 = format1.parse(time1);
            	} catch (ParseException e) {
            		e.printStackTrace();
            	}
            	
            	Ccgp cc = new Ccgp();
            	cc.setArea(unicode2String(area));
            	cc.setTime(time11);
            	cc.setTitle(unicode2String(title));
            	cc.setType(unicode2String(type));
            	cc.setHref("http://www.nmgp.gov.cn/ay_post/post.php?tb_id=1&p_id="+id);
            	logger.info(cc.toString());
            	list.add(cc);
            }
		}
        ndao.save(list);
		logger.debug("处理结束 内蒙");


	}
	// unicode转字符串
	public static String unicode2String(String unicode) {
        StringBuffer string = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        if (hex.length==1) {
			return unicode;
		}
        for (int i = 1; i < hex.length; i++) {
            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            // 追加成string
            string.append((char) data);
        }
        return string.toString();
    }
}
