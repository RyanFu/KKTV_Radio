package com.kktv.radio.parse;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.kktv.radio.BaseActivity;
import com.kktv.radio.type.RadioType;

public class RadioChannelParse {
	
	public static ArrayList<RadioType> parseRadioChannel(String urlString){
		ArrayList<RadioType> lists = new ArrayList<RadioType>();
		String head = BaseActivity.radioUrlHead;
		try {
			Document doc = Jsoup.connect(urlString).get();
			Element divGroup = doc.getElementById("divGroup");
			if (divGroup != null) {
				RadioType type;
				Elements videos = divGroup.getElementsByTag("a");
				for (Element video : videos) {
					type = new RadioType();
					String url = video.attr("href");
					if (url.startsWith("http://")){
						type.setUrl(url);
					}else{
						url = head+url;
						type.setUrl(url);
					}
					String name = video.text();
					type.setName(name);
					type.setFlag(0);
					lists.add(type);
					type = null;
				}
			}
		} catch (Exception e) {
		}
		return lists;
	}
	
	public static ArrayList<RadioType> parseRadioChild(String urlString){
		ArrayList<RadioType> lists = new ArrayList<RadioType>();
		try {
			Document doc = Jsoup.connect(urlString).get();
			Element contentwrapper = doc.getElementById("contentwrapper");
			if (contentwrapper != null) {
				RadioType type;
				Elements radios = contentwrapper.getElementsByTag("a");
				for (Element radio : radios) {
					type = new RadioType();
					String url = radio.attr("href");
					String name = radio.text();
					type.setUrl(url);
					type.setName(name);
					lists.add(type);
					type = null;
				}
			}
		} catch (Exception e) {
		}
		return lists;
	}
}
