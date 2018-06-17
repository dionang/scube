package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


/**
* This class contains methods for validating in the form beans
*@author     PKTAN
*/

public class ItemWorkerHelper extends ItemWorkerAttr{

	public ItemWorkerHelper(String formBeanName,String docMod, String configType){
		this.formBeanName=formBeanName;
		this.docMod=docMod;
		this.configType=configType;
	}
	
	public ArrayList<String> getConfigList(){
		ArrayList<String> designOne=new ArrayList();
		//row-col-span#w@width(em,px)#
				//t@fieldType
				//s@size
				//mx@maxLengh
		if("stdDoc".equals(configType)){
			designOne.add("set@1-2-1#|n@ourProdName#|t@textField#");
			designOne.add("set@1-1-1#|n@ourProdId#|t@textField#ph@lot code");
		//	designOne.add("set@2-2-1#|n@ourProdName#|t@textField#");
		//	designOne.add("set@2-1-1#|n@ourProdId#|t@textField#ph@lot code");
		}else if("creditorAcct".equals(configType)){
			designOne.add("set@1-1-1#|n@vendCode#|t@write#");
			designOne.add("set@1-1-1#|n@vendName#|t@write#");
		}else if("prod".equals(configType)){
			designOne.add("set@1-2-1#|n@prodName#|t@textField#");
			designOne.add("set@1-1-1#|n@prodId#|t@textField#ph@lot code");
		}else if("layout".equals(configType)||"nestedSlots".equals(configType)||"nestedSlotsForTF".equals(configType)){
			designOne.add("set@1-1-1#|k@text.signageTemplate#n@slotName#|t@write#");
			if("layout".equals(configType)){
				designOne.add("set@1-2-1#shwHeader@false#|k@link.specialTextNull#n@remark#|t@sjLink#ac@saveLayout#ak@editSlotDetail#param@itemId,itemId.itemNo,itemNo.slotType,slotType#staticTargetId@slotEditDetailDiv#afTopic@/afterSlotEdit#class@icon-pencil#");
				//designOne.add("set@1-2-1#shwHeader@false#|n@remark#|t@linkStatic#ac@saveLayout#ak@editSlotDetail#param@itemId,itemId.itemNo,itemNo.#label@edit#");
				designOne.add("set@1-3-1#shwHeader@false#|n@remark#|t@linkStatic#ac@saveLayout#ak@deleteSlot#param@itemId,itemId.itemNo,itemNo.#class@icon-remove#");
			}else if("nestedSlots".equals(configType)){
				designOne.add("set@1-2-1#shwHeader@false#|n@remark#|t@linkStatic#ac@saveLayout#ak@editNestedSlotDetail#param@itemId,itemId.itemNo,itemNo.#class@icon-pencil#");
				designOne.add("set@1-3-1#shwHeader@false#|n@remark#|t@linkStatic#ac@saveLayout#ak@deleteNestedSlot#param@itemId,itemId.itemNo,itemNo.#class@icon-remove#");
			}else if("nestedSlotsForTF".equals(configType)){
				designOne.add("set@1-2-1#shwHeader@false#|n@remark#|t@linkStatic#ac@saveTimeFrame#ak@editNestedSlotDetail#param@itemId,itemId.itemNo,itemNo.#class@icon-pencil#");
				designOne.add("set@1-3-1#shwHeader@false#|n@remark#|t@linkStatic#ac@saveTimeFrame#ak@deleteNestedSlot#param@itemId,itemId.itemNo,itemNo.#class@icon-remove#");
			}
			
			/*designOne.add("set@2-1-1#shwLab@true#|k@text.width#n@slotWidth#|t@write#");
			designOne.add("set@2-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@2-3-1#|k@text.width#n@slotWidth#|t@empty#");
			
			designOne.add("set@3-1-1#shwLab@true#|k@text.height#n@slotHeight#|t@write#");
			designOne.add("set@3-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@3-3-1#|k@text.width#n@slotWidth#|t@empty#");

			designOne.add("set@4-1-1#shwLab@true#|k@text.x#n@slotXCoordinate#|t@write#");
			designOne.add("set@4-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@4-3-1#|k@text.width#n@slotWidth#|t@empty#");
			
			designOne.add("set@5-1-1#shwLab@true#|k@text.y#n@slotYCoordinate#|t@write#");
			designOne.add("set@5-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@5-3-1#|k@text.width#n@slotWidth#|t@empty#");
			
			designOne.add("set@6-1-1#shwLab@true#|n@backgroundColor#|t@write#");
			designOne.add("set@6-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@6-3-1#|k@text.width#n@slotWidth#|t@empty#");
			
			designOne.add("set@7-1-1#shwLab@true#|n@backgroundImageId#|t@write#");
			designOne.add("set@7-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@7-3-1#|k@text.width#n@slotWidth#|t@empty#");
			
			designOne.add("set@8-1-1#shwLab@true#|k@text.overLap#n@zindex#|t@write#");
			designOne.add("set@8-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@8-3-1#|k@text.width#n@slotWidth#|t@empty#");
			
			designOne.add("set@9-1-1#shwLab@true#|n@remark#|t@write#");
			designOne.add("set@9-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@9-3-1#|k@text.width#n@slotWidth#|t@empty#");
			
			designOne.add("set@10-1-1#shwLab@true#|n@slotType#|t@write#");
			designOne.add("set@10-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@10-3-1#|k@text.width#n@slotWidth#|t@empty#");

			designOne.add("set@11-1-1#shwLab@true#|k@field.timer#n@timerWithUnit#|t@write#");
			designOne.add("set@11-2-1#|k@text.width#n@slotWidth#|t@empty#");
			designOne.add("set@11-3-1#|k@text.width#n@slotWidth#|t@empty#");*/
			
		

		}else if("directoryFloorUnit".equals(configType)){
			designOne.add("set@1-2-1#|n@unitNumber#|t@textField#");
			designOne.add("set@1-3-1#|n@unitName#|t@textField#");
			designOne.add("set@1-4-1#|n@contact#|t@textField#");
			designOne.add("set@1-5-1#|n@liftLobby#|t@textField#");
			designOne.add("set@1-6-1#|n@unitCategoryName#|t@textField#");
			designOne.add("set@1-7-1#shwHeader@false#|k@link.arrowRight#n@unitNumber#|t@sjLink#ac@saveEdirectory#ak@prepareAllocateCat#param@itemNo,itemNo.itemId,itemId.floorLevel,floorLevel.floorItemId,floorItemId.#staticTargetId@unitRow#dynTargetId@floorItemId,itemNo#bfTopic@/clearAllAllocateCatDiv@");
			designOne.add("set@1-8-1#shwHeader@false#|n@unitNumber#|t@sjDiv#staticId@unitRow#dynId@floorItemId,itemNo#class@allocateCatDiv#");
		}else if("unitCategoryXref".equals(configType)){
			designOne.add("set@1-2-1#|n@unitNumber#|t@write#");
		}else if("unitCategoryXrefSvgLive".equals(configType)){
			designOne.add("set@1-1-1#attr@n.data-linkitemid,vdyn.floorItemId#attr@n.data-pointeritemid,vdyn.unitItemId#onclick@selectedPointerItemId($(this));|n@unitNumber#|t@write#");
			designOne.add("set@1-2-1#attr@n.data-linkitemid,vdyn.floorItemId#attr@n.data-pointeritemid,vdyn.unitItemId#onclick@selectedPointerItemId($(this));|n@unitName#|t@write#");
		}else if("dsScheduler".equals(configType)){
			designOne.add("set@1-1-1#|n@colorCode#|t@colorPicker#");
			designOne.add("set@1-2-1#|n@startDate#|t@dateOnly#");
			designOne.add("set@1-3-1#|n@endDate#|t@dateOnly#");
			designOne.add("set@1-4-1#|n@startTime#|t@timeOnly#");
			designOne.add("set@1-5-1#|n@endTime#|t@timeOnly#");
			designOne.add("set@1-6-1#|n@layoutId#|t@write#");
			designOne.add("set@1-7-1#|n@layoutName#|t@write#");
		}else if("timeFrame".equals(configType)){
			designOne.add("set@1-1-1#|k@field.duration#n@durationWUnit#|t@write#");
			designOne.add("set@1-3-1#shwHeader@false#|n@remark#|t@linkStatic#ac@saveTimeFrame#ak@editFrameDetail#param@itemId,itemId.itemNo,itemNo.#class@icon-pencil#");
			designOne.add("set@1-4-1#shwHeader@false#|n@remark#|t@linkStatic#ac@saveTimeFrame#ak@deleteFrame#param@itemId,itemId.itemNo,itemNo.#class@icon-remove#");
		}else if("timeFrameView".equals(configType)){
			designOne.add("set@1-1-1#|n@duration#|t@write#");
			designOne.add("set@1-2-1#|n@durationUnit#|t@write#");
		}
		
		
		ArrayList<String> sortedDesignOneList=new ArrayList<>();
		if(Validator.isNotNull(designOne)){
			//do filtering and sorting
			TreeMap<Integer,TreeMap> sortDesignListMap=new TreeMap<>();
			for(int i=0; i<designOne.size(); i++){
				String fieldDetail=(String)designOne.get(i);
				StringTokenizer st = new StringTokenizer((String)fieldDetail, "|");
				String cssSet=st.nextToken();
				String propertySet=st.nextToken();
				String typeSet=st.nextToken();
				
				inspectCssPotion(cssSet);
				int thisColRow=Integer.parseInt(getColRow());
				int thisColOrder=Integer.parseInt(getColOrder());
				TreeMap<Integer,String> thisRowMap=new TreeMap<>();
				if(sortDesignListMap.containsKey(thisColRow)){
					thisRowMap=sortDesignListMap.get(thisColRow);
				}
				if(thisRowMap.containsKey(thisColOrder)){
					//error!!
				}
				thisRowMap.put(thisColOrder, fieldDetail);
				sortDesignListMap.put(thisColRow, thisRowMap);
			}

			Iterator it = sortDesignListMap.entrySet().iterator();
	    	while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				int thisColRow = (int)entry.getKey();
				TreeMap<Integer, String> thisRowMap=(TreeMap)entry.getValue();
				Iterator it2 = thisRowMap.entrySet().iterator();
				while (it2.hasNext()) {
					Map.Entry entry2 = (Map.Entry) it2.next();
					int thisColOrder = (int)entry2.getKey();
					String fieldDetail=(String)entry2.getValue();
					sortedDesignOneList.add(fieldDetail);
				}
	    	}
		}
		
		return sortedDesignOneList;
	}
	
	public void inspectDetail(String fieldDetail){
		//designOne.add("1-3-1|itemName#ourProdName|textbox#6#5");
		//css|fieldProperty|type
		StringTokenizer st = new StringTokenizer((String)fieldDetail, "|");
		String cssSet=st.nextToken();
		String propertySet=st.nextToken();
		String typeSet=st.nextToken();
		
		//CSS
		color="";
		theme="xhtmlExLabelSimple";
		shwLab=false;
		inspectCssPotion(cssSet);
		
		//PROPERTY
		propertyName="";
		key="";
		label="";
		if(Validator.isNotNull(propertySet)){
			if(propertySet.contains("#")){
				String[] propertySetA = propertySet.split("#");
				if(propertySetA.length>0){
					for(int c=0; c<propertySetA.length; c++){
						String propertyAttrSet=propertySetA[c];
						if(propertyAttrSet.startsWith("n@")){
							String[] propertyAttr = propertyAttrSet.split("@");
							propertyName=propertyAttr[1];
						}else if(propertyAttrSet.startsWith("k@")){
							String[] propertyAttr = propertyAttrSet.split("@");
							key=propertyAttr[1];
						}
					}
				}
			}
		}
		name=formBeanName+"."+propertyName;
		if(Validator.isNull(key)){
			if(key.startsWith("text.")||key.startsWith("field.")){
				
			}else{
				key="field."+propertyName;
			}
		}
		PropHelper ph=new PropHelper();
		label=ph.getLabel(key, docMod);
		
		//FIELDTYPE
		//colsList.add("c@red#|n@cid#|t@link#ac@prepareSubscriber#ak@edit#param@docId,cid.coName,companyName.#");
		
		required=false;
		
		fieldAttr1="";
		fieldAttr2="";
		fieldAttr3="";
		if(Validator.isNotNull(typeSet)){
			if(typeSet.contains("#")){
				String[] typeSetA = typeSet.split("#");
				if(typeSetA.length>0){
					for(int c=0; c<typeSetA.length; c++){
						String typeAttrSet=typeSetA[c];
						if(typeAttrSet.startsWith("t@")){
							String[] typeAttr = typeAttrSet.split("@");
							fieldType=typeAttr[1];
							if("write".equals(fieldType)){
								break;
							}else if("link".equals(fieldType)||"linkStatic".equals(fieldType)){
								for(int z=0; z<typeSetA.length; z++){
									String fieldAttrSet=typeSetA[z];
									String[] fieldAttr = fieldAttrSet.split("@");
									if(fieldAttrSet.startsWith("ac@")){
										fieldAttr1=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("ak@")){
										fieldAttr2=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("param@")){
										fieldAttr3=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("label@")){
										fieldAttr4=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("class@")){
										valueClass=fieldAttr[1];
									}
								}
								break;
							}else if("textField".equals(fieldType)||"date".equals(fieldType)||"dateOnly".equals(fieldType)||"timeOnly".equals(fieldType)
									||"colorPicker".equals(fieldType)){
								fieldAttr1=label;
								for(int z=0; z<typeSetA.length; z++){
									String fieldAttrSet=typeSetA[z];
									if(fieldAttrSet.startsWith("r@")){
										String[] fieldAttr = fieldAttrSet.split("@");
										//required attribute
										if("true".equals(fieldAttr[1])){
											required=true;
										}
									}else if(fieldAttrSet.startsWith("ph@")){
										String[] fieldAttr = fieldAttrSet.split("@");
										fieldAttr1=fieldAttr[1];//placeHolder
									}
								}
								break;
							}else if("sjDiv".equals(fieldType)){
								for(int z=0; z<typeSetA.length; z++){
									String fieldAttrSet=typeSetA[z];
									String[] fieldAttr = fieldAttrSet.split("@");
									if(fieldAttrSet.startsWith("staticId@")){
										fieldAttr1=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("dynId@")){
										fieldAttr2=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("css@")){
										fieldAttr3=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("class@")){
										fieldAttr4=fieldAttr[1];
									}
								}
								break;
							}else if("sjLink".equals(fieldType)){
								for(int z=0; z<typeSetA.length; z++){
									String fieldAttrSet=typeSetA[z];
									String[] fieldAttr = fieldAttrSet.split("@");
									if(fieldAttrSet.startsWith("ac@")){
										fieldAttr1=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("ak@")){
										fieldAttr2=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("param@")){
										fieldAttr3=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("staticTargetId@")){
										fieldAttr4=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("dynTargetId@")){
										fieldAttr5=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("css@")){
										fieldAttr6=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("bfTopic@")){
										fieldAttr7=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("afTopic@")){
										fieldAttr8=fieldAttr[1];
									}else if(fieldAttrSet.startsWith("class@")){
										valueClass=fieldAttr[1];
									}
									
								}
								break;
							}
						}
					}
				}
			}
		}
	}
	private void inspectCssPotion(String cssSet){
		if(Validator.isNotNull(cssSet)){
			if(cssSet.contains("#")){
				String[] cssSetA = cssSet.split("#");
				if(cssSetA.length>0){
					for(int c=0; c<cssSetA.length; c++){
						String cssAttrSet=cssSetA[c];
						if(cssAttrSet.startsWith("set@")){
							String[] cssAttr = cssAttrSet.split("@");
							String colSetting=cssAttr[1];
							if(Validator.isNotNull(colSetting)){
								String[] colSettingA=colSetting.split("\\-");
								if(colSettingA.length>0){
									colRow=colSettingA[0];
									colOrder=colSettingA[1];
									colSpan=colSettingA[2];
								}
							}
						}else if(cssAttrSet.startsWith("attr@")){ 
							
						}else if(cssAttrSet.startsWith("onclick@")){
							String[] cssAttr = cssAttrSet.split("@");
							onclick=cssAttr[1];
						}else if(cssAttrSet.startsWith("c@")){
							String[] cssAttr = cssAttrSet.split("@");
							color=cssAttr[1];
						}else if(cssAttrSet.startsWith("th@")){
							String[] cssAttr = cssAttrSet.split("@");
							theme=cssAttr[1];
						}else if(cssAttrSet.startsWith("shwLab@")){
							String[] cssAttr = cssAttrSet.split("@");
							shwLab=Boolean.parseBoolean(cssAttr[1]);
						}else if(cssAttrSet.startsWith("shwHeader@")){
							String[] cssAttr = cssAttrSet.split("@");
							shwHeader=Boolean.parseBoolean(cssAttr[1]);
						}else if(cssAttrSet.startsWith("class@")){
							String[] cssAttr = cssAttrSet.split("@");
							staticClass=cssAttr[1];
						}
					}
				}
			}
		}
	}

	
} 
