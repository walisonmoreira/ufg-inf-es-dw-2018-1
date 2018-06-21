<!DOCTYPE html>
<%@page import="dw.VendaModel"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Venda</title>
<meta charset="utf-8">
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 15px">
  <div class="container">
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <ol class="breadcrumb">
          <li><a href="/">Menu</a></li>
          <li class="active">Venda</li>
        </ol>
        <div class="panel panel-default">
          <div class="panel-body">
            <form>
              <div class="form-group">
                <input
                  name="codigo"
                  value="${param.codigo}"
                  type="text"
                  placeholder="Código"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="produto"
                  value="${param.produto}"
                  type="text"
                  placeholder="Produto"
                  class="form-control">
              </div>
              <div class="form-group">
                <input
                  name="quantidade"
                  value="${param.quantidade}"
                  type="number"
                  placeholder="Quantidade"
                  class="form-control">
              </div>
              <button name="op" value="incluir" class="btn btn-default">Incluir Novo</button>
              <button name="op" value="salvar" class="btn btn-default">Salvar Atual</button>
            </form>
          </div>
        </div>
        <table class="table table-bordered table-striped">
          <tr>
            <td>Código</td>
            <td>Produto</td>
            <td>Quantidade</td>
            <td>#</td>
          </tr>
          <%
          List<VendaModel> vendas = (List<VendaModel>) request.getAttribute("vendas");
          for (VendaModel v:vendas) {
          %>
            <tr>
              <td><a href="venda?codigo=<%=v.getCodigo()%>&produto=<%=v.getProduto()%>&quantidade=<%=v.getQuantidade()%>"><%=v.getCodigo()%></a></td>
              <td><%=v.getProduto()%></td>
              <td><%=v.getQuantidade()%></td>
              <td><a href="venda?op=excluir&codigo=<%=v.getCodigo()%>">Excluir</a></td>
            </tr>
          <%
          }
          %>
        </table>
      </div>
    </div>
  </div>
</body>
</html>