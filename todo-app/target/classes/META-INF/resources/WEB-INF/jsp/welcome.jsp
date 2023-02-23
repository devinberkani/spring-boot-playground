<!-- header coming from header.jspf -->
<%@ include file="common/header.jspf" %>

<!-- navbar coming from navigation.jspf -->
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<h1>Welcome ${name}</h1>
	<a href="list-todos">Manage</a> your todos
</div>
		
<!-- footer coming from footer.jspf -->
<%@ include file="common/footer.jspf" %>