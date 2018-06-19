<%@include file="/header.jsp" %>
<div class="mensagme text-center col-md-15">
    <c:if test="${flag eq true}">
        <p class="bg-success" style="color:green">Usu�rio alterado com sucesso</p>
        <%
            session.setAttribute("flag", null);
        %>
    </c:if>
    <c:if test="${flag eq false}">
        <p class="bg-danger" style="color:red">Ocorreu algo de errado</p>
        <%
            session.setAttribute("flag", null);
        %>
    </c:if>
</div>
<div class="col-md-15 col-md-offset-0">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Dados do Usu�rio</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" method="POST" action="/AcidentesPRF/EditarUsuario">
                <div class="form-group">
                    <label class="col-md-2 control-label">Nome</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="nome" value="${user.nome}" required="required">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Codigo</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="codigo" value="${user.codigo}" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Fun��o</label>
                    <div class="col-md-9">
                        <select class="form-control" name="funcao"> 
                            <option value="${user.funcao}">${user.funcao}</option>
                            <option value="Administrador">Administrador</option> 
                            <option value="Coordenador de Controle Operacional">Coordenador(a) de Controle Operacional</option> 
                            <option value="Planejador Operacional">Planejador(a) Operacional</option> 
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Senha</label>
                    <div class="col-md-9">
                        <input type="password" class="form-control" name="senha" value="${user.senha}" required="required">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-8 col-md-offset-3">
                        <p class="text-danger">Todos os campos s�o de preenchimento obrigat�rio</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 col-md-offset-8">
                        <button type="submit" class="btn btn-default">
                            <span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> Salvar
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="/footer.jsp" %>
