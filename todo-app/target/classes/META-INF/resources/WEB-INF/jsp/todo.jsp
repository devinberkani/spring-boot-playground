<!-- header coming from header.jspf -->
<%@ include file="common/header.jspf" %>

<!-- navbar coming from navigation.jspf -->
<%@ include file="common/navigation.jspf" %>

<div class="container">

	<h1>Enter Todo Details</h1>
	
	<form:form method="post" modelAttribute="todo">
	
		<fieldset class="mb-3">
			<form:label path ="description">Description</form:label>
			<!-- Description path maps this input to the description in todo bean, which is referenced via the modelAttribute above -->
			<form:input type="text" path="description" required="required" />
			<!-- cssClass is how you declare css classes for spring tags  -->
			<form:errors path="description" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3">
			<form:label path ="targetDate">Target Date</form:label>
			<!-- Description path maps this input to the description in todo bean, which is referenced via the modelAttribute above -->
			<form:input type="text" path="targetDate" required="required" />
			<!-- cssClass is how you declare css classes for spring tags  -->
			<form:errors path="targetDate" cssClass="text-warning"/>
		</fieldset>
		
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="done" />
		<input type="submit" class="btn btn-success"/>
		
	</form:form>
	
</div>

<!-- footer coming from footer.jspf -->
<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
$('#targetDate').datepicker({
    format: 'yyyy-mm-dd',
});
</script>