package com.example.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.entity.BaseEntity;

public class BaseXmlParser<T extends BaseEntity> extends DefaultHandler{
	protected List<T> list = new ArrayList<>();
	// 用来存放每次遍历后的元素名称
	private String tagName; 
	// 构建对象
	protected T t;
	
	public void setList(List<T> list){ this.list = list; }
	public List<T> getList() { return list; }

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		tagName = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		
		tagName = null;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
	}
}
