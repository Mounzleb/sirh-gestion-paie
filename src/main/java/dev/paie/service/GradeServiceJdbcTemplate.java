package dev.paie.service;

import java.nio.channels.NetworkChannel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {

		super();

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade saveGrade) {
		String sql = "INSERT INTO grade (ID, code, nbHeuresBase, tauxbase) VALUES (?, ?, ?,? )";
		this.jdbcTemplate.update(sql, saveGrade.getId(), saveGrade.getCode(), saveGrade.getNbHeuresBase(),
				saveGrade.getTauxBase());
	}

	@Override
	public List<Grade> lister() {

		
		// je recupére mes lignes de table dans la base de données.
		// Grâce au RowMapper, je transforme chaque ligne en objet
		// je stoque c'est objet dans une liste de grade

		String sql = "SELECT * FROM grade";
		return this.jdbcTemplate.query(sql, new GradeMapper());

	}

	@Override
	public void mettre_a_jour(Grade updateGrade) {
		String sql = "UPDATE grade SET ID = ?, code = ?, nbHeuresBase = ?, tauxbase = ? WHERE grade.ID = 1 ";
		this.jdbcTemplate.update(sql, updateGrade.getId(), updateGrade.getCode(), updateGrade.getNbHeuresBase(),
				updateGrade.getTauxBase());
	}

	// ici j'ai une classe interne pour pouvoir utiliser mon RowMapper ( jaurais
	// pu egalement le faire dans un autre fichier class)
	public class GradeMapper implements RowMapper<Grade> {

		// le RowMapper va me permettre de transformer chaque turplet (ligne de
		// tables de base de donnée) en un objet
		@Override
		public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {

			Grade g = new Grade();
			g.setId(rs.getInt("ID"));
			g.setCode(rs.getString("code"));
			g.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
			g.setTauxBase(rs.getBigDecimal("tauxbase"));

			return g;
		}

	}

}
