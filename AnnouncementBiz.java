package com.idiway.cab.announcement.biz;
import java.util.List;

import com.idiway.cab.announcement.dao.AnnouncementDAO;
import com.idiway.cab.announcement.entity.Announcement;


public class AnnouncementBiz {
	private AnnouncementDAO andao;

	public AnnouncementDAO getAndao() {
		return andao;
	}

	public void setAndao(AnnouncementDAO andao) {
		this.andao = andao;
	}
	
	public void add(Announcement announcement)
	{
		announcement.setFilecode(andao.getid());
		announcement.setState("0");
		andao.save(announcement);
	}
	
	public void update(Announcement announcement)
	{		
		Announcement announcement1 = andao.findById(announcement.getId());
		announcement1.setContent(announcement.getContent());
		announcement1.setHeadline(announcement.getHeadline());
		announcement1.setChecker(announcement.getChecker());
		andao.attachDirty(announcement1);		
	}
	
	public void delete(Announcement announcement)
	{
		andao.delete(announcement);		
	}
	
	public List findall()
	{
		return andao.findAll();
	}
	
	public Announcement findById(Long id)
	{
		return andao.findById(id);
	}
	
	public List getCurrentPage(String pageSize, String currentPage,Object filecode,Object headline){
	
		return  andao.getCurrentPage(pageSize, currentPage, filecode, headline);
	}
	
	public Integer getTotalRecord(String pageSize,Object filecode,Object headline) {
		return new Integer(andao.getTotalRecord(pageSize, filecode, headline));
	}

	public synchronized void  updatestate(Long id,String state) {
		Announcement announcement = andao.findById(id);
		announcement.setState(state);
		andao.attachDirty(announcement);
	}

}
