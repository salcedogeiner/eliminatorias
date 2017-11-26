package ui.entity;

import dat.entity.Incide;
import ui.entity.util.JsfUtil;
import ui.entity.util.JsfUtil.PersistAction;
import dat.facade.IncideFacade;

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

@Named("incideController")
@SessionScoped
public class IncideController implements Serializable {

    @EJB
    private dat.facade.IncideFacade ejbFacade;
    private List<Incide> items = null;
    private Incide selected;

    public IncideController() {
    }

    public Incide getSelected() {
        return selected;
    }

    public void setSelected(Incide selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getIncidePK().setFEnfrenta(selected.getEnfrenta().getEnfrentaPK().getFEnfrenta());
        selected.getIncidePK().setCodEquipoVisitante(selected.getEnfrenta().getEnfrentaPK().getCodEquipoVisitante());
        selected.getIncidePK().setCodEquipoLocal(selected.getEnfrenta().getEnfrentaPK().getCodEquipoLocal());
        selected.getIncidePK().setCodEquipo(selected.getJugadores().getJugadoresPK().getCodEquipo());
        selected.getIncidePK().setCodEstadio(selected.getEnfrenta().getEnfrentaPK().getCodEstadio());
        selected.getIncidePK().setCodJugador(selected.getJugadores().getJugadoresPK().getCodJugador());
    }

    protected void initializeEmbeddableKey() {
        selected.setIncidePK(new dat.entity.IncidePK());
    }

    private IncideFacade getFacade() {
        return ejbFacade;
    }

    public Incide prepareCreate() {
        selected = new Incide();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("IncideCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("IncideUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("IncideDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Incide> getItems() {
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

    public Incide getIncide(dat.entity.IncidePK id) {
        return getFacade().find(id);
    }

    public List<Incide> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Incide> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Incide.class)
    public static class IncideControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            IncideController controller = (IncideController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "incideController");
            return controller.getIncide(getKey(value));
        }

        dat.entity.IncidePK getKey(String value) {
            dat.entity.IncidePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new dat.entity.IncidePK();
            key.setCodEquipo(values[0]);
            key.setCodJugador(Integer.parseInt(values[1]));
            key.setCodEstadio(Integer.parseInt(values[2]));
            key.setCodEquipoLocal(values[3]);
            key.setCodEquipoVisitante(values[4]);
            key.setFEnfrenta(java.sql.Date.valueOf(values[5]));
            key.setMinuto(Short.parseShort(values[6]));
            key.setTipoIncidente(values[7]);
            return key;
        }

        String getStringKey(dat.entity.IncidePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodEquipo());
            sb.append(SEPARATOR);
            sb.append(value.getCodJugador());
            sb.append(SEPARATOR);
            sb.append(value.getCodEstadio());
            sb.append(SEPARATOR);
            sb.append(value.getCodEquipoLocal());
            sb.append(SEPARATOR);
            sb.append(value.getCodEquipoVisitante());
            sb.append(SEPARATOR);
            sb.append(value.getFEnfrenta());
            sb.append(SEPARATOR);
            sb.append(value.getMinuto());
            sb.append(SEPARATOR);
            sb.append(value.getTipoIncidente());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Incide) {
                Incide o = (Incide) object;
                return getStringKey(o.getIncidePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Incide.class.getName()});
                return null;
            }
        }

    }

}
