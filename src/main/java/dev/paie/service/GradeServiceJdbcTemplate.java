package dev.paie.service;

import java.nio.channels.NetworkChannel;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		this.jdbcTemplate.update(sql, saveGrade.getId(), saveGrade.getCode(), saveGrade.getNbHeuresBase(), saveGrade.getTauxBase());
	}

	@Override
	public void lister(Grade listGrade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mettre_a_jour(Grade updateGrade) {
		// TODO Auto-generated method stub

	}

}
