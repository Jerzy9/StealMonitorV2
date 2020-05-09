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
<meta name="viewport" content="width=device-width,initial-scale=1.0">

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
            
            <div class="behind-nav">
                
            </div>

            <div class="content">
            
            	<div class="side-div">
                    <div class="filter">
                        <form id="search">
                            <input type="text" placeholder="Szukaj">
                        </form>
                        <div class="details">
                            <div class="checkboxes">
                                <h3>Filtry</h3>
                                <div class="check">
                                    <input type="checkbox">
                                    <p>obniżka o 90%</p>
                                </div>
                                <div class="check">
                                    <input type="checkbox">
                                    <p>obniżka o 60%</p>
                                </div>
                                <div class="check">
                                    <input type="checkbox">
                                    <p>obniżka o 20%</p>
                                </div>
                                <div class="check">
                                    <input type="checkbox">
                                    <p>ostatnia godzina</p>
                                </div>
                                <div class="check">
                                    <input type="checkbox">
                                    <p>ostatnia minuta</p>
                                </div>
                            </div>
                            <div class="slider-section">
                                <h3>Przedział cenowy</h3>
                                <div class="slider">
                                </div>
                            </div>
                        </div>
                    </div>
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
					
					
				</div>
				
				<div class="side-div">
                    <img src="images/ad.png">   
                </div>
                <div id="up" class="up-key">
                    <i class="arrow up"></i>
                </div>

            </div>
            
    </div>
	
</body>
</html>