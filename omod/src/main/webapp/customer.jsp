<%@ include file="/WEB-INF/template/header.jsp"%>

<h2><spring:message code="contactmanager-omod.title" /></h2>
<h3><Spring:message code="contactmanager.title"/></h3>


<br/>
<%@ include file="/WEB-INF/template/footer.jsp"%> -->
<form method="get">
  Choose a Contact :<openmrs_tag:contactField formFieldName="contactId"/>
  <input type="submit" value="View"/>
  </form>
  <hr/>
  <h1>CustomerManage</h1>
  <table>
   <tr>
   <th>Contact ID</th>
   <td>${ contact.contactId }</td>
   </tr>
   <tr>
   <th>UUID</th>
   <td>${ contact.uuid }</td>
   </tr>
   <tr>
   <th>Names</th>
   <td>
   <table border="1">
   <tr>
   <th>Address</th>
   <th>Email</th>
   <th>Phone Number</th>
   <th>Location</th>
   <th>Action</th>
   </tr>
   <c:forEach var="cm" contact="${ contact.names }">
   <tr>
   <td>${ cm.Email }</td>
   <td>${ cm.PhoneNumber }</td>
   <td>${ cm.Location }</td>
   <td>${ cm.Action }</td>
   <td><c:out escapeXml="true" value="${ cm.name }"/></td>
   <td>
   <c:forEach var="t" contactmanager="${ cm.tags }" varStatus="status">
   <c:out escapeXml="true" value="${ t.tag }"/>
   <c:if test="${ not status.last }">,</c:if>
   </c:forEach>
   </td>
   </tr>
   </c:forEach>
   </table>
   </td>
   </tr>
   
  </table>
  <%@ include file="/WEB-INF/template/footer.jsp"%>