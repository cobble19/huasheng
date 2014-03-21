package com.cobble.huasheng.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.cobble.huasheng.dto.FragmentDTO;
import com.cobble.huasheng.dto.VideoDTO;
import com.cobble.huasheng.service.HandleUrlService;

public class HandleUrlServiceImpl implements HandleUrlService {

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
	public List<FragmentDTO> getFragmentByUrl(String url) {
		if (StringUtils.isBlank(url)) {
			return null;
		}
		List<FragmentDTO> ret = new ArrayList<FragmentDTO>();
		try {
			//Document doc = Jsoup.parse(url, "http://v.qq.com", null);
			Document doc = Jsoup.connect(url).get();
			Elements elements = doc.select("div#mod_coverinfo");
			for (Element el : elements) {
				String content = el.html();
				FragmentDTO fragmentDTO = new FragmentDTO();
				fragmentDTO.setContent(content);
				ret.add(fragmentDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}

}
