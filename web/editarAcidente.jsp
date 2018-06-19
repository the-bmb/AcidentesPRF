<%@include file="/header.jsp" %>
<div class="mensagme text-center col-md-15">
    <c:if test="${flag eq true}">
        <p class="bg-success" style="color:green">Acidente alterado com sucesso</p>
        <%
            session.setAttribute("flag", null);
        %>
    </c:if>
    <c:if test="${flag eq false}">
        <p class="bg-danger" style="color:red">Todos os campos s�o obrigat�rios</p>
        <%
            session.setAttribute("flag", null);
        %>
    </c:if>
</div>
<div class="col-md-15 col-md-offset-0">
    <form class="form-horizontal"method="POST" action="/AcidentesPRF/EditarAcidente">
        <input type="hidden" name="id" value="${acidente.id}">
        <div class="panel panel-primary">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">N�meros do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Mortos</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="mortos" value="${acidente.mortos}" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Feridos Leves</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="feridos_leves" value="${acidente.feridosLeves}" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Feridos Graves</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="feridos_graves" value="${acidente.feridosGraves}" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Ilesos</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="ilesos" value="${acidente.ilesos}" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Ignorados</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="ignorados" value="${acidente.ignorados}" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Ve�culos Envolvidos</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="veiculos" value="${acidente.veiculos}" required="required">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Data do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Data</label>
                        <div class="col-md-8">
                            <input type="date" class="form-control" name="data" value="${acidente.data.dataAcidente}" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Dia da Semana</label>
                        <div class="col-md-8">
                            <select class="form-control" name="semana">
                                <option value="${acidente.data.diaSemana}">${acidente.data.diaSemana}</option> 
                                <option value="Domingo">Domingo</option>
                                <option value="Segunda">Segunda</option>
                                <option value="Ter�a">Ter�a</option>
                                <option value="Quarta">Quarta</option>
                                <option value="Quinta">Quinta</option>
                                <option value="Sexta">Sexta</option>
                                <option value="S�bado">S�bado</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Hor�rio</label>
                        <div class="col-md-8">
                            <select class="form-control" name="horario"> 
                                <option value="${acidente.data.horario}">Entre ${acidente.data.horario}:00 e ${acidente.data.horario}:59</option>
                                <option value="0">Entre 00:00 e 00:59</option>
                                <option value="1">Entre 01:00 e 01:59</option>
                                <option value="2">Entre 02:00 e 02:59</option>
                                <option value="3">Entre 03:00 e 03:59</option>
                                <option value="4">Entre 04:00 e 04:59</option>
                                <option value="5">Entre 05:00 e 05:59</option>
                                <option value="6">Entre 06:00 e 06:59</option>
                                <option value="7">Entre 07:00 e 07:59</option>
                                <option value="8">Entre 08:00 e 08:59</option>
                                <option value="9">Entre 09:00 e 09:59</option>
                                <option value="10">Entre 10:00 e 10:59</option>
                                <option value="11">Entre 11:00 e 11:59</option>
                                <option value="12">Entre 12:00 e 12:59</option>
                                <option value="13">Entre 13:00 e 13:59</option>
                                <option value="14">Entre 14:00 e 14:59</option>
                                <option value="15">Entre 15:00 e 15:59</option>
                                <option value="16">Entre 16:00 e 16:59</option>
                                <option value="17">Entre 17:00 e 17:59</option>
                                <option value="18">Entre 18:00 e 18:59</option>
                                <option value="19">Entre 19:00 e 19:59</option>
                                <option value="20">Entre 20:00 e 20:59</option>
                                <option value="21">Entre 21:00 e 21:59</option>
                                <option value="22">Entre 22:00 e 22:59</option>
                                <option value="23">Entre 23:00 e 23:59</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Local do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Estado</label>
                        <div class="col-md-8">
                            <select class="form-control" name="estado"> 
                                <option value="${acidente.local.uf}">${acidente.local.uf}</option> 
                                <option value="AC">Acre</option> 
                                <option value="AL">Alagoas</option> 
                                <option value="AM">Amazonas</option> 
                                <option value="AP">Amap�</option> 
                                <option value="BA">Bahia</option> 
                                <option value="CE">Cear�</option> 
                                <option value="DF">Distrito Federal</option> 
                                <option value="ES">Esp�rito Santo</option> 
                                <option value="GO">Goi�s</option> 
                                <option value="MA">Maranh�o</option> 
                                <option value="MT">Mato Grosso</option> 
                                <option value="MS">Mato Grosso do Sul</option> 
                                <option value="MG">Minas Gerais</option> 
                                <option value="PA">Par�</option> 
                                <option value="PB">Para�ba</option> 
                                <option value="PR">Paran�</option> 
                                <option value="PE">Pernambuco</option> 
                                <option value="PI">Piau�</option> 
                                <option value="RJ">Rio de Janeiro</option> 
                                <option value="RN">Rio Grande do Norte</option> 
                                <option value="RO">Rond�nia</option> 
                                <option value="RS">Rio Grande do Sul</option> 
                                <option value="RR">Roraima</option> 
                                <option value="SC">Santa Catarina</option> 
                                <option value="SE">Sergipe</option> 
                                <option value="SP">S�o Paulo</option> 
                                <option value="TO">Tocantins</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Munic�pio</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="municipio" value="${acidente.local.municipio}" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Rodovia</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="br" value="${acidente.local.br}" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Km</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="km" value="${acidente.local.km}" required="required">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Condi��es do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Causa</label>
                        <div class="col-md-8">
                            <select class="form-control" name="causa">
                                <option value="${acidente.condicao.causaAcidente}">${acidente.condicao.causaAcidente}</option>
                                <option value="Animais na Pista">Animais na Pista</option>
                                <option value="Defeito mec�nico em ve�culo">Defeito mec�nico em ve�culo</option>
                                <option value="Defeito na via">Defeito na via</option>
                                <option value="Desobedi�ncia � sinaliza��o">Desobedi�ncia � sinaliza��o</option>
                                <option value="Dormindo">Dormindo</option>
                                <option value="Falta de aten��o">Falta de aten��o</option>
                                <option value="Ingest�o de �lcool">Ingest�o de �lcool</option>
                                <option value="N�o guardar dist�ncia de seguran�a">N�o guardar dist�ncia de seguran�a</option>
                                <option value="Ultrapassagem indevida">Ultrapassagem indevida</option>
                                <option value="Velocidade incompat�vel">Velocidade incompat�vel</option>
                                <option value="Outras">Outras</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Tipo de Acidente</label>
                        <div class="col-md-8">
                            <select class="form-control" name="tipo_acidente">
                                <option value="${acidente.condicao.tipoAcidente}">${acidente.condicao.tipoAcidente}</option>
                                <option value="Atropelamento de animal">Atropelamento de animal</option>
                                <option value="Atropelamento de pessoa">Atropelamento de pessoa</option>
                                <option value="Capotamento">Capotamento</option>
                                <option value="Colis�o com bicicleta">Colis�o com bicicleta</option>
                                <option value="Colis�o com objeto fixo">Colis�o com objeto fixo</option>
                                <option value="Colis�o com objeto m�vel">Colis�o com objeto m�vel</option>
                                <option value="Colis�o frontal">Colis�o frontal</option>
                                <option value="Colis�o lateral">Colis�o lateral</option>
                                <option value="Colis�o Transversal">Colis�o Transversal</option>
                                <option value="Colis�o traseira">Colis�o traseira</option>
                                <option value="Danos Eventuais">Danos Eventuais</option>
                                <option value="Derramamento de Carga">Derramamento de Carga</option>
                                <option value="Inc�ndio">Inc�ndio</option>
                                <option value="Queda de motocicleta / bicicleta / ve�culo">Queda de motocicleta / bicicleta / ve�culo</option>
                                <option value="Sa�da de Pista">Sa�da de Pista</option>
                                <option value="Tombamento">Tombamento</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Classifica��o</label>
                        <div class="col-md-8">
                            <select class="form-control" name="classificacao">
                                <option value="${acidente.condicao.classificacaoAcidente}">${acidente.condicao.classificacaoAcidente}</option>
                                <option value="Com V�timas Fatais">Com V�timas Fatais</option>
                                <option value="Com V�timas Feridas">Com V�timas Feridas</option>
                                <option value="Ignorado">Ignorado</option>
                                <option value="Sem V�timas">Sem V�timas</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Fase do Dia</label>
                        <div class="col-md-8">
                            <select class="form-control" name="fase">
                                <option value="${acidente.condicao.faseDia}">${acidente.condicao.faseDia}</option>
                                <option value="Amanhecer">Amanhecer</option>
                                <option value="Anoitecer">Anoitecer</option>
                                <option value="Plena noite">Plena noite</option>
                                <option value="Pleno dia">Pleno dia</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Sentido da Via</label>
                        <div class="col-md-8">
                            <select class="form-control" name="sentido">
                                <option value="${acidente.condicao.sentidoVia}">${acidente.condicao.sentidoVia}</option>
                                <option value="Crescente">Crescente</option>
                                <option value="Decrescente">Decrescente</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Cond. Meteorol�gicas</label>
                        <div class="col-md-8">
                            <select class="form-control" name="cond_metereologica">
                                <option value="${acidente.condicao.condMetereologica}">${acidente.condicao.condMetereologica}</option>
                                <option value="Ceu Claro">Ceu Claro</option>
                                <option value="Chuva">Chuva</option>
                                <option value="Granizo">Granizo</option>
                                <option value="Ignorada">Ignorada</option>
                                <option value="Neve">Neve</option>
                                <option value="Nevoeiro/neblina">Nevoeiro/neblina</option>
                                <option value="Nublado">Nublado</option>
                                <option value="Sol">Sol</option>
                                <option value="Vento">Vento</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Tipo de Pista</label>
                        <div class="col-md-8">
                            <select class="form-control" name="tipo_pista">
                                <option value="${acidente.condicao.tipoPista}">${acidente.condicao.tipoPista}</option>
                                <option value="Dupla">Dupla</option>
                                <option value="M�ltipla">M�ltipla</option>
                                <option value="Simples">Simples</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Tra�ado da Via</label>
                        <div class="col-md-8">
                            <select class="form-control" name="tracado">
                                <option value="${acidente.condicao.tracadoVia}">${acidente.condicao.tracadoVia}</option>
                                <option value="Cruzamento">Cruzamento</option>
                                <option value="Curva">Curva</option>
                                <option value="Reta">Reta</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Uso do Solo</label>
                        <div class="col-md-8">
                            <select class="form-control" name="uso_solo">
                                <option value="${acidente.condicao.usoSolo}">${acidente.condicao.usoSolo}</option>
                                <option value="Rural">Per�metro Rural</option>
                                <option value="Urbano">Per�metro Urbano</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-8 col-md-offset-3">
                    <p class="text-danger">Todos os campos s�o de preenchimento obrigat�rio</p>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-4 col-md-offset-5">
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> Salvar</button>
                </div>
            </div>
        </div>
    </form>
</div>
</div>
<%@include file="/footer.jsp" %>
