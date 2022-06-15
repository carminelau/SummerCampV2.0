<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,model.entity.Centro, model.entity.Bambino, model.entity.Settimana, control.gestioneIscrizione.VisualizzaIscrizioniControl"
	pageEncoding="UTF-8"%>

<%
	List<Centro> centri = (List<Centro>) request.getAttribute("centri");
	
%>

<%@include file="./assets/includes/header.jsp" %>
<link rel="stylesheet" href="./assets/css/order_list.css">

  </head>

  <body>

    <div class="container">

      <p class="text-left font-weight-bold">I nostri Centri Estivi</p>

	<% if(centri != null) { %>
      <div class="row">
        <div class="col-lg-12">
          <div class="table-responsive-sm">
          <table class="table table-hover">
            <thead class="thead-dark">
              <tr>
                <th scope="col">Denominazione</th>
                <th scope="col">Indirizzo</th>
                <th scope="col">Comune (Provincia)</th>
                <th scope="col">Capienza Settimanale</th>
                <th scope="col">Cancellato</th>
                <th scope="col">Visualizza Iscrizioni</th>
              </tr>
            </thead>
            <tbody>
            <%
            int i=1;
            for(Centro ce: centri) { %>
              <tr>
                <th scope="row"><%= ce.getDenominazione() %></th>
                <td><%= ce.getIndirizzo()%></td>
                
                <td>
                	<%= ce.getComune() + "( " + ce.getProvincia() +" )"%>
                </td>
                <td>
					<%= ce.getCapienzaTot() %>
				</td>
                <td><%if(ce.isCancellato()){ %>
                	Si
                	<%} else {%>
                	No
                	<%}%>
               </td>
                                
                <td>
                	<a href="${pageContext.request.contextPath}/list_iscrizioni?action=centri&centro=<%=ce.getIdCentro()%>">
                  <svg width="2em" height="3em" viewBox="0 0 16 16" class="bi bi-file-earmark-text" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path d="M4 1h5v1H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V6h1v7a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2z"/>
                    <path d="M9 4.5V1l5 5h-3.5A1.5 1.5 0 0 1 9 4.5z"/>
                    <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                  </svg>
                  </a>
                </td>
              </tr>
              <% i=i+1; } %>
            </tbody>
          </table>
        </div>
        </div>
    </div>
    <% } %>
   </div>

<%@include file="./assets/includes/footer.jsp" %>

  </body>
</html>
