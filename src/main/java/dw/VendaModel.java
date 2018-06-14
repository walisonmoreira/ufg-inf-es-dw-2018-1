package dw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendaModel {
  private String codigo;
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  private String produto;
  public String getProduto() {
    return produto;
  }
  public void setProduto(String produto) {
    this.produto = produto;
  }

  private Integer quantidade;
  public Integer getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  private static Connection obterConexao() throws SQLException {
    //Estabelecer uma conexão com o banco de dados.
    String url = "jdbc:derby://localhost:1527/vendadb;create=true";
    String user = "app";
    String password = "app";
    return DriverManager.getConnection(url, user, password);
  }

  public void incluir() throws SQLException {
    Connection conn = obterConexao();
    
    //Obter sentença SQL.
    String sql = "insert into venda (codigo, produto, quantidade) values (?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, codigo);
    pstmt.setString(2, produto);
    pstmt.setInt(3, quantidade);
    pstmt.execute();
  }

  public void salvar() throws SQLException {
    Connection conn = obterConexao();

    //Obter sentença SQL.
    String sql = "update venda set produto = ?, quantidade = ? where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, produto);
    pstmt.setInt(2, quantidade);
    pstmt.setString(3, codigo);
    pstmt.execute();
  }

  public void excluir() throws SQLException {
    Connection conn = obterConexao();
    
    //Obter sentença SQL.
    String sql = "delete from venda where codigo = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, codigo);
    pstmt.execute();
  }

  public static List<VendaModel> listar() throws SQLException {
    Connection conn = obterConexao();
    
    Statement stmt = conn.createStatement();
    String sql = "select codigo, produto, quantidade from venda order by codigo";
    ResultSet rs = stmt.executeQuery(sql);
  
    List<VendaModel> listaDeVendas = new ArrayList<VendaModel>();
    while (rs.next()) {
      // Cria um venda para o registro.
      VendaModel venda = new VendaModel();
      venda.setCodigo(rs.getString("codigo"));
      venda.setProduto(rs.getString("produto"));
      venda.setQuantidade(rs.getInt("quantidade"));
      // Adiciona o venda na lista de vendas.
      listaDeVendas.add(venda);
    }
    return listaDeVendas;
  }
}
