<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome in our contact manager</title>
</head>
<body>

	<!-- creer un input avec creer user -->

	<form action="creationUser">
		<input type="text" name="newUser" value="Entrez un user" /><input
			type="submit" value="créer un user" />
	</form>
	<!-- liste des users avec bouton de connexion -->


	<c:if test="${gestionnaire != null}">
		<ul>
			<c:forEach items="${gestionnaire.users }" var="user">
				<li>
					<h3>
						<c:out value="${user}" />
					</h3> <c:url var="connexion" value="connexion">
						<c:param name="name" value="${user.name}" />
						<!-- à remplacer par l'id pour la connexion plutôt que le name -->
					</c:url> <a href="${connexion}">Se connecter</a>

				</li>
			</c:forEach>
		</ul>
	</c:if>

</body>
</html>
