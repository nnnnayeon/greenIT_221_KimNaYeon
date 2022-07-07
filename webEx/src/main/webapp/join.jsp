<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>NAVER</h1>

    <form method="get">
        <ul>
            <div class="ID">
                <p>아이디</p>
                <input type="text" name="username" required> @naver.com
            </div>

            <div class="PW">
                <p>비밀번호</p>
                <input type="password" name="password" required>
            </div>

            <div class="PWR">
                <p>비밀번호 재확인</p>
                <input type="password" name="password" required>
            </div>

            <div class="NAME">
                <p>이름</p>
                <input type="text" name="name" required>
            </div>

            <div class="BIRTH">
                <p>생년월일</p>
                <input type="number" name="year" placeholder="년(4자)" required>
                <select name="month" required>
                    <option value="0">월</option>
                    <option value="1">1</option>
                    <option value="1">2</option>
                    <option value="1">3</option>
                    <option value="1">4</option>
                    <option value="1">5</option>
                    <option value="1">6</option>
                    <option value="1">7</option>
                    <option value="1">8</option>
                    <option value="1">9</option>
                    <option value="1">10</option>
                    <option value="1">11</option>
                    <option value="1">12</option>
                </select>
                <input type="number" min="1" max="31" name="day" placeholder="일" required>
            </div>

            <div class="Gender">
                <p>성별</p>
                <select name="gender" required>
                    <option value="1">성별</option>
                    <option value="2">남자</option>
                    <option value="3">여자</option>
                    <option value="4">선택 안함</option>
                </select>
            </div>

            <div class="EMAIL">
                <p>본인 확인 이메일</p>
                <input type="email" placeholder="선택입력" name="Email">
            </div>

            <div class="Mobile Phone">
                <p>휴대전화</p>
                <select name="nation">
                    <option value="82+">대한민국 +82</option>
                    <option value="49+">독일 +49</option>
                    <option value="1+">미국/캐나다 +1</option>
                </select><br>
                <input type="text" name="mobile phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="전화번호 입력" required>
                <button onclick="alert('인증번호')">인증번호 받기</button><br>
                <input type="text" name="number" pattern="[0-9]{3}" placeholder="인증번호 입력하세요" required>
            </div>
        </ul>

        <input type="submit">
    </form>
</body>
</html>