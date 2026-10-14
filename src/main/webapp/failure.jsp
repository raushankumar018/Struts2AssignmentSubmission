<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Submission Failed</title>
  <link rel="stylesheet" href="assets/css/style.css"/>
</head>
<body class="gradient-bg">
<div class="container slide-up">
  <div class="card error">
    <h2>Submission Failed ❌</h2>
    <p>You missed some required input fields or constraints.</p>
    <p><strong>Details:</strong> <s:property value="failureReason"/></p>
    <p>Please <a class="link" href="showForm">go back</a> and fill it again.</p>
  </div>
</div>
</body>
</html>
