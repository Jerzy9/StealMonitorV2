<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page new</title>
<link href="<c:url value="assets/style.css"/>" rel="stylesheet">

<!-- Przy tej konfiguracji to na dole tez dziala, niech tu bedzie narazie jakby sie cos zepsulo -->
<%-- <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" > --%>

</head>
<body>
	<div class="container">
	
   			<nav>
                <ul>
                    <a href="/"><li>Glowne promocje</li></a>
                    <a href="/all"><li>Wszystkie promocje</li></a>
                    <a href="xd"><li>Dolacz do Subskrybcji</li></a>
                    <a href="xd"><li>Inne</li></a>
                </ul>
            </nav>

            <div class="content">

				<c:forEach items="${list}" var="item">
                <div class="steal">
                    <div class="left-side">
                        <h3>${item.getName()}</h3>
                        <img src="${item.getImage()}">
                        <div class="prices">
                            <p class="new-price">${item.getNewPrice()}</p>
                            <p class="old-price">${item.getOldPrice()}</p>
                        </div>
                    </div>
                    <div class="right-side">
                        <h2>${item.getSiteName()}</h2>
                        <div class="time">
                            <h3>Do końca oferty pozostalo</h3>
                            <div class="time-cons">
                                <div class="time-con"> 
                                    <p class="time-text">godzin</p>
                                    <div class="time-box">
                                        <p class="time-box-number" id="hours">00</p>
                                    </div>
                                </div>
                                <div class="time-con"> 
                                    <p class="time-text">minut</p>
                                    <div class="time-box">
                                        <p class="time-box-number" id="minutes">00</p>        
                                    </div>
                                </div>
                                <div class="time-con"> 
                                    <p class="time-text">sekund</p>
                                    <div class="time-box">
                                        <p class="time-box-number" id="seconds">00</p>    
                                    </div>
                                </div>
                            </div>
                        </div>
						<form target="_blank" action="${item.getSiteLink()}">
						    <input class="link" type="submit" value="Przejdz do strony" />
						</form>
                        <div class ="counter">
                            <p>pozostało ${item.getRemainingQuantity()} sztuk</p>
                        </div>
                    </div>   
                </div>
				</c:forEach>

            </div>
            
    </div>
	
</body>
</html>