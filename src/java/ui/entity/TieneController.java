package ui.entity;

import dat.entity.Tiene;
import ui.entity.util.JsfUtil;
import ui.entity.util.JsfUtil.PersistAction;
import dat.facade.TieneFacade;

import java.io.Serializable;
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

@Named("tieneController")
@SessionScoped
public class TieneController implements Serializable {

    @EJB
    private dat.facade.TieneFacade ejbFacade;
    private List<Tiene> items = null;
    private Tiene selected;

    public TieneController() {
    }

    public Tiene getSelected() {
        return selected;
    }

    public void setSelected(Tiene selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTienePK().setCodEstadio(selected.getEstadios().getCodEstadio());
        selected.getTienePK().setCodEquipo(selected.getEquipos().getCodEquipo());
    }

    protected void initializeEmbeddableKey() {
        selected.setTienePK(new dat.entity.TienePK());
    }

    private TieneFacade getFacade() {
        return ejbFacade;
    }

    public Tiene prepareCreate() {
        selected = new Tiene();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TieneCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TieneUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TieneDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tiene> getItems() {
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

    public Tiene getTiene(dat.entity.TienePK id) {
        return getFacade().find(id);
    }

    public List<Tiene> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tiene> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tiene.class)
    public static class TieneControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TieneController controller = (TieneController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tieneController");
            return controller.getTiene(getKey(value));
        }

        dat.entity.TienePK getKey(String value) {
            dat.entity.TienePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new dat.entity.TienePK();
            key.setCodEquipo(values[0]);
            key.setCodEstadio(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(dat.entity.TienePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodEquipo());
            sb.append(SEPARATOR);
            sb.append(value.getCodEstadio());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tiene) {
                Tiene o = (Tiene) object;
                return getStringKey(o.getTienePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tiene.class.getName()});
                return null;
            }
        }

    }

}
