<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page new</title>
<link href="<c:url value="assets/style.css"/>" rel="stylesheet">
<link href="<c:url value="assets/all.css"/>" rel="stylesheet">

</head>
<body>
	<div class="container">
	
   			<nav>
                <ul>
                    <a href="/beststeals"><li>Glowne promocje</li></a>
                    <a href="/beststeals/all"><li>Wszystkie promocje</li></a>
                    <a href="xd"><li>Dolacz do Subskrybcji</li></a>
                    <a href="xd"><li>Inne</li></a>
                </ul>
            </nav>

            <div class="content">
            
            	<div class="filter">

                </div>

				<div class="products">

					<c:forEach items="${list}" var="item">
	               
	                    
	                    <div class="product">
	                        <h3>${item.getName()}</h3>
	                        <div class="down">
	                        <div class="left-side">
	                            <img src="${item.getImage()}">
	                            <div class="prices">
	                                <p class="new-price">${item.getNewPrice()}</p>
	                                <p class="old-price">${item.getOldPrice()}</p>
	                            </div>
	                        </div>
	                        <div class="right-side">
	                            <h2>${item.getSiteName()}</h2>
	                            <form target="_blank" action="${item.getSiteLink()}">
						   			<input class="link" type="submit" value="Przejdz do strony" />
								</form>
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