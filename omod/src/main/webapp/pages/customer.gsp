<% ui.decorateWith("appui", "standardEmrPage") %>

<h1>Customer Manager<h1/>

<% if (context.authenticated) { %>
    And a special hello to you, $context.authenticatedUser.personName.fullName.
    Your roles are:
    <% context.authenticatedUser.roles.findAll { !it.retired }.each { %>
        $it.role ($it.description)
    <% } %>
<% } else { %>
    You are not logged in.
<% } %>
<div><>

${ ui.includeFragment("customer", "users") }