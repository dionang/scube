package setup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.Action;
import action.Form;

public class LookupLicenseAction extends Action {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6767254183010998061L;

	private String string1 = "A";
	private String[] stringarray1 = {"A1","B1"};
	private int number1 = 123456789;
	private int[] numberarray1 = {1,2,3,4,5,6,7,8,9};
	private List<String> lists = new ArrayList<String>();
	private Map<String, String> maps = new HashMap<String, String>();
	private String macAdd = "";
	private String name = "";
	private String status = "";
	private Form fm=new Form();
	


	public String execute() {
		lists.add("list1");
		lists.add("list2");
		lists.add("list3");
		lists.add("list4");
		lists.add("list5");

		maps.put("key1", "value1");
		maps.put("key2", "value2");
		maps.put("key3", "value3");
		maps.put("key4", "value4");
		maps.put("key5", "value5");
		return Action.SUCCESS;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String[] getStringarray1() {
		return stringarray1;
	}

	public void setStringarray1(String[] stringarray1) {
		this.stringarray1 = stringarray1;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int[] getNumberarray1() {
		return numberarray1;
	}

	public void setNumberarray1(int[] numberarray1) {
		this.numberarray1 = numberarray1;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	public String getMacAdd() {
		return macAdd;
	}
	public void setMacAdd(String macAdd) {
		this.macAdd = macAdd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Form getFm() {
		return fm;
	}

	public void setFm(Form fm) {
		this.fm = fm;
	}

}
