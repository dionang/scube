<%--  
<%@page import="com.object.B2bCompanyDetail"%>

<%@page import="front.FrontObject"%>
<%@page import="utils.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	FrontObject front = (FrontObject) session.getAttribute("front");
	ArrayList<B2bCompanyDetail> sliderList = front.getCompanydetail();
	if (Validator.isNull(sliderList)) {
		sliderList = new ArrayList();
	}
%>
--%>
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>b2b Sign In</title>
<!-- Favicon-->

<!-- Google Fonts -->
<link href="/assets/font/googleFont.css" rel="stylesheet"
	type="text/css">
<link href="/assets/font/icon.css" rel="stylesheet" type="text/css">

<!-- Bootstrap Core Css -->
<link href="/assets/plugins/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- Waves Effect Css -->
<link href="/assets/plugins/node-waves/waves.css" rel="stylesheet" />

<!-- Animation Css -->
<link href="/assets/plugins/animate-css/animate.css" rel="stylesheet" />

<!-- Custom Css -->
<link href="/assets/css/style.css" rel="stylesheet">
</head>



<body class="login-page">
	<div class="login-box">

		<div class="card">
			<div class="header">
				<h2>Add Company</h2>
			</div>
			<div class="body">
				<form id="sign_in" method="POST" action="addcompany">
					<div class="msg"></div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">work</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="front.name"
								placeholder="Company Name">
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">maps</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="front.email"
								placeholder="Email">
						</div>
					</div>
					<div class="input-group">
						<span class="input-group-addon"> <i class="material-icons">maps</i>
						</span>
						<div class="form-line">
							<input type="text" class="form-control" name="front.contact"
								placeholder="Contact">
						</div>
					</div>

					<div class="row">
						<div class="col-xs-8 p-t-5"></div>
						<div class="col-xs-4">
							<button class="btn btn-block bg-pink waves-effect" type="submit"
								name="actionKey" value="submit">Save</button>

						</div>
					</div>


					<div class="header">
						<h2>Company List</h2>
					</div>

					<div class="body">
						<div class="table-responsive">
							<table
								class="table table-bordered table-striped table-hover dataTable js-exportable">
								<thead>
									<tr>
										<th>ID</th>
										<th>Company Name</th>
										<th>Email</th>
										<th>Contact</th>
										<th>Created Date</th>
										<th>Updated Date</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>ID</th>
										<th>Company Name</th>
										<th>Email</th>
										<th>Contact</th>
										<th>Created Date</th>
										<th>Updated Date</th>
									</tr>
								</tfoot>
								<tbody>
									<%-- 
									<%
										for (B2bCompanyDetail s : sliderList) {
									%>
									<tr>
										<td><a
											href="/company/fasheConfig/slider/<%=s.getCompany_id()%>/get"><%=s.getCompany_id()%></a></td>

										<td><%=s.getName()%></td>
										<td><%=s.getEmail()%></td>
										<td><%=s.getContact()%></td>
										<td><%=s.getCreationDate()%></td>
										<td><%=s.getUpdatedDate()%></td>
									</tr>
									<%
										}
									%>
									--%>
								</tbody>
							</table>



						</div>
					</div>












				</form>
			</div>
		</div>
	</div>






	<!-- #END# Exportable Table -->

	<script>
		$(function() {
			//Exportable table
			$('.js-exportable').DataTable({
				dom : 'Bfrtip',
				responsive : true,
				buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
			});
		});
	</script>

	<!-- Jquery Core Js -->
	<script src="/assets/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script src="/assets/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="/assets/plugins/node-waves/waves.js"></script>

	<!-- Validation Plugin Js -->
	<script src="/assets/plugins/jquery-validation/jquery.validate.js"></script>

	<!-- Custom Js -->
	<script src="/assets/js/admin.js"></script>
	<script src="/assets/js/pages/examples/sign-in.js"></script>
</body>

</html>