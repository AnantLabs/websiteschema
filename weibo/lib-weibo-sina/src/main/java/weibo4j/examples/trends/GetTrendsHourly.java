package weibo4j.examples.trends;

import java.util.List;

import weibo4j.Trend;
import weibo4j.Weibo;
import weibo4j.examples.Log;
import weibo4j.model.Trends;
import weibo4j.model.WeiboException;

public class GetTrendsHourly {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String access_token = args[0];
		Weibo weibo = new Weibo();
		weibo.setToken(access_token);
		int base_app = Integer.parseInt(args[1]);
		Trend tm = new Trend();
		List<Trends> trends = null;
		try {
			trends = tm.getTrendsHourly(base_app);
			for(Trends ts : trends){
				Log.logInfo(ts.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
