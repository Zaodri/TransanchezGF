/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languageOptions;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.ManagedBean;
import java.util.Locale;
//import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author SAODRI
 */

@ManagedBean
//@ApplicationScoped
@SessionScoped
@Named("tranIntern")
public class ChangeLanguage implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String languaje;
    private static Map<String, Object> listLenguajes;

    public String getLanguaje() {
        return languaje;
    }

    public void setLanguaje(String languaje) {
        this.languaje = languaje;
    }


    public Map<String, Object> getListLenguajes() {
    return listLenguajes;
    }
    public static void setListLenguajes(Map<String, Object> listLenguajes) {
    ChangeLanguage.listLenguajes = listLenguajes;
    }
    

    static {
        listLenguajes = new LinkedHashMap<String, Object>();
        
        listLenguajes.put("",Locale.getDefault());
        listLenguajes.put("English", Locale.US);
        listLenguajes.put("Français", Locale.FRANCE);
        
        Locale espanol = new Locale("es");
        listLenguajes.put("Español", espanol);        
        
    }
   
    public void languajeChanged(ValueChangeEvent event){
        String newlanguajeValue = event.getNewValue().toString();
        
        for (Map.Entry<String, Object> entry : listLenguajes.entrySet()) {
            if (entry.getValue().toString().equals(newlanguajeValue)) {
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
                
            }
        }
    }
    
    public void selectLanguaje(int optionLG){
        
        switch(optionLG){
            case 1:
                FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
                break;
                
            case 2:
                 FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.getDefault());

                 break;
                
            default:
                FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.getDefault());
                break;
        }      
    }
}
