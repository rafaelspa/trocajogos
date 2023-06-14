<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>TrocaJogos - Trocas</title>
  <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
  <!-- Font Awesome icons (free version)-->
  <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
  <!-- Google fonts-->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
  <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet"
    type="text/css" />
  <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="css/styles.css" rel="stylesheet" />
</head>

<body id="page-top">
  <tag:menu-superior></tag:menu-superior>
  
  <!-- jogos -->
  <section class="page-section bg-light" id="portfolio">
    <div class="container">
      <div>
        <form method="get" action="<c:url value="trocas"/>">
          <div class="row mb-5">
            <div class="col-md-6">
              <div class="form-group">
                <input name="filtro.nome" value="${filtro.nomeJogo}" class="form-control" id="email" type="text" placeholder="Pesquisar.."
                  data-validation-required-message="Jogo a ser consultado." />
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="col-md-3">
              <div class="form-group">
                <select name="filtro.categoria.id" class="form-control" id="email"
                  data-validation-required-message="Selecione a categoria">
                  	<option value="">(Todos)</option>
                   <c:forEach var="categoria" items="${categorias}">
                   	<option ${(filtro != null && filtro.categoria != null && categoria.id == filtro.categoria.id) ?"selected":""} value="${categoria.id}">${categoria.nome}</option>
                   </c:forEach>
                </select>
                <p class="help-block text-danger"></p>
              </div>
            </div>
            <div class="col-md-3">
              <div class="form-group mb-md-0">
                <button type="submit" class="btn btn-primary btn-xl text-uppercase js-scroll-trigger">Pesquisar</button>
              </div>
            </div>
          </div>
          <div class="row mb-2 ml-1">
            <button title="Editar" onclick="window.location.href='formtroca'" class="btn btn-success mb-3"  type="button">
                <i class="fas fa-plus mr 1"></i>
                Nova Troca
            </button>
          </div>
        </form>
      </div>
      <div class="row">
      	<c:forEach var="troca" items="${trocas}">
      	
      	<!-- Inicio Card-->
        <div class="col-lg-4 col-sm-6 mb-4">
          <div class="portfolio-item">
            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal${troca.id}">
              <div class="portfolio-hover">
                <div class="portfolio-hover-content">
                  <i class="fas fa-plus fa-3x"></i>
                </div>
              </div>
              <img class="img-fluid" src="img/get/${troca.imagem.nome}" alt="" />
            </a>
            <div class="portfolio-caption">
              <div class="portfolio-caption-heading">${troca.valorMoney}</div>
              <div class="portfolio-caption-subheading text-muted">
                ${troca.nomeJogo}
              </div>
            </div>
          </div>
        </div>
		<!-- Fim Card-->

        <!-- Modal 1-->
        <div class="portfolio-modal modal fade" id="portfolioModal${troca.id}" tabindex="-1" role="dialog" aria-hidden="true">
          <div class="modal-dialog mx-auto">
            <div class="modal-content">
              <div class="close-modal" data-dismiss="modal">
                <img src="assets/img/close-icon.svg" alt="Close modal" />
              </div>
              <div class="container">
                <div class="row justify-content-center">
                  <div class="col-lg-8">
                    <div class="modal-body">
                      <!-- Project Details Go Here-->
                      <img class="img-fluid d-block mx-auto img-modal" src="img/get/${troca.imagem.nome}" alt="" />
                      <h2 class="text-uppercase">${troca.valorMoney}</h2>
                      <p class="item-intro text-muted">
                        ${troca.nomeJogo}
                      </p>
                      <p>
                        ${troca.descricao}
                      </p>
                      <div class="d-flex justify-content-center">
                        <div class="form-group mb-md-0 ml-2">
                          <button class="btn btn-primary btn-xl text-uppercase js-scroll-trigger">Trocar</button>
                        </div>
                        <div class="form-group mb-md-0 ml-2">
                          <button class="btn btn-info btn-xl text-uppercase js-scroll-trigger" onclick="window.location.href='formtroca?troca.id=${troca.id}'" >Editar</button>
                        </div>
                        <div class="form-group mb-md-0 ml-2">
                          <button class="btn btn-danger btn-info btn-xl text-uppercase js-scroll-trigger" onclick="window.location.href='deletatroca/${troca.id}'" >Remover</button>
                        </div>
                      </div>
                      
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
		<!-- Fim do Modal -->
		
       </c:forEach>
      </div>
      <p>Total de Trocas: ${totalTrocas > 0 ? totalTrocas : 0}</p>
    </div>
  </section>

  <!-- Bootstrap core JS-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Third party plugin JS-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
  <!-- Contact form JS-->
  <script src="assets/mail/jqBootstrapValidation.js"></script>
  <script src="assets/mail/contact_me.js"></script>
  <!-- Core theme JS-->
  <script src="js/scripts.js"></script>
  <script></script>
</body>

</html>