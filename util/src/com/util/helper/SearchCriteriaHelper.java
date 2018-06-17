package com.util.helper;

import java.util.ArrayList;

import utils.CodeHelper;

public class SearchCriteriaHelper {
	public static ArrayList getCriteriaList(String docType){
		ArrayList criteriaList = new ArrayList();
		criteriaList.add("type@string|entity@cid|searchdetail@cid|operator@=");
		criteriaList.add("type@string|entity@pfcCode|searchdetail@pfcCode|operator@=");
		
		if(docType.equals(CodeHelper.DOC_TYPE_LAYOUT)){
			criteriaList.add("type@string|entity@layoutName|searchdetail@layoutName|operator@LIKE");
			criteriaList.add("type@string|entity@projectName|searchdetail@projectName|operator@LIKE");
		}
		if(docType.equals(CodeHelper.DOC_TYPE_DS)){
			criteriaList.add("type@string|entity@dsName|searchdetail@dsName|operator@LIKE");
		}
		if(docType.equals(CodeHelper.DOC_TYPE_TIME_FRAME)){
			criteriaList.add("type@string|entity@timeFrameName|searchdetail@timeFrameName|operator@LIKE");
		}
		if(docType.equals(CodeHelper.DOC_TYPE_EDIRECTORY)){
			criteriaList.add("type@string|entity@edirectoryName|searchdetail@edirectoryName|operator@LIKE");
			criteriaList.add("type@string|entity@categoryName|searchdetail@categoryName|operator@LIKE");
			criteriaList.add("type@string|entity@unitName|searchdetail@unitName|operator@LIKE");
			criteriaList.add("type@string|entity@unitNumber|searchdetail@unitNumber|operator@LIKE");
			criteriaList.add("type@string|entity@floorLevel|searchdetail@floorLevel|operator@LIKE");
		}
		return criteriaList;
	}
}
