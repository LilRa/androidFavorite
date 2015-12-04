package com.study.boardapp.board;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XMLDefaultHandler extends DefaultHandler{
    String TAG;

    boolean writer;
    boolean title;
    boolean regdate;
    ArrayList<Board> list=new ArrayList<Board>();
    Board dto;

    public XMLDefaultHandler() {
        TAG=this.getClass().getName();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        Log.d(TAG, "<"+qName+">");

        if(qName.equalsIgnoreCase("data")){
            dto = new Board();
        }

        if(qName.equalsIgnoreCase("writer")){
            writer=true;
        }

        if(qName.equalsIgnoreCase("title")){
            title=true;
        }

        if(qName.equalsIgnoreCase("regdate")){
            regdate=true;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if(writer){
            dto.setWriter(new String(ch, start, length));
            writer=false;
        }
        if(title){
            dto.setTitle(new String(ch, start, length));
            title=false;
        }
        if(regdate){
            dto.setRegdate(new String(ch, start, length));
            regdate=false;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        Log.d(TAG, "</"+qName+">");
        if(qName.equalsIgnoreCase("data")){
            list.add(dto);
        }
    }

}
