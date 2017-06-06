package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfileRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	PeriodeRepository periodeRepository;
	@Autowired
	BulletinSalaireRepository bulletinSalaireRepository;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletins");
		/*
		 * Recupérer de la base de donner les table necessaire pour afficher
		 * dans liste deroulante
		 */
		mv.addObject("listPeriodes", periodeRepository.findAll());
		mv.addObject("listEmploye", remunerationEmployeRepository.findAll());
		mv.addObject("bulletin", new BulletinSalaire());
		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletins");
		mv.addObject("bulletins", remunerationEmployeRepository.findAll());
		return mv;
	}

	@RequestMapping(value = "/creer", method = RequestMethod.POST)
	public String form(@RequestParam("periode") Periode periode, @RequestParam("matricule") RemunerationEmploye matricule,@RequestParam("prime") BigDecimal prime , Model model) {
		BulletinSalaire bulletin = new BulletinSalaire();
		bulletin.setPeriode(periode);
		bulletin.setRemunerationEmploye(matricule);
		bulletin.setPrimeExceptionnelle(prime);
		
		
		
		bulletinSalaireRepository.saveAndFlush(bulletin);

		return "redirect:/mvc/employes/lister";
	}

}
