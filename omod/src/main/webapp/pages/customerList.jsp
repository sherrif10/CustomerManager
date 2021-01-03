<html>
<body>
<h1>Openmrs Customer client HomePAge</h1>

<form action="/FirstSpringMvc/submitAdmissionForm.html" method ="post">
<table>
<tr>
				<th>
					<openmrs:message code="customerId" />
				</th>
				<th>
					<openmrs:message code="CustomerLocation" />
				</th>
				<th>
					<openmrs:message code="CustomerPhoneNumber" />
				</th>
				
				<th></th>
			</tr>
<tr>
 <td><label for="start-date"> <spring:message code="label.studentDOB"/>studentDOB</label></td><td> <input type="date" id="Student DOB" name="studentDOB" /></tr></td>
</tr>
<tr>
          <td>Customer Location:</td>   <td><select name="multiple">
                          <option value="Uganda">Uganda</option>
                          <option value="Kenya">Kenya</option>
                          <option value="Ethiopia">Ethiopia</option>
                          <option value="Susdan">Sudan</option>
                          </select></td>
</tr>
</table>
<input type ="submit" value="submit this form by clicking"/>
</body>
</html>