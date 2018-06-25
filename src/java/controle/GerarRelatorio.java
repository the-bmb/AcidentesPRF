package controle;

import com.keypoint.PngEncoder;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento1.Data;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GerarRelatorio extends HttpServlet {

    private CondicaoDAO cDao;
    private ArrayList<Data> datas;
    private DataDAO dDao;
    private int dia;
    private int mes;
    private int ano;
    private String[] aux;
    private String data;
    private Date dInicial;
    private Date dFinal;
    private Map<String, Long> mapa;
    private String busca;
    private String opcao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            opcao = request.getParameter("opcao");
            if (opcao.equals("grafico")) {
                busca = request.getParameter("busca");
                data = request.getParameter("dInicial");
                aux = data.split("-");
                dia = Integer.parseInt(aux[2]);
                mes = Integer.parseInt(aux[1]) - 1;
                ano = Integer.parseInt(aux[0]) - 1900;
                dInicial = new Date(ano, mes, dia);
                data = request.getParameter("dFinal");
                aux = data.split("-");
                dia = Integer.parseInt(aux[2]);
                mes = Integer.parseInt(aux[1]) - 1;
                ano = Integer.parseInt(aux[0]) - 1900;
                dFinal = new Date(ano, mes, dia);
                dDao = new DataDAO();
                datas = dDao.buscar(dInicial, dFinal);
                if (busca.equals("causa")) {
                    long[] cont = new long[11];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.causaPorData(dInicial, dFinal, "Animais na Pista");
                        cont[1] = cDao.causaPorData(dInicial, dFinal, "Defeito mecânico em veículo");
                        cont[2] = cDao.causaPorData(dInicial, dFinal, "Defeito na via");
                        cont[3] = cDao.causaPorData(dInicial, dFinal, "Desobediência à sinalização");
                        cont[4] = cDao.causaPorData(dInicial, dFinal, "Dormindo");
                        cont[5] = cDao.causaPorData(dInicial, dFinal, "Falta de atenção");
                        cont[6] = cDao.causaPorData(dInicial, dFinal, "Ingestão de álcool");
                        cont[7] = cDao.causaPorData(dInicial, dFinal, "Não guardar distância de segurança");
                        cont[8] = cDao.causaPorData(dInicial, dFinal, "Ultrapassagem indevida");
                        cont[9] = cDao.causaPorData(dInicial, dFinal, "Velocidade incompatível");
                        cont[10] = cDao.causaPorData(dInicial, dFinal, "Outras");
                        DefaultCategoryDataset data = new DefaultCategoryDataset();
                        data.setValue(cont[0], "Quantidade de Ocorrências", "Animais na pista");
                        data.setValue(cont[1], "Quantidade de Ocorrências", "Defeito mecânico em veiculo");
                        data.setValue(cont[2], "Quantidade de Ocorrências", "Defeito na Via");
                        data.setValue(cont[3], "Quantidade de Ocorrências", "Desobediência da Sinalização");
                        data.setValue(cont[4], "Quantidade de Ocorrências", "Dormindo");
                        data.setValue(cont[5], "Quantidade de Ocorrências", "Falta de Atenção");
                        data.setValue(cont[6], "Quantidade de Ocorrências", "Ingestão de Álcool");
                        data.setValue(cont[7], "Quantidade de Ocorrências", "Não Guardar a Distância de Segurança");
                        data.setValue(cont[8], "Quantidade de Ocorrências", "Ultrapassagem Indevida");
                        data.setValue(cont[9], "Quantidade de Ocorrências", "Velocidade incompativel");
                        data.setValue(cont[10], "Quantidade de Ocorrências", "Outras");
                        JFreeChart grafico = ChartFactory.createBarChart("Quantidade x Causa do Acidente", "Causa do Acidente", "Quantidade", data, PlotOrientation.HORIZONTAL, true, true, false);
                        response.setContentType("image/png");
                        BufferedImage buf = grafico.createBufferedImage(800, 500, null);
                        PngEncoder encoder = new PngEncoder(buf, false, 0, 9);
                        response.getOutputStream().write(encoder.pngEncode());
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("tipoAcidente")) {
                    long[] cont = new long[16];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.tipoAcidPorData(dInicial, dFinal, "Atropelamento de animal");
                        cont[1] = cDao.tipoAcidPorData(dInicial, dFinal, "Atropelamento de pessoa");
                        cont[2] = cDao.tipoAcidPorData(dInicial, dFinal, "Capotamento");
                        cont[3] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão com bicicleta");
                        cont[4] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão com objeto fixo");
                        cont[5] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão com objeto móvel");
                        cont[6] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão frontal");
                        cont[7] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão lateral");
                        cont[8] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão Transversal");
                        cont[9] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão traseira");
                        cont[10] = cDao.tipoAcidPorData(dInicial, dFinal, "Danos Eventuais");
                        cont[11] = cDao.tipoAcidPorData(dInicial, dFinal, "Derramamento de Carga");
                        cont[12] = cDao.tipoAcidPorData(dInicial, dFinal, "Incêndio");
                        cont[13] = cDao.tipoAcidPorData(dInicial, dFinal, "Queda de motocicleta / bicicleta / veículo");
                        cont[14] = cDao.tipoAcidPorData(dInicial, dFinal, "Saída de Pista");
                        cont[15] = cDao.tipoAcidPorData(dInicial, dFinal, "Tombamento");
                        DefaultCategoryDataset data = new DefaultCategoryDataset();
                        data.setValue(cont[0], "Quantidades de Ocorrências", "Atropelamento De Animais");
                        data.setValue(cont[1], "Quantidades de Ocorrências", "Atropelamento de Pessoas");
                        data.setValue(cont[2], "Quantidades de Ocorrências", "Capotamento");
                        data.setValue(cont[3], "Quantidades de Ocorrências", "Colisão com Bicicleta");
                        data.setValue(cont[4], "Quantidades de Ocorrências", "Colisão com Objeto Fixo");
                        data.setValue(cont[5], "Quantidades de Ocorrências", "Colisão Lateral");
                        data.setValue(cont[6], "Quantidades de Ocorrências", "Colisão Transversal");
                        data.setValue(cont[7], "Quantidades de Ocorrências", "Colisão Lateral");
                        data.setValue(cont[8], "Quantidades de Ocorrências", "Colisão Transversal");
                        data.setValue(cont[9], "Quantidades de Ocorrências", "Colisão Traseira");
                        data.setValue(cont[10], "Quantidades de Ocorrências", "Danos Eventuai");
                        data.setValue(cont[11], "Quantidades de Ocorrências", "Derramamento de Carga");
                        data.setValue(cont[12], "Quantidades de Ocorrências", "Incêndio");
                        data.setValue(cont[13], "Quantidades de Ocorrências", "Queda de Motocicleta/bicicleta/veículo");
                        data.setValue(cont[14], "Quantidades de Ocorrências", "Saída de Pista");
                        data.setValue(cont[15], "Quantidades de Ocorrências", "Tombamento");
                        JFreeChart grafico = ChartFactory.createBarChart("Quantidade x Tipo de Acidente", "Tipo de Acidente", "Quantidade", data, PlotOrientation.HORIZONTAL, true, true, false);
                        response.setContentType("image/png");
                        BufferedImage buf = grafico.createBufferedImage(800, 500, null);
                        PngEncoder encoder = new PngEncoder(buf, false, 0, 9);
                        response.getOutputStream().write(encoder.pngEncode());
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("classificacao")) {
                    long[] cont = new long[4];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.classificacaoPorData(dInicial, dFinal, "Com Vítimas Fatais");
                        cont[1] = cDao.classificacaoPorData(dInicial, dFinal, "Com Vítimas Feridas");
                        cont[2] = cDao.classificacaoPorData(dInicial, dFinal, "Ignorado");
                        cont[3] = cDao.classificacaoPorData(dInicial, dFinal, "Sem Vítimas");
                        DefaultPieDataset data = new DefaultPieDataset();
                        data.setValue("Com Vítimas Fatais", cont[0]);
                        data.setValue("Com Vítimas Feridas", cont[1]);
                        data.setValue("Ignorado", cont[2]);
                        data.setValue("Sem Vítimas", cont[3]);
                        JFreeChart grafico = ChartFactory.createPieChart("Classificacao do Acidente", data, true, true, false);
                        response.setContentType("image/png");
                        BufferedImage buf = grafico.createBufferedImage(800, 500, null);
                        PngEncoder encoder = new PngEncoder(buf, false, 0, 9);
                        response.getOutputStream().write(encoder.pngEncode());
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("fase")) {
                    long[] cont = new long[4];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.fasePorData(dInicial, dFinal, "Amanhecer");
                        cont[1] = cDao.fasePorData(dInicial, dFinal, "Anoitecer");
                        cont[2] = cDao.fasePorData(dInicial, dFinal, "Plena noite");
                        cont[3] = cDao.fasePorData(dInicial, dFinal, "Pleno dia");
                        DefaultPieDataset data = new DefaultPieDataset();
                        data.setValue("Amanhecer", cont[0]);
                        data.setValue("Anoitecer", cont[1]);
                        data.setValue("Plena noite", cont[2]);
                        data.setValue("Pleno dia", cont[3]);
                        JFreeChart grafico = ChartFactory.createPieChart("Fase do Dia", data, true, true, false);
                        response.setContentType("image/png");
                        BufferedImage buf = grafico.createBufferedImage(800, 500, null);
                        PngEncoder encoder = new PngEncoder(buf, false, 0, 9);
                        response.getOutputStream().write(encoder.pngEncode());
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("cond")) {
                    long[] cont = new long[9];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.condPorData(dInicial, dFinal, "Ceu Claro");
                        cont[1] = cDao.condPorData(dInicial, dFinal, "Chuva");
                        cont[2] = cDao.condPorData(dInicial, dFinal, "Granizo");
                        cont[3] = cDao.condPorData(dInicial, dFinal, "Ignorada");
                        cont[4] = cDao.condPorData(dInicial, dFinal, "Neve");
                        cont[5] = cDao.condPorData(dInicial, dFinal, "Nevoeiro/neblina");
                        cont[6] = cDao.condPorData(dInicial, dFinal, "Nublado");
                        cont[7] = cDao.condPorData(dInicial, dFinal, "Sol");
                        cont[8] = cDao.condPorData(dInicial, dFinal, "Vento");
                        DefaultCategoryDataset data = new DefaultCategoryDataset();
                        data.setValue(cont[0], "Quantidades de Ocorrências", "Ceu Claro");
                        data.setValue(cont[1], "Quantidades de Ocorrências", "Chuva");
                        data.setValue(cont[2], "Quantidades de Ocorrências", "Granizo");
                        data.setValue(cont[3], "Quantidades de Ocorrências", "Ignorada");
                        data.setValue(cont[4], "Quantidades de Ocorrências", "Neve");
                        data.setValue(cont[5], "Quantidades de Ocorrências", "Nevoeiro/neblina");
                        data.setValue(cont[6], "Quantidades de Ocorrências", "Nublado");
                        data.setValue(cont[7], "Quantidades de Ocorrências", "Sol");
                        data.setValue(cont[8], "Quantidades de Ocorrências", "Vento");
                        JFreeChart grafico = ChartFactory.createBarChart("Quantidade x Cond. Meteorológicas", "Cond. Meteorológicas", "Quantidade", data, PlotOrientation.HORIZONTAL, true, true, false);
                        response.setContentType("image/png");
                        BufferedImage buf = grafico.createBufferedImage(800, 500, null);
                        PngEncoder encoder = new PngEncoder(buf, false, 0, 9);
                        response.getOutputStream().write(encoder.pngEncode());
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("tipoPista")) {
                    long[] cont = new long[3];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.tipoPistaPorData(dInicial, dFinal, "Dupla");
                        cont[1] = cDao.tipoPistaPorData(dInicial, dFinal, "Múltipla");
                        cont[2] = cDao.tipoPistaPorData(dInicial, dFinal, "Simples");
                        DefaultPieDataset data = new DefaultPieDataset();
                        data.setValue("Dupla", cont[0]);
                        data.setValue("Múltipla", cont[1]);
                        data.setValue("Simples", cont[2]);
                        JFreeChart grafico = ChartFactory.createPieChart("Tipo de Pista", data, true, true, false);
                        response.setContentType("image/png");
                        BufferedImage buf = grafico.createBufferedImage(800, 500, null);
                        PngEncoder encoder = new PngEncoder(buf, false, 0, 9);
                        response.getOutputStream().write(encoder.pngEncode());
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("tracado")) {
                    long[] cont = new long[3];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.tracadoPorData(dInicial, dFinal, "Cruzamento");
                        cont[1] = cDao.tracadoPorData(dInicial, dFinal, "Curva");
                        cont[2] = cDao.tracadoPorData(dInicial, dFinal, "Reta");
                        DefaultPieDataset data = new DefaultPieDataset();
                        data.setValue("Cruzamento", cont[0]);
                        data.setValue("Curva", cont[1]);
                        data.setValue("Reta", cont[2]);
                        JFreeChart grafico = ChartFactory.createPieChart("Traçado da Via", data, true, true, false);
                        response.setContentType("image/png");
                        BufferedImage buf = grafico.createBufferedImage(800, 500, null);
                        PngEncoder encoder = new PngEncoder(buf, false, 0, 9);
                        response.getOutputStream().write(encoder.pngEncode());
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("solo")) {
                    long[] cont = new long[2];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.usoSoloPorData(dInicial, dFinal, "Urbano");
                        cont[1] = cDao.usoSoloPorData(dInicial, dFinal, "Rural");
                        DefaultPieDataset data = new DefaultPieDataset();
                        data.setValue("Perímetro Urbano", cont[0]);
                        data.setValue("Perímetro Rural", cont[1]);
                        JFreeChart grafico = ChartFactory.createPieChart("Uso do Solo", data, true, true, false);
                        response.setContentType("image/png");
                        BufferedImage buf = grafico.createBufferedImage(800, 500, null);
                        PngEncoder encoder = new PngEncoder(buf, false, 0, 9);
                        response.getOutputStream().write(encoder.pngEncode());
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                }
            } else if (opcao.equals("tabela")) {
                busca = request.getParameter("busca");
                data = request.getParameter("dInicial");
                aux = data.split("-");
                dia = Integer.parseInt(aux[2]);
                mes = Integer.parseInt(aux[1]) - 1;
                ano = Integer.parseInt(aux[0]) - 1900;
                dInicial = new Date(ano, mes, dia);
                data = request.getParameter("dFinal");
                aux = data.split("-");
                dia = Integer.parseInt(aux[2]);
                mes = Integer.parseInt(aux[1]) - 1;
                ano = Integer.parseInt(aux[0]) - 1900;
                dFinal = new Date(ano, mes, dia);
                dDao = new DataDAO();
                datas = dDao.buscar(dInicial, dFinal);
                session.setAttribute("dInicial", dInicial);
                session.setAttribute("dFinal", dFinal);
                if (busca.equals("causa")) {
                    long[] cont = new long[11];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.causaPorData(dInicial, dFinal, "Animais na Pista");
                        cont[1] = cDao.causaPorData(dInicial, dFinal, "Defeito mecânico em veículo");
                        cont[2] = cDao.causaPorData(dInicial, dFinal, "Defeito na via");
                        cont[3] = cDao.causaPorData(dInicial, dFinal, "Desobediência à sinalização");
                        cont[4] = cDao.causaPorData(dInicial, dFinal, "Dormindo");
                        cont[5] = cDao.causaPorData(dInicial, dFinal, "Falta de atenção");
                        cont[6] = cDao.causaPorData(dInicial, dFinal, "Ingestão de álcool");
                        cont[7] = cDao.causaPorData(dInicial, dFinal, "Não guardar distância de segurança");
                        cont[8] = cDao.causaPorData(dInicial, dFinal, "Ultrapassagem indevida");
                        cont[9] = cDao.causaPorData(dInicial, dFinal, "Velocidade incompatível");
                        cont[10] = cDao.causaPorData(dInicial, dFinal, "Outras");
                        mapa = new LinkedHashMap<>();
                        mapa.put("Animais na Pista", cont[0]);
                        mapa.put("Defeito mecânico em veículo", cont[1]);
                        mapa.put("Defeito na via", cont[2]);
                        mapa.put("Desobediência à sinalização", cont[3]);
                        mapa.put("Dormindo", cont[4]);
                        mapa.put("Falta de atenção", cont[5]);
                        mapa.put("Ingestão de álcool", cont[6]);
                        mapa.put("Não guardar distância de segurança", cont[7]);
                        mapa.put("Ultrapassagem Indevida", cont[8]);
                        mapa.put("Velocidade incompatível", cont[9]);
                        mapa.put("Outras", cont[10]);
                        session.setAttribute("flag", true);
                        session.setAttribute("titulo", "Causa do Acidente");
                        session.setAttribute("mapa", mapa);
                        RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                        r.forward(request, response);
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("tipoAcidente")) {
                    long[] cont = new long[16];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.tipoAcidPorData(dInicial, dFinal, "Atropelamento de animal");
                        cont[1] = cDao.tipoAcidPorData(dInicial, dFinal, "Atropelamento de pessoa");
                        cont[2] = cDao.tipoAcidPorData(dInicial, dFinal, "Capotamento");
                        cont[3] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão com bicicleta");
                        cont[4] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão com objeto fixo");
                        cont[5] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão com objeto móvel");
                        cont[6] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão frontal");
                        cont[7] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão lateral");
                        cont[8] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão Transversal");
                        cont[9] = cDao.tipoAcidPorData(dInicial, dFinal, "Colisão traseira");
                        cont[10] = cDao.tipoAcidPorData(dInicial, dFinal, "Danos Eventuais");
                        cont[11] = cDao.tipoAcidPorData(dInicial, dFinal, "Derramamento de Carga");
                        cont[12] = cDao.tipoAcidPorData(dInicial, dFinal, "Incêndio");
                        cont[13] = cDao.tipoAcidPorData(dInicial, dFinal, "Queda de motocicleta / bicicleta / veículo");
                        cont[14] = cDao.tipoAcidPorData(dInicial, dFinal, "Saída de Pista");
                        cont[15] = cDao.tipoAcidPorData(dInicial, dFinal, "Tombamento");
                        mapa = new LinkedHashMap<>();
                        mapa.put("Atropelamento de animal", cont[0]);
                        mapa.put("Atropelamento de pessoa", cont[1]);
                        mapa.put("Capotamento", cont[2]);
                        mapa.put("Colisão com bicicleta", cont[3]);
                        mapa.put("Colisão com objeto fixo", cont[4]);
                        mapa.put("Colisão com objeto móvel", cont[5]);
                        mapa.put("Colisão frontal", cont[6]);
                        mapa.put("Colisão lateral", cont[7]);
                        mapa.put("Colisão Transversal", cont[8]);
                        mapa.put("Colisão traseira", cont[9]);
                        mapa.put("Danos Eventuais", cont[10]);
                        mapa.put("Derramamento de Carga", cont[11]);
                        mapa.put("Incêndio", cont[12]);
                        mapa.put("Queda de motocicleta / bicicleta / veículo", cont[13]);
                        mapa.put("Saída de Pista", cont[14]);
                        mapa.put("Tombamento", cont[15]);
                        session.setAttribute("flag", true);
                        session.setAttribute("titulo", "Tipo de Acidente");
                        session.setAttribute("mapa", mapa);
                        RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                        r.forward(request, response);
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("classificacao")) {
                    long[] cont = new long[4];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.classificacaoPorData(dInicial, dFinal, "Com Vítimas Fatais");
                        cont[1] = cDao.classificacaoPorData(dInicial, dFinal, "Com Vítimas Feridas");
                        cont[2] = cDao.classificacaoPorData(dInicial, dFinal, "Ignorado");
                        cont[3] = cDao.classificacaoPorData(dInicial, dFinal, "Sem Vítimas");
                        mapa = new LinkedHashMap<>();
                        mapa.put("Com Vítimas Fatais", cont[0]);
                        mapa.put("Com Vítimas Feridas", cont[1]);
                        mapa.put("Ignorado", cont[2]);
                        mapa.put("Sem Vítimas", cont[3]);
                        session.setAttribute("flag", true);
                        session.setAttribute("titulo", "Classificação do Acidente");
                        session.setAttribute("mapa", mapa);
                        RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                        r.forward(request, response);
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("fase")) {
                    long[] cont = new long[4];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.fasePorData(dInicial, dFinal, "Amanhecer");
                        cont[1] = cDao.fasePorData(dInicial, dFinal, "Anoitecer");
                        cont[2] = cDao.fasePorData(dInicial, dFinal, "Plena noite");
                        cont[3] = cDao.fasePorData(dInicial, dFinal, "Pleno dia");
                        mapa = new LinkedHashMap<>();
                        mapa.put("Amanhecer", cont[0]);
                        mapa.put("Anoitecer", cont[1]);
                        mapa.put("Plena noite", cont[2]);
                        mapa.put("Pleno dia", cont[3]);
                        session.setAttribute("flag", true);
                        session.setAttribute("titulo", "Fase do Dia");
                        session.setAttribute("mapa", mapa);
                        RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                        r.forward(request, response);
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("cond")) {
                    long[] cont = new long[9];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.condPorData(dInicial, dFinal, "Ceu Claro");
                        cont[1] = cDao.condPorData(dInicial, dFinal, "Chuva");
                        cont[2] = cDao.condPorData(dInicial, dFinal, "Granizo");
                        cont[3] = cDao.condPorData(dInicial, dFinal, "Ignorada");
                        cont[4] = cDao.condPorData(dInicial, dFinal, "Neve");
                        cont[5] = cDao.condPorData(dInicial, dFinal, "Nevoeiro/neblina");
                        cont[6] = cDao.condPorData(dInicial, dFinal, "Nublado");
                        cont[7] = cDao.condPorData(dInicial, dFinal, "Sol");
                        cont[8] = cDao.condPorData(dInicial, dFinal, "Vento");
                        mapa = new LinkedHashMap<>();
                        mapa.put("Ceu Claro", cont[0]);
                        mapa.put("Chuva", cont[1]);
                        mapa.put("Granizo", cont[2]);
                        mapa.put("Ignorada", cont[3]);
                        mapa.put("Neve", cont[4]);
                        mapa.put("Nevoeiro/neblina", cont[5]);
                        mapa.put("Nublado", cont[6]);
                        mapa.put("Sol", cont[7]);
                        mapa.put("Vento", cont[8]);
                        session.setAttribute("flag", true);
                        session.setAttribute("titulo", "Condições Meteorológicas");
                        session.setAttribute("mapa", mapa);
                        RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                        r.forward(request, response);
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("tipoPista")) {
                    long[] cont = new long[3];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.tipoPistaPorData(dInicial, dFinal, "Dupla");
                        cont[1] = cDao.tipoPistaPorData(dInicial, dFinal, "Múltipla");
                        cont[2] = cDao.tipoPistaPorData(dInicial, dFinal, "Simples");
                        mapa = new LinkedHashMap<>();
                        mapa.put("Dupla", cont[0]);
                        mapa.put("Múltipla", cont[1]);
                        mapa.put("Simples", cont[2]);
                        session.setAttribute("flag", true);
                        session.setAttribute("titulo", "Tipo de Pista");
                        session.setAttribute("mapa", mapa);
                        RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                        r.forward(request, response);
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("tracado")) {
                    long[] cont = new long[3];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.tracadoPorData(dInicial, dFinal, "Cruzamento");
                        cont[1] = cDao.tracadoPorData(dInicial, dFinal, "Curva");
                        cont[2] = cDao.tracadoPorData(dInicial, dFinal, "Reta");
                        mapa = new LinkedHashMap<>();
                        mapa.put("Cruzamento", cont[0]);
                        mapa.put("Curva", cont[1]);
                        mapa.put("Reta", cont[2]);
                        session.setAttribute("flag", true);
                        session.setAttribute("titulo", "Traçado da Via");
                        session.setAttribute("mapa", mapa);
                        RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                        r.forward(request, response);
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                } else if (busca.equals("solo")) {
                    long[] cont = new long[2];
                    cDao = new CondicaoDAO();
                    if (!datas.isEmpty()) {
                        cont[0] = cDao.usoSoloPorData(dInicial, dFinal, "Urbano");
                        cont[1] = cDao.usoSoloPorData(dInicial, dFinal, "Rural");
                        mapa = new LinkedHashMap<>();
                        mapa.put("Perímetro Urbano", cont[0]);
                        mapa.put("Perímetro Rural", cont[1]);
                        session.setAttribute("flag", true);
                        session.setAttribute("titulo", "Uso do Solo");
                        session.setAttribute("mapa", mapa);
                        RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                        r.forward(request, response);
                    } else {
                        session.setAttribute("flag", false);
                        RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                        r.forward(request, response);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("erro " + ex.getMessage());
        }
    }

}
