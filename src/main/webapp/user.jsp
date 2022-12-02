<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue <c:out value="${user.name}" /></title>
</head>
<body>

	<form action="contactmanager">
		<input type="text" value="Entrez un nom" name="name" /> <input
			type="text" value="Entrez un tél" name="tel" /> <input type="submit"
			name="ajout" value="Ajouter un contact" /> <input type="submit"
			name="recherche" value="Rechercher un tél" />
	</form>

	<c:if test="${retour != null}">
		<p>
			<c:out value="${retour}" />
		</p>
	</c:if>

	<c:if test="${contacts != null}">
		<ul>
			<c:forEach items="${contacts.contacts}" var="contact">
			
				<c:choose>
					<c:when test="${modifying == contact.tel}">
						<li>
							<form action="contactmanager">
								<input type="text" value="${contact.nom}" name="nom" /> <input
									type="text" value="${contact.tel}" name="tel" /> <input
									type="text" hidden="true" value="${contact.tel}" name="modifying" />
								<input type="submit" name="modification" value="modifier" />
							</form>
						</li>
					</c:when>
					<c:otherwise>
						<li><c:out value="${contact.nom}" /> <c:out value="${contact.tel}" /> <c:url var="supprimer"
								value="contactmanager">
								<c:param name="tel" value="${contact.tel}" />
								<c:param name="suppression" value="" />
							</c:url> <a href="${supprimer}">Supprimer</a> <c:url var="modifier"
								value="contactmanager">
								<c:param name="tel" value="${contact.tel}" />
								<c:param name="modification" value="" />
							</c:url> <a href="${modifier}">Modifier</a></li>
					</c:otherwise>
				</c:choose>

			</c:forEach>
		</ul>
	</c:if>

	<a href="accueil">Retour</a>

</body>
</html>