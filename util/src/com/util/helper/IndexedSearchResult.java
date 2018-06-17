package com.util.helper;

import java.io.Serializable;
import java.util.HashMap;

public class IndexedSearchResult implements Serializable{
	
	protected int totalResultCount;
	protected int maxPerPage;
	protected int currentIndex;
	protected java.util.ArrayList resultList;
	protected Object extraDetail;
	protected Object extraDetail2;
	protected Object extraDetail3;
	protected Object extraDetail4;
	protected Object extraDetail5;
	protected Object extraDetail6;
	public int getTotalResultCount() {
		return totalResultCount;
	}
	public void setTotalResultCount(int totalResultCount) {
		this.totalResultCount = totalResultCount;
	}
	public int getMaxPerPage() {
		return maxPerPage;
	}
	public void setMaxPerPage(int maxPerPage) {
		this.maxPerPage = maxPerPage;
	}
	public int getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	public java.util.ArrayList getResultList() {
		return resultList;
	}
	public void setResultList(java.util.ArrayList resultList) {
		this.resultList = resultList;
	}
	public Object getExtraDetail() {
		return extraDetail;
	}
	public void setExtraDetail(Object extraDetail) {
		this.extraDetail = extraDetail;
	}
	public Object getExtraDetail2() {
		return extraDetail2;
	}
	public void setExtraDetail2(Object extraDetail2) {
		this.extraDetail2 = extraDetail2;
	}
	public Object getExtraDetail3() {
		return extraDetail3;
	}
	public void setExtraDetail3(Object extraDetail3) {
		this.extraDetail3 = extraDetail3;
	}
	public Object getExtraDetail4() {
		return extraDetail4;
	}
	public void setExtraDetail4(Object extraDetail4) {
		this.extraDetail4 = extraDetail4;
	}
	public Object getExtraDetail5() {
		return extraDetail5;
	}
	public void setExtraDetail5(Object extraDetail5) {
		this.extraDetail5 = extraDetail5;
	}
	public Object getExtraDetail6() {
		return extraDetail6;
	}
	public void setExtraDetail6(Object extraDetail6) {
		this.extraDetail6 = extraDetail6;
	}
}