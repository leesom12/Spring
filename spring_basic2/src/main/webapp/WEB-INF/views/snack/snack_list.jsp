<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 홍길동
	******************************************** 
 -->	
	<title>TRACK11 이소민</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
</head>

<script type="text/javascript">
	function goWrite(){
		snack.t_gubun.value="writeForm";
		snack.method="post";
		snack.action="Snack";
		snack.submit();
	}
	
	function goSearch(){
		searchForm.method="post";
		searchForm.action="Snack";
		searchForm.submit();
	}
	
	function goView(p_code){
		snack.t_p_code.value= p_code;
		snack.t_gubun.value="view";
		snack.method="post";
		snack.action="Snack";
		snack.submit();
	}
</script>

<body>
<form name="snack">
	<input type="hidden" name="t_gubun">
	<input type="hidden" name="t_p_code">
</form>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 이소민 SNACK</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span>${t_arr.size()}</span>건</p>
			</div>
			<form name="searchForm">
			<div class="search_group">
				<select class="select" name="t_select">
					<option value="h.p_name">제품명</option>
					<option value="c.m_name" <c:if test="${t_select eq 'c.m_name'}">selected</c:if>>제조사명</option>
				</select>
				<input type="text" class="search_word" name="t_search" value="${t_search}">
				<button class="btn_search" onclick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>
			</form>
		</div>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<thead>
				<tr>
					<th>제품번호</th>
					<th>제품명</th>
					<th>제조사명</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${t_arr}" var="arr">
					<tr>
						<td><a href="javascript:goView('${arr.getP_code()}')">${arr.getP_code()}</a></td>
						<td><a href="javascript:goView('${arr.getP_code()}')">${arr.getP_name()}</a></td>
						<td>${arr.getM_name()}</td>
						<td>${arr.getStrPrice()}</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		<div class="paging">
			<a href="javascript:goWrite()" class="write">제품등록</a>
		</div>
	</div>
 </body>
</html>







