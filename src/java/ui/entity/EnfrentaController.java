package ui.entity;

import dat.entity.Enfrenta;
import ui.entity.util.JsfUtil;
import ui.entity.util.JsfUtil.PersistAction;
import dat.facade.EnfrentaFacade;

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

@Named("enfrentaController")
@SessionScoped
public class EnfrentaController implements Serializable {

    @EJB
    private dat.facade.EnfrentaFacade ejbFacade;
    private List<Enfrenta> items = null;
    private Enfrenta selected;

    public EnfrentaController() {
    }

    public Enfrenta getSelected() {
        return selected;
    }

    public void setSelected(Enfrenta selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getEnfrentaPK().setCodEquipoVisitante(selected.getEquipos().getCodEquipo());
        selected.getEnfrentaPK().setCodEstadio(selected.getTiene().getTienePK().getCodEstadio());
        selected.getEnfrentaPK().setCodEquipoLocal(selected.getTiene().getTienePK().getCodEquipo());
    }

    protected void initializeEmbeddableKey() {
        selected.setEnfrentaPK(new dat.entity.EnfrentaPK());
    }

    private EnfrentaFacade getFacade() {
        return ejbFacade;
    }

    public Enfrenta prepareCreate() {
        selected = new Enfrenta();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EnfrentaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EnfrentaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EnfrentaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Enfrenta> getItems() {
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

    public Enfrenta getEnfrenta(dat.entity.EnfrentaPK id) {
        return getFacade().find(id);
    }

    public List<Enfrenta> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Enfrenta> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Enfrenta.class)
    public static class EnfrentaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EnfrentaController controller = (EnfrentaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "enfrentaController");
            return controller.getEnfrenta(getKey(value));
        }

        dat.entity.EnfrentaPK getKey(String value) {
            dat.entity.EnfrentaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new dat.entity.EnfrentaPK();
            key.setCodEstadio(Integer.parseInt(values[0]));
            key.setCodEquipoLocal(values[1]);
            key.setCodEquipoVisitante(values[2]);
            key.setFEnfrenta(java.sql.Date.valueOf(values[3]));
            return key;
        }

        String getStringKey(dat.entity.EnfrentaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodEstadio());
            sb.append(SEPARATOR);
            sb.append(value.getCodEquipoLocal());
            sb.append(SEPARATOR);
            sb.append(value.getCodEquipoVisitante());
            sb.append(SEPARATOR);
            sb.append(value.getFEnfrenta());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Enfrenta) {
                Enfrenta o = (Enfrenta) object;
                return getStringKey(o.getEnfrentaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Enfrenta.class.getName()});
                return null;
            }
        }

    }

}
