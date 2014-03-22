package com.cobble.huasheng.service.impl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

import com.cobble.huasheng.dto.FragmentDTO;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.service.HandleUrlService;

public class HandleUrlServiceImpl implements HandleUrlService {
	private static Logger logger = Logger.getLogger(HandleUrlServiceImpl.class);
	
	@Override
	public List<VideoDTO> getVideoByUrl(String url) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		List<VideoDTO> ret = new ArrayList<VideoDTO>();
		try {
			Document doc = Jsoup.connect(url).get();
			Elements elements = doc.select("a[href]");
			for (Element el : elements) {
				String href = el.attr("href");
				VideoDTO videoDTO = new VideoDTO();
				videoDTO.setUrl(href);
				ret.add(videoDTO);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public List<FragmentDTO> getFragmentByUrl(String urlString) {
		if (StringUtils.isBlank(urlString)) {
			return null;
		}
		List<FragmentDTO> ret = new ArrayList<FragmentDTO>();
		URL url = null;
		String html = "";
		try {
			url = new URL(urlString);
			// HTTP Client
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url.toString());
			CloseableHttpResponse httpResponse = httpclient.execute(httpget);
			try {
			    HttpEntity entity = httpResponse.getEntity();
			    if (entity != null) {
			        long len = entity.getContentLength();
			        logger.info("url=" + url.toString() + ", ContentLength=" + len);
			        html = EntityUtils.toString(entity, "UTF-8");
			        logger.debug("html=" + html);
			    }
			} finally {
				httpResponse.close();
			}
			// Jsoup
			String baseUri = url.getProtocol() + "://" + url.getHost();
			Document doc = Jsoup.parse(html, baseUri);
			// 2. get html
			Elements aElements = doc.select("a");
			for (Element ele : aElements) {
				String href = ele.attr("href");
				if (StringUtils.isNotBlank(href) && href.contains("javascript")) {
					// do nothing
				} else {
					ele.attr("href", ele.absUrl("href"));
				}
			}
			Elements e = doc.select("body>div:not(.info_container)").remove();
			e = doc.select("div.info_container > div:not(#mod_coverinfo)").remove();
			String content = doc.html();
			FragmentDTO fragmentDTO = new FragmentDTO();
			fragmentDTO.setContent(content);
			ret.add(fragmentDTO);
			// 3. get all a tag
			aElements = doc.select("div#mod_videolist a");
			content = "";
			for (Element ele : aElements) {
				String a = ele.outerHtml();
				content += a + " ";
			}
			fragmentDTO = new FragmentDTO();
			fragmentDTO.setContent(content);
			ret.add(fragmentDTO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

}
