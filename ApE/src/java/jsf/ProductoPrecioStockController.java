package jsf;

import jpa.entities.ProductoPrecioStock;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import jpa.session.ProductoPrecioStockFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "productoPrecioStockController")
@SessionScoped
public class ProductoPrecioStockController implements Serializable {

    private ProductoPrecioStock current;
    private DataModel items = null;
    private DataModel itemsConsulta = null;
    @EJB
    private jpa.session.ProductoPrecioStockFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private String pattern = "";
    private int cant_comprar;

    public ProductoPrecioStockController() {
    }

    public ProductoPrecioStock getSelected() {
        if (current == null) {
            current = new ProductoPrecioStock();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProductoPrecioStockFacade getFacade() {
        return ejbFacade;
    }

//    public PaginationHelper nuevaBusqueda() {
//        if (pagination == null) {
//            pagination = new PaginationHelper(10) {
//
//                @Override
//                public int getItemsCount() {
//                    return getFacade().count();
//                }
//
//                @Override
//                public DataModel createPageDataModel() {
//                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
//                }
//            };
//        }
//        return pagination;
//    }
    
    public String consultarProductos(){
        recreateModel();
        pagination = null;
        return "listado";
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }
    
    public PaginationHelper getPagination(){
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }
       
                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().buscar(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}, getPattern()));
                }
            };
        }
        return pagination;
    }
    
    private void agregarALista(){
        
    }

    public String prepareView() {
        current = (ProductoPrecioStock) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new ProductoPrecioStock();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ProductoPrecioStockCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (ProductoPrecioStock) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ProductoPrecioStockUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (ProductoPrecioStock) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ProductoPrecioStockDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        System.out.println("getItems()");
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return the cant_comprar
     */
    public int getCant_comprar() {
        return cant_comprar;
    }

    /**
     * @param cant_comprar the cant_comprar to set
     */
    public void setCant_comprar(int cant_comprar) {
        this.cant_comprar = cant_comprar;
    }

    @FacesConverter(forClass = ProductoPrecioStock.class)
    public static class ProductoPrecioStockControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductoPrecioStockController controller = (ProductoPrecioStockController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productoPrecioStockController");
            return controller.ejbFacade.find(getKey(value));
        }

        int getKey(String value) {
            int key;
            key = Integer.parseInt(value);
            return key;
        }

        String getStringKey(int value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProductoPrecioStock) {
                ProductoPrecioStock o = (ProductoPrecioStock) object;
                return getStringKey(o.getIdProducto());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + ProductoPrecioStockController.class.getName());
            }
        }
    }
}
