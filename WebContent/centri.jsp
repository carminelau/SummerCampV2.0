<%@ page language="java" import="java.util.*,main.model.entity.Utente, main.model.entity.Bambino, main.model.entity.Settimana, main.model.entity.Centro, main.model.entity.CentroSettimana" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String error = (String) request.getAttribute("errorMessage");

%>
<%@include file="./assets/includes/header.jsp" %>


<div class="container" style="position: relative">

		<%if(error != null) { %>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
			  <strong><%=error %></strong>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
		<%} %> 

    	<form id="form_centro" class="form-register" action="centri" method="post" data-toggle="validator" role="form" enctype="multipart/form-data" novalidate>

    	  <div class="text-center mb-4">
    	    <img class="mb-4" src="assets/images/Logo_SummerCamp.png" alt="American Delights" width="250" height="200">
    	    <h1 class="h3 mb-3 font-weight-normal">Inserimento del nuovo Centro</h1>
    	  
    	  
    	  
    <div class="dati anagrafici">

    	  <div class="form-label">
    	  	<label for="nome">Nome Centro</label>
    	    <input type="text" id="nome" name="nome" class="form-control" placeholder="Nome Centro" required autofocus>
    	    <div id="invalidNome" class="invalid-tooltip"></div>
    	  </div>
    	  
    	  <div class="form-label">
    	  	<label for="comune">Comune</label>
    	    <input type="text" id="indirizzo" name="comune" class="form-control" placeholder="Comune" required autofocus>
    	    <div id="invalidCognome" class="invalid-tooltip"></div>
    	  </div>
    	  
    	  <div class="form-label">
    	  	<label for="provincia">Provincia</label>
    	    <input type="text" id="indirizzo" name="provincia" class="form-control" placeholder="Provincia" required autofocus>
    	    <div id="invalidCognome" class="invalid-tooltip"></div>
    	  </div>

    	  <div class="form-label">
    	  	<label for="indirizzo">Indirizzo</label>
    	    <input type="text" id="indirizzo" name="indirizzo" class="form-control" placeholder="Indirizzo" required autofocus>
    	    <div id="invalidCognome" class="invalid-tooltip"></div>
    	  </div>

    	  <div class="form-label">
    	  	<label for="capienza">Capienza Settimanale</label>
    	    <input type="number" id="capienza" name="capienza" class="form-control" min="1" max="150" required autofocus>
    	  </div>
         </div>
          	

      <div class="BUTTON">
    	  <button class="btn btn-lg btn-primary btn-block center" type="submit">Inserisci il nuovo centro</button>
        <p class="mt-5 mb-3 text-muted text-center">&copy; 2020-2021</p>

      </div>
    </form>

  </div>
  
	<%@include file="./assets/includes/footer.jsp" %>
	<script src="./assets/js/iscrizione.js"></script>
	</body>
</html>