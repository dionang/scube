<%--
<%@page import="company.CompanyObject"%>
<%@page import="utils.Validator"%>
<%@page import="com.object.CompanyDetail"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
--%>

 <!-- Dropzone Css -->
 <link href="/assets/plugins/dropzone/dropzone.css" rel="stylesheet">
 <!-- Dropzone Plugin Js -->
 <script src="/assets/plugins/dropzone/dropzone.js"></script>   

<%--
CompanyObject company=(CompanyObject)session.getAttribute("company");
CompanyDetail detail=company.getDetail();
--%>
<div class="row clearfix">
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="card">
            <div class="header">
                <h2>
                    Company Account 
                    		<span class="label label-primary"><%--=detail.getName() --%></span>
                </h2>
            </div>
            <div class="body">
            		<form id="" method="POST" action="/company/companyProfile/<%--=detail.getId() --%>/button">
	            		<div class="row clearfix">
						<div class="col-sm-6">
							<div class="form-group form-float">
							    <div class="form-line">
	                                 <s:textfield cssClass="form-control" id="name" name="company.detail.name" />
	                                 <label class="form-label">Company Name</label>
	                             </div>
							</div>
					    </div>
					    <div class="col-sm-6">
					        <div class="form-group form-float">
					            <div class="form-line">
	                                 <s:textfield cssClass="form-control" id="domain" name="company.detail.domain" />
	                                 <label class="form-label">Domain</label>
	                             </div>
					        </div>
					    </div>
					    <div class="col-sm-12">
					        <div class="form-group form-float">
					            <div class="form-line">
	                                 <p><b>API KEY</b></p>
	                                 <p><%--=detail.getApiKey() --%></p>
	                             </div>
					        </div>
					    </div>
					    <div class="col-sm-12">
							<p><b>Select Theme Type</b></p>
							<s:select theme="simple" cssClass="form-control show-tick" 	list="company.themeSelectionList" listKey="valueInt" listValue="label" name="company.detail.themeId"  />
						</div>
					</div>
					<div class="row clearfix">
						<div class="col-sm-12">
							<button type="submit" name="actionKey" value="save" class="btn bg-orange waves-effect">
                                 <i class="material-icons">save</i>
                                 <span>SAVE</span>
                             </button>
						</div>
					</div>
				</form>
            </div>
            <div class="header">
                <h3><%--=detail.getUsername() --%></h3>
            </div>
            <div class="body">
            		<form id="" method="POST" action="/company/companyProfile/<%--=detail.getId()--%>/button">
	            		<div class="row clearfix">
	            			<h3><%--=detail.getUsername() --%></h3>
					    <div class="col-sm-6">
					        <div class="form-group form-float">
					            <div class="form-line">
	                                 <s:textfield cssClass="form-control" id="password" name="company.detail.password" />
	                                 <label class="form-label">Password</label>
	                             </div>
					        </div>
					    </div>
					    <div class="col-sm-6">
					        <div class="form-group form-float">
					            <div class="form-line">
	                                 <s:textfield cssClass="form-control" id="password" name="company.detail.confirmPassword" />
	                                 <label class="form-label">Confirm Password</label>
	                             </div>
					        </div>
					    </div>
					</div>
					<div class="row clearfix">
						<div class="col-sm-12">
							<button type="submit" name="actionKey" value="updatePassword" class="btn bg-orange waves-effect">
                                 <i class="material-icons">save</i>
                                 <span>Update Password</span>
                             </button>
						</div>
					</div>
				</form>
            </div>
            
            <%--if(Validator.isNotNull(detail.getLogoPath())){ 
            <div class="row clearfix">
               <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                Logo
                                <a href="/company/companyProfileUploadLogo/<%=detail.getId() %>/removeLogo" class="btn bg-red waves-effect">remove photo</a>
                            </h2>
                        </div>
                        <div class="body">
                        		<img src="http://<%=request.getServerName()+":8080"+detail.getLogoPath() %>" class="img-responsive" />
                        </div>
                    </div>
                </div>
            </div>
            
            
            <%}else{ %>
            <!-- File Upload | Drag & Drop OR With Click & Choose -->
            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header">
                            <h2>
                                UPLOAD Slider Image
                                <a href="/company/companyProfile/<% =detail.getId()%>/get" class="btn bg-green waves-effect">refresh page</a>
                            </h2>
                            <ul class="header-dropdown m-r--5">
                                <li class="dropdown">
                                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                        <i class="material-icons">more_vert</i>
                                    </a>
                                    <ul class="dropdown-menu pull-right">
                                        <li><a href="javascript:void(0);">Action</a></li>
                                        <li><a href="javascript:void(0);">Another action</a></li>
                                        <li><a href="javascript:void(0);">Something else here</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        
                        
                        
                        <div class="body">
                            <form action="/company/companyProfileUploadLogo/<%=detail.getId()%>/uploadLogo" id="frmFileUpload" class="dropzone" method="post" enctype="multipart/form-data">
                                <div class="dz-message">
                                    <div class="drag-icon-cph">
                                        <i class="material-icons">touch_app</i>
                                    </div>
                                    <h3>Drop files here or click to upload.</h3>
                                    <em>Only 1 Image is Supported</em>
                                </div>
                                <div class="fallback">
                                    <input name="file" type="file" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# File Upload | Drag & Drop OR With Click & Choose -->
            <%} --%>
            
        </div>
    </div>
</div>
