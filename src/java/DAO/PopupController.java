/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Euklides Hutasoit
 */

@ManagedBean
@SessionScoped
public class PopupController implements Serializable{
    
    private boolean showPopup;
    
    public void show(){
        showPopup=true;
    }
    public void hide(){
        showPopup=false;
    }

    public boolean isShowPopup() {
        return showPopup;
    }

    public void setShowPopup(boolean showPopup) {
        this.showPopup = showPopup;
    }
//    
//    public String isHidePopup(){
//        return "index.xhtml";
//    }
}
