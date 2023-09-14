<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
	
	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="javascript:goPage('login')">LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="javascript:goPage('join')"><span class="fnt"><i class="fas fa-apple-alt"></i></span> CONTACK</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER MyInfo
			</p>
			<form name="mem">
			<input type="hidden" name="t_gubun">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>${t_dto.getId()}</td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td>${t_dto.getName() }</td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td>
				  	<c:forEach begin="1" end="${t_dto.getPass_len() }">*</c:forEach>
				  </td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>${t_dto.getArea() }</td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td>${t_dto.getAddress() }</td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>${t_dto.getMobile_1() }-${t_dto.getMobile_2() }-${t_dto.getMobile_3()}</td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					 <c:if test="${t_dto.getGender() eq 'M'}">남성</c:if>
					 <c:if test="${t_dto.getGender() eq 'F'}">여성</c:if>
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input disabled <c:if test="${t_dto.getTravel() eq 'Y'}">checked</c:if> type="checkbox" value="Y" name="t_hobby_travel" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input disabled <c:if test="${t_dto.getReading() eq 'Y'}">checked</c:if> type="checkbox" value="Y" name="t_hobby_reading" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input disabled <c:if test="${t_dto.getSports() eq 'Y'}">checked</c:if> type="checkbox" value="Y" name="t_hobby_sports" class="middleCheck" /> 운동
				  </td>
				</tr>
				<tr>
				  <th>회원가입일</th>
				  <td>${t_dto.getReg_date() }</td>
				</tr>
				<tr>
				  <th>정보수정일</th>
				  <td>${t_dto.getUpdate_date() }</td>
				</tr>
				<tr>
				  <th>최근접속일</th>
				  <td>${t_dto.getLogin_time() }</td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:goJoin()" class="butt">정보수정</a>
				<a href="javascript:goJoin()" class="butt">비밀번호변경</a>
				<a href="javascript:goJoin()" class="butt">회원탈퇴</a>
			</div>	
		</div>	

<%@ include file = "../common_footer.jsp" %>

	</div>	
</body>
</html>






