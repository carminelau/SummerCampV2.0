<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,main.model.entity.Iscrizione, main.model.entity.Bambino, main.model.entity.Settimana, main.control.gestioneIscrizione.SingolaIscrizioneControl, main.model.entity.Centro"
	pageEncoding="UTF-8"%>

<%
	Iscrizione iscrizione = (Iscrizione) request.getAttribute("iscrizione");
	
	Centro centroid = iscrizione.getCentro();
%>

<%@include file="./assets/includes/header.jsp" %>

<link rel="stylesheet" href="./assets/css/dettagliIscrizione.css">

</head>
  <body>

    <div class="container">
    <%if(iscrizione!=null) {%>

      <!-- Dettagli dell'ordine -->
        <div class="row">
          <div class="col-lg-12">

            <div class="card text-center">
              <div class="card-header">
                <h2> Iscrizione </h2>
              </div>
              <div class="card-body">

                <div class="row">

                  <div class="col-md-6 text-left">
                    <p class="text-left font-weight-bold">Dati anagrafici</p>
                    <span>Nominativo: 
                    	<%Bambino b = iscrizione.getBambino();%>
                    	<b><%=b.getNome()+" "+b.getCognome()%></b></span><br>
                    <span>Codice fiscale: <b><%= b.getCodiceFiscale() %></b></span><br>	
                    <span>Data di nascita: <b><%= b.getDataNascita() %></b></span><br>
                    <span>Luogo di nascita: <b><%= b.getLuogoNascita() %></b></span><br>
					<span>Genere: <b><%= b.getGenere() %></b></span><br>
					<span>Taglia indumenti: <b><%= b.getTagliaIndumenti() %></b></span><br>                    

                  </div>

                  <div class="col-md-6 text-left">
                    <p class="text-left font-weight-bold">Settimana/e iscrizione</p>
                   
                    <span>Periodo: 
                    <%List<Settimana> sett = iscrizione.getSettimane();
                    	for(Settimana s: sett){%>
                    	<br>
                    	 Dal: <b><%=s.getDataInizio()%></b><br>
                    	 Al: 	<b><%=s.getDataFine()%> </b><br>
                		<%}%>
                    	
                    </span><br>
                    <span>Tipo soggiorno: <b><%= iscrizione.getTipoSoggiorno() %></b></span><br>
                    
                    <span>Centro scelto: <b><%= centroid.getDenominazione()%></b></span><br>
                    
                  </div>

                  </div>

                </div>
              </div>
              <div class="card-footer text-center">
                    <span>Prezzo totale: <b><%= iscrizione.getPrezzo()%>€</b></span>
              </div>
            </div>

          </div>
          <%}%>
        </div>
        
<%@include file="./assets/includes/footer.jsp" %>

  </body>
</html>