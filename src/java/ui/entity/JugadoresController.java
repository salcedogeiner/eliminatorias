package ui.entity;

import dat.entity.Jugadores;
import ui.entity.util.JsfUtil;
import ui.entity.util.JsfUtil.PersistAction;
import dat.facade.JugadoresFacade;

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

@Named("jugadoresController")
@SessionScoped
public class JugadoresController implements Serializable {

    @EJB
    private dat.facade.JugadoresFacade ejbFacade;
    private List<Jugadores> items = null;
    private Jugadores selected;

    public JugadoresController() {
    }

    public Jugadores getSelected() {
        return selected;
    }

    public void setSelected(Jugadores selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getJugadoresPK().setCodEquipo(selected.getEquipos().getCodEquipo());
    }

    protected void initializeEmbeddableKey() {
        selected.setJugadoresPK(new dat.entity.JugadoresPK());
    }

    private JugadoresFacade getFacade() {
        return ejbFacade;
    }

    public Jugadores prepareCreate() {
        selected = new Jugadores();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("JugadoresCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("JugadoresUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("JugadoresDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Jugadores> getItems() {
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

    public Jugadores getJugadores(dat.entity.JugadoresPK id) {
        return getFacade().find(id);
    }

    public List<Jugadores> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Jugadores> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Jugadores.class)
    public static class JugadoresControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            JugadoresController controller = (JugadoresController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "jugadoresController");
            return controller.getJugadores(getKey(value));
        }

        dat.entity.JugadoresPK getKey(String value) {
            dat.entity.JugadoresPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new dat.entity.JugadoresPK();
            key.setCodJugador(Integer.parseInt(values[0]));
            key.setCodEquipo(values[1]);
            return key;
        }

        String getStringKey(dat.entity.JugadoresPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodJugador());
            sb.append(SEPARATOR);
            sb.append(value.getCodEquipo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Jugadores) {
                Jugadores o = (Jugadores) object;
                return getStringKey(o.getJugadoresPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Jugadores.class.getName()});
                return null;
            }
        }

    }

}
