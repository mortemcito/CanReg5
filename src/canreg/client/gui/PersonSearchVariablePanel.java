/*
 * PersonSearchVariablePanel.java
 *
 * Created on 21 October 2008, 14:08
 */

package canreg.client.gui;

import canreg.common.DatabaseVariablesListElement;
import canreg.common.PersonSearchVariable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.application.Action;

/**
 *
 * @author  ervikm
 */
public class PersonSearchVariablePanel extends javax.swing.JPanel {
    private ActionListener listener;

    /** Creates new form PersonSearchVariablePanel */
    public PersonSearchVariablePanel() {
        initComponents();
    }
    
    public void setDatabaseVariables(DatabaseVariablesListElement[] variables){
        variablesComboBox.setModel(new javax.swing.DefaultComboBoxModel(variables));
    }
    
    public void setSelectedVariable(DatabaseVariablesListElement variable){
        variablesComboBox.setSelectedItem(variable);
    }

    void setPersonSearchVariable(PersonSearchVariable searchVariable) {
        boolean found = false;
        String searchVariableName = searchVariable.getName();
        DatabaseVariablesListElement databaseVariablesListElement = null;
        int i = 0;
        while (!found && i< variablesComboBox.getItemCount()){
            databaseVariablesListElement = (DatabaseVariablesListElement) variablesComboBox.getItemAt(i++);
            found = searchVariableName.equalsIgnoreCase(databaseVariablesListElement.getShortName());
        }
        if (found){
            variablesComboBox.setSelectedItem(databaseVariablesListElement);
        }
        weightTextField.setText(searchVariable.getWeight()+"");
    }
    
    private DatabaseVariablesListElement getSelectedVariable(){
        return (DatabaseVariablesListElement) variablesComboBox.getSelectedItem();
    }
    
    public void setWeigth(int weight){
        weightTextField.setText(weight+"");
    }
    
    private float getWeight(){
        float weight = 0;
        try {
            weight = Float.parseFloat(weightTextField.getText());
        } catch (NumberFormatException nfe){
            
        }
        return weight;
    }
    
    public void setActionListener(ActionListener listener){
        this.listener = listener;
    }

    public PersonSearchVariable getPersonSearchVariable() {
        PersonSearchVariable psv = new PersonSearchVariable();
        psv.setName(getSelectedVariable().getShortName());
        psv.setWeight(getWeight());
        return psv;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        variablesComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        weightTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getActionMap(PersonSearchVariablePanel.class, this);
        jButton1.setAction(actionMap.get("removeVariableAction")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        variablesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        variablesComboBox.setName("variablesComboBox"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(canreg.client.CanRegClientApp.class).getContext().getResourceMap(PersonSearchVariablePanel.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        weightTextField.setText(resourceMap.getString("weightTextField.text")); // NOI18N
        weightTextField.setName("weightTextField"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(variablesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weightTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(variablesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void removeVariableAction() {
        listener.actionPerformed(new ActionEvent(this,0,"remove"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox variablesComboBox;
    private javax.swing.JTextField weightTextField;
    // End of variables declaration//GEN-END:variables

}
