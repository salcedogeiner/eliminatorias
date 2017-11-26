package ui.entity;

import dat.entity.Juega;
import ui.entity.util.JsfUtil;
import ui.entity.util.JsfUtil.PersistAction;
import dat.facade.JuegaFacade;

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

@Named("juegaController")
@SessionScoped
public class JuegaController implements Serializable {

    @EJB
    private dat.facade.JuegaFacade ejbFacade;
    private List<Juega> items = null;
    private Juega selected;

    public JuegaController() {
    }

    public Juega getSelected() {
        return selected;
    }

    public void setSelected(Juega selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getJuegaPK().setCodEquipo(selected.getJugadores().getJugadoresPK().getCodEquipo());
        selected.getJuegaPK().setCodJugador(selected.getJugadores().getJugadoresPK().getCodJugador());
        selected.getJuegaPK().setIdTorneo(selected.getTorneos().getIdTorneo());
    }

    protected void initializeEmbeddableKey() {
        selected.setJuegaPK(new dat.entity.JuegaPK());
    }

    private JuegaFacade getFacade() {
        return ejbFacade;
    }

    public Juega prepareCreate() {
        selected = new Juega();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("JuegaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("JuegaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("JuegaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Juega> getItems() {
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

    public Juega getJuega(dat.entity.JuegaPK id) {
        return getFacade().find(id);
    }

    public List<Juega> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Juega> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Juega.class)
    public static class JuegaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            JuegaController controller = (JuegaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "juegaController");
            return controller.getJuega(getKey(value));
        }

        dat.entity.JuegaPK getKey(String value) {
            dat.entity.JuegaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new dat.entity.JuegaPK();
            key.setCodJugador(Integer.parseInt(values[0]));
            key.setCodEquipo(values[1]);
            key.setIdTorneo(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(dat.entity.JuegaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodJugador());
            sb.append(SEPARATOR);
            sb.append(value.getCodEquipo());
            sb.append(SEPARATOR);
            sb.append(value.getIdTorneo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Juega) {
                Juega o = (Juega) object;
                return getStringKey(o.getJuegaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Juega.class.getName()});
                return null;
            }
        }

    }

}
