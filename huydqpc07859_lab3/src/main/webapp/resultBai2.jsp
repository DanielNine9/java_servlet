<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin nhân viên</title>
<!-- Bootstrap CSS link -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        padding-top: 20px;
    }
    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    .profile-image {
        max-width: 100%;
        height: auto;
        display: block;
        margin-bottom: 20px;
        border-radius: 5px;
        box-shadow: 0 0 5px rgba(0,0,0,0.2);
    }
</style>
</head>
<body>
    <div class="container">
        <h2 class="text-center mb-4">Thông tin nhân viên</h2>
        <hr>
        <div class="row">
            <div class="col-md-4">
                <img src="uploads/${staff.photo}" alt="Hình ảnh nhân viên" class="profile-image img-fluid rounded">
            </div>
            <div class="col-md-8">
                <ul class="list-unstyled">
                    <li><strong>Họ và tên:</strong> ${staff.fullname}</li>
                    <li><strong>Ngày sinh:</strong> ${staff.birthday}</li>
                    <li><strong>Giới tính:</strong> ${staff.gender ? "Nam" : "Nữ"}</li>
                    <li><strong>Quốc tịch:</strong> ${staff.country}</li>
                    <li><strong>TT hôn nhân:</strong> ${staff.married}</li>
                    <li><strong>Sở thích:</strong> ${hobbies}</li>
                    <li><strong>Ghi chú:</strong> ${staff.notes}</li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies (optional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-MV4f4pctF1J2YXdzDvZ8cCY7qHY4OgqjI8K5FJrZxgct4ym3/GD5qNqQKO6GdFsG" crossorigin="anonymous"></script>
</body>
</html>
