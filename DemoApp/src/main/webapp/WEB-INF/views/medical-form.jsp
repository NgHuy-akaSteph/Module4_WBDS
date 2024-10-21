<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Khai báo y tế</title>
</head>
<body>
<h2>TỜ KHAI Y TẾ</h2>
<h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
<h3>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lí hình sự</h3>
<br><br><br>
<form:form action="/medical/submit" method="post" modelAttribute="medicalForm">
    <table>
        <tr>
          <td>Họ tên (Ghi chữ IN HOA) <span class="note">(*)</span></td>
        </tr>
        <tr>
            <td><form:input path="fullName" /></td>
        </tr>
        <tr>
            <td>Năm sinh <span class="note">(*)</span></td>
            <td><form:select path="yearOfBirth">
                <form:options items="${years}"/>
                </form:select>
            </td>
            <td>Giới tính <span class="note">(*)</span></td>
            <td><form:radiobuttons path="gender" items="${gender}"/></td>
        </tr>
        <tr>
           <td>Số CMND hoặc giấy tờ tùy thân khác <span class="note">(*)</span></td>
           <td><form:input path="IDNumber"/></td>
        </tr>
        <tr>
            <td>Thông tin đi lại<span class="note">(*)</span></td>
            <td><form:radiobutton path="vehicle"/></td>
        </tr>
        <tr>
          
        </tr>
    </table>
</form:form>

</body>
</html>
