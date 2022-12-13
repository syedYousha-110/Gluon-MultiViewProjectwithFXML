package com.gluonapplication.views;

import com.gluonapplication.Controller.DarazSellerModel.GetRequest.*;
import com.gluonapplication.Controller.Enum.Constants;
import com.gluonapplication.Controller.TableModelData.*;
import com.gluonhq.charm.glisten.animation.BounceInRightTransition;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;


import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.Node;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.converter.NumberStringConverter;

import java.util.*;



public class ApiPresenter {

    public HBox ActionParameterHbox;
    @FXML
    private View api;
    private String brand;
    private String categoryTree;
    private String categoryAttribute;
    private String orders;
    private String response;
    @FXML
    private VBox responseTableContainer;
    @FXML
    private VBox fieldsContainer;
    @FXML
    private TextField Limit;
    @FXML
    private TextField OffSet;
    @FXML
    private GridPane ButtonGridNP;
    public TextField ApiUrlText;
    public TextField ApikeyText;
    @FXML
    private TextField search_query;
    @FXML
    private GridPane gridTextField;
    @FXML
    private ChoiceBox<String> actionsBox;
    @FXML
    private Button btn_clear;
    @FXML
    private Button btn_LoadData;
    @FXML
    private Button execute;
    @FXML
    private Button btn_previous;
    @FXML
    private Button btn_next;
    @FXML
    private TableView<CustomTableProperty> table_View;
    @FXML
    private VBox tableVboxContainer;
    @FXML
    private Label TableLabel;
    private List<TableUtility> tableViews;
    private TableView<CustomTableProperty> newTableView;
    public static ObservableList<CustomTableProperty> observableList;
    private static List<CustomTableProperty> customProperties;
    private static ListIterator<CustomTableProperty> propertyListIterator;
    private static CustomTableProperty customTableProperty;
    private static final List<ObservableList<CustomTableProperty>> tableItemLists = FXCollections.observableArrayList();

    private static ListIterator<ObservableList<CustomTableProperty>> iterator;
    private static ListIterator<TableUtility> iteratorTable;
    private static SortedList<CustomTableProperty> dataSortedList;
    private final BrandsTableData getBrandsTableData  = new BrandsTableData();
    private final OrdersTableData ordersTableData = new OrdersTableData();
    private final AttributesTableData attributesTableData = new AttributesTableData();
    private int tableIndex = 0;
    private final TableView<?> messageTable = new TableView<>();


    public void initialize() {
        api.setShowTransitionFactory(BounceInRightTransition::new);
        FloatingActionButton fb = new FloatingActionButton(MaterialDesignIcon.EXIT_TO_APP.text, e->{

        });
        fb.showOn(api);
        api.showingProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue){
                AppBar app = AppManager.getInstance().getAppBar();
                app.backgroundProperty().setValue(Background.fill(Color.ORANGE));
                app.setTitle(new Label(" GetRequest"));
                app.setNavIcon(MaterialDesignIcon.MENU.button(e->AppManager.getInstance().getDrawer().open()));
            }
        }));

        fieldsContainer.setSpacing(10);
        TableLabel.setTextAlignment(TextAlignment.CENTER);
        responseTableContainer.getChildren().add(0,new Label("SuccessResponse"));
        responseTableContainer.getChildren().add(1,new Label(""));
        this.tableViews = new ArrayList<>();
        customProperties = new ArrayList<>();
        tableVboxContainer.getChildren().remove(table_View);
        newTableView = new TableView<>();
        tableVboxContainer.getChildren().add(newTableView);
        tableIndex = tableVboxContainer.getChildren().indexOf(newTableView);
        ApikeyText.setText(Constants.API_KEY.getKey());
        ApiUrlText.setText("syanstore723@gmail.com");
        initializer();
        buttonEvent();
    }
    private void TextBoxSearchEvent(TextField textField){
        textField.textProperty().unbind();
        textField.textProperty().bind(search_query.textProperty());
            TableLabel.textProperty().bind(customTableProperty.TableName().textProperty());
            TableLabel.textFillProperty().bind(customTableProperty.TableName().fillProperty());
            TableLabel.fontProperty().bind(customTableProperty.TableName().fontProperty());
    }

    private void forward(ActionEvent event){

        if (iterator.hasNext()){
            newTableView = iteratorTable.next().getTableView();
            observableList = iterator.next();
            customTableProperty =  propertyListIterator.next();
            inputTableItems(observableList);
            tableVboxContainer.getChildren().set(tableIndex,newTableView);

        }if(!iterator.hasNext()) {
            customTableProperty =  propertyListIterator.previous();
            iteratorTable.previous();
            iterator.previous();
            btn_next.setDisable(true);
            btn_previous.setDisable(false);
        }

    }

    private void backward(ActionEvent event){
        if (iterator.hasPrevious()) {
            newTableView = iteratorTable.previous().getTableView();
            customTableProperty = propertyListIterator.previous();
            tableVboxContainer.getChildren().set(tableIndex,newTableView);
            observableList = iterator.previous();


            btn_next.setDisable(false);
        }if (!iterator.hasPrevious() || iterator.previousIndex()==-1){
            newTableView = iteratorTable.next().getTableView();
            tableVboxContainer.getChildren().set(tableIndex,newTableView);
            observableList=iterator.next();
            customTableProperty = propertyListIterator.next();
            btn_previous.setDisable(true);
        }
        inputTableItems(observableList);
        var text = search_query.getText();
        search_query.setText("");
        search_query.setText(text);
    }
    private void pointer(){
        while (iterator.hasNext() ){
            observableList = iterator.next();
            newTableView = iteratorTable.next().getTableView();
            customTableProperty = propertyListIterator.next();
            tableVboxContainer.getChildren().set(tableIndex,newTableView);

        }
        customTableProperty = propertyListIterator.previous();
        observableList = iterator.previous();
        newTableView = iteratorTable.previous().getTableView();
        tableVboxContainer.getChildren().set(tableIndex,newTableView);

        if (iterator.hasPrevious()){
            btn_previous.setDisable(false);
        }
    }
    private void tableFunction(TableView<CustomTableProperty> table_View){
        table_View.setTableMenuButtonVisible(true);
        table_View.getColumns().forEach(y->y.setResizable(true));
        table_View.getColumns().forEach(x->x.setPrefWidth(table_View.getPrefWidth()/4));
        table_View.getColumns().forEach(x->x.setMinWidth(150));
        table_View.backgroundProperty().setValue(Background.fill(Color.GRAY));
//        Set<Node> nodes = table_View.lookupAll(".scroll-bar");
//        for (final Node node : nodes) {
//            if (node instanceof ScrollBar) {
//                ScrollBar scrollBar = (ScrollBar) node;
//                if (!scrollBar.backgroundProperty().isBound()) {
//                    scrollBar.setBackground(Background.fill(Color.GRAY));
//                }
//                scrollBar.hoverProperty().addListener(event-> scrollBar.backgroundProperty().bind(Bindings.when(scrollBar.hoverProperty().or(scrollBar.pressedProperty())).then(Background.fill(Color.LIGHTGRAY)).otherwise(Background.fill(Color.GRAY))));
//                scrollBar.setPrefHeight(20);
//                scrollBar.setPrefWidth(20);
//            }
//        }

    }
    private void inputTableItems(ObservableList<CustomTableProperty> item){
       /* the data class contain three private properties or field named as Email, Owner and ShopName
        therefore in new propertyValueFactory(String) function we need to provide the exact field named we had written in class Data */
        newTableView.setItems(item);
        var table = newTableView;
        if (!table.getItems().isEmpty()){
            TableView<?> s = new TableView<>();
            s.setPrefSize(300,300);
            responseTableContainer.getChildren().set(1,s);
        }
//        Set<Node> nodes = table.lookupAll(".scroll-bar");
//        for (final Node node : nodes) {
//            if (node instanceof ScrollBar) {
//                ((ScrollBar)node).backgroundProperty().unbind();
//                ((ScrollBar)node).setBackground(Background.fill(Color.GRAY));
//                ((ScrollBar)node).setPrefHeight(15);
//                ((ScrollBar)node).setPrefWidth(15);
//
//            }
//        }
        var text = customTableProperty.searchText(newTableView,dataSortedList);
        TextBoxSearchEvent(text);
        tableVboxContainer.getChildren().set(tableIndex,newTableView);

    }

    private void initializer(){
        setChoiceBox(actionsBox);
        observableList = FXCollections.observableArrayList();
        TableLabel.setContentDisplay(ContentDisplay.CENTER);
        TableLabel.setText("JavaFX TABLE");
        TableLabel.setFont(Font.font(30));
        Limit.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        OffSet.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        Limit.textProperty().isEmpty().addListener(observable -> {
                Limit.setText("100");
                Limit.textProperty().setValue("100");
        });
    }
    public void setChoiceBox(ChoiceBox<String> actionList) {
        actionList.widthProperty().add(30);
        actionList.setValue("Select Api Call");
        ObservableList<String> stringObservableList = FXCollections.observableArrayList();
        brand = "GetBrands";
        categoryAttribute = "GetCategoryAttribute";
        categoryTree= "GetCategoryTree";
        orders= "GetOrders";
        response= "GetResponse";

        stringObservableList.add(brand);
        stringObservableList.add(categoryAttribute);
        stringObservableList.add(categoryTree);
        stringObservableList.add(orders);
        stringObservableList.add(response);
        gridTextField.setVisible(false);
        actionList.setOnShowing(event -> actionList.setItems(stringObservableList));

        actionList.setOnAction(event -> gridTextField.visibleProperty().bind(new BooleanBinding() {
            @Override
            protected boolean computeValue() {
                return actionList.getSelectionModel().getSelectedItem().equals(brand);
            }
        }));
    }
    private void buttonEvent(){
        btn_previous.setOnAction(this::backward);
        btn_next.setOnAction(this::forward);

        btn_next.setDisable(true);
        btn_previous.setDisable(true);
        btn_clear.setText("Exit");
        btn_clear.setOnAction(event -> {
            Platform.exit();
        });
        execute.setOnAction(event -> {Platform.runLater(()-> {
            ApiCall apiCall;
            if(actionsBox.getSelectionModel().getSelectedIndex() == -1)
            {
                responseTableContainer.getChildren().add(new StackPane(new TreeView<>(new TreeItem<>("Unkown API Call"))));
                messageTable.setPrefSize(300, 300);
                responseTableContainer.setPrefSize(300, 300);
                messageTable.setMaxWidth(300);
                messageTable.setMaxHeight(300);

                return;
            }
            if (actionsBox.getSelectionModel().getSelectedItem().equals(categoryAttribute)){
                GetCategoryAttributes attributes = new GetCategoryAttributes(ApiUrlText.getText(),ApikeyText.getText());
                apiCall = new ApiCall(attributes, attributesTableData);
                apiCall.start();

            }
            else if (actionsBox.getSelectionModel().getSelectedItem().equals(orders)){
                GetOrders orders = new GetOrders(ApiUrlText.getText(),ApikeyText.getText());
                apiCall = new ApiCall(orders,ordersTableData);
                apiCall.start();

            }else if (actionsBox.getSelectionModel().getSelectedItem().equals(brand)){
                GetBrands brands = new GetBrands(ApiUrlText.getText(),ApikeyText.getText());
                brands.AddParameterOffSet(OffSet.getText());
                brands.AddParameterLimit(Limit.getText().replace(",","").strip());
                apiCall = new ApiCall(brands,getBrandsTableData);
                apiCall.start();
            }else if (actionsBox.getSelectionModel().getSelectedItem().equals(categoryTree)){
                GetCategoryTree tree = new GetCategoryTree(ApiUrlText.getText(),ApikeyText.getText());
                apiCall = new ApiCall(tree,new CategoryTreeAttributes());
                apiCall.start();
            }


        });
        });


    }
    private class ApiCall extends Service<ApiGetRequestModel> {
        private final ApiGetRequestModel apiGetRequestModel;
        private final CustomTableProperty property;
        public ApiCall(ApiGetRequestModel apiGetRequestModel, CustomTableProperty property){
          this.apiGetRequestModel = apiGetRequestModel;
          this.property = property;
        }
        @Override
        protected Task<ApiGetRequestModel> createTask() {
            return new Task<>() {

                @Override
                protected ApiGetRequestModel call() throws Exception {
                    ApiGetRequestModel api = apiGetRequestModel;
                    api.setDaemon(true);
                    api.start();
                    api.join();
                    return api;
                }
                @Override
                protected void running() {

                    execute.setDisable(true);
                }
                @Override
                protected void succeeded() {
                    Platform.runLater(()-> {
                    ApiGetRequestModel model = getValue();
                    ObservableList<CustomTableProperty> collection = FXCollections.observableArrayList();
                    collection.addAll(model.getDataForTable());
                    tableItemLists.add(FXCollections.observableArrayList(collection));
                    observableList = FXCollections.observableArrayList(tableItemLists.get(tableItemLists.size() - 1));
                    TableUtility newTable = new TableUtility(property,observableList,newTableView);
                    tableViews.add(newTable);
                    newTableView = newTable.getTableView();
                    tableFunction(newTableView);
                    iterator = tableItemLists.listIterator();
                    iteratorTable = tableViews.listIterator();
                    customProperties.add(property);
                    propertyListIterator = customProperties.listIterator();
                    pointer();
                    if (observableList!=null){
                    inputTableItems(observableList);}
                    var text =  property.searchText(newTableView,dataSortedList);
                    TextBoxSearchEvent(text);
                    btn_next.setDisable(true);
                    execute.setDisable(false);
                    });
                }
            };
        }
    }
}




