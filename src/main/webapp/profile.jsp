<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Profile</title>
  <link rel="stylesheet" href="assets/css/style.css"/>
</head>
<body class="gradient-bg">
<div class="container slide-up">
  <div class="card">
    <h2>Profile</h2>
    <p><strong>Name:</strong> <s:property value="name"/></p>
    <p><strong>Program:</strong> <s:property value="program"/></p>
    <div class="actions">
      <a class="btn" href="index.jsp">Home</a>
      <a class="btn" href="showForm">Submit Assignment</a>
    </div>
  </div>
</div>
</body>
</html>
