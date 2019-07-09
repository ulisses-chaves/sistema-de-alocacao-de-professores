/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Beans.HorarioDisciplinas;
import com.Hirukar.Project.Models.Beans.Periodo;
import com.Hirukar.Project.Models.Enums.Area;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Hirukar.Project.Models.Enums.Cursos;
import com.Hirukar.Project.Models.Users_.Professor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RODEMARCK
 */
@Controller
public class  DisciplinaController {
    static boolean esq = true,dir = true;
    
    public Periodo[] init() throws SQLException, ClassNotFoundException {
        Periodo horarios[] = new Periodo[5];
        for(Periodo h : horarios)
            h = new Periodo();
        
        return horarios;
    }
    @RequestMapping("/disciplinas")
    public ModelAndView disciplinas() throws IllegalAccessException, SQLException, ClassNotFoundException {
        ModelAndView mv = new ModelAndView("disciplinas");
        return mv;
    }
    
    @RequestMapping(value="/atualizarSlots", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String atualizarSlots(int idCurso, int nPeriodo, ModelMap map) throws IllegalAccessException,SQLException, ClassNotFoundException {
        Periodo h = DisciplinasDAO.getPeriodo(idCurso, nPeriodo);
        ArrayList<Integer> p = DisciplinasDAO.listarPeriodos(1);
        ArrayList<Professor> profesores = ProfessorDAO.listar();
        
        ArrayList<Disciplina> disciplinas = DisciplinasDAO.listar();
        ArrayList<Professor> profesoresARC = new ArrayList<>();
        ArrayList<Professor> profesoresFC = new ArrayList<>();
        ArrayList<Professor> profesoresENSISO = new ArrayList<>();
        
        profesoresARC.addAll(profesores);
        profesoresFC.addAll(profesores);
        profesoresENSISO.addAll(profesores);
        profesoresARC.removeIf((t) -> t.getArea().getValue() != Area.ARC.getValue());
        profesoresFC.removeIf((t) -> t.getArea().getValue() != Area.FC.getValue());
        profesoresENSISO.removeIf((t) -> t.getArea().getValue() != Area.ENSISO.getValue());
        
        for(HorarioDisciplinas hd : h.getHorarioDisciplinas())
            disciplinas.remove(hd.getDisciplina());
        
        map.addAttribute("h", h);
        map.addAttribute("prof",profesores);
        map.addAttribute("prof_ARC",profesoresARC);
        map.addAttribute("prof_FC",profesoresFC);
        map.addAttribute("prof_ENSISO",profesoresENSISO);
        map.addAttribute("disciplinas",disciplinas);
        map.addAttribute("p", p);
        return "ResponseServer :: #corpo";
    }
    
    @RequestMapping(value="/getModalDisciplina", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String modalDisciplinas() throws IllegalAccessException{
        return "ResponseServer :: #modal-disciplina";
    }
    
    @RequestMapping(value="/getBotaoNavegacaoDisciplina", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public String botaoNavegacaoDisciplina() throws IllegalAccessException{
        return "ResponseServer :: #navegaca-disciplina";
    }
    
    @RequestMapping(value = "/alterarSlots", method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> alterarSlots(int idCurso, int nPeriodo, int n1,int n2) {
        try{
            int idN1 = DisciplinasDAO.getIdHorarioDisciplina(idCurso,nPeriodo,n1);
            int idN2 = DisciplinasDAO.getIdHorarioDisciplina(idCurso,nPeriodo,n2);
            DisciplinasDAO.atualizaSlots(idN1,n2);
            DisciplinasDAO.atualizaSlots(idN2,n1);
            return new ResponseEntity<>("OK",HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("",HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @RequestMapping(value = "/trocarDiscplina" , method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> salvar(int idCurso, int nPeriodo, int numero, int IDNovaDisciplina){
        try{
            int idHorario = DisciplinasDAO.getIdHorarioDisciplina(idCurso, nPeriodo, numero);
            DisciplinasDAO.trocaDisciplina(idHorario, IDNovaDisciplina);
            return new ResponseEntity<>("OK",HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/alocarProfessor"  , method = RequestMethod.POST, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> alocar(String cpf){
        return new ResponseEntity<>("",HttpStatus.NOT_ACCEPTABLE);
    }
}
;