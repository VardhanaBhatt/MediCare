/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EmployeeViewArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.City;
import Business.Network.Country;
import Business.Network.State;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.IssueWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.axis.CategoryAxis;

/**
 *
 * @author shali
 */
public class ViewResolvedIssuesStatisticsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewResolvedIssuesStatisticsJPanel
     */
    
    private static String workingDir = System.getProperty("user.dir");
    private static int count = 1;
    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private static Random rand = new Random();
    private static String[] imageName = {"air", "ir", "mi", "sor", "mee", "clo",
        "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
        "marac", "zoir", "slamar", "salmar", "urak", "d", "ed", "ark", "arc", "es", "er", "der",
        "tron", "med", "ure", "zur", "cred", "mur", "Kr", "Ca", "Ra", "Mrok", "Cru",
        "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
        "Zork", "Md", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
        "Mar", "Luk"};
    final CategoryDataset dataset;
    final JFreeChart chart;
    final ChartPanel chartPanel;
    public ViewResolvedIssuesStatisticsJPanel(JPanel userProcessContainer, EcoSystem system, UserAccount userAccount, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        // REMOVE ANY ITEM CURRENTLY IN THE JCROLLPANE
        scrollPane.getViewport().removeAll();
        // BUILD AND ADD THE CHART TO THE JSCROLLPANE
        // scrollPane.getViewport().add(createPiePanel());

        dataset = createDataset();
        chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        scrollPane.getViewport().add(chartPanel);
    }
     
    public static void saveToFile(JFreeChart chart,
            String aFileName,
            int width,
            int height,
            double quality)
            throws FileNotFoundException, IOException {
        BufferedImage img = draw(chart, width, height);

        FileOutputStream fos = new FileOutputStream(aFileName);
        ImageIO.write(img, "jpg", fos);
        fos.close();
    }
    
     protected static BufferedImage draw(JFreeChart chart, int width, int height) {
        BufferedImage img
                = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();

        chart.draw(g2, new Rectangle2D.Double(0, 0, width, height));

        g2.dispose();
        return img;
    }
     private CategoryDataset createDataset() {

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        HashMap<String, Integer> hashmapResolved = new HashMap<>();
        hashmapResolved.put("Medications", 0);
        hashmapResolved.put("Treatment Senior", 0);
        hashmapResolved.put("Donation of Basic Amenities", 0);

        HashMap<String, Integer> hashmapOpen = new HashMap<>();
        hashmapOpen.put("Medications", 0);
        hashmapOpen.put("Treatment Senior", 0);
        hashmapOpen.put("Donation of Basic Amenities", 0);
        
        if(enterprise.getEnterpriseType().getValue().equals("OldAgeHome")){
            String[] arrOfStr = enterprise.getName().split(" ", 2); 
            String ent = arrOfStr[0] + " Trust";
            System.out.println(ent);
            for (Country c : system.getNetworkList()) {
            for (State s : c.getStateList()) {
                for (City city : s.getCityList()) {
                    for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                        if(e.getName().equals(ent)){
                            System.out.println(e);
                        //if (userAccount.getRole().getName().equals("System Type")) {
                            lblHeader.setText("EcoSystem Level");
                            for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
                                if (organization instanceof ManagerOrganization) {
                                    for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                                        if (!(request instanceof IssueWorkRequest)) {
                                        } else {
                                            String type = ((IssueWorkRequest) request).getType();
                                            if (type.equals("Medications")) {
                                                if (request.getStatus().equals("Resolved")) {
                                                    hashmapResolved.put("Medications", hashmapResolved.get("Medications") + 1);
                                                } else {
                                                    hashmapOpen.put("Medications", hashmapOpen.get("Medications") + 1);
                                                }
                                            } else if (type.equals("Treatment Senior")) {
                                                if (request.getStatus().equals("Resolved")) {
                                                    hashmapResolved.put("Treatment Senior", hashmapResolved.get("Treatment Senior") + 1);
                                                } else {
                                                    hashmapOpen.put("Treatment Senior", hashmapOpen.get("Treatment Senior") + 1);
                                                }
                                            } else if (request.getStatus().equals("Resolved")) {
                                                hashmapResolved.put("Donation of Basic Amenities", hashmapResolved.get("Donation of Basic Amenities") + 1);
                                            } else {
                                                hashmapOpen.put("Donation of Basic Amenities", hashmapOpen.get("Donation of Basic Amenities") + 1);
                                            }

                                        }
                                    }
                                }
                            }
                        //} 

                    }

                }
                }
            }
        }
        }else{
        for (Country c : system.getNetworkList()) {
            for (State s : c.getStateList()) {
                for (City city : s.getCityList()) {
                    for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                        if (userAccount.getRole().getName().equals("System Type")) {
                            lblHeader.setText("EcoSystem Level");
                            for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
                                if (organization instanceof ManagerOrganization) {
                                    for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                                        if (!(request instanceof IssueWorkRequest)) {
                                        } else {
                                            String type = ((IssueWorkRequest) request).getType();
                                            if (type.equals("Medications")) {
                                                if (request.getStatus().equals("Resolved")) {
                                                    hashmapResolved.put("Medications", hashmapResolved.get("Medications") + 1);
                                                } else {
                                                    hashmapOpen.put("Medications", hashmapOpen.get("Medications") + 1);
                                                }
                                            } else if (type.equals("Treatment Senior")) {
                                                if (request.getStatus().equals("Resolved")) {
                                                    hashmapResolved.put("Treatment Senior", hashmapResolved.get("Treatment Senior") + 1);
                                                } else {
                                                    hashmapOpen.put("Treatment Senior", hashmapOpen.get("Treatment Senior") + 1);
                                                }
                                            } else if (request.getStatus().equals("Resolved")) {
                                                hashmapResolved.put("Donation of Basic Amenities", hashmapResolved.get("Donation of Basic Amenities") + 1);
                                            } else {
                                                hashmapOpen.put("Donation of Basic Amenities", hashmapOpen.get("Donation of Basic Amenities") + 1);
                                            }

                                        }
                                    }
                                }
                            }
                        } else {
                            for (UserAccount ua : e.getUserAccountDirectory().getUserAccountList()) {
                                if (userAccount.getUsername().equals(ua.getUsername())) {
                                    lblHeader.setText("Enterprise Level");
                                    for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
                                        if (organization instanceof ManagerOrganization) {
                                            for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                                                if (!(request instanceof IssueWorkRequest)) {
                                                } else {
                                                    String type = ((IssueWorkRequest) request).getType();
                                                    if (type.equals("Medications")) {
                                                        if (request.getStatus().equals("Resolved")) {
                                                            hashmapResolved.put("Medications", hashmapResolved.get("Medications") + 1);
                                                        } else {
                                                            hashmapOpen.put("Medications", hashmapOpen.get("Medications") + 1);
                                                        }
                                                    }else if (type.equals("Treatment Senior")) {
                                                        if (request.getStatus().equals("Resolved")) {
                                                            hashmapResolved.put("Treatment Senior", hashmapResolved.get("Treatment Senior") + 1);
                                                        } else {
                                                            hashmapOpen.put("Treatment Senior", hashmapOpen.get("Treatment Senior") + 1);
                                                        }
                                                    } else if (request.getStatus().equals("Resolved")) {
                                                        hashmapResolved.put("Donation of Basic Amenities", hashmapResolved.get("Donation of Basic Amenities") + 1);
                                                    } else {
                                                        hashmapOpen.put("Donation of Basic Amenities", hashmapOpen.get("Donation of Basic Amenities") + 1);
                                                    }

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }

                }

            }
        }
        }

        // row keys...
        final String series1 = "Open";
        final String series2 = "Resolved";

        // column keys...
        final String category1 = "Medications";
        final String category3 = "Treatment Senior";
        final String category4 = "Donation of Basic Amenities";

        dataset.setValue(hashmapOpen.get("Medications"), series1, category1);
        dataset.setValue(hashmapOpen.get("Treatment Senior"), series1, category3);
        dataset.setValue(hashmapOpen.get("Donation of Basic Amenities"), series1, category4);

        dataset.setValue(hashmapResolved.get("Medications"), series2, category1);
        dataset.setValue(hashmapResolved.get("Treatment Senior"), series2, category3);
        dataset.setValue(hashmapResolved.get("Donation of Basic Amenities"), series2, category4);

        return dataset;

    }
     
     private JFreeChart createChart(final CategoryDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
                "Open and Resolved Issues", // chart title
                "Category", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
                0.0f, 0.0f, Color.red,
                0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
                0.0f, 0.0f, Color.blue,
                0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
                0.0f, 0.0f, Color.red,
                0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        btnSaveImage = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPane.setMaximumSize(new java.awt.Dimension(700, 700));
        scrollPane.setMinimumSize(new java.awt.Dimension(700, 700));
        jPanel1.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 700, 577));

        btnSaveImage.setBackground(new java.awt.Color(113, 160, 160));
        btnSaveImage.setText("Save as Image");
        btnSaveImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveImageActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaveImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 670, -1, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-button.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 40, 40));


        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Enterprise Level");
        jPanel1.add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 370, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(240, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveImageActionPerformed
        // TODO add your handling code here:
        // JFreeChart pieChart = createPieChart(createPieDataset());
        try {
            String fileName = String.valueOf(count);
            fileName += imageName[rand.nextInt(imageName.length)];
            saveToFile(chart, workingDir + "\\src\\Images" + "\\" + fileName + "plot.jpg", 500, 300, 100);
                count++;
                JOptionPane.showMessageDialog(null, "Image saved successfully", "Warning", JOptionPane.WARNING_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_btnSaveImageActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaveImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
