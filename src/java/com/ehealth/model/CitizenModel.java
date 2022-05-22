package com.ehealth.model;

import com.ehealth.controller.CitizenDao;
import com.ehealth.entities.Citizen;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author hirwa
 */
@ManagedBean
public class CitizenModel {
    private Citizen citizen = new Citizen();
    private CitizenDao citizenDao = new CitizenDao();
    
    public String save(){
        try {
            citizen.calculateBmi();
            citizenDao.create(citizen);
            return "resultPage";
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("Failed to Save, maybe you are trying to save an existing ID");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "index";
        }
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public List<Citizen> getCitizens() {
        return citizenDao.findAllCitizens();
    } 
}
