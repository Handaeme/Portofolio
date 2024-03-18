package com.pbo.mhscrud;

import com.mysql.cj.protocol.Resultset;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class MhsController implements Initializable {
    Connection conn=null;
    PreparedStatement st=null;
    ResultSet rs = null;
    @FXML
    private TableColumn<Mhs, String> cNama;
    @FXML
    private TableColumn<Mhs, String> cNim;
    @FXML
    private TableColumn<Mhs, String> cProdi;
    @FXML
    private Button tbClear;
    @FXML
    private Button tbDel;
    @FXML
    private TableView<Mhs> tbMhs;
    @FXML
    private Button tbSave;
    @FXML
    private Button tbUpdate;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfNim;
    @FXML
    private TextField tfProdi;
    @FXML
    void clearText(ActionEvent event) {
        clear();
        tfNim.setEditable(true);
    }
    void clear(){
        tfNim.setText(null);
        tfNama.setText(null);
        tfProdi.setText(null);
        tbSave.setDisable(false);
        tbUpdate.setDisable(true);
        tfNim.setEditable(true);
    }
    @FXML
    void delData(ActionEvent event) {
        String sql="delete from mhs where nim=?";
        conn = DBConnection.getConn();
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,tfNim.getText());
            st.executeUpdate();
            showListMhs();
            clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void getData(MouseEvent event) {
        Mhs m = tbMhs.getSelectionModel().getSelectedItem();
        tfNim.setText(m.getNim());
        tfNim.setEditable(false);
        tfNama.setText(m.getNama());
        tfProdi.setText(m.getProdi());
        tbSave.setDisable(true);
        tbUpdate.setDisable(false);
    }
    @FXML
    void addData(ActionEvent event) {
        String sql="insert into mhs(nim,nama,prodi) values (?,?,?)";
        conn = DBConnection.getConn();
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,tfNim.getText());
            st.setString(2,tfNama.getText());
            st.setString(3,tfProdi.getText());
            st.executeUpdate();
            showListMhs();
            clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void updateData(ActionEvent event) {
        String sql="update mhs set nama=?,prodi=? where nim=?";
        conn = DBConnection.getConn();
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,tfNama.getText());
            st.setString(2,tfProdi.getText());
            st.setString(3,tfNim.getText());
            st.executeUpdate();
            showListMhs();
            clear();
// tbSave.setDisable(false);
// tbUpdate.setDisable(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ObservableList<Mhs> getlistMhs(){
        ObservableList<Mhs> listmhs = FXCollections.observableArrayList();
        String sql="select * from mhs";
        conn = DBConnection.getConn();
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Mhs m = new Mhs();
                m.setNim(rs.getString("nim"));
                m.setNama(rs.getString("nama"));
                m.setProdi(rs.getString("prodi"));
                listmhs.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listmhs;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){showListMhs();
    }
    public void showListMhs(){
        ObservableList<Mhs> listMhs = getlistMhs();
        tbMhs.setItems(listMhs);
        cNim.setCellValueFactory(new PropertyValueFactory<Mhs,String>("nim"));
        cNama.setCellValueFactory(new PropertyValueFactory<Mhs,String>("nama"));
        cProdi.setCellValueFactory(new PropertyValueFactory<Mhs,String>("prodi"));
    }
// public void getData(javafx.scene.input.MouseEvent mouseEvent){// }
}
