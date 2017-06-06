package dev.paie.web.controller;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfileRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	@Autowired
	GradeRepository gradeRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	ProfileRemunerationRepository profileRemunerationRepository;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;

//	List<Entreprise> listeEntreprise = new ArrayList<>();
//	List<Grade> listeGrade = new ArrayList<>();
//	List<ProfilRemuneration> listProfile = new ArrayList<>();

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		/*
		 * Ici nous sommes entrain de recupérer les liste de grade, entrepris et
		 * profil pour pouvoir les afficher dans les liste déroulante dans la
		 * page créer un employé
		 */
		mv.addObject("listeGrade", gradeRepository.findAll());
		mv.addObject("listeEntreprise", entrepriseRepository.findAll());
		mv.addObject("listeProfil", profileRemunerationRepository.findAll());
		return mv;

	}

	 @RequestMapping(method = RequestMethod.GET, path = "/lister")
	    public ModelAndView listerEmploye() {
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("employes/listerEmploye");
	        mv.addObject("employes",remunerationEmployeRepository.findAll());
	        return mv;
	    }
	    @RequestMapping(value = "/creer", method = RequestMethod.POST)
	    public String form(@RequestParam("matricule") String matricule, @RequestParam("entreprise") Integer entreprise,
	            @RequestParam("profil") Integer profil, @RequestParam("grade") Integer grade, Model model) {
	        RemunerationEmploye remnum = new RemunerationEmploye();
	        remnum.setMatricule(matricule);
	        remnum.setDateHeure(ZonedDateTime.now());
	        remnum.setEntreprise(entrepriseRepository.findOne(entreprise));
	        remnum.setProfilRemuneration(profileRemunerationRepository.findOne(profil));
	        remnum.setGrade(gradeRepository.findOne(grade));
	        remunerationEmployeRepository.saveAndFlush(remnum);
	        
	        return "redirect:/mvc/employes/lister";
	    }

}
