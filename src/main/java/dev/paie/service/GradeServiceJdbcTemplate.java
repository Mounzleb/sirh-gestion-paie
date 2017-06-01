package dev.paie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

/**
 * Script création de la table : 
 * 
CREATE TABLE `GRADE` (
  `ID` int(11) NOT NULL,
  `CODE` varchar(200) NOT NULL,
  `NB_HEURES_BASE` decimal(10,2) NOT NULL,
  `TAUX_BASE` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 *
 */
@Service
public class GradeServiceJdbcTemplate implements GradeService {
	
	// dans le commit précedent j'ai utilisé une class pour le RowMapper et ici on le met dans une constante et on utilise un lambda.
	// ça fait nes en moins la même chose 
	private static final RowMapper<Grade> GRADE_MAPPER = (rs, rowNum) -> new Grade(rs.getInt("ID"), rs.getString("code"), rs.getBigDecimal("nbHeuresBase"), rs.getBigDecimal("tauxBase"));
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Map<String, Object> creerParametres(Grade grade) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ID", grade.getId());
		parameters.put("CODE", grade.getCode());
		parameters.put("NB_HEURES_BASE", grade.getNbHeuresBase());
		parameters.put("TAUX_BASE", grade.getTauxBase());
		return parameters;
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		this.jdbcTemplate.update("insert into grade (ID,code,nbHeuresBase,tauxbase) VALUES(:ID,:CODE,:NB_HEURES_BASE,:TAUX_BASE)",
				creerParametres(nouveauGrade));
	}

	@Override
	public void mettre_a_jour(Grade gradeAModifier) {
		this.jdbcTemplate.update("update grade set code=:CODE,nbHeuresBase=:NB_HEURES_BASE,tauxbase=:TAUX_BASE where ID=:ID",
				creerParametres(gradeAModifier));
	}

	@Override
	public List<Grade> lister() {
		return this.jdbcTemplate.query("select * from grade", GRADE_MAPPER);
	}

}