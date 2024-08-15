<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>LAB 7 - HƯỚNG DẪN BẢO MẬT BẰNG FILTER</title>
    <style>
    	label{font-weight: bold;}
    
    </style>
  </head>
  <body>
    
	<div>
		<div class="container mx-auto border border-danger p-2 m-1 bg-light text-dark" style="width: 600px">
			<div class="card-header bg-dark text-warning">
				<h5 class="text-center p-3 mb-2">Danh sách các bài LAB7 đã hoàn thành</h5>
			</div>	<br />
			<div class="form-inline mb-1">
				<label class="text-success" for="">Bài 1 :</label><span>Xây dựng bộ đếm khách đến tham Web</span>
				<form action="Bai1_Visitors_Servlet" class="ml-auto">
    			<input type="submit" value="Xem Bài 1" class="btn btn-primary"/>
				</form>
			</div>
			
			<div class="form-inline mb-1">
				<label class="text-success" for="">Bài 2 :</label><span>Lưu vết người sử dụng</span>
				<form action="Bai2_LoginServlet" class="ml-auto">
    			<input type="submit" value="Xem Bài 2" class="btn btn-primary"/>
				</form>
			</div>
			
			<div class="form-inline mb-1">
				<label class="text-success" for="">Bài 3+4 :</label><span>Xây dựng AppFilter phục vụ chung(Code phục vụ bài 5)</span>
				<form action="#" class="ml-auto">
    			<input type="submit" value="Xem Bài 3" class="btn btn-primary"/>
				</form>
			</div>
			
			<div class="form-inline mb-1">
				<label class="text-success" for="">Bài 5 :</label><span>Bảo mật Ứng dụng</span>
				<form action="Bai3_LoginServlet" class="ml-auto">
    			<input type="submit" value="Xem Bài 5" class="btn btn-primary"/>
				</form>
			</div>
			
		</div>
	</div>	
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>