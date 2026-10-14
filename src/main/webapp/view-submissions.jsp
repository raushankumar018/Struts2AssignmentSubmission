<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
  <title>All Submissions</title>
  <link rel="stylesheet" href="assets/css/style.css"/>
</head>
<body class="gradient-bg">
<div class="container fade-in">
  <h1>All Submissions</h1>
  <table class="table">
    <thead>
      <tr>
        <th>ID</th><th>Name</th><th>Student ID</th><th>Course</th><th>Title</th><th>Words</th><th>File</th><th>Created</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator value="submissions">
        <tr>
          <td><s:property value="id"/></td>
          <td><s:property value="studentName"/></td>
          <td><s:property value="studentId"/></td>
          <td><s:property value="courseName"/></td>
          <td><s:property value="assignmentTitle"/></td>
          <td><s:property value="wordCount"/></td>
          <td>
            <s:if test="filePath != null">
              <a class="link" href="<s:property value='filePath'/>" target="_blank">Download</a>
            </s:if>
            <s:else>-</s:else>
          </td>
          <td><s:date name="createdAt" format="yyyy-MM-dd HH:mm"/></td>
        </tr>
      </s:iterator>
    </tbody>
  </table>
  <div class="actions">
    <a class="btn" href="index.jsp">Home</a>
    <a class="btn" href="exportCsv">Export CSV</a>
  </div>
</div>
</body>
</html>
