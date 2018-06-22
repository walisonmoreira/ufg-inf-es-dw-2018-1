package dw.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Data Access Object.
 */
public class ProfessorModel {

	//"professores" é o nome da unidade de persistência no "persistence.xml".
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("professores");

	public static void inclui(String matricula, String nome) {
		// Obter "conexão".
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Professor professor = new Professor();
		professor.setMatricula(matricula);
		professor.setNome(nome);

		// Grava o objeto no banco de dados.
		em.persist(professor);
		em.getTransaction().commit();
		em.close();
	}

	public static void alterar(String matricula, String nome) {
	}

	public static void excluir(String matricula) {
	}

	public static List<Professor> listar() {
		EntityManager em = emf.createEntityManager();
		//Não é SQL! É JPQL.
		String jpql = "from Professor";
		TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
		List<Professor> result = query.getResultList();
		em.close();
		return result;
	}
}
