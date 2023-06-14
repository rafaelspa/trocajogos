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
        <title>TrocaJogos - Form Troca</title>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <link href="css/glyphicon.css" media="all" rel="stylesheet" type="text/css"/>
        <link href="css/fileinput.min.css" media="all" rel="stylesheet" type="text/css"/>
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <tag:menu-superior></tag:menu-superior>
        
        <header class="masthead" id="login">
            <div class="container"></div>
        </header>
        
        <section class="page-section" id="formtroca">
            <div class="container">
                <div class="text-center">
		         <c:if test="${troca != null && troca.getId() > 0}">
                	<h2 class="section-heading text-uppercase">Editar Troca</h2>
                </c:if>
                <c:if test="${troca == null || troca.getId() < 1}">
                	<h2 class="section-heading text-uppercase">Nova Troca</h2>
                </c:if>      
                    
                </div>
                
                <c:if test="${not empty errors}">
                	<div class="alert alert-danger" role="alert">
                  	<c:forEach var="error" items="${errors}">
                     ${error.message}<br/>
                  	</c:forEach>
                	</div>
              	</c:if>
              		
                <form method="post" action="<c:url value="formtroca/salvaTroca"/>" enctype="multipart/form-data"  >
					<input type="hidden" name="troca.id" value="${troca.id}" >
                    <input type="hidden" name="troca.ativo" value="${troca.isAtivo()}">
                    <div class="row justify-content-md-center mb-5 text-center">
                        <div class="col-md-12 align-self-center text-center">
                            <div class="form-group input-login mx-auto">
                                <input name="troca.imagem.file" id="input-id" type="file" class="file" data-preview-file-type="file" required="required">
                                 <p class="help-block text-danger"></p>
                             </div>
                            <div class="form-group input-login mx-auto">
                                <input name="troca.nomeJogo" value="${troca.getNomeJogo()}" class="form-control" id="email" type="text" placeholder="Nome *" required="required" data-validation-required-message="Digite o Nome do Jogo." />
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group input-login mx-auto">
                                <input name="troca.valor" value="${troca.valor}" class="form-control money" id="valor" type="tel" placeholder="Valor em R$*" required="required" data-validation-required-message="Digite o Valor do Jogo." />                            
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group input-login mx-auto">
                               
                               <textarea name="troca.descricao" class="form-control" placeholder="Descreva o Jogo">${troca.descricao}</textarea>
                               
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group">
                                <select name="troca.categoria.id" class="form-control input-login mx-auto" required="required"
                                  data-validation-required-message="Categoria do jogo.">
                                  
                                  <c:forEach var="categoria" items="${categorias}">
                                  	<option value="${categoria.id}">${categoria.nome}</option>
                                  </c:forEach>
                                  
                                </select>
                                
                                <p class="help-block text-danger"></p>
                            </div>
                            <div class="form-group input-login mx-auto">
                                <input name="troca.dataValidadeEn" value="${troca.dataValidade}" class="form-control date-br" id="valor" type="date" placeholder="Data Validade *"  data-validation-required-message="Digite a data de Validade da Troca" required="required" />
                                <p class="help-block text-danger"></p>
                            </div>
                           
                            <button type="submit" class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" >Salvar</button>
                        </div> 
                    </div>
                </form>
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
        
        <script src="js/jquery.mask.min.js"></script>
        <script src="js/fileinput/fileinput.min.js" type="text/javascript"></script>
        <script src="js/add-mask.js"></script>
        <script>

        </script>
    </body>
</html>
