package com.itheima.web.common;

import java.util.List;

//��װ���ҳ�йص�������Ϣ
public class Page {
	private List records;//Ҫ��ʾ�ķ�ҳ��¼
	private int currentPageNum;//��ǰҳ�룺�����û�ָ��*
	private int pageSize=10;//ÿҳ��ʾ�ļ�¼���� *
	private int totalPageNum;//��ҳ��*
	private int prePageNum;//��һҳ��ҳ��*
	private int nextPageNum;//��һҳ��ҳ��*
	
	private int startIndex;//���ݿ�ÿҳ��ʼ��¼������*
	private int totalRecords;//�ܼ�¼������*
	
	
	//��չ��
	private int startPage;//��ʼҳ��
	private int endPage;//����ҳ��
	
	
	private String url;//��ѯ��ҳ������servlet�ĵ�ַ
	
	//currentPageNum���û�Ҫ����ҳ��
	//totalRecords:�ܼ�¼����
	public Page(int currentPageNum,int totalRecords){
		this.currentPageNum = currentPageNum;
		this.totalRecords = totalRecords;
		
		//������ҳ��
		totalPageNum = totalRecords%pageSize==0?totalRecords/pageSize:(totalRecords/pageSize+1);
		//����ÿҳ��ʼ������
		startIndex = (currentPageNum-1)*pageSize;
		
		//���㿪ʼ�ͽ���ҳ��:9��ҳ��
		if(totalPageNum>9){
			//����9ҳ
			startPage = currentPageNum-4;
			endPage = currentPageNum+4;
			
			if(startPage<1){
				startPage = 1;
				endPage = 9;
			}
			if(endPage>totalPageNum){
				endPage = totalPageNum;
				startPage = endPage-8;
			}
			
			
		}else{
			//û��9ҳ
			startPage = 1;
			endPage = totalPageNum;
		}
	}

	public List getRecords() {
		return records;
	}

	public void setRecords(List records) {
		this.records = records;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public int getPrePageNum() {
		prePageNum = currentPageNum-1;
		if(prePageNum<1){
			prePageNum = 1;
		}
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum() {
		
		nextPageNum = currentPageNum+1;
		if(nextPageNum>totalPageNum){
			nextPageNum = totalPageNum;
		}
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
