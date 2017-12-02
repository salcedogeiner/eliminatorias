package ui.entity;

import dat.entity.VInfoPosiciones;
import ui.entity.util.JsfUtil;
import ui.entity.util.JsfUtil.PersistAction;
import dat.facade.VInfoPosicionesFacade;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("vInfoPosicionesController")
@SessionScoped
public class VInfoPosicionesController implements Serializable {

    @EJB
    private dat.facade.VInfoPosicionesFacade ejbFacade;
    private List<VInfoPosiciones> items = null;
    private VInfoPosiciones selected;

    public VInfoPosicionesController() {
    }

    public VInfoPosiciones getSelected() {
        return selected;
    }

    public void setSelected(VInfoPosiciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private VInfoPosicionesFacade getFacade() {
        return ejbFacade;
    }

    public VInfoPosiciones prepareCreate() {
        selected = new VInfoPosiciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VInfoPosicionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VInfoPosicionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VInfoPosicionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<VInfoPosiciones> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public VInfoPosiciones getVInfoPosiciones(java.math.BigInteger id) {
        return getFacade().find(id);
    }

    public List<VInfoPosiciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<VInfoPosiciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = VInfoPosiciones.class)
    public static class VInfoPosicionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VInfoPosicionesController controller = (VInfoPosicionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "vInfoPosicionesController");
            return controller.getVInfoPosiciones(getKey(value));
        }

        java.math.BigInteger getKey(String value) {
            java.math.BigInteger key;
            key = new BigInteger(value);
            return key;
        }

        String getStringKey(java.math.BigInteger value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof VInfoPosiciones) {
                VInfoPosiciones o = (VInfoPosiciones) object;
                return getStringKey(o.getPosicion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VInfoPosiciones.class.getName()});
                return null;
            }
        }

    }

}