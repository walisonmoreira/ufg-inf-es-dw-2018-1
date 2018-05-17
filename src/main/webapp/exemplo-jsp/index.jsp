<!DOCTYPE html>
<html>
  <head>
    <title>Maior Menor?</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="bootstrap.min.css">
  </head>
<body style="margin-top: 15px">
  <div class="container">
    <div class="row">
      <div class="col-md-offset-4 col-md-4">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title"><b>Maior menor</b></h3>
          </div>
          <div class="panel-body">
            <form>
                <div class="form-group">
                <input
                    name="idade"
                    type="number"
                    class="form-control"
                    placeholder="Idade">
                </div>
                <button class="btn btn-default">Calcular</button>
            </form>
<%
//Início do scriptlet.

//Pegar o parâmetro "idade".
String idadeStr = request.getParameter("idade");

String mensagem = "Informe a idade.";
if (idadeStr != null && !idadeStr.isEmpty()) {
    int idade = Integer.parseInt(idadeStr);
    if (idade >= 18) {
        mensagem = "Maior de idade.";
    } else {
        mensagem = "Menor de idade.";
    }
}
%>
          </div>
          <div class="panel-footer">
            <%
            out.print(mensagem);
            %>
          </div>          
        </div>
      </div>
    </div>
  </div>
</body>
</html>