<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 이소민</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goUpdate(){
			mem.method="post";
			mem.action="Member";
			mem.submit();
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 이소민 회원관리</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<form name="mem">
				<input type="hidden" name="t_gubun" value="update">
				<input type="hidden" name="t_id" value="${t_dto.getId()}">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					
					<tbody>
						<tr>
							<th>ID</th>
							<td class="th_left">
								${t_dto.getId()}
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input name="t_name" value="${t_dto.getName()}" class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>나이</th>
							<td class="th_left">
								<input name="t_age" value="${t_dto.getAge()}" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td class="th_left">
								<input name="t_reg_date" value="${t_dto.getReg_date()}" class="input_200px" type="date">							
							</td>
						</tr>
					</tbody>
				</table>
				</form>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='memberList'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>



















