package com.example.androidboard.board;

import android.os.Message;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by jhmfrd on 2015-10-26.
 */
public class BoardDefaultHandler extends DefaultHandler{
    boolean writer;
    boolean title;
    boolean regdata;
    ArrayList<Board> list;
    Board dto;
    BoardItemAdapter adapter;

    public BoardDefaultHandler(final BoardItemAdapter adapter){
        this.adapter=adapter;
    }
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

         if(qName.equalsIgnoreCase("list")){
             list=new ArrayList<Board>();
        }
        if(qName.equalsIgnoreCase("item")){
            /*DTO 생성*/
            dto=new Board();
        }
        if(qName.equalsIgnoreCase("writer")){
            writer=true;
        }
        if(qName.equalsIgnoreCase("title")){
            title=true;
        }
        if(qName.equalsIgnoreCase("regdate")){
            regdata=true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("item")){
            list.add(dto);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
       if(writer){
           dto.setWriter(new String(ch,start,length));
           writer=true;
       }
        if(title){
            dto.setTitle(new String(ch, start, length));
            title = true;
        }
        if(regdata){
            dto.setRegdate(new String(ch,start,length));
            regdata=true;
        }

    }
}
