<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page new</title>
<link href="<c:url value="/resources/css/all.css"/>" rel="stylesheet">

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
            
            	<div class="filter">

                </div>

				<div class="products">

					<c:forEach items="${list}" var="item">
	               
	               		<div class="products">
	                    
	                    <div class="product">
	                        <h3>Apple MacBook Air i5/8GB/128/UHD 617/Mac OS Space Gray</h3>
	                        <div class="down">
	                        <div class="left-side">
	                            <img src="images/macbook.png">
	                            <div class="prices">
	                                <p class="new-price">4 599,00 zł</p>
	                                <p class="old-price">5099,00 zł</p>
	                            </div>
	                        </div>
	                        <div class="right-side">
	                            <h2>x-kom</h2>
	                            <button class="link">Przejdź do strony</button>
	                        </div>
	                        </div>
	                    </div>
	      
					</c:forEach>
					
					<div class="advertisement">

                	</div>
					
				</div>

            </div>
            
    </div>
	
</body>
</html>