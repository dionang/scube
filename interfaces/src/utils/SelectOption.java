package utils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;


/**
 *  This class contains structure for select option
 *
 *@author     PKTAN
*/

public final class SelectOption implements Serializable{
	private boolean selected=false;
	private String order="0";
	private String label=null;
	private String value=null;
	private int valueInt;
	private Object detail;
	
	private int tmp1;
	private int tmp2;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public SelectOption(){
		
	}
	public SelectOption(SelectOption clone){
		try {
			PropertyUtils.copyProperties(this, clone);
		} catch (IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public SelectOption(String value){
		this.label=value;
		this.value=value;
	}
	public SelectOption(String label,String value){
		this.label=label;
		this.value=value;
	}
	public SelectOption(String label,String value,Object detail){
		this.label=label;
		this.value=value;
		this.detail=detail;
	}
	public SelectOption(String label,String value,Object detail,boolean selected){
		this.label=label;
		this.value=value;
		this.detail=detail;
		this.selected=selected;
	}

	public SelectOption(String label,String value,Object detail,String order){
		this.label=label;
		this.value=value;
		this.detail=detail;
		this.order=order;
	}
	public Object getDetail() {
		return detail;
	}
	public void setDetail(Object detail) {
		this.detail = detail;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public int getTmp1() {
		return tmp1;
	}
	public void setTmp1(int tmp1) {
		this.tmp1 = tmp1;
	}
	public int getTmp2() {
		return tmp2;
	}
	public void setTmp2(int tmp2) {
		this.tmp2 = tmp2;
	}
	public int getValueInt() {
		return valueInt;
	}
	public void setValueInt(int valueInt) {
		this.valueInt = valueInt;
	}
	
}
